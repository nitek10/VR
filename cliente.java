package proyecto;
public class cliente {
	boolean administrador=false;
	int pregunta_seguridad;
	String usuario,contrase�a, respuesta_seguridad, correo_electronico;
	public cliente(String usuario, String contrase�a, String correo_electronico, int pregunta_seguridad, String repuesta_seguridad) {
		this.usuario=usuario;
		this.contrase�a=contrase�a;
		this.correo_electronico=correo_electronico;
		this.pregunta_seguridad=pregunta_seguridad;
		this.respuesta_seguridad=respuesta_seguridad;
	}
	
	public cliente(String usuario, String contrase�a, String correo_electronico, int pregunta_seguridad, String repuesta_seguridad, boolean administrador) {
		this.usuario=usuario;
		this.contrase�a=contrase�a;
		this.correo_electronico=correo_electronico;
		this.pregunta_seguridad=pregunta_seguridad;
		this.respuesta_seguridad=respuesta_seguridad;
		this.administrador=administrador;
	}
	public boolean comprobarUsuario(String usuario, String contrase�a){
		boolean correcto=false;
			if(usuario.equalsIgnoreCase(this.usuario) && contrase�a.equals(this.contrase�a)) {
				correcto=true;
			}
		return correcto;
	}
	public boolean getAdministrador() {
		return administrador;
	}
	public void setAdministrador(boolean administrador) {
		this.administrador=administrador;
	}
}