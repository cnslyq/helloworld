/**
 * 屏蔽右侧广告
 */
function block_right_ads(){
	removeNodeById('content_right');
}

var t ;
var count = 0;

function block_ads(){
    count++;
    if(count>12){
        return;
    }

    block_right_ads();
	
    t = window.setTimeout(block_ads, 300);
}

if(t != null){
    clearTimeout(t);
}


setTimeout(function(){
	block_ads();
},100);

function removeNodeById(id){
	var x = document.getElementById(id);
	if(x != null) {
        x.parentNode.removeChild(x);
    }
}

