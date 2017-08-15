<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="common/common.jsp"%>
<body>
	<div class="container">
		<div class="span8">
			<img src="img/logo.gif">
			<div class="row">
				<form:errors path="loginForm.*" />
				<form:form modelAttribute="loginForm"
					action="${pageContext.request.contextPath}/login">
					<table class="table table-striped">
						<tr>
							<th>メールアドレス</th>
							<td>
								<form:input path="mailAddress" placeholder="Email" />
								<form:errors path="mailAddress" />
							</td>
						</tr>
						<tr>
							<th>パスワード</th>
							<td>
								<form:password path="password" placeholder="Password" />
								<form:errors path="password" />
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input class="btn" type="submit" value="ログイン">
							</td>
						</tr>
					</table>
				</form:form>
				<a href="/member/form" id="toInsertMember">メンバー登録はこちらから</a>
			</div>
		</div>
	</div>
</body>
</html>
