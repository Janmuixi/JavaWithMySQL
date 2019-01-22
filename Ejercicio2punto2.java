import java.sql.*;

public class Ejercicio2punto2 {
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
			for (int i = 1; i <= columnCount; i++ ) {
				  String name = rsmd.getColumnName(i);
				  String type = rsmd.getColumnTypeName(i);
				  int size = rsmd.getColumnDisplaySize(i);
				  int nullable = rsmd.isNullable(i);
				  System.out.println(name + " - " + type + " - " + size + " - " + nullable);
				}
			conexion.close();
		}
		catch (ClassNotFoundException cn) {cn.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}
}
