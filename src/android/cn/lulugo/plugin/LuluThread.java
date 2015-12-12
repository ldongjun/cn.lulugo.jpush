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

    public static boolean isStop = false;

    @Override
    public void run() {
        try {
            while (!isStop) {
                Thread.sleep(100000);
                String registrationId = JPushInterface.getRegistrationID(curContext);
                String sid = JPushUtil.getSID();
                Log.e("JPUSH", "registrationId  =  " + registrationId );
                if (null != registrationId && !"".equals(registrationId) && null != sid && !"".equals(sid)) {
                    Log.e("JPUSH", "registrationId is not null :  " + registrationId);
                    JPushUtil.setCurPushRegistrationId(registrationId);
                    isStop = true;
//                    JPushUtil.singleThreadExecutor.shutdown();
                }
            }
        } catch (InterruptedException e) {
            Log.e("JPUSH", "getRegistrationID is error " + e.getMessage());
        } finally {
            Log.i("JPUSH", "getRegistrationID is shutdown " + (JPushUtil.singleThreadExecutor.isShutdown()));
        }
    }
}
