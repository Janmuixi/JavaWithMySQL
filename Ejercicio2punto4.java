import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio2punto4 {
	public static void main (String [] args) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection
					("jdbc:mysql://localhost/ejemplo","jan","");
			Statement sentencia =conexion.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM depart");
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			System.out.println(columnCount);
			for (int i = 1; i <= columnCount; i++ ) {
				  String type = rsmd.getColumnTypeName(i);
				  System.out.println(type);
				}
			conexion.close();
		}
		catch (ClassNotFoundException cn) {cn.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}
}
