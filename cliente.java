public class cliente {
	boolean administrador=false;
	String usuario,contrase�a, recuperar_contrase�a, correo_electronico;
	public cliente(String usuario, String contrase�a, String correo_electronico) {
		this.usuario=usuario;
		this.contrase�a=contrase�a;
		this.correo_electronico=correo_electronico;
		
	}
	public boolean comprobarUsuario(String usuario, String contrase�a){
		boolean correcto=false;
			if(usuario.equalsIgnoreCase(this.usuario) && contrase�a.equals(this.contrase�a)) {
				correcto=true;
			}
		return correcto;
	}
}