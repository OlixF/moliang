<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="js/jquery.min.js"></script>
<script src="js/jquery.fly.min.js"></script>
<!-- [if lte IE 9]> -->
<script src="js/requestAnimationFrame.js"></script>
<!-- <![endif]-->
<style type="text/css">
	.u-flyer{display: block;width: 50px;height: 50px;border-radius: 50px;position: fixed;z-index: 9999;} 
</style>
<script type="text/javascript">
	$(function() {
		var offset = $("#end").offset();
		$("#addcar").click(function(event){
			alert("sdfsd");
			var addcar = $(this);
			/* var img = addcar.parent().find('img').attr('src'); */
			var img = "images/img_1.jsp";
			var flyer = $('<img class="u-flyer" src="'+img+'">');
			flyer.fly({
				start: {
					left: event.pageX,
					top: event.pageY
				},
				end: {
					left: offset.left+10,
					top: offset.top+10,
					width: 10,
					height: 10
				},
				onEnd: function(){
					alert("添加成功");
				}
			});
		});
		var page = 1;
		var size = 50;
		$.post('goods?action=list',
			{
				page : page,
				size : size
			},function(data){
				var item = "";
				var json = eval(data);
				var columns = $("#fh5co-board").attr("data-columns");
				var count = 0;
				var time = json.length/columns;
				for(var i=0;i<json.length;i++){
					if(i%Math.ceil(time)==0){
						item += "<div class='column size-1of"+columns+"'>";
					}
					item += "<div class='item'>"+
								"<div class='animate-box bounceIn animated'>"+
	        						"<a href='goods?action=show&id="+json[i].id+"' class='image-popup fh5co-board-img' target='_Blank' title='"+json[i].name+"'>"+
	        							"<img src='"+json[i].url+"' alt='"+json[i].name+"'/>"+
	        						"</a>"+
	        					"</div>"+
	    						"<div class='fh5co-desc'>"+json[i].info+
	    							"<div style='text-align:right;overflow:hidden;font-size:0;margin-bottom:10px;'>"+
	    								"<a id='addcar' style='color:#F58B88;font-size:14px;text-decoration:none;' href='#' title='加入购物车'>"+
	    									"&yen"+json[i].price+" <i class='fa fa-shopping-cart'></i>"+
	    								"</a>"+
	    							"</div>"+
	    						"</div>"+
	    					"</div>";
	    			count ++;
					if(count%Math.ceil(time)==0||(json.length-i)==1){
						item += "</div>";
					}
				}
    			$("#fh5co-board").html(item);
				/* document.getElementById("fh5co-board").innerHTML=item; */
			},"json");
	});
</script>

<div id="fh5co-main">
	<div class="container">
		<div class="row">
			<div id="fh5co-board" data-columns>
				<!-- <div class="item">
		        		<div class="animate-box">
			        		<a href="images/img_16.jpg" class="image-popup fh5co-board-img"><img src="images/img_16.jpg" alt="Free HTML5 Bootstrap template"></a>
			        		<div class="fh5co-desc">
			        			Qui nisi error dolorum dolor delectus, alias doloremque perspiciatis nemo.
			        		</div>
		        		</div>
		        	</div> -->

			</div>
		</div>
	</div>
</div>
