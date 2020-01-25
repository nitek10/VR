package proyecto;
import java.util.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<cliente> array_clientes = new ArrayList<cliente>();
		ArrayList<equipos> array_equipos = new ArrayList<equipos>();
		/*ArrayList<reserva> array_reservas = new ArrayList<reserva>();*/
		int opcion, pregunta_seguridad;
		int borrar=0, salas, ordenadores, contador_salas=1, contador_ordenadores=1, comienzo_remove;
		String usuario, contraseña, respuesta_seguridad, correo_electronico, fecha;
		String nombre, metodo_de_pago;
		Double precio_sala_hora, precio_sala_ordenador;
		Scanner teclado=new Scanner(System.in);
		/*System.out.println("Usuario:");
		usuario=teclado.nextLine();
		System.out.println("Contraseña");
		contraseña=teclado.nextLine();
		array_clientes.add(new cliente(usuario,contraseña));*/
		/*creamos un primer administrador para poder gestionar*/
		array_clientes.add(new cliente("root","Smr","", 1, "", true));
		
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
				switch(opcion){
					case 1:
						System.out.println("Usuario:");
						usuario=teclado.nextLine();
						System.out.println("Contraseña:");
						contraseña=teclado.nextLine();
						for(cliente i: array_clientes) {
							if(i.comprobarUsuario(usuario, contraseña)==true) {
								System.out.println("Sesion inciada correctamente");
								if(i.getAdministrador()==true){
									/*Menu de administrador*/
									System.out.println("1.Gestión de salas y ordenadores\n"+
									"2.Hacer reserva\n"+
											"3.Gestionar Cuentas\n"+
									"4.Gestionar precios");
										opcion=teclado.nextInt();
										teclado.nextLine();
										switch(opcion) {
										/*Aqui crearemos la cantidad de salas y ordenadores en funcion de lo que introduzca el usuario. Como cada sala y ordenador va a tener un id 
										 * creamos dos contadores para que el id se vaya incrementando.*/
										/*Probablemente vayamos a crear una clase que se llame precios para poder crear la hora el tipo y la cantidad de dinero por hora.*/
											case 1:
												System.out.println("1.Añadir salas\n"+
											"2.Añadir ordenadores\n"+
														"3.Eliminar salas\n"+
											"4.Eliminar ordenadores");
												opcion=teclado.nextInt();
												teclado.nextLine();
													switch(opcion) {
													case 1: 
														System.out.println("¿Cuántas salas quieres añadir?");
														salas=teclado.nextInt();
														for(int j=0; j<salas; j++) {
															array_equipos.add(new equipos(contador_salas,"sala"));
															contador_salas++;
														}
														break;
													case 2:
														System.out.println("¿Cuántos ordenadores quieres añadir?");
														ordenadores=teclado.nextInt();
														for(int j=0; j<ordenadores; j++) {
															array_equipos.add(new equipos(contador_ordenadores,"ordenador"));
															contador_ordenadores++;
														}
														break;
													case 3:
														int a=0;
														System.out.println("¿Cuántas salas desea eliminar?");
														salas=teclado.nextInt();
														comienzo_remove=(contador_salas-1)-salas;
														//System.out.println("comienzo_remove: "+comienzo_remove+"/"+" contador_salas: "+contador_salas);
														/*Lo que hacemos es basicamente que si el usuario quiere borrar 4 salas y tenemos 8 borremos desde la ultima sala no desde la primera
														 * asi evitaremos que la primera sala comienze en 4*/
														/*error al usar el next en el array list de objetos*/
														Iterator<equipos> iterador_equipos = array_equipos.iterator();
														while(iterador_equipos.hasNext()){
															a=iterador_equipos.next().getId();
															//System.out.println("id: "+a);
															if(a>comienzo_remove && a<=(contador_salas-1)) {
																//System.out.println("boorado: "+a);
															iterador_equipos.remove();
															}
														}
														break;
													}
												break;
										}
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
						System.out.println("Inserte la contraseña");
						contraseña=teclado.nextLine();
						System.out.println("Inserte el correo electronico");
						correo_electronico=teclado.nextLine();
						System.out.println("Seleccione una pregunta de seguridad para recuperar la contraseña:\n"+
						"1.¿Cuál fue mi primera mascota?\n"+
								"2.¿Cual fue tu primer trabajo?\n"+
						"3.¿Dónde naciste?\n"+
								"4.¿Como se llama tu abuelo?\n"+
						"5.¿Cuál es el nombre de tu colegio?\n"+
								"6.¿Cual es tu comida favorita?");
						pregunta_seguridad=teclado.nextInt();
						teclado.nextLine();
						System.out.println("Respuesta: ");
						respuesta_seguridad=teclado.nextLine();
						array_clientes.add(new cliente(usuario,contraseña,correo_electronico, pregunta_seguridad, respuesta_seguridad));
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
					System.out.println("Introduce la fecha específica\n"+
				"DD/MM/YYYY");
					fecha=teclado.nextLine();
					/*Comprobar las reservas*/
					break;
				}
			break;
		}
				
		/*borrar*//*for (equipos i:array_equipos) {
			if(i.tipo.equalsIgnoreCase("sala")){
				System.out.println("Sala: "+i.id);
			}
		}*/
		Iterator<equipos> iterador_equipos = array_equipos.iterator();
		 while (iterador_equipos.hasNext()) { 
	            System.out.println("sala: "+iterador_equipos.next().getId()); 
	        } 
		}while(borrar==0);
	}

}