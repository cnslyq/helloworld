/**
 * 屏蔽右侧广告
 */
function block_right_ads(){
	removeParentNodeById('con-ar');
}

/**
 * 屏蔽左上广告
 */
function block_left_top_ads(){
	removeParentNodeById('4001');
}

/**
 * 屏蔽左下广告
 */
function block_left_bottom_ads(){
	removeParentNodeById('5001');
}

/**
 * 屏蔽推广
 */
function block_300x_ads(){
	var tmp = ['3001','3002','3003','3004','3005','3006'];
    for(var i=0;i<tmp.length;i++){
    	removeNodeById(tmp[i]);
    }
}

/**
 * 百度搜索结果类型如下：
 * 1. <div class="result c-container"> 自然排名
 * 2. <div class="result-op c-container"> 阿拉丁
 * 3. <div class="result-op c-container xpath-log"> 百度内部阿拉丁，如百科、贴吧等
 * 屏蔽第2种类型，阿拉丁
 */
function block_aladdin(){
	removeNodesByClass('result-op c-container', 'xpath-log');
}

var t ;
var count = 0;

function block_ads(){
    count++;
    if(count>12){
        return;
    }

    block_right_ads();
	block_left_top_ads();
	block_left_bottom_ads();
	block_300x_ads();
	block_aladdin();
	
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

function removeParentNodeById(id){
	var x = document.getElementById(id);
    if(x != null) {
        x = x.parentNode;
        if(x != null) {
            x.parentNode.removeChild(x);
        }
    }
}

function removeNodeByClass(cls, idx){
	var x = document.getElementsByClassName(cls)[idx];
	if(x != null) {
        x.parentNode.removeChild(x);
    }
}

function removeNodesByClass(cls, exceptCls){
	var nodes = document.getElementsByClassName(cls);
	for(var i=0;i<nodes.length;i++){
		if(nodes[i] != null) {
			if(exceptCls == null || exceptCls == '' || !nodes[i].className.match(exceptCls))
				nodes[i].parentNode.removeChild(nodes[i]);
	    }
	}
}
