package proyecto;
public class cliente {
	boolean administrador=false;
	int pregunta_seguridad;
	String usuario,contraseņa, respuesta_seguridad, correo_electronico;
	public cliente(String usuario, String contraseņa, String correo_electronico, int pregunta_seguridad, String repuesta_seguridad) {
		this.usuario=usuario;
		this.contraseņa=contraseņa;
		this.correo_electronico=correo_electronico;
		this.pregunta_seguridad=pregunta_seguridad;
		this.respuesta_seguridad=respuesta_seguridad;
	}
	public boolean comprobarUsuario(String usuario, String contraseņa){
		boolean correcto=false;
			if(usuario.equalsIgnoreCase(this.usuario) && contraseņa.equals(this.contraseņa)) {
				correcto=true;
			}
		return correcto;
	}
	public boolean getAdministrador() {
		return administrador;
	}
}