package br.com.vtjk.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
@Component
public class CriadorDeSession implements ComponentFactory<Session> {

	private final SessionFactory factory;
	private Session session;

	public CriadorDeSession(SessionFactory factory) {
		this.factory = factory;
	}
	
	public Session getInstance() {
		return this.session;
	}

	@PostConstruct
	public void abre() {
		this.session = this.factory.openSession();
	}
	
	@PreDestroy
	public void fecha() {
		this.session.close();
	}

}
