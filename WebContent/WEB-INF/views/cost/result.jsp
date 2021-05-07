<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/layout.jsp">
	<c:param name="content">
		<div>
			<h2>【結果】</h2>
		</div>
		<div>
			<table border="2">
				<tr>
					<th>予算</th>
					<th>使用する合計額</th>
					<th>出勤人数</th>
					<th>時給</th>
					<th>勤務時間</th>
				</tr>
				<tr>
					<td><c:out value="${r.budget}" /></td>
					<td><c:out value="${result}" /></td>
					<td><c:out value="${r.number_of_people}" /></td>
					<td><c:out value="${r.hourly_wage}" /></td>
					<td><c:out value="${r.time}" /></td>
				</tr>
			</table>
		</div><br><br>
		<div class="container">
			<div class="item">
				<h3>予算に対して使用金額は</h3>
				<p><c:out value="${parcent}"/>％</p>
			</div>
			<div class="item">
				<h3>差し引き</h3>
				<p><c:out value="${remaining}" />円</p>
			</div>
		</div>
		<c:if test="${parcent > 80 && parcent <= 100}">
			<h4><strong class="warning">【WARNING】使用できる人件費が20％を下回りました</strong></h4>
		</c:if>
		<c:if test="${parcent > 100}">
			<h4><strong class="warning">【WARNING】使用金額が予算を超えています</strong></h4>
		</c:if>
		<br>
	</c:param>
</c:import>