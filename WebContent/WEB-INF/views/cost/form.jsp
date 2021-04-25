<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
スコープにresultの値がない場合は最初の数値入力の画面を表示

 --%>
<c:import url="../layout/layout.jsp">
	<c:param name="content">
		<c:choose>
			<c:when test = "${result == null}">
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
			</c:when>
			<c:otherwise>
				<div>
					<h3>人件費進捗予測</h3>
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
				<h5><a href="<c:url value='/cost/save' />">保存する</a></h5>
				<c:if test="${parcent > 80 && parcent <= 100}">
					<h4><strong class="warning">【WARNING】使用できる人件費が20％を下回りました</strong></h4>
				</c:if>
				<c:if test="${parcent > 100}">
					<h4><strong class="warning">【WARNING】使用金額が予算を超えています</strong></h4>
				</c:if>
			</c:otherwise>
		</c:choose>
		<%
			if(request.getSession().getAttribute("result") != null){
				request.getSession().removeAttribute("result");
			}
			%>
	</c:param>
</c:import>