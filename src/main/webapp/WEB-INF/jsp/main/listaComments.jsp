<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>E-mail</th>
			<th>Comentário</th>
			<th>Tópico</th>
		</tr>
	</thead>



	<tbody>
		<c:forEach var="comment" items="${commentList}">
			<tr>
				<td>${comment.id}</td>
				<td>${comment.email}</td>
				<td>${comment.comment}</td>
				<td>${comment.topico}</td>
			</tr>
		</c:forEach>

	</tbody>


</table>
<br>