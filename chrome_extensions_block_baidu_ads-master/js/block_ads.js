/**
 * 屏蔽右侧广告
 */
function block_right_ads(){
	removeParentNodeById('con-ar')
}

/**
 * 屏蔽左上广告
 * <a class="WapncK" href="http://e.baidu.com/?refer=666" target="_blank">推广链接</a>
 */
function block_left_top_ads(){
	removeParentNodeById('4001')
}

/**
 * 屏蔽左下广告
 * <a class="WapncK" href="http://e.baidu.com/?refer=666" target="_blank">推广链接</a>
 */
function block_left_bottom_ads(){
	removeParentNodeById('5001')
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
	
    t = window.setTimeout(block_ads, 300)
}

if(t != null){
    clearTimeout(t)
}


setTimeout(function(){
    //console.log("time: "+new Date())
	block_ads()
},100);


function removeNodeById(id){
	x = document.getElementById(id);
	if(x != null) {
        x.parentNode.removeChild(x);
    }
}

function removeNodeByClass(cls, idx){
	x = document.getElementsByClassName(cls)[idx];
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

