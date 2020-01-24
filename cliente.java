public class cliente {
	boolean administrador=false;
	int pregunta_seguridad;
	String usuario,contraseña, respuesta_seguridad, correo_electronico;
	public cliente(String usuario, String contraseña, String correo_electronico, int pregunta_seguridad, String repuesta_seguridad) {
		this.usuario=usuario;
		this.contraseña=contraseña;
		this.correo_electronico=correo_electronico;
		this.pregunta_seguridad=pregunta_seguridad;
		this.respuesta_seguridad=respuesta_seguridad;
	}
	public boolean comprobarUsuario(String usuario, String contraseña){
		boolean correcto=false;
			if(usuario.equalsIgnoreCase(this.usuario) && contraseña.equals(this.contraseña)) {
				correcto=true;
			}
		return correcto;
	}
}