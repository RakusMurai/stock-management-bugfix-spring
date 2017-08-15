<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>
<body>
	<div class="container">
		<h3>メンバー登録画面</h3>
		<div class="span8">
			<div class="row">
				<form:form modelAttribute="memberForm"
					action="${pageContext.request.contextPath}/member/create">
					<table class="table table-striped">
						<tr>
							<th>氏名</th>
							<td>
								<form:input path="name" placeholder="Name" />
								<br>
								<form:errors path="name"></form:errors>
							</td>
						</tr>
						<tr>
							<th>メールアドレス</th>
							<td>
								<form:input path="mailAddress" placeholder="Email" />
								<br>
								<form:errors path="mailAddress"></form:errors>
							</td>
						</tr>
						<tr>
							<th>パスワード</th>
							<td>
								<form:password path="password" placeholder="Password" />
								<br>
								<form:errors path="password"></form:errors>
							</td>
						</tr>
						<tr>
							<th>確認用パスワード</th>
							<td>
								<form:password path="passwordCheck" placeholder="Password" />
								<br>
								<form:errors path="passwordCheck"></form:errors>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input class="btn" type="submit" value="登録">
							</td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>