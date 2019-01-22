import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio2punto2diferente {
	public static void main (String [] args) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection
					("jdbc:mysql://localhost/ejemplo","jan","");
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet resul = null;
			resul = dbmd.getColumns(null,null,"depart",null);
			while (resul.next()){
				
				String catalogo = resul.getString("IS_NULLABLE");
				System.out.println(catalogo);
			}
			conexion.close();
		}
		catch (ClassNotFoundException cn) {cn.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}
}
