package ucr.casoUso;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ControladorLogin {
	
	VistaLogin interfazLogin;
	ModeloLogin modeloLogin;
	private static ControladorLogin primeraInstancia = null;
		
	public ControladorLogin() {
	
	}
	
	public void iniciar(){
		
		interfazLogin = new VistaLogin();
		modeloLogin = ModeloLogin.obtenerInstancia();
	
	}
	
	public static ControladorLogin obtenerInstancia() {

		if(primeraInstancia == null){
			primeraInstancia = new ControladorLogin();
		}
		return primeraInstancia;
	
	}
	
	public boolean enviarDatos(String [] credenciales) {
		
		boolean exito = false;
		String [] datosUsuario;
		Controlador controlador = Controlador.obtenerInstancia();
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(credenciales[1].getBytes());
			credenciales[1] = new String(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Error de hash");
		}
		
		//Cambiar las comillas para que sean aceptadas por SQL
		credenciales[1].replaceAll("'", "0");
		
		datosUsuario = modeloLogin.autenticar(credenciales);
		
		if (!datosUsuario[0].equals("")) {
			//Guardar datos del usuario
			controlador.setNombreUsuario(datosUsuario[0]);
			controlador.setApellidoUsuario(datosUsuario[1]);
			controlador.setTipoUsuario(datosUsuario[2]);
			controlador.setCedulaUsuario(datosUsuario[4]);
			if (datosUsuario[2].compareTo("Asistente") == 0 || datosUsuario[2].compareTo("Instructor") == 0 || datosUsuario[2].compareTo("Instructor Jefe") == 0) {
				controlador.setNumInstructor(datosUsuario[3]);
			}
			exito = true;
		}
		
		return exito;
		
	}
	
	public void setVista() {
		interfazLogin.setVista();
	}

}
