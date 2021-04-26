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
					<th>使用する金額</th>
					<th>出勤人数</th>
					<th>時給</th>
					<th>勤務時間</th>
				</tr>
				<tr>
					<td><c:out value="${c.budget}" /></td>
					<td><c:out value="${result}" /></td>
					<td><c:out value="${c.number_of_people}" /></td>
					<td><c:out value="${c.hourly_wage}" /></td>
					<td><c:out value="${c.time}" /></td>
				</tr>
			</table>
		</div><br><br>
		<h4>人件費の進捗は</h4><h2><strong><c:out value="${parcent}" />%</strong></h2><h4>です</h4><br>
		<h4>残りの人件費は</h4><h2><c:out value="${remaining}" />円</h2><h4>です。</h4><br>
		<h3><a href="<c:url value='/cost/save' />">保存する</a></h3>
		<c:if test="${parcent > 80 && parcent <= 100}">
			<h4><strong class="warning">【WARNING】使用できる人件費が20％を下回りました</strong></h4>
		</c:if>
		<c:if test="${parcent > 100}">
			<h4><strong class="warning">【WARNING】使用金額が予算を超えています</strong></h4>
		</c:if>
	</c:param>
</c:import>