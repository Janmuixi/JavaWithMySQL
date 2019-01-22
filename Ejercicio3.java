import java.sql.*;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        System.out.println("Localidad: ");
        Scanner localidad = new Scanner(System.in);
        String loc = localidad.nextLine();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion=DriverManager.getConnection 
                    ("jdbc:mysql://localhost/ejemplo","jan","");
            Statement sentencia =conexion.createStatement();
            String sql = "select depart.dnombre, emple.apellido from emple, depart where depart.dept_no=emple.dept_no and loc=\""+loc+"\"";
            ResultSet result = sentencia.executeQuery(sql);
            
            while (result.next()){
                System.out.printf("%s, %s, %n",
                        result.getString("depart.dnombre"),
                        result.getString("emple.apellido"));
            }
            
            result.close();
            sentencia.close();
            conexion.close();
        } catch (ClassNotFoundException cn) { cn.printStackTrace();
        } catch (SQLException e) {e.printStackTrace();
        }
    }
}