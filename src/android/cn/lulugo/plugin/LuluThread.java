package cn.lulugo.plugin;

import android.content.Context;
import android.util.Log;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by admin on 2015/12/3.
 */
public class LuluThread implements Runnable {

    private Context curContext = null;

    public LuluThread(Context context) {
        this.curContext = context;
    }

    public boolean isStop = false;

    @Override
    public void run() {
        try {
            while (!isStop) {
                Thread.sleep(100000);
//                Log.e("JPUSH", "22222222222222================================================ " );
                String registrationId = JPushInterface.getRegistrationID(curContext);
                if (null != registrationId && !"".equals(registrationId)) {
//                    Log.e("JPUSH", "444444444================================================ " + registrationId);
                    JPushUtil.setCurPushRegistrationId(registrationId);
                    isStop = true;
                    JPushUtil.singleThreadExecutor.shutdown();
                }
            }
        } catch (InterruptedException e) {
            Log.e("JPUSH", "getRegistrationID is error " + e.getMessage());
        } finally {
            Log.i("JPUSH", "getRegistrationID is shutdown " + (JPushUtil.singleThreadExecutor.isShutdown()));
        }
    }
}
