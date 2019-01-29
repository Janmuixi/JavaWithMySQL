import paqueteDiagrama.*;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Hibernate9 {
	public static void main(String[] args){
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("select avg(e.salario), count(apellido) from Emple e group by e.depart");
		List <?> lista =q.list();
		Iterator <?> iter = lista.iterator();
		Object[] listaObj;
		while (iter.hasNext()){
			listaObj = (Object[]) iter.next();
			System.out.println(listaObj[0] + " - " + listaObj[1]);
		}
		session.close();
		System.exit(0);
	}
}