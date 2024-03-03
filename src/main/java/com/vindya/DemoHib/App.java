package com.vindya.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
    	Alien tel = new Alien();
//    	tel.setAid(104);
//    	tel.setAname("dpc");
//    	tel.setColor("green");
    	
    	Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
    	ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf=con.buildSessionFactory(reg);
    	Session session1 =sf.openSession();
    	Session session2= sf.openSession();    	
    	Transaction tx=session1.beginTransaction();
    	Transaction tx1=session2.beginTransaction();
    	
//        session.save(tel);
        tel=(Alien)session1.get(Alien.class,101);
        System.out.println(tel);
        tel=(Alien)session2.get(Alien.class,101);
        
        tx.commit();
        tx1.commit();
        
        System.out.println(tel);
//        root@localhost:3306
    }
}
