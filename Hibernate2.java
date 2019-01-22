import paqueteDiagrama.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class Hibernate2 {
	public static void main(String[] args){
		//En primer lugar se obtiene la sesión creada por el Singleton.
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		
		//Abrimos sesión e iniciamos una transacción
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Inserto una fila en emple");
		
		//Creamos un nuevo objeto Emple y damos valor a sus atributos
		Emple emp = new Emple();
		emp.setEmpNo(3);
		emp.setApellido("MUIXI");
		emp.setOficio("VENDEDOR");
		emp.setDir(7234);
		Date now = new Date();
		emp.setFechaAlt(now);
		emp.setSalario(4000);
		emp.setComision(null);
		Depart dep = new Depart();
		dep.setDeptNo((byte) 10);
		dep.setDnombre("MARKETING");
		dep.setLoc("GUADALAJARA");
		emp.setDepart(dep);
		
		//Guardamos en la base de datos y comprometemos la información
		session.save(emp);
		tx.commit();
		session.close();
		System.exit(0);
	}
}