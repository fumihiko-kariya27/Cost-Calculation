<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:param name="content">
	<h3>以下の内容を保存しました</h3>
	<div>
		<table border="2">
			<tr>
				<th>使用する金額</th>
				<td><c:out value="${r.result}" /></td>
			</tr>
			<tr>
				<th>進捗率</th>
				<td><c:out value="${r.parcent}" /></td>
			</tr>
			<tr>
				<th>差し引き予算</th>
				<td><c:out value="${r.remaining}" /></td>
			</tr>
		</table>
	</div>
</c:param>