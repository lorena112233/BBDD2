package banco;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.util.Scanner;

//import com.mysql.jdbc.Statement;

public class Clientes {

	public static void main(String[] args) {
		// Desarrollado el Main - se llama a los metodos desde el menu inicial
		// desarrollado en la clase empleado
		Scanner entrada = new Scanner(System.in);
		int opcion;
		ClienteDDBB RegistroDatosUser = new ClienteDDBB();

		do {
			System.out.println("1.- Introduccion de datos");
			System.out.println("2.- Listado de datos");
			System.out.println("3.- Insertar los datos ");
			System.out.println("4.- Fin");
			opcion = entrada.nextInt();
			switch (opcion) {

			case 1:
				RegistroDatosUser.Datos();
				break;

			case 2:
				RegistroDatosUser.Listado();
				break;

			case 3:
				RegistroDatosUser.insert();
				break;


			case 4:
				System.out.println("Agur");
				break;

			}
		} while (opcion < 4);
		entrada.close();
		
		
		
//		try {
//			// generar la conexion
//			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banco", "root", "");
//
//			// crear un objeto de tipo Statement para realizar las consultas
//			Statement miStatement = (Statement) miConexion.createStatement();
//
////******** INSERT *******
//			String instruccionSql = "INSERT INTO CLIENTES (IDCLIENTE, NOMBRE, ADRESS, POSTCODE, TELEFONO, DOB) values(1323, 'Juan', 'PASEO, 2', '95687', 777111111, '1855-07-08')";
//			miStatement.executeUpdate(instruccionSql);
//
//			// dejo comentado el insert, porque ya lo he hecho, y me da error porque es
//			// repetido
//// ******* UPDATE *******
////			String instruccionSql = "UPDATE CLIENTES SET TELEFONO = 100557 WHERE NOMBRE = 'FERNANDA'";
////			miStatement.executeUpdate(instruccionSql);
//
//			// ejecutar sql
//			ResultSet miResulset = miStatement.executeQuery("SELECT * FROM CLIENTES");
//
//			// Bucle para visualizar dichos datos
//			while (miResulset.next()) {
//				System.out.println(miResulset.getString("Nombre") + " " + miResulset.getString("Telefono"));
//
//			}
//		} catch (Exception e) {
//			System.out.println("no conecta!");
//			// si quiero saber el tipo de error
//			e.printStackTrace();
//		}
	}

}
