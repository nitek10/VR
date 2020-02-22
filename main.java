package local;

import java.util.*;

public class main {

	public static void main(String[] args) {

		// TODO Auto-generated method stubb
		/*
		 * Notas Me gustaria hacer comandos tipo add computer 2 y que añda dos
		 * ordenadores tipo consola Corregir: si me temos un numero tipo double
		 * en el rango de ordenadores o sala se sale del programa/ya esta
		 * solucionado falta hacer mas pruebas si solo una sala y un ordenador
		 * no hace el metodo avanzado de eliminar. hacer mas pruebas sobre la
		 * creacion y eliminacion de salas y ordenadores probando extremos
		 * eliminando extremos añadiendo salas nuevos etc. ya podemos modificar
		 * la tarifa yn añadir ordenadores
		 * 
		 * 
		 * tenemos que crear la opcion obviamente de eliminar una tarifa no solo modificarla. y solamente es buscarla en el array y eliminarla y no tocar nada mas. IMPORTANTE si el usuario crea una tarifa y pone el rango de all no se podra modificar en un futuro
		 * debera eliminarla y volverla a crear.
		 */
		sesion_Administrador objeto_administrador=new sesion_Administrador();
		entrada_salida teclado2=new entrada_salida();
		cliente objeto_cliente=new cliente();
		metodos_main objeto_main=new metodos_main();
		/* ArrayList<reserva> array_reservas = new ArrayList<reserva>(); */
		int pregunta_seguridad, recorrer_letra, a = 0, borrar=0;
		String opcion, fecha;
		String usuario, contraseña;
		/* variables para la clase precios */
	
		/**/

		Double precio_sala_hora, precio_sala_ordenador;
		//Scanner teclado = new Scanner(System.in);
		/*
		 * System.out.println("Usuario:"); usuario=teclado.nextLine();
		 * System.out.println("Contraseña"); contraseña=teclado.nextLine();
		 * array_clientes.add(new cliente(usuario,contraseña));
		 */
		/* creamos un primer administrador para poder gestionar */
		/*
		 * habra que comprobar cosas como por ejemplo que apra reservar el
		 * usuario haya metido minimo una tarifa general. y que cuando se pide
		 * un numero no haya caracteres
		 * 
		 * hay que perfecionar lo de la tarifa modificacion por ejemplo. que no pueda modificar el tiempo de la tarifa general ni el rango. Es decir que no le salga en su menu.
		 */
		String borrar2 = ",";
		if (borrar2.contains(".")) {

			System.out.println("hola mundo");
		}
		objeto_main.defaultAdministrador();
		do {
			System.out.println("1.Iniciar sesión\\Registrarse.\n2.Ver salas/ordenadores disponibles");
			opcion = teclado2.tipoString("string");
			switch (opcion) {
			case "1":
				System.out.println("1.Iniciar sesion.\n" + "2.Registrarse\n"+"3.Recuperar Contraseña");
				opcion = teclado2.tipoString("int");
				switch (opcion) {
				case "1":
					/*Iniciamos sesion*/
					/*pasamos el objeto de metodos main que sera sobre el que trabajemos aparte de este*/
					objeto_main.metodo_main(objeto_main);
					objeto_main.iniciarSesion();
					/*
					 * Primero comprobamos si es usuario y despues si es cliente
					 */

					break;
				case "2":
					/*crear usuario*/
					/*falta  comprobar errores*/
					objeto_main.crearCuenta(false);
					break;
				case "3":
					/*crear usuario*/
					/*falta  comprobar errores*/
					objeto_main.recuperarContraseña();
					break;
				}
				break;
			case "2":
				break;
			}

			/* borrar *//*
						 * for (equipos i:array_equipos) {
						 * if(i.tipo.equalsIgnoreCase("sala")){
						 * System.out.println("Sala: "+i.id); } }
						 */
			/*iterador_equipos = array_equipos.iterator();
			while (iterador_equipos.hasNext()) {
				System.out.println("sala: " + iterador_equipos.next().getId() + " contador_salas" + contador_salas);
			}*/
		} while (borrar == 0);
	}

}