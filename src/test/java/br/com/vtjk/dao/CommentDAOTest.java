package br.com.vtjk.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import br.com.vtjk.modelo.Comment;

public class CommentDAOTest {

	@Test
	public void testAddComment() {
		Comment comment = getComment();
		Session session = getSession();
		
		Transaction tx = session.beginTransaction();
		session.save(comment);
		tx.commit();
		
		Comment c = (Comment) session.load(Comment.class, comment.getId());
		assertEquals("avanti!!", c.getComment());
	}
	
	@Test(expected=org.hibernate.ObjectNotFoundException.class)
	public void testRemoveComment() {
		Comment comment = getComment();
		Session session = getSession();
		
		Transaction tx = session.beginTransaction();
		session.delete(comment);
		tx.commit();
		
		Comment c = (Comment) session.load(Comment.class, comment.getId());
		System.out.println(c.getId());
	}
	
	@Test
	public void testLista() throws Exception {
		Comment comment = getComment();
		Session session = getSession();
		
		Transaction tx = session.beginTransaction();
		session.save(comment);
		tx.commit();
		
		Criteria criteria = session.createCriteria(Comment.class);
		List<Comment> comments = criteria.list();
		
		assertEquals(1, comments.size());
	}
	
	@Test
	public void testListaPorTopico(){
		Session session = getSession();
		
		Comment c1 = new Comment();
		c1.setComment("relax!");
		c1.setTopico("crise");
		c1.setEmail("banco@banco.com.br");
		
		Transaction tx = session.beginTransaction();
		session.save(c1);
		tx.commit();
		
		Criteria criteria = session.createCriteria(Comment.class)
				.add(Restrictions.ilike("topico", "crise", MatchMode.ANYWHERE));
		List<Comment> comments = criteria.list();
		
		assertEquals(1, comments.size());
	}
	
	//métodos auxiliares
	private Session getSession() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		return session;
	}
	
	private Comment getComment() {
		Comment comment = new Comment();
		comment.setId(1);
		comment.setTopico("palmeiras");
		comment.setComment("avanti!!");
		comment.setEmail("verdao@verdao.com.br");
		return comment;
	}

}
