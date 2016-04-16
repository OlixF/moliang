<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style>
	@charset "utf-8";
*{margin:0;padding:0;list-style-type:none;}
a{color:#666;text-decoration:none;}
table{border-collapse:collapse;border-spacing:0;border:0;}
body{color:#666;font:12px/180% Arial, Helvetica, sans-serif, "鏂板畫浣�";}
clearfix:after{content:".";display:block;height:0;clear:both;visibility:hidden}
.clearfix{display:inline-table}
*html .clearfix{height:1%}
.clearfix{display:block}
*+html .clearfix{min-height:1%}
.fl{float:left;}
.fr{float:right;}

.catbox{width:940px;margin:0 auto;}
.catbox table{text-align:center;width:100%;}
.catbox table th,.catbox table td{border:1px solid #CADEFF;}
.catbox table th{background:#e2f2ff;border-top:3px solid #a7cbff;height:30px;}
.catbox table td{padding:10px;color:#444;}
.catbox table tbody tr:hover{background:RGB(238,246,255);}
.checkbox{width:60px;}
.goods{width:300px;}
.goods span{width:180px;margin-top:20px;text-align:left;float:left;}
.goods img{width:100px;height:80px;margin-right:10px;float:left;}
.price{width:130px;}
.count{width:90px;}
.count .add, .count input, .count .reduce{float:left;margin-right:-1px;position:relative;z-index:0;}
.count .add, .count .reduce{height:23px;width:17px;border:1px solid #e5e5e5;background:#f0f0f0;text-align:center;line-height:23px;color:#444;}
.count .add:hover, .count .reduce:hover{color:#f50;z-index:3;border-color:#f60;cursor:pointer;}
.count input{width:50px;height:15px;line-height:15px;border:1px solid #aaa;color:#343434;text-align:center;padding:4px 0;background-color:#fff;z-index:2;}
.subtotal{width:150px;color:red;font-weight:bold;}
.operation span:hover,a:hover{cursor:pointer;color:red;text-decoration:underline;}

.foot{margin-top:10px;color:#666;height:48px;border:1px solid #c8c8c8;background-color:#eaeaea;background-image:linear-gradient(RGB(241,241,241),RGB(226,226,226));position:relative;z-index:8;}
.foot div, .foot a{line-height:48px;height:48px;}
.foot .select-all{width:100px;height:48px;line-height:48px;padding-left:5px;color:#666;}
.foot .closing{border-left:1px solid #c8c8c8;width:100px;text-align:center;color:#000;font-weight:bold;background:RGB(238,238,238);cursor:pointer;}
.foot .total{margin:0 20px;cursor:pointer;}
.foot  #priceTotal, .foot #selectedTotal{color:red;font-family:"Microsoft Yahei";font-weight:bold;}
.foot .selected{cursor:pointer;}
.foot .selected .arrow{position:relative;top:-3px;margin-left:3px;}
.foot .selected .down{position:relative;top:3px;display:none;}
.show .selected .down{display:inline;}
.show .selected .up{display:none;}
.foot .selected:hover .arrow{color:red;}
.foot .selected-view{width:935px;border:1px solid #c8c8c8;position:absolute;height:auto;background:#ffffff;z-index:9;bottom:48px;left:-1px;display:none;}
.show .selected-view{display:block;}
.foot .selected-view div{height:auto;}
.foot .selected-view .arrow{font-size:16px;line-height:100%;color:#c8c8c8;position:absolute;right:330px;bottom:-9px;}
.foot .selected-view .arrow span{color:#ffffff;position:absolute;left:0px;bottom:1px;}

#selectedViewList{padding:10px 20px 10px 20px;}
#selectedViewList div{display:inline-block;position:relative;width:100px;height:80px;border:1px solid #ccc;margin:10px;float:left;}
#selectedViewList div img{width:100px;height:80px;margin-right:10px;float:left;}
#selectedViewList div span{display:none;color:#ffffff;font-size:12px;position:absolute;top:0px;right:0px;width:60px;height:18px;line-height:18px;text-align:center;background:#000;cursor:pointer;}
#selectedViewList div:hover span{display:block;}
</style>
</head>
<body>
<!-- 头部 -->
	<%@include file="header.jsp"%>
	<div id="fh5co-main">
		<table id="container">
			<thead>
				<tr>
					<th><label><input class="check-all check" type="checkbox"/>&nbsp;全选</label></th>
					<th>商品</th>
					<th>单价</th>
					<th>数量</th>
					<th>小计</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="checkbox"><input class="check-one check" type="checkbox"/></td>
					<td class="goods"><img src="images/1.jpg" alt=""/><span>Casio/卡西欧 EX-TR350</span></td>
					<td class="price">5999.88</td>
					<td class="count"><span class="reduce"></span><input class="count-input" type="text" value="1"/><span class="add">+</span></td>
					<td class="subtotal">5999.88</td>
					<td class="operation"><span class="delete">删除</span></td>
				</tr>
				<tr>
					<td class="checkbox"><input class="check-one check" type="checkbox"/></td>
					<td class="goods"><img src="images/2.jpg" alt=""/><span>Canon/佳能 PowerShot SX50 HS</span></td>
					<td class="price">3888.50</td>
					<td class="count"><span class="reduce"></span><input class="count-input" type="text" value="1"/><span class="add">+</span></td>
					<td class="subtotal">3888.50</td>
					<td class="operation"><span class="delete">删除</span></td>
				</tr>
				<tr>
					<td class="checkbox"><input class="check-one check" type="checkbox"/></td>
					<td class="goods"><img src="images/3.jpg" alt=""/><span>Sony/索尼 DSC-WX300</span></td>
					<td class="price">1428.50</td>
					<td class="count"><span class="reduce"></span><input class="count-input" type="text" value="1"/><span class="add">+</span></td>
					<td class="subtotal">1428.50</td>
					<td class="operation"><span class="delete">删除</span></td>
				</tr>
				<tr>
					<td class="checkbox"><input class="check-one check" type="checkbox"/></td>
					<td class="goods"><img src="images/4.jpg" alt=""/><span>Fujifilm/富士 instax mini 25</span></td>
					<td class="price">640.60</td>
					<td class="count"><span class="reduce"></span><input class="count-input" type="text" value="1"/><span class="add">+</span></td>
					<td class="subtotal">640.60</td>
					<td class="operation"><span class="delete">删除</span></td>
				</tr>
			</tbody>
		</table>
		
		<div class="foot" id="foot">
			<label class="fl select-all"><input type="checkbox" class="check-all check"/>&nbsp;全选</label>
			<a class="fl delete" id="deleteAll" href="javascript:;">删除</a>
			<div class="fr closing">结 算</div>
			<div class="fr total">合计：￥<span id="priceTotal">0.00</span></div>
			<div class="fr selected" id="selected">已选商品<span id="selectedTotal">0</span>件<span class="arrow up">︽</span><span class="arrow down">︾</span></div>
			<div class="selected-view">
				<div id="selectedViewList" class="clearfix">
					<div><img src="images/1.jpg"><span>取消选择</span></div>
				</div>
				<span class="arrow">◆<span>◆</span></span>
			</div>
		</div>
	
	</div>
<script type="text/javascript">
/**
 * Created by an.han on 13-12-17.
 */
window.onload = function () {
    if (!document.getElementsByClassName) {
        document.getElementsByClassName = function (cls) {
            var ret = [];
            var els = document.getElementsByTagName('*');
            for (var i = 0, len = els.length; i < len; i++) {

                if (els[i].className.indexOf(cls + ' ') >=0 || els[i].className.indexOf(' ' + cls + ' ') >=0 || els[i].className.indexOf(' ' + cls) >=0) {
                    ret.push(els[i]);
                }
            }
            return ret;
        }
    }

    var table = document.getElementById('cartTable'); // 璐墿杞﹁〃鏍�
    var selectInputs = document.getElementsByClassName('check'); // 鎵€鏈夊嬀閫夋
    var checkAllInputs = document.getElementsByClassName('check-all') // 鍏ㄩ€夋
    var tr = table.children[1].rows; //琛�
    var selectedTotal = document.getElementById('selectedTotal'); //宸查€夊晢鍝佹暟鐩鍣�
    var priceTotal = document.getElementById('priceTotal'); //鎬昏
    var deleteAll = document.getElementById('deleteAll'); // 鍒犻櫎鍏ㄩ儴鎸夐挳
    var selectedViewList = document.getElementById('selectedViewList'); //娴眰宸查€夊晢鍝佸垪琛ㄥ鍣�
    var selected = document.getElementById('selected'); //宸查€夊晢鍝�
    var foot = document.getElementById('foot');

    // 鏇存柊鎬绘暟鍜屾€讳环鏍硷紝宸查€夋诞灞�
    function getTotal() {
		var seleted = 0;
		var price = 0;
		var HTMLstr = '';
		for (var i = 0, len = tr.length; i < len; i++) {
			if (tr[i].getElementsByTagName('input')[0].checked) {
				tr[i].className = 'on';
				seleted += parseInt(tr[i].getElementsByTagName('input')[1].value);
				price += parseFloat(tr[i].cells[4].innerHTML);
				HTMLstr += '<div><img src="' + tr[i].getElementsByTagName('img')[0].src + '"><span class="del" index="' + i + '">鍙栨秷閫夋嫨</span></div>'
			}
			else {
				tr[i].className = '';
			}
		}
	
		selectedTotal.innerHTML = seleted;
		priceTotal.innerHTML = price.toFixed(2);
		selectedViewList.innerHTML = HTMLstr;
	
		if (seleted == 0) {
			foot.className = 'foot';
		}
	}

    // 璁＄畻鍗曡浠锋牸
    function getSubtotal(tr) {
        var cells = tr.cells;
        var price = cells[2]; //鍗曚环
        var subtotal = cells[4]; //灏忚td
        var countInput = tr.getElementsByTagName('input')[1]; //鏁扮洰input
        var span = tr.getElementsByTagName('span')[1]; //-鍙�
        //鍐欏叆HTML
        subtotal.innerHTML = (parseInt(countInput.value) * parseFloat(price.innerHTML)).toFixed(2);
        //濡傛灉鏁扮洰鍙湁涓€涓紝鎶�-鍙峰幓鎺�
        if (countInput.value == 1) {
            span.innerHTML = '';
        }else{
            span.innerHTML = '-';
        }
    }

    // 鐐瑰嚮閫夋嫨妗�
    for(var i = 0; i < selectInputs.length; i++ ){
        selectInputs[i].onclick = function () {
            if (this.className.indexOf('check-all') >= 0) { //濡傛灉鏄叏閫夛紝鍒欏惂鎵€鏈夌殑閫夋嫨妗嗛€変腑
                for (var j = 0; j < selectInputs.length; j++) {
                    selectInputs[j].checked = this.checked;
                }
            }
            if (!this.checked) { //鍙鏈変竴涓湭鍕鹃€夛紝鍒欏彇娑堝叏閫夋鐨勯€変腑鐘舵€�
                for (var i = 0; i < checkAllInputs.length; i++) {
                    checkAllInputs[i].checked = false;
                }
            }
            getTotal();//閫夊畬鏇存柊鎬昏
        }
    }

    // 鏄剧ず宸查€夊晢鍝佸脊灞�
    selected.onclick = function () {
        if (selectedTotal.innerHTML != 0) {
            foot.className = (foot.className == 'foot' ? 'foot show' : 'foot');
        }
    }

    //宸查€夊晢鍝佸脊灞備腑鐨勫彇娑堥€夋嫨鎸夐挳
    selectedViewList.onclick = function (e) {
        var e = e || window.event;
        var el = e.srcElement;
        if (el.className=='del') {
            var input =  tr[el.getAttribute('index')].getElementsByTagName('input')[0]
            input.checked = false;
            input.onclick();
        }
    }

    //涓烘瘡琛屽厓绱犳坊鍔犱簨浠�
    for (var i = 0; i < tr.length; i++) {
        //灏嗙偣鍑讳簨浠剁粦瀹氬埌tr鍏冪礌
        tr[i].onclick = function (e) {
            var e = e || window.event;
            var el = e.target || e.srcElement; //閫氳繃浜嬩欢瀵硅薄鐨則arget灞炴€ц幏鍙栬Е鍙戝厓绱 
            var cls = el.className; //瑙﹀彂鍏冪礌鐨刢lass
            var countInout = this.getElementsByTagName('input')[1]; // 鏁扮洰input
            var value = parseInt(countInout.value); //鏁扮洰
            //閫氳繃鍒ゆ柇瑙﹀彂鍏冪礌鐨刢lass纭畾鐢ㄦ埛鐐瑰嚮浜嗗摢涓厓绱 
            switch (cls) {
                case 'add': //鐐瑰嚮浜嗗姞鍙�
                    countInout.value = value + 1;
                    getSubtotal(this);
                    break;
                case 'reduce': //鐐瑰嚮浜嗗噺鍙�
                    if (value > 1) {
                        countInout.value = value - 1;
                        getSubtotal(this);
                    }
                    break;
                case 'delete': //鐐瑰嚮浜嗗垹闄�
                    var conf = confirm('纭畾鍒犻櫎姝ゅ晢鍝佸悧锛�');
                    if (conf) {
                        this.parentNode.removeChild(this);
                    }
                    break;
            }
            getTotal();
        }
        // 缁欐暟鐩緭鍏ユ缁戝畾keyup浜嬩欢
        tr[i].getElementsByTagName('input')[1].onkeyup = function () {
            var val = parseInt(this.value);
            if (isNaN(val) || val <= 0) {
                val = 1;
            }
            if (this.value != val) {
                this.value = val;
            }
            getSubtotal(this.parentNode.parentNode); //鏇存柊灏忚
            getTotal(); //鏇存柊鎬绘暟
        }
    }

    // 鐐瑰嚮鍏ㄩ儴鍒犻櫎
    deleteAll.onclick = function () {
        if (selectedTotal.innerHTML != 0) {
            var con = confirm('纭畾鍒犻櫎鎵€閫夊晢鍝佸悧锛�'); //寮瑰嚭纭妗�
            if (con) {
                for (var i = 0; i < tr.length; i++) {
                    // 濡傛灉琚€変腑锛屽氨鍒犻櫎鐩稿簲鐨勮
                    if (tr[i].getElementsByTagName('input')[0].checked) {
                        tr[i].parentNode.removeChild(tr[i]); // 鍒犻櫎鐩稿簲鑺傜偣
                        i--; //鍥為€€涓嬫爣浣嶇疆
                    }
                }
            }
        } else {
            alert('璇烽€夋嫨鍟嗗搧锛�');
        }
        getTotal(); //鏇存柊鎬绘暟
    }

    // 榛樿鍏ㄩ€�
    checkAllInputs[0].checked = true;
    checkAllInputs[0].onclick();
}

</script>
<!-- 底部 -->
	<%@include file="footer.jsp"%>
</body>
</html>