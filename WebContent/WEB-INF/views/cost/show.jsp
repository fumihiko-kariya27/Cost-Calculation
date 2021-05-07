<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout/layout.jsp">
	<c:param name="content">
		<h3>以下の内容を保存しました</h3>
		<div>
			<table border="2">
				<tr>
					<th>使用する金額</th>
					<td><c:out value="${c.result}" />円</td>
				</tr>
				<tr>
					<th>進捗率</th>
					<td><c:out value="${c.parcent}" />％</td>
				</tr>
				<tr>
					<th>差し引き予算</th>
					<td><c:out value="${c.remaining}" />円</td>
				</tr>
				<tr>
					<th>登録日時</th>
					<td><fmt:formatDate value="${c.date}" pattern="yyyy-MM-dd" />に使用した人件費</td>
				</tr>
			</table>
		</div>
	</c:param>
</c:import>