<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/layout.jsp">
	<c:param name="content">
		<div class="container">
    		<div class="item">
    			<h2>該当項目を入力してください</h2>
    			<form method="GET" action="<c:url value='/cost/index' />">
    				<h3>予算</h3>
    				<input type="text" name="budget"><br><br>
    				<h3>時給</h3>
    				<input type="text" name="hourly_wage"><br><br>
   					<h3>労働時間</h3>
   					<input type="text" name="time"><br><br>
   					<h3>出勤人数</h3>
   					<input type="text" name="number_of_people"><br><br>
   					<input type="submit" name="input" value="入力"><br><br>
   				</form>
   			</div>
   		</div>
	</c:param>
</c:import>