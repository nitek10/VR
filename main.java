package proyecto;
import java.util.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<cliente> array_clientes = new ArrayList<cliente>();
		/*ArrayList<reserva> array_reservas = new ArrayList<reserva>();*/
		int opcion, pregunta_seguridad;
		int borrar=0;
		String usuario, contrase�a, respuesta_seguridad, correo_electronico, fecha;
		String nombre, metodo_de_pago;
		Scanner teclado=new Scanner(System.in);
		/*System.out.println("Usuario:");
		usuario=teclado.nextLine();
		System.out.println("Contrase�a");
		contrase�a=teclado.nextLine();
		array_clientes.add(new cliente(usuario,contrase�a));*/
		
		do{
		System.out.println("1.Iniciar sesi�n\\Registrarse.\n"
				+ "2.Hacer reserva\n");
		opcion=teclado.nextInt();
		teclado.nextLine();
		switch (opcion){
		case 1: 
			System.out.println("1.Iniciar sesion.\n"+
						"2.Registrarse");
			opcion=teclado.nextInt();
			teclado.nextLine();
				switch(opcion){
					case 1:
						System.out.println("Usuario:");
						usuario=teclado.nextLine();
						System.out.println("Contrase�a:");
						contrase�a=teclado.nextLine();
						for(cliente i: array_clientes) {
							if(i.comprobarUsuario(usuario, contrase�a)==true) {
								System.out.println("Sesion inciada correctamente");
								if(i.getAdministrador()==true){
									/*Menu de administrador*/
								}else{
									/*Menu de clientes*/
								}
							}else {
								System.out.println("Fallo al iniciar sesion");
							}
						}
						break;
					case 2:
						System.out.println("Inserte el nombre de usuario");
						usuario=teclado.nextLine();
						System.out.println("Inserte la contrase�a");
						contrase�a=teclado.nextLine();
						System.out.println("Inserte el correo electronico");
						correo_electronico=teclado.nextLine();
						System.out.println("Seleccione una pregunta de seguridad para recuperar la contrase�a:\n"+
						"1.�Cu�l fue mi primera mascota?\n"+
								"2.�Cual fue tu primer trabajo?\n"+
						"3.�D�nde naciste?\n"+
								"4.�Como se llama tu abuelo?\n"+
						"5.�Cu�l es el nombre de tu colegio?\n"+
								"6.�Cual es tu comida favorita?");
						pregunta_seguridad=teclado.nextInt();
						teclado.nextLine();
						System.out.println("Respuesta: ");
						respuesta_seguridad=teclado.nextLine();
						array_clientes.add(new cliente(usuario,contrase�a,correo_electronico, pregunta_seguridad, respuesta_seguridad));
						break;
				}
			break;
		case 2:
			/*Crear un if por si no hay salas de vr u ordenadores*/
			System.out.println("1.Ver salas y ordenadores disponibles de hoy\n"+
			"2.Consultar fecha concreta");
			opcion=teclado.nextInt();
			teclado.nextLine();
				switch(opcion){
				case 1:
					/*metodos de alvaro para sacar la fecha de hoy y comprobar las reservas*/
					break;
				case 2:
					System.out.println("Introduce la fecha espec�fica\n"+
				"DD/MM/YYYY");
					fecha=teclado.nextLine();
					/*Comprobar las reservas*/
					break;
				}
			break;
		}
				
				
		}while(borrar==0);
	}

}