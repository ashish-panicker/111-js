package in.stackroute.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {


    private HibernateUtil() {}

    public static SessionFactory getSessionFactory() throws HibernateException {
        SessionFactory sessionFactory;
        Configuration cfg = new Configuration();
        cfg.configure();
        ServiceRegistry registry = cfg.getStandardServiceRegistryBuilder().build();
        sessionFactory = cfg.buildSessionFactory(registry);
        return sessionFactory;
    }

}
