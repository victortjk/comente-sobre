package br.com.vtjk.controllers;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.vtjk.dao.CommentDAO;
import br.com.vtjk.modelo.Comment;

@Resource
@Path("/")
public class MainController {
	
	private final Result result;
	private final CommentDAO dao;

	public MainController(Result result, CommentDAO dao) {
		this.result = result;
		this.dao = dao;
	}
	
	@Path("/")
	public void index() {
		
	}
	@Path("novo/{topico}")
	public void form(String topico) {
		
	}
		
	@Post("/topico")
	public void addTopic(String topico) {
		result.include("topico", topico).redirectTo(this).form(topico);
	}
	
	@Post("/comments")
	public void adiciona(Comment comment) {
		dao.adiciona(comment);
		result.redirectTo(this).listaPorTopico(comment.getTopico());
	}
	
	@Get("/comments")
	public List<Comment> listaComments() {
		return dao.lista();
	}
	@Path("/commentsByTopic")
	public List<Comment> listaPorTopico(String topico){
		return dao.listaPorTopico(topico);
	}
}
