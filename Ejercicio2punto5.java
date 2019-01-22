import java.sql.*;
import java.util.Scanner;

public class Ejercicio2punto5 {

    public static void main(String[] args) {

        System.out.println("Numero de departamento: ");
        Scanner departamento = new Scanner(System.in);
        String dept_no = departamento.nextLine();
        
        System.out.println("Numero de incremento de salario: ");
        Scanner incremento = new Scanner(System.in);
        String increment = incremento.nextLine();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection 
                    ("jdbc:mysql://localhost/ejemplo","jan","");
            Statement sentencia = conexion.createStatement();
            String sql = "UPDATE emple SET salario = salario + \""+increment+"\" where dept_no=\""+dept_no+"\"";
            int result = sentencia.executeUpdate(sql);
            
            System.out.println("se han modificado " + result + " columnas");
            sentencia.close();
            conexion.close();
        } catch (ClassNotFoundException cn) { cn.printStackTrace();
        } catch (SQLException e) {e.printStackTrace();
        }
    }
}