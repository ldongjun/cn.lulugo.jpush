1.need dependency CordovaLib module.

2.need dependency Android API Platform.

3.jpush android sdk download:

http://docs.jpush.io/resources/


install plugin

cordova plugin add https://github.com/leiwang0418/com.51amani.baidu.location.git --variable API_KEY="API_KEY"

eg:cordova plugin add https://github.com/leiwang0418/com.51amani.baidu.location.git --variable API_KEY="Z4hwG8B2LiSVuB2cV5bfPFf4"
eg:cordova plugin add D:\plugins\cn.lulugo.jpush --variable API_KEY="5f1364e9ab147174bc93e359"  PACKAGE_NAME="cn.lulugo.plugin"
remove plugin

cordova plugin remove cn.lulugo.jpush

说明：

1.使用百度定位sdk6.1.2持续返回定位。

2.example中index.html为demo,放到真正的android项目，即可运行。

3.index.html中的ak为html的ak(需要去百度申请）。

4.添加插件用于定位的api_key为定位的ak,需要另外申请。