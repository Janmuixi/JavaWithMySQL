import java.sql.*;

public class Ejercicio1 {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/ejemplo","jan","");
			Statement sentencia =conexion.createStatement();
			String sql = "SELECT * from emple where dept_no = 10";
			ResultSet result = sentencia.executeQuery(sql);
			while (result.next()){
				System.out.printf("%s, %s, %d, %n",
						result.getString("APELLIDO"),
						result.getString("OFICIO"),
						result.getInt("SALARIO"));
			}
			result.close();
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException cn) { cn.printStackTrace();
		} catch (SQLException e) {e.printStackTrace();
		}
	}
}