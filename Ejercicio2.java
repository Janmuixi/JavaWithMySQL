import java.sql.*;

public class Ejercicio2 {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion2=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/ejemplo","jan","");
			Statement sentencia2 =conexion2.createStatement();
			String sql = "SELECT emple.apellido, emple.salario, depart.dnombre from emple join depart using(dept_no) order by salario desc limit 1";
			ResultSet result = sentencia2.executeQuery(sql);
			while (result.next()){
				System.out.printf("%s, %d, %s, %n",
						result.getString("emple.APELLIDO"),
						result.getInt("emple.SALARIO"),
						result.getString("depart.DNOMBRE"));
			}
			result.close();
			sentencia2.close();
			conexion2.close();
		} catch (ClassNotFoundException cn) { cn.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		}
	}
}
