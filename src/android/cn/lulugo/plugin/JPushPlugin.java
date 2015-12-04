package cn.lulugo.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONException;

public class JPushPlugin extends CordovaPlugin {
    @Override
    public boolean execute(String action, String args, CallbackContext callbackContext) throws JSONException {
        callbackContext.success();
        JPushUtil.getRegistrationId(this.cordova.getActivity().getApplicationContext());
        return true;
    }

}
