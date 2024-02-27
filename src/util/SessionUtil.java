package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionUtil {
private static Configuration configuration;
private static ServiceRegistry serviceRegistry;

static {
	configuration=new Configuration().configure();
	serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	
}
public static SessionFactory getSessionFactory() {
	return configuration.buildSessionFactory(serviceRegistry);
}
public static Session getSession() {
	return configuration.buildSessionFactory(serviceRegistry).openSession();
}
}
