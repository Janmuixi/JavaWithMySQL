import paqueteDiagrama.*;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class Hibernate4 {
	public static void main(String[] args){
		//En primer lugar se obtiene la sesión creada por el Singleton.
		SessionFactory sesion = HibernateUtil.getSessionFactory();

		//Abrimos sesión e iniciamos una transacción
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Depart dep = new Depart();
		try {
			dep = (Depart) session.load(Depart.class, 10);
			Set<Emple> listaemp = dep.getEmples();
			Iterator<Emple> it = listaemp.iterator();
			
			while(it.hasNext()) {
			    System.out.println("Nombre: " + it.next().getApellido());
			    System.out.println("Salario: " + it.next().getSalario()); 
			}
		} catch (Exception e) {
			System.out.println("no hay mas usuarios");
		}
			
			
		tx.commit();
		session.close();
		System.exit(0);
	}
}