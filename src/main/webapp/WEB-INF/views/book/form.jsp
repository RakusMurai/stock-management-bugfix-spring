<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common.jsp"%>
<body>
	<div class="container">
		<h3>新書登録画面</h3>
		<div class="span8">
			<div class="row">
				<form:form modelAttribute="bookForm"
					action="${pageContext.request.contextPath}/book/save">
					<table class="table table-striped">
						<tr>
							<th>書籍名</th>
							<td>
								<form:input path="name" placeholder="Name" />
								<br>
								<form:errors path="name"></form:errors>
							</td>
						</tr>
						<tr>
							<th>著書</th>
							<td>
								<form:input path="author" placeholder="Author" />
								<br>
								<form:errors path="author"></form:errors>
							</td>
						</tr>
						<tr>
							<th>出版社</th>
							<td>
								<form:input path="publisher" placeholder="Publisher" />
								<br>
								<form:errors path="publisher"></form:errors>
							</td>
						</tr>
						<tr>
							<th>価格</th>
							<td>
								<form:input path="price" placeholder="Price" />
								<br>
								<form:errors path="price"></form:errors>
							</td>
						</tr>
						<tr>
							<th>ISBNコード</th>
							<td>
								<form:input path="isbncode" placeholder="Isbncode" />
								<br>
								<form:errors path="isbncode"></form:errors>
							</td>
						</tr>
						<tr>
							<th>発売日</th>
							<td>
								<input type="date" name="saledate">
								<br>
								<form:errors path="saledate"></form:errors>
							</td>
						</tr>
						<tr>
							<th>説明</th>
							<td>
								<form:input path="explanation" placeholder="Explanation" />
								<br>
								<form:errors path="explanation"></form:errors>
							</td>
						</tr>
						<tr>
							<th>画像</th>
							<td>
								<form:input path="image" placeholder="Image" />
								<br>
								<form:errors path="image"></form:errors>
							</td>
						</tr>
						<tr>
							<th>在庫</th>
							<td>
								<form:input path="stock" placeholder="Stock" />
								<br>
								<form:errors path="stock"></form:errors>
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