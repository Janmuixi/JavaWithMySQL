import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio2punto3 {
	public static void main (String [] args) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection
					("jdbc:mysql://localhost/ejemplo","jan","");
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet resul = null;
			resul = dbmd.getPrimaryKeys("ejemplo", null, "depart");
			while (resul.next()){
				String name = resul.getString("COLUMN_NAME");
				System.out.println(name);
			}
			
			resul = dbmd.getImportedKeys("ejemplo", null, "emple");
			while (resul.next()){
				String name = resul.getString("FKCOLUMN_NAME");
				System.out.println(name);
			}
			
			conexion.close();
		}
		catch (ClassNotFoundException cn) {cn.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}
}
