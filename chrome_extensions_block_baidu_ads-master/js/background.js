//var console = chrome.extension.getBackgroundPage().console;

(function($){
	chrome.tabs.onUpdated.addListener(function(tabId,changeInfo,tab){
		//console.log('tab.url='+tab.url+ " , changeInfo.status="+changeInfo.status)
		if(tab.url != undefined && changeInfo.status == 'complete'){
			// Block Ads for www.baidu.com
			if(tab.url.match('http://www.baidu.com') || tab.url.match('https://www.baidu.com')){
				//console.log("document.readyState="+document.readyState)
				//console.log("----match------ tabId = "+tabId)
				chrome.tabs.executeScript(tabId,{file:"/js/block_ads.js",runAt:"document_end"});
			} else if(tab.url.match('http://play.baidu.com')){
				//chrome.tabs.executeScript(tabId,{file:"/js/block_play_ads.js",runAt:"document_end"});
			}
		}
		//console.log("----end--------------")
	});
})(jQuery);