<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="/pages/common/header.jsp"%>
	<script type="text/javascript">
		$(function () {
$("a.delete").click(function () {
return confirm("确定删除【"+$(this).parent().parent().find("td:first").text()+"】吗");
})
			$("a.clearall").click(function () {
return confirm("确定清空购物车吗");
			})
			$("input.update").change(function () {
var id=$(this).attr("bookid");
var name=$(this).parent().parent().find("td:first").text();
var count=this.value;
if(confirm("您确定将【"+name+"】的数量修改为【"+count+"】吗？"))
{
location.href="${pageScope.base}cart?action=update&id="+id+"&count="+count;
	//location.href="http://localhost:8080/book/cart?action=update&id="+id+"&count="+count;
}
else {
	this.value=this.defaultValue;
}
			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%@include file="/pages/common/TheSame.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${not empty sessionScope.cart.items}">
				<c:forEach items="${sessionScope.cart.items}" var="entry">
			<tr>
				<td>${entry.value.name}</td>
				<td><input class="update" style="width: 80px;" bookid="${entry.value.id}" type="text" value="${entry.value.count}"></td>
				<td>${entry.value.price}</td>
				<td>${entry.value.totalprice}</td>
				<td><a class="delete" href="cart?action=deleteitem&id=${entry.value.id}">删除</a></td>
			</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="5">
						<a href="index.jsp">亲您还没添加购物信息，快去浏览吧</a>
					</td>
				</tr>
			</c:if>
		</table>
		<c:if test="${not empty sessionScope.cart.items}">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalcount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalprice}</span>元</span>
			<span class="cart_span"><a class="clearall" href="cart?action=clear">清空购物车</a></span>
			<span class="cart_span"><a href="orderservlet?action=createorder">去结账</a></span>
		</div>
		</c:if>
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>