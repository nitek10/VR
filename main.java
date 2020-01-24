
import java.util.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<cliente> array_clientes = new ArrayList<cliente>();
		ArrayList<reserva> array_reservas = new ArrayList<reserva>();
		int opcion;
		int borrar=0;
		String usuario, contraseña, pregunta_seguridad, respuesta_seguridad, correo_electronico, fecha;
		String nombre, metodo_de_pago;
		Scanner teclado=new Scanner(System.in);
		/*System.out.println("Usuario:");
		usuario=teclado.nextLine();
		System.out.println("Contraseña");
		contraseña=teclado.nextLine();
		array_clientes.add(new cliente(usuario,contraseña));*/
		
		do{
		System.out.println("1.Iniciar sesión\\Registrarse.\n"
				+ "2.Hacer reserva\n");
		opcion=teclado.nextInt();
		teclado.nextLine();
		switch (opcion){
		case 1: 
			System.out.println("1.Iniciar sesion.\n"+
						"2.Registrarse");
			opcion=teclado.nextInt();
			teclado.nextLine();
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
					System.out.println("Introduce la fecha específica\n"+
				"DD/MM/YYYY");
					fecha=teclado.nextLine();
					/*Comprobar las reservas*/
					break;
				}
			break;
		}
				switch(opcion) {
					case 1:
						System.out.println("Usuario:");
						usuario=teclado.nextLine();
						System.out.println("Contraseña:");
						contraseña=teclado.nextLine();
						for(cliente i: array_clientes) {
							if(i.comprobarUsuario(usuario, contraseña)==true) {
								System.out.println("Sesion inciada correctamente");
							}else {
								System.out.println("Fallo al iniciar sesion");
							}
						}
						break;
					case 2:
						System.out.println("Inserte el nombre de usuario");
						usuario=teclado.nextLine();
						System.out.println("Inserte la contraseña");
						contraseña=teclado.nextLine();
						System.out.println("Inserte el correo electronico");
						correo_electronico=teclado.nextLine();
						array_clientes.add(new cliente(usuario,contraseña,correo_electronico));
						break;
				
				}
				
		}while(borrar==0);
	}

}