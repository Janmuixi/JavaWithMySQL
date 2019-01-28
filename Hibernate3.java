import paqueteDiagrama.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class Hibernate3 {
	public static void main(String[] args){
		//En primer lugar se obtiene la sesión creada por el Singleton.
		SessionFactory sesion = HibernateUtil.getSessionFactory();

		//Abrimos sesión e iniciamos una transacción
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Emple emp = (Emple) session.get(Emple.class, 7369);
		if (emp==null) {
			System.out.println ("No existe el empleado");
			}
			else {
			System.out.printf("Nombre y salario empleado: %s%n", emp.getApellido()+ " " + emp.getSalario());
			} 
		tx.commit();
		session.close();
		System.exit(0);
	}
}