<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout/layout.jsp">
	<c:param name="content">
		<c:choose>
			<c:when test="${message} != null">
				<div id="message">
					<p>数値が入力されていません。TOPページへ戻ってやり直してください</p>
				</div>
			</c:when>
			<c:otherwise>
			<h3>使用履歴一覧</h3>
				<table>
					<tr>
						<th>登録日時</th>
						<th>使用金額</th>
						<th>差し引きの金額</th>
						<th>進捗</th>
					</tr>
					<c:forEach var="cost" items="${costs}" varStatus="status">
						<tr>
							<td><fmt:formatDate value="${cost.date}" pattern="yyyy-MM-dd" /></td>
							<td><c:out value="${cost.result}" />円使用</td>
							<td><c:out value="${cost.remaining}" />円</td>
							<td><c:out value="${cost.parcent}" />％</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</c:param>
</c:import>