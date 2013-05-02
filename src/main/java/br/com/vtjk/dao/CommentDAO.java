package br.com.vtjk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.vtjk.modelo.Comment;

@Component
public class CommentDAO {
	
	private final Session session;

	public CommentDAO(Session session) {
		this.session = session;
	}
	
	public void adiciona(Comment comment) {
		Transaction tx = this.session.beginTransaction();
		this.session.save(comment);
		tx.commit();
	}
	
	public void remove(Comment comment) {
		Transaction tx = this.session.beginTransaction();
		this.session.delete(comment);
		tx.commit();
	}
	
	public List<Comment> lista() {
		Criteria criteria = session.createCriteria(Comment.class);
		return criteria.list();
	}
	
	public List<Comment> listaPorTopico(String topico){
		Criteria criteria = session.createCriteria(Comment.class)
				.add(Restrictions.ilike("topico", topico, MatchMode.ANYWHERE));
		System.out.println(criteria.list().size());
		return criteria.list();
	}
}
