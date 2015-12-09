package cn.lulugo.plugin;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JPushUtil {

    //ID
    private static String CUR_PUSH_REGISTRATION_ID = "";

    private static String SID = "";

    public static ExecutorService singleThreadExecutor = null;


    private static IServiceCallback listener = null;//2.1

    public static void setCallbackListener(IServiceCallback cbl) {//2.2
        listener = cbl;
    }


    //ID
    public static void setCurPushRegistrationId(String id) {
        CUR_PUSH_REGISTRATION_ID = id;

        if (listener != null)
        {
            listener.saveRegistrationId();
        }
    }

    public static void setSID(String sid) {
        SID = sid;
    }

    public static String getSID() {
        return SID;
    }



    public static String getCurPushRegistrationId() {
        return CUR_PUSH_REGISTRATION_ID;
    }

    /**
     * ID
     *
     * @param context
     */
    public static void getRegistrationId(Context context) {
//        Log.e("TAG", "CUR_PUSH_REGISTRATION_ID================================================ " + CUR_PUSH_REGISTRATION_ID);
//        if ("".equals(CUR_PUSH_REGISTRATION_ID)) {
        if (null != CUR_PUSH_REGISTRATION_ID) {
//            Log.e("TAG", "CUR_PUSH_REGISTRATION_ID2================================================ " + CUR_PUSH_REGISTRATION_ID);
            singleThreadExecutor = Executors.newSingleThreadExecutor();
            singleThreadExecutor.execute(new LuluThread(context));
        }
    }
}
