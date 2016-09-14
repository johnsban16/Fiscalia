package ucr.casoUso;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeloCambioPassword {
	
	private static ModeloCambioPassword primeraInstancia;
		
		public static ModeloCambioPassword obtenerInstancia() {
			if(primeraInstancia == null)
				primeraInstancia = new ModeloCambioPassword();
			return primeraInstancia;
		}
	
	public boolean autenticar(String usuario, String pass){
		boolean valido = false;
		Connection c;
		Statement s;
		String consulta;
		Modelo m = Modelo.obtenerInstancia();
		try {
			c = m.getConnectionPool().reserveConnection();
			s = c.createStatement();
			consulta = "SELECT pass from usuario where cedula = " + usuario + "'";
			System.out.println(consulta);
			ResultSet rs = s.executeQuery(consulta);
			s.close();
			c.commit();
			c.close();
			m.getConnectionPool().releaseConnection(c);
			rs.next();
			if(rs.getString("pass") == hash(pass))
				valido = true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return valido;
	}
		
	public boolean actualizarPass(String user, String pass) {
		Connection c;
		Statement s;
		String consulta;
		boolean exito = false;
		Modelo m = Modelo.obtenerInstancia();
		try {
			c = m.getConnectionPool().reserveConnection();
			s = c.createStatement();
			consulta = "UPDATE usuario SET pass = '" + pass + "' WHERE cedula = '" + user + "'";
			System.out.println(consulta);
			s.executeUpdate(consulta);
			s.close();
			c.commit();
			c.close();
			m.getConnectionPool().releaseConnection(c);
			exito = true;
			return exito;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return exito;
	}
	
	public String hash(String pass){
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(pass.getBytes());
			pass = new String(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Error de hash");
		}
		return pass;
	}
}
