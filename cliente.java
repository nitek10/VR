public class cliente {
	boolean administrador=false;
	String usuario,contraseņa, recuperar_contraseņa, correo_electronico;
	public cliente(String usuario, String contraseņa, String correo_electronico) {
		this.usuario=usuario;
		this.contraseņa=contraseņa;
		this.correo_electronico=correo_electronico;
		
	}
	public boolean comprobarUsuario(String usuario, String contraseņa){
		boolean correcto=false;
			if(usuario.equalsIgnoreCase(this.usuario) && contraseņa.equals(this.contraseņa)) {
				correcto=true;
			}
		return correcto;
	}
}