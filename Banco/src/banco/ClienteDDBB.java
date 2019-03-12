package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class ClienteDDBB {
	private int idCliente;
	private String nombre;
	private String adress;
	private String postCode;
	private int telefono;

	// ++++++++++ getters y setters +++++++++
	public int getidCliente() {
		return idCliente;
	}

	public void setidCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

//**************************************

	Scanner entrada = new Scanner(System.in);

	ClienteDDBB miarray[] = new ClienteDDBB[1];

	public ClienteDDBB() {

	}

	public void Datos() {

		for (int i = 0; i < 1; i++) {
			ClienteDDBB objeto = new ClienteDDBB();

			System.out.println("Introducir el nombre ");
			//objeto.setNombre(entrada.nextLine());
			nombre = entrada.nextLine();
			objeto.setNombre(nombre);

			System.out.println("Introducir la direccion");
			//objeto.setAdress(entrada.nextLine());
			adress = entrada.nextLine();
			objeto.setAdress(adress);

			System.out.println("Introducir CP");
			//objeto.setPostCode(entrada.nextLine());
			postCode = entrada.nextLine();
			objeto.setPostCode(postCode);


			System.out.println("Introducir telefono");
			//objeto.setTelefono(entrada.nextInt());
			telefono = entrada.nextInt();
			objeto.setTelefono(telefono);;
			
			miarray[i]=objeto;
		}
	}

	public void Listado() {
		for (int i = 0; i < miarray.length; i++) {
			// de cualquiera de las dos formas muestra la info (dejo una comentada)
			miarray[i].mostrar();
		}
	}

	public void mostrar() {
//	System.out.println("Los empleado registrado son:");
		System.out.println(this.toString());
	}

	public void insert() {
		try {
			// generar la conexion
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banco", "root", "");

			// crear un objeto de tipo Statement para realizar las consultas
			Statement miStatement = (Statement) miConexion.createStatement();

//******** INSERT *******
//			String instruccionSql = "INSERT INTO CLIENTES (NOMBRE, ADRESS, POSTCODE, TELEFONO, DOB) values(nombre, adress, postCode, telefono, '1855-07-08')";
//			miStatement.executeUpdate(instruccionSql);

			// dejo comentado el insert, porque ya lo he hecho, y me da error porque es
			// repetido
// ******* UPDATE *******
			String instruccionSql = "UPDATE CLIENTES SET TELEFONO = 100557 WHERE NOMBRE = 'FERNANDA'";
			miStatement.executeUpdate(instruccionSql);

			// ejecutar sql
			ResultSet miResulset = miStatement.executeQuery("SELECT * FROM CLIENTES");

			// Bucle para visualizar dichos datos
			while (miResulset.next()) {
				System.out.println(miResulset.getString("Nombre") + " " + miResulset.getString("Telefono"));

			}
		} catch (Exception e) {
			System.out.println("no conecta!");
			// si quiero saber el tipo de error
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		return "\nnombre=" + this.nombre + "\nedad=" + this.adress + "\nSalario: " + this.postCode + "\nSexo: " + this.telefono + "\n";
	}

}
