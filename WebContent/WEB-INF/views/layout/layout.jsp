<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
        <title>original portfolio</title>
    </head>
    <body>
    	<header>
    		<div id="header_menu">
    			<h2>人件費計算アプリ</h2>
    		</div>
    	</header>
    	<div id="content">
    		${param.content}
    		<div>
    			<nav id="nav">
    				<ul class="link-box">
    					<li class="link"><h3><a href="<c:url value='/cost/remove' />">TOPページへ</a></h3>
   						<li class="link"><h3><a href="<c:url value='/cost/list' />">確認する</a></h3>
   						<c:if test="${result != null}">
   							<li class="link"><h3><a href="<c:url value='/cost/save' />">保存する</a></h3>
   						</c:if>
   					</ul>
   				</nav>
   			</div>
   		</div>
    	<div id="footer">
    		<footer>
    			<h5>ORIGINAL PORTFOLIO BY FUMIHIKO KARIYA</h5>
    		</footer>
    	</div>

    </body>
</html>