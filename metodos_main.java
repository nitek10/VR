package local;

import java.util.*;
import java.util.Collections;
import java.util.Arrays;
public class metodos_main {
	/*variables para añadir y borrar salas*/
	int contador_salas=0,salas, ultimo_id=0;
	int contador_ordenadores=0;
	int cantidad;
	precios objeto_precios=new precios();
	administrador objeto_administrador=new administrador();
	metodos_main objeto_metodos;
	ArrayList<Integer> array_crear = new ArrayList<Integer>();
	ArrayList<precios> array_precios_aux = new ArrayList<precios>();
	ArrayList<cliente> array_clientes = new ArrayList<cliente>();
	ArrayList<administrador> array_administradores = new ArrayList<administrador>();
	ArrayList<administrador> array_administradores_aux = new ArrayList<administrador>();
	sesion_Administrador objeto_sesion_administrador=new sesion_Administrador();
	sesion_Cliente objeto_sesion_cliente=new sesion_Cliente();
	String tipo="", cadena, rangos_aux;
	entrada_salida teclado2=new entrada_salida();
	public metodos_main(){
		
	}
	public ArrayList añadirSalas(ArrayList<equipos> array_equipos, String opcion){
		sesion_Administrador objeto_administrador=new sesion_Administrador();
		contador_salas=0;
		ultimo_id=0;
		contador_ordenadores=0;
		for (equipos string : array_equipos) {
			if(string.tipo.equals("ordenador")){
				contador_ordenadores++;
			}else{
				contador_salas++;
			}
		}
		if (opcion.equals("1")) {
			tipo = "sala";
			System.out.println("contador salas: " + contador_salas);
		} else if (opcion.equals("2")) {
			tipo = "ordenador";
			System.out.println("contador ordenador: " + contador_ordenadores);
		}

		for (equipos string : array_equipos) {
			if (string.tipo.equals(tipo)) {
				System.out.println("id " + tipo + ": " + string.id);
			}
		}
		if (opcion.equals("1")) {
			System.out.println("¿Cuantas salas quieres añadir?");
		} else if (opcion.equals("2")) {
			System.out.println("¿Cuantos ordenadores quieres añadir?");
		}
		do{
		cadena = teclado2.tipoString("int");
		}while(cadena.equals(""));
		salas=Integer.parseInt(cadena);
		/*
		 * Crear un comprobante para cuando
		 * eliminemos un ordenador y
		 * añadamos uno nuevo coja el id del
		 * que ya no está
		 */
		array_crear.clear();
		ultimo_id = 0;
		for (equipos string : array_equipos) {
			if (string.id > ultimo_id && string.tipo.equalsIgnoreCase(tipo)) {
				ultimo_id = string.id;
				System.out.println("ultimo id: " + ultimo_id);
				array_crear.add(string.id);
			}
		}
		Collections.sort(array_crear);
		if (tipo.equals("sala")) {
			cantidad = contador_salas;
		} else if (tipo.equals("ordenador")) {
			cantidad = contador_ordenadores;
		}

		for (int j = 0; j < salas; j++) {
			int k = 1;
			for (k = 1; k <= ultimo_id; k++) {// int
												// k=1;
												// k<ultimo_id;
												// k++

				if (array_crear.contains(k)) {

				} else {
					if (tipo.equals("ordenador") && j < salas) {
						System.out.println("ordenador creado: " + k);
						contador_ordenadores++;
						array_equipos.add(new equipos(k, tipo));
						j++;
					} else if (tipo.equals("sala") && j < salas) {
						contador_salas++;
						array_equipos.add(new equipos(k, tipo));
						j++;
					}
				}
			}

			while (j < salas) {
				System.out.println("hola: " + j);
				if (tipo.equals("ordenador") && j < salas) {
					contador_ordenadores++;
					array_equipos.add(new equipos(contador_ordenadores, tipo));
					j++;
				} else if (tipo.equals("sala") && j < salas) {
					contador_salas++;
					array_equipos.add(new equipos(contador_salas, tipo));
					j++;
				}
			}
		}

		/*
		 * if(ciclos<ordenadores) { for(int
		 * j=ciclos; j<ordenadores; j++) {
		 * contador_ordenadores++;
		 * array_equipos.add(new
		 * equipos(contador_ordenadores,
		 * "ordenador")); } }
		 */

		/* ordenar array */
		Collections.sort(array_equipos);

		System.out.println("contador salas: " + contador_salas
				+ "\nContador_ordenadores: " + contador_ordenadores);
		for (equipos string : array_equipos) {
			if (string.tipo.equals(tipo)) {
				System.out.println("id " + tipo + ": " + string.id);
			}
		}
		return array_equipos;
	}
	public ArrayList getArray_precios_aux() {
		return array_precios_aux;
	}
	public void limpiarArray() {
		array_precios_aux.clear();
	}
	public ArrayList eliminarSalas_main(ArrayList<equipos> array_equipos, String opcion, ArrayList<precios> array_precios){
		equipos objeto_aux = new equipos();
		array_precios_aux.clear();
		int a=0;
		contador_salas=0;
		ultimo_id=0;
		contador_ordenadores=0;
		for (equipos string : array_equipos) {
			if(string.tipo.equals("ordenador")){
				contador_ordenadores++;
			}else{
				contador_salas++;
			}
		}
		if (opcion.equals("3")) {
			a = contador_salas;
			System.out.println("¿Cuántas salas desea eliminar?");
			tipo = "sala";
		} else if (opcion.equals("4")) {
			a = contador_ordenadores;
			System.out.println("¿Cuántos ordenadores desea eliminar?");
			tipo = "ordenador";
		}
		do{
			cadena = teclado2.tipoString("int");
		}while(cadena.equals(""));
		salas=Integer.parseInt(cadena);
		if (opcion.equals("3")) {
			System.out.println(
					"salas: " + salas + " cotnadorSalas: " + contador_salas);
		} else {
			System.out.println("ordenadores: " + salas + " cotnadorOrdenadores: "
					+ contador_ordenadores);
		}
		if (salas <= a) {
			for (int j = array_equipos.size() - 1; salas > 0; j--) {
				// System.out.println("hola:
				// "+array_equipos.get(j).tipo);
				if (array_equipos.get(j).tipo.equalsIgnoreCase(tipo)) {
					array_precios_aux = (ArrayList) objeto_aux.eliminarSalas(
							array_precios, array_equipos.get(j).id, tipo).clone();
					array_precios.clear();
					array_precios = (ArrayList) array_precios_aux.clone();
					array_equipos.remove(j);
					salas--;
					if (tipo.equals("ordenador")) {
						contador_ordenadores--;
					} else if (tipo.equals("sala")) {
						contador_salas--;
					}
				}
			}
		}

		// System.out.println("comienzo_remove:
		// "+comienzo_remove+"/"+"
		// contador_salas:
		// "+contador_salas);

		System.out.println("contador_salas: " + contador_salas
				+ "\nContador_ordenadores: " + contador_ordenadores);
		for (precios string : array_precios) {
			if (string.tipo.equalsIgnoreCase(tipo)) {
				System.out.print("\nNombre: " + string.tarifa);
				string.imprimirRangos();
				System.out.print("rango: ");
			}
		}
		/*y como devolvemos el array precios??
		 * lo metemos como atributo y lo sacamos despue?*/
		return array_equipos;
	}
	
	public ArrayList aplicarTarifa(ArrayList<precios> array_precios, equipos objeto_aux, ArrayList<equipos> array_equipos) {
		String tarifa="",  opcion;
		precios objeto_precios=new precios();
		int tiempo;
		Double precio_sala_hora;
		ArrayList <Integer> array_rangos=new ArrayList<Integer>();
		ArrayList <Integer> array_rangos_aux=new ArrayList<Integer>();
		System.out.println("¿Para que categoría desea aplicar la tarifa?\n"
				+ "1.Ordenadores\n" + "2.Salas");
		do{
			opcion=teclado2.tipoString("string");
		}while(opcion.equals(""));
		/*
		 * comprobar si existe el nombre de
		 * la tarifa
		 */
		if (opcion.equals("1")) {
			tipo = "ordenador";
			cantidad = contador_ordenadores;
		} else if (opcion.equals("2")) {
			tipo = "sala";
			cantidad = contador_salas;
		}
		do {
			System.out.println("Inserte el nombre de la tarifa");
			tarifa = teclado2.tipoString("string");
		} while (objeto_precios.comprobarNombreTarifa(tarifa, tipo,
				array_precios) == false);

		System.out.println("Inserte el tiempo de la tarifa en minutos");
		do{
			cadena=teclado2.tipoString("int");
		}while(cadena.equals(""));
		tiempo = Integer.parseInt(cadena);
		System.out.println("Inserte el precio de la tarifa");
		do{
			cadena=teclado2.tipoString("double");
		}while(cadena.equals(""));
		precio_sala_hora =  Double.parseDouble(cadena);
		switch (opcion) {
		case "1":
		case "2":
			if (cantidad == 0) {
				if (tipo.equals("ordenador")) {
					System.out.println(
							"Para aplicar la tarifa primero debe añadir ordenadores");
				} else {
					System.out.println(
							"Para aplicar la tarifa primero debe añadir salas");
				}

			} else {
				do {
				do {
					System.out.println(
							"Separe con una ',' para ids especificos. Separe con un '-' para establecer un rango.\n"
									+ "Escriba all para aplicarle la tarifa a todos los ids"+"\nEscriba exit para salir");
					array_rangos.clear();
					rangos_aux = teclado2.tipoString("string");
					array_rangos = objeto_precios.comprobar_rango(rangos_aux,
							array_rangos, tipo, array_equipos);
					for(Integer i:array_rangos) {
						if(Collections.frequency(array_rangos_aux, i)==1) {
							System.out.println("no añadido");
						}else {
						array_rangos_aux.add(i);
						System.out.println("añadido");
						}
					}

				} while (array_rangos.size() == 0
						&& !rangos_aux.equalsIgnoreCase("all")  && !rangos_aux.equalsIgnoreCase("exit"));
				}while(!rangos_aux.equalsIgnoreCase("exit") && !rangos_aux.equalsIgnoreCase("all") );
				for (Integer integer : array_rangos_aux) {
					System.out.println("numero: "+integer);
				}
				if(array_rangos_aux.size()<=0 && !rangos_aux.equalsIgnoreCase("all")) {
					
				}else {
					array_rangos.clear();
					for (Integer integer : array_rangos_aux) {
						array_rangos.add(integer);
					}
					Collections.sort(array_rangos);
				if (!rangos_aux.equalsIgnoreCase("all")) {
					// System.out.println("hola:
					// " + rangos);
					array_precios.add(new precios(tarifa, tiempo, tipo,
							array_rangos, precio_sala_hora));
					for (precios precio : array_precios) {
						System.out.println(precio.toString());
					}
				} else {
					array_rangos.clear();
					array_rangos.add(0);
					array_precios.add(new precios(tarifa, tiempo, tipo,
							array_rangos, precio_sala_hora));
				}
				}

			}
			break;
		}
		return array_precios;
	}
	public administrador crearCuenta(boolean all_privilegios) {
		/*falta comprobar en le metodo de crear que  no se repite el usuario y comprobar errores*/
		boolean existe=false;
		String tipo="cliente",opcion;
		String usuario, contraseña, respuesta_seguridad, correo_electronico;
		int pregunta_seguridad;
		//boleean administrador esto sirve para que si es admin pueda crear cuentas admin.
		if(all_privilegios==true) {
			System.out.println("1.Crear cuenta de cliente\n"+
		"2.Crear cuenta de administrador");
			do {
			opcion=teclado2.tipoString("string");
			}while(!opcion.equals("1") && !opcion.equals("2"));
			if(opcion.equals("1")) {
				tipo="cliente";
			}else {
				tipo="administrador";
			}
		}
		for (administrador administrador : array_administradores) {
			System.out.println("usuario_administrador: "+administrador.usuario);
		}
		for (cliente c : array_clientes) {
			System.out.println("usuario_cliente: "+c.usuario);
		}
		System.out.println("Inserte el nombre de usuario");
		do {
			existe=false;
			usuario = teclado2.tipoString("string");
			for (cliente cliente : array_clientes) {
				if(usuario.equalsIgnoreCase(cliente.getUsuario())) {
					existe=true;
				}
			}
			for (administrador admin : array_administradores) {
				if(usuario.equalsIgnoreCase(admin.getUsuario())) {
					existe=true;
				}
			}
			if(existe==true) {
				System.out.println("Usuario no disponible");
			}
		}while(existe==true);
		System.out.println("Inserte la contraseña");
		contraseña = teclado2.tipoString("string");
		System.out.println("Inserte el correo electronico");
		correo_electronico = teclado2.tipoString("string");
		preguntasSeguridad();
		do{
			cadena=teclado2.tipoString("int");
		}while(cadena.equals("") || (!cadena.equals("1") && !cadena.equals("2") && !cadena.equals("3") &&  !cadena.equals("4") &&  !cadena.equals("5") &&  !cadena.equals("6") ) );
		pregunta_seguridad = Integer.parseInt(cadena);
		System.out.println("Respuesta: ");
		respuesta_seguridad = teclado2.tipoString("string");
		System.out.println("repuesta: "+respuesta_seguridad);
		System.out.println("privilegios: "+all_privilegios);
		if(tipo.equals("cliente")) {
			System.out.println("respuestaaa: "+respuesta_seguridad);
		array_clientes.add(new cliente(usuario, contraseña, correo_electronico, pregunta_seguridad, respuesta_seguridad));
		}else if(tipo.equals("administrador") && all_privilegios==true) {
			System.out.println("¿Desea que tenga todos los privilegios?\n"+
		"1.Si\n"+
					"2.No");
			
			do {
				opcion=teclado2.tipoString("string");
			}while(!opcion.equals("1") && !opcion.equals("2"));
				if(opcion.equals("1")) {
					System.out.println("hola");
					array_administradores.add(new administrador(usuario, contraseña, correo_electronico, pregunta_seguridad, respuesta_seguridad, true));
				}else {
					System.out.println("gola2");
					array_administradores.add(new administrador(usuario, contraseña, correo_electronico, pregunta_seguridad, respuesta_seguridad));
				}
		}
		for (administrador administrador : array_administradores) {
			System.out.println("usuario: "+administrador.usuario);
		}
		/*como vamos a crear una desde los admin las cuentas o desde el inicio de sesion y no desde la sesion del cliente devolvemos el ultimo admin puesto que añadimos de uno en uno dado que en la sesion de administrador no podemos modificar
		 * el array de administradores pues instanciamos mientras lo estamos usando.*/
		return array_administradores.get(array_administradores.size()-1);
	}
	
	public void crearAdministrador() {
		
	}
	public String getRangos_aux() {
		return rangos_aux;
	}
	public void defaultAdministrador() {
		this.array_administradores.add(new administrador("root", "Smr", "", 1, "", true));
		this.array_administradores.add(new administrador("root2", "Smr", "", 1, "", false));
	}
	public void metodo_main(metodos_main objeto) {
			this.objeto_metodos=objeto;
	}
	public void verTarifas() {
		for (precios precio : objeto_sesion_administrador.getArray_precios()) {
			System.out.println(precio.toString());
		}
	}
	public void iniciarSesion() {
		boolean all_privilegios=false;
		boolean admin=false;
		boolean cliente=false;
		for (administrador administrador : array_administradores) {
			System.out.println("usuario_administrador: "+administrador.usuario);
		}
		for (cliente c : array_clientes) {
			System.out.println("usuario_cliente: "+c.usuario);
		}
		String usuario,contraseña;
		System.out.println("Usuario:");
		usuario = teclado2.tipoString("string");
		System.out.println("Contraseña:");
		contraseña = teclado2.tipoString("string");
		//sesion_Administrador objeto_sesion_administrador=new sesion_Administrador();

		for (administrador i : array_administradores) {
			System.out.println("nombre: "+i.usuario);
			if (i.comprobarUsuario(usuario, contraseña) == true) {
				System.out.println("Sesion inciada correctamente\nUsuario: "+usuario+"\ncontraseña: "+contraseña);
				/*for (administrador administrador : array_administradores) {
					System.out.println("usuario: "+administrador.usuario);
					objeto_administrador=i;
				}*/
				all_privilegios=i.getAll_privilegios();
				admin=true;
			} else {
				//System.out.println("Fallo al iniciar sesion");
			}
		}
		for (cliente c : array_clientes) {
			System.out.println("nombre: "+c.usuario);
			if (c.comprobarUsuario(usuario, contraseña) == true) {
				System.out.println("Sesion inciada correctamente\nUsuario: "+usuario+"\ncontraseña: "+contraseña);
				cliente=true;
			} else {
				//System.out.println("Fallo al iniciar sesion");
			}
		}
		/*pasamos si tiene todos los privilegios para hacer un menu u otro y el objeto de metodos que teniamos en el main para que se pasen los mismos valores.*/
		if(admin==true) {
			objeto_sesion_administrador.gestionAdminsitrador(all_privilegios, objeto_metodos, usuario);
		}else if(cliente==true){
			objeto_sesion_cliente.gestionCliente(objeto_metodos, usuario);
		}
		
	}
	public void eliminarCuenta(String usuario_actual) {
		int contador=0;
		boolean borrado=false;
		String usuario_borrar;
		boolean cliente=false;
		do {
		System.out.println("Inserte el nombre del usuario que desea eliminar\nIntroduzca exit para salir\n1.Mostrar lista de los administradores\n2.Mostrar lista de los clientes");
		usuario_borrar=teclado2.tipoString("string");
		if(usuario_borrar.equals("1")) {
			System.out.println("Lista de administradores: ");
			for (administrador administrador : array_administradores) {
				System.out.println(administrador.getUsuario());
			}
		}else if(usuario_borrar.equals("2")) {
			System.out.println("Lista de clientes: ");
			for (cliente c : array_clientes) {
				System.out.println(c.getUsuario());
			}
		}else {
			//Si solo hay un usuario con todos los provilegios no se podra borrar
		for (administrador administrador : array_administradores) {
			if(administrador.getAll_privilegios()) {
				contador++;
			}
		}
		if(cliente==false && !usuario_borrar.equalsIgnoreCase(usuario_actual) && contador>=1) {
			Iterator<administrador> it = array_administradores.iterator();
		while(it.hasNext()) {
	         administrador object = it.next();
	        if(object.getUsuario().equalsIgnoreCase(usuario_borrar)) {
	        	it.remove();
	        	borrado=true;
	        }

	      }
		}else {
			Iterator<cliente> it = array_clientes.iterator();
			while(it.hasNext()) {
		         cliente object = it.next();
		        if(object.getUsuario().equalsIgnoreCase(usuario_borrar)) {
		        	it.remove();
		        	borrado=true;
		        }
		      }
		}
		if(borrado==false) {
			System.out.println("No se ha podido borrar el usuario");
		}else {
			System.out.println("Usuario borrado");
		}
		}
		}while(!usuario_borrar.equalsIgnoreCase("exit"));
	}
	public void modificarCuenta(String usuario_actual) {
		String usuario_modificar;
		do {
			System.out.println("Inserte el nombre del usuario que desea modificar\nIntroduzca exit para salir\n1.Mostrar lista de los administradores\n2.Mostrar lista de los clientes");
			usuario_modificar=teclado2.tipoString("string");
			if(usuario_modificar.equals("1")) {
				System.out.println("Lista de administradores: ");
				for (administrador administrador : array_administradores) {
					System.out.println(administrador.getUsuario());
				}
			}else if(usuario_modificar.equals("2")) {
				System.out.println("Lista de clientes: ");
				for (cliente c : array_clientes) {
					System.out.println(c.getUsuario());
				}
			}else {
			for (administrador administrador : array_administradores) {
				if(administrador.getUsuario().equalsIgnoreCase(usuario_modificar)) {
					administrador.modificarAtributos(usuario_actual);
				}
			}
			for (cliente c : array_clientes) {
				if(c.getUsuario().equalsIgnoreCase(usuario_modificar)) {
					c.modificarAtributos();
				}
			}
			}
		}while(!usuario_modificar.equalsIgnoreCase("exit"));
	}
	public void modificar_atributos_cliente(String usuario) {
		for (cliente c : array_clientes) {
			if(c.getUsuario().equalsIgnoreCase(usuario)) {
				c.modificarAtributos();
			}
		}
	}
	public void recuperarContraseña() {
		String usuario_recuperar;
		usuario_recuperar=teclado2.tipoString("string");
		for (administrador administrador : array_administradores) {
			if(usuario_recuperar.equalsIgnoreCase(administrador.getUsuario())) {
				administrador.recuperarContraseña();
			}
		}
		for (cliente c : array_clientes) {
			if(usuario_recuperar.equalsIgnoreCase(c.getUsuario())) {
				c.recuperarContraseña();
			}
		}
	}
	public void preguntasSeguridad() {
		System.out.println("Seleccione una pregunta de seguridad para recuperar la contraseña:\n"
				+ "1.¿Cuál fue mi primera mascota?\n" + "2.¿Cual fue tu primer trabajo?\n"
				+ "3.¿Dónde naciste?\n" + "4.¿Como se llama tu abuelo?\n"
				+ "5.¿Cuál es el nombre de tu colegio?\n" + "6.¿Cual es tu comida favorita?");
	}
	public void preguntasSeguridad2(int pregunta) {
		if(pregunta==1) {
			System.out.println("¿Cuál fue mi primera mascota?");
		}else if(pregunta==2) {
			System.out.println("¿Cual fue tu primer trabajo?");
		}else if(pregunta==3) {
			System.out.println("¿Dónde naciste?");
		}else if(pregunta==4) {
			System.out.println("¿Como se llama tu abuelo?");
		}else if(pregunta==5) {
			System.out.println("¿Cuál es el nombre de tu colegio?");
		}else if(pregunta==6) {
			System.out.println("¿Cual es tu comida favorita?");
		}
	}

}
