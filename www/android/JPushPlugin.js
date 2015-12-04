
var JPushPlugin = function(){
};

JPushPlugin.prototype.getRegistrationId = function(successCallback, errorCallback) {
	return cordova.exec(successCallback, errorCallback, 'JPushPlugin', "", []);
};

module.exports = new JPushPlugin();

