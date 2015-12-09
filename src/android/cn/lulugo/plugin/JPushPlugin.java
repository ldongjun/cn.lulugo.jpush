package cn.lulugo.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class JPushPlugin extends CordovaPlugin {

    private static JPushPlugin instance;

    public JPushPlugin() {
        instance = this;
    }

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        callbackContext.success();
        JPushUtil.getRegistrationId(this.cordova.getActivity().getApplicationContext());
        String sid = data != null ? data.getString(0) : "";
        JPushUtil.setSID(sid);
//        Log.e("TAG", "JPushUtil.setSID================================================ " +data.getString(0));
        return true;
    }


//    void setTags(JSONArray data, CallbackContext callbackContext) {
//
//        HashSet<String> tags=null;
//        try {
//            String tagStr;
//            if(data==null){
//                //tags=null;
//            }else if(data.length()==0) {
//                tags= new HashSet<String>();
//            }else{
//                tagStr = data.getString(0);
//                String[] tagArray = tagStr.split(",");
//                for (String tag : tagArray) {
//                    if(tags==null){
//                        tags= new HashSet<String>();
//                    }
//                    tags.add(tag);
//                }
//            }
//            //Set<String> validTags = JPushInterface.filterValidTags(tags);
//            JPushInterface.setTags(this.cordova.getActivity()
//                    .getApplicationContext(), tags, mTagWithAliasCallback);
//            callbackContext.success();
//        } catch (JSONException e) {
//            e.printStackTrace();
//            callbackContext.error("Error reading tags JSON");
//        }
//    }
//
//    private final TagAliasCallback mTagWithAliasCallback = new TagAliasCallback() {
//
//        @Override
//        public void gotResult(int code, String alias, Set<String> tags) {
//            if (instance == null) {
//                return;
//            }
//
//            JSONObject data = new JSONObject();
//            try {
//                data.put("resultCode", code);
//                data.put("tags", tags);
//                data.put("alias", alias);
//
//                String jsEvent=String
//                        .format("cordova.fireDocumentEvent('jpush.setTagsWithAlias',%s)",
//                                data.toString());
//                instance.webView.sendJavascript(jsEvent);
//
//
//            } catch (JSONException e) {
//
//            }
//
//        }
//
//    };
}
