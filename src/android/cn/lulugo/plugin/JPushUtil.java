package cn.lulugo.plugin;

import android.content.Context;
import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JPushUtil {

    //推送ID
    private static String CUR_PUSH_REGISTRATION_ID = "";

    public static ExecutorService singleThreadExecutor = null;

    //设置推送ID
    public static void setCurPushRegistrationId(String id) {
        CUR_PUSH_REGISTRATION_ID = id;
        //存到服务器
        saveRegistrationId();
    }

    /**
     * 获取用户推送ID
     * @param context
     */
    public static void getRegistrationId(Context context) {
        Log.e("TAG", "CUR_PUSH_REGISTRATION_ID================================================ " + CUR_PUSH_REGISTRATION_ID);
        if ("".equals(CUR_PUSH_REGISTRATION_ID)) {
            singleThreadExecutor = Executors.newSingleThreadExecutor();
            singleThreadExecutor.execute(new LuluThread(context));
        }
    }

    /**
     * 将推送ID存入服务器
     */
    public static void saveRegistrationId() {

    }

//    private static final String BASE_URL = "http://192.168.8.210/lulugo-driver-webapp/";
//    public static void asyncHttpClientByGet(String path ,RequestParams params){
//        Log.e("TAG", "test================================================ ");
//        AsyncHttpClient client = new AsyncHttpClient();
//        client.get(BASE_URL + "security/jumpToLogin",params, new AsyncHttpResponseHandler(){
//            @Override
//            public void onSuccess(int i, Header[] headers, byte[] data) {
//               String d =  new String(data);
//                Log.e("TAG ", "onSuccess================================================ " + String.valueOf(d));
//            }
//
//            @Override
//            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
//                String d =  new String(bytes);
//                Log.e("TAG ", "onFailure================================================ " + String.valueOf(d));
//            }
//
//        });
//    }
}
