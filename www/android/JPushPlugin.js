
var JPushPlugin = function(){
};

JPushPlugin.prototype.test = function(successCallback, errorCallback) {
	return cordova.exec(successCallback, errorCallback, 'JPushPlugin', "", []);
};

module.exports = new JPushPlugin();

