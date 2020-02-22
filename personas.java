package local;
public abstract class personas {
	int pregunta_seguridad;
	String usuario,contraseña, respuesta_seguridad, correo_electronico;
	public personas(String usuario, String contraseña, String correo_electronico, int pregunta_seguridad, String respuesta_seguridad) {
		this.usuario=usuario;
		this.contraseña=contraseña;
		this.correo_electronico=correo_electronico;
		this.pregunta_seguridad=pregunta_seguridad;
		this.respuesta_seguridad=respuesta_seguridad;
	}
	public personas() {
		/*este metodo sera para crear objetos de admin y clientes*/
	}
	
	public boolean comprobarUsuario(String usuario, String contraseña){
		boolean correcto=false;
			if(usuario.equalsIgnoreCase(this.usuario) && contraseña.equals(this.contraseña)) {
				correcto=true;
			}
		return correcto;
	}

	public String getUsuario() {
		return usuario;
	}
	public void recuperarContraseña() {
		System.out.println("repuesta: "+respuesta_seguridad);
		entrada_salida teclado2=new entrada_salida();
		metodos_main objeto_metodos=new metodos_main();
		String respuesta;
		System.out.println("Pregunta de seguridad: \n");
		objeto_metodos.preguntasSeguridad2(pregunta_seguridad);
		System.out.println("Respuesta de seguridad: ");
		respuesta=teclado2.tipoString("string");
		if(respuesta.equalsIgnoreCase(respuesta_seguridad)) {
			System.out.println("Inserte la nueva contraseña");
			this.contraseña=teclado2.tipoString("string");
		}
		
	}
}