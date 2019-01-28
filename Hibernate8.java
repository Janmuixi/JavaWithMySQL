
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import paqueteDiagrama.Depart;
import paqueteDiagrama.Emple;
import paqueteDiagrama.HibernateUtil;
public class Hibernate8 {
	public static void main(String[] args){
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("from emple as e, depart as d");
		List <Emple> lista =q.list();
		Iterator <Emple> iter = lista.iterator();
		while (iter.hasNext()){
			Emple emp = (Emple) iter.next();
			System.out.printf("%s, %d%n", emp.getApellido(), emp.getSalario());
		}
		session.close();
		System.exit(0);
	}
}