package local;

public class cliente extends personas {



	public cliente(String usuario, String contrase�a, String correo_electronico, int pregunta_seguridad,
			String repuesta_seguridad) {
		super(usuario, contrase�a, correo_electronico, pregunta_seguridad, repuesta_seguridad);
		// TODO Auto-generated constructor stub
	}
	public cliente() {
	
	}

	
	public void modificarAtributos() {
		String opcion;
		entrada_salida teclado2=new entrada_salida();
		System.out.println("Modificar: \n"+
		"1.Contrase�a\n"+
				"2.Correo electronico\n"+
		"3.Pregunta de seguridad\n"+
				"4.Respuesta de seguridad\n"+
				"5.Salir");
		opcion=teclado2.tipoString("string");
		switch(opcion) {
		case "1":
			System.out.println("Contrase�a actual: "+contrase�a+"\nNueva contrase�a: ");
			this.contrase�a=teclado2.tipoString("string");
			break;
		case "2":
			System.out.println("Correo electronico actual: "+correo_electronico+"\nNuevo correo: ");
			this.correo_electronico=teclado2.tipoString("string");
			break;
		case "3":
			System.out.println("Pregunta de seguridad actual: "+pregunta_seguridad+"\nNueva pregunta de seguridad: ");
			System.out.println("Seleccione una pregunta de seguridad para recuperar la contrase�a:\n"
					+ "1.�Cu�l fue mi primera mascota?\n" + "2.�Cual fue tu primer trabajo?\n"
					+ "3.�D�nde naciste?\n" + "4.�Como se llama tu abuelo?\n"
					+ "5.�Cu�l es el nombre de tu colegio?\n" + "6.�Cual es tu comida favorita?");
			do {
				opcion=teclado2.tipoString("int");
			}while(!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3") && !opcion.equals("4") && !opcion.equals("5") && !opcion.equals("6") );
			this.pregunta_seguridad=Integer.parseInt(opcion);
			break;
		case "4":
			System.out.println("Respuesta de seguridad actual: "+respuesta_seguridad+"\nNueva respuesta de seguridad: ");
			this.respuesta_seguridad=teclado2.tipoString("string");
			break;
		case "5":
			break;
		default:
			break;
		}
	}
	
	@Override
	public String toString() {
		return "nombre cliente: "+usuario;
	}
	
	
}
