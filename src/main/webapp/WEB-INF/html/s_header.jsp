<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<link rel="stylesheet" type="text/css" href="static/css/style.css" />
<style>
.change:before{content:"I";color: red !important;}
</style>
</head>
<body style="text-align:center">
<header>
 <h1><img src="static/images/admin_logo.png"/></h1>
 <ul class="rt_nav">
  <li style="margin-top:10px">
  	<input type="text" style="padding:0 6px;border: 1px #139667 solid;line-height: 30px;font-size: 12px;vertical-align: middle" class="length_input_20" placeholder="订单号" id="orderid"/>
  	<input type="button" id="search" value="搜索" class="" style="display: inline-block;height: 32px;line-height: 30px;border: 1px #19a97b solid;border-radius: 2px;background: #f8f8f8;color: #19a97b;vertical-align: middle;cursor: pointer;"/>
  </li>
  <li><a href="/orderOff/s_query_refund/${id}/1?token=${token}" target="_top" class="website_icon" id="ordermanage">订单管理</a></li>
  <li><a href="/user/s_queryall/${id}/1?token=${token}" target="_top" class="admin_icon">会员管理</a></li>
  <li><a href="/product/s_products/${id}/1?token=${token}" target="_top" class="product_icon">商品管理</a></li>
  <li><a href="/vendor/s_queryall/${id}?token=${token}" target="_top" class="set_icon">账号设置</a></li>
  <li><a href="/supervisor/logout?token=${token}" target="_top" class="quit_icon">安全退出</a></li>
 </ul>
 </header>
 <input type="hidden" value="${onumber}" id="number"></input>
 <input type="hidden" value="${id}" id="loginid"></input>
 <input type="hidden" value="${token}" id="token"></input>
  <audio id="chatAudio">
 	<!-- <source src="notify.ogg" type="audio/ogg"> 
 	<source src="notify.mp3" type="audio/mpeg"> -->
 	<source src="http://data3.huiyi8.com/2015/dqd/07/31/4.wav" type="audio/wav"> 
 </audio>
  <script src="static/js/jquery.js"></script>
 <script>
 	if(document.getElementById("number").value>0){
 		var target = document.getElementById("ordermanage");
 		target.style.cssText="color:red;font-size:13px";
 		target.className="change";
 	}
 	function refresh(){
		$.ajax({
   		 	  type: "POST",
	          contentType: "application/json",
	          url: "/orderOff/hasNew/"+$("#loginid").val()+"/?token="+$("#token").val(),
	          dataType: "json",
	          data: "{}",
	          success: function(data){
	        	  if(data.onumber>0){
	        		  var target = document.getElementById("ordermanage");
	        	 	  target.style.cssText="color:red;font-size:13px";
	        	 	  target.className="change";
	        	 	  document.getElementById("chatAudio").play(); 
	        	  }
	        	  else if(data.onumber<=0){
	        		  var target = document.getElementById("ordermanage");
	        	 	  target.style.cssText="color:white;font-size:12px";
	        	 	  target.className="website_icon";
	        	  }
	          }
   	 	});
	}
	setInterval(refresh,90000);
	
	//搜索订单
	$('#search').click(function(){
		var ordernumber = $.trim($('#orderid').val());
		if(ordernumber.length==0){
			alert("请输入完整订单号");
			return false;
		}
		window.parent.location="/orderOn/searchall/"+$("#loginid").val()+"?token="+$("#token").val()+"&number="+ordernumber;
	});
	</script>
 </body>