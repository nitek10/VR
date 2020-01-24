public class cliente {
	boolean administrador=false;
	String usuario,contraseña, recuperar_contraseña, correo_electronico;
	public cliente(String usuario, String contraseña, String correo_electronico) {
		this.usuario=usuario;
		this.contraseña=contraseña;
		this.correo_electronico=correo_electronico;
		
	}
	public boolean comprobarUsuario(String usuario, String contraseña){
		boolean correcto=false;
			if(usuario.equalsIgnoreCase(this.usuario) && contraseña.equals(this.contraseña)) {
				correcto=true;
			}
		return correcto;
	}
}