package br.com.vtjk.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class CriadorDeSessionFactory implements
		ComponentFactory<SessionFactory> {

	private SessionFactory factory;

	public SessionFactory getInstance() {
		return this.factory;
	}

	@PostConstruct
	public void abre() {
		Configuration cfg = new Configuration();
		cfg.configure();
		this.factory = cfg.buildSessionFactory();
	}

	@PreDestroy
	public void fecha() {
		this.factory.close();
	}

}
