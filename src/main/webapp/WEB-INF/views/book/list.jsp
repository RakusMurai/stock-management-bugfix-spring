<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>
<body>
	<div class="container">
		<sec:authorize access="hasRole('ROLE_MEMBER') and isAuthenticated()">
			<sec:authentication var="memberName" property="principal.member.name" />
			<c:out value="${memberName}" />&nbsp;
						</sec:authorize>
		さん こんにちは！
		<br>
		<a href="${pageContext.request.contextPath}/logout/sessionInvalidate">ログアウト</a>
		<br>
		<a href="${pageContext.request.contextPath}/book/form">新書登録</a>
		<br>
		<h3>書籍一覧</h3>
		<div class="span8">
			<div class="row">
				<table class="table table-striped">
					<tr>
						<th>書籍</th>
						<th>在庫数</th>
					</tr>
					<c:forEach var="book" items="${bookList}">
						<tr>
							<td>
								<a
									href="${pageContext.request.contextPath}/book/show/${book.id}"><c:out
										value="${book.name}" /></a>
							</td>
							<td>
								<c:out value="${book.stock}" />
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
