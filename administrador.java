package local;

import java.util.Calendar;

public class administrador extends personas {
/*en lugar de que tenga todos los privilegios lo que haremos sera que marque la fecha de entrada y la fecha de salida.*/
	boolean all_privilegios=false;
	
	public administrador(String usuario, String contraseña, String correo_electronico, int pregunta_seguridad,
			String repuesta_seguridad) {
		super(usuario, contraseña, correo_electronico, pregunta_seguridad, repuesta_seguridad);
		// TODO Auto-generated constructor stub
	}


	public administrador(String usuario, String contraseña, String correo_electronico, int pregunta_seguridad,
			String repuesta_seguridad, boolean all_privilegios) {
		super(usuario, contraseña, correo_electronico, pregunta_seguridad, repuesta_seguridad);
		this.all_privilegios=all_privilegios;
		// TODO Auto-generated constructor stub
	}
	public administrador() {
		
	}
	public boolean getAll_privilegios() {
		return all_privilegios;
	}
	public void modificarAtributos(String usuario_actual) {
		String opcion;
		entrada_salida teclado2=new entrada_salida();
		do {
		System.out.println("Modificar: \n"+
		"1.Contraseña\n"+
				"2.Correo electronico\n"+
		"3.Pregunta de seguridad\n"+
				"4.Respuesta de seguridad\n"+
		"5.Privilegios\n"+
				"6.Salir");
		opcion=teclado2.tipoString("string");
		switch(opcion) {
		case "1":
			System.out.println("Contraseña actual: "+contraseña+"\nNueva contraseña: ");
			this.contraseña=teclado2.tipoString("string");
			break;
		case "2":
			System.out.println("Correo electronico actual: "+correo_electronico+"\nNuevo correo: ");
			this.correo_electronico=teclado2.tipoString("string");
			break;
		case "3":
			System.out.println("Pregunta de seguridad actual: "+pregunta_seguridad+"\nNueva pregunta de seguridad: ");
			System.out.println("Seleccione una pregunta de seguridad para recuperar la contraseña:\n"
					+ "1.¿Cuál fue mi primera mascota?\n" + "2.¿Cual fue tu primer trabajo?\n"
					+ "3.¿Dónde naciste?\n" + "4.¿Como se llama tu abuelo?\n"
					+ "5.¿Cuál es el nombre de tu colegio?\n" + "6.¿Cual es tu comida favorita?");
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
			if(usuario_actual.equalsIgnoreCase(usuario)) {
				System.out.println("No puede modificar los privilegios de una sesion inciada actualmente");
			}else {
				do {
				System.out.println("Todos los priviledios: "+all_privilegios+"\n1.Asignar todos los privilegios\n"+
			"2.Quitarle todos los privilegios");
		
				opcion=teclado2.tipoString("string");
				}while(!opcion.equals("1") && !opcion.equals("2"));
				if(opcion.equals("1")) {
					this.all_privilegios=true;
				}else {
					this.all_privilegios=false;
				}
			}
			break;
		default:
			break;
		}
		}while(!opcion.equals("6"));
	}

	
}
