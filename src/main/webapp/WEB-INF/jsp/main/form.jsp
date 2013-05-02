<form id="commentsForm" action="<c:url value="/comments"/>" method="POST">
	<fieldset id="newComment">
		
		<label for="email">E-mail:</label>
		<input id="email" class="required" type="text" name="comment.email" maxlength="50"/>
		<br>
		
		<label for="login">Comentário:</label><br/>
		<textarea id="login" class="required" name="comment.comment">
		</textarea>
		<br><br>
		<input type="hidden" name="comment.topico" value="${topico}" />
		
		<button type="submit">Enviar</button>
		
		
			
		<script type="text/javascript">
			$('#commentsForm').validate();
		</script>
		
	</fieldset>
</form>