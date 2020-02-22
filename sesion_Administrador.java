package local;

import java.util.ArrayList;
import java.util.Iterator;

public class sesion_Administrador{
	String opcion, tipo="", cadena;
	int borrar = 0, salas, ordenadores, contador_salas = 0, contador_ordenadores = 0, comienzo_remove,
			ultimo_id = 0, primer_id = 0, ciclos = 0, cantidad = 0;
	boolean solo_numero = false, existe = false, aux_ordenador = false, aux_sala = false;
	ArrayList<equipos> array_equipos = new ArrayList<equipos>();
	ArrayList<equipos> array_equipos_aux = new ArrayList<equipos>();
	ArrayList<precios> array_precios_aux = new ArrayList<precios>();
	ArrayList<precios> array_precios = new ArrayList<precios>();
	ArrayList<Integer> array_crear = new ArrayList<Integer>();
	Iterator<equipos> iterador_equipos = array_equipos.iterator();
	Iterator<precios> iterador_precios = array_precios.iterator();
	administrador objeto_admin=new administrador();
	entrada_salida teclado2=new entrada_salida();
	equipos objeto_aux = new equipos();
	precios objeto_precio=new precios();
	Double precio_sala_hora, precio_sala_ordenador;
	String tarifa = "general", id;
	int tiempo, primer_numero, ultimo_numero, buscar_id;
	String  rangos_aux;
	ArrayList<Integer> array_rangos = new ArrayList<Integer>();
	sesion_Administrador objeto_sesion;
	public void gestionAdminsitrador(boolean all_privilegios, metodos_main objeto_main, String usuario) {
		/*pasando el objeto_main desde metodos_main nos aseguramos de trabajar sobre el mismo objeto*/
		if(all_privilegios==false) {
			//System.out.println("usuario sin privilegios");
			do {
				System.out.println("1.Activar/Desactivar\n" + "2.Crear cuenta\n"+"3.Ver tarifas\n"+"4.Gestion de reservas\n"+"5.Salir");
				do{
				opcion = teclado2.tipoString("string");
				}while(opcion.equals(""));
				switch(opcion) {
				case "1":
					cambiarEstado();
					break;
				case "2":
					objeto_main.crearCuenta(all_privilegios);
					break;
				case "3":
					verTarifas();
					break;
				case "4":
					System.out.println("1.Hacer reserva\n"+
				"2.Cancelar reserva");
					break;
				default:
					break;
				}
			}while(!opcion.equals("5"));
		}else {
		do {

			for (precios string : array_precios) {
				if (string.tipo.equalsIgnoreCase("ordenador")) {
					System.out.print("rango: ");
					string.imprimirRangos();
					System.out.print(" \nNombre: " + string.tarifa + "\n");
				}
			}

			System.out.println("1.Gestión de salas y ordenadores\n" + "2.Hacer reserva\n"
					+ "3.Gestionar Cuentas\n" + "4.Gestionar precios\n" + "5.Ver tarifas"+"\n6.Salir");
			do{
			opcion = teclado2.tipoString("string");
			}while(opcion.equals(""));
			switch (opcion) {
			/*
			 * Aqui crearemos la cantidad de salas y
			 * ordenadores en funcion de lo que
			 * introduzca el usuario. Como cada sala y
			 * ordenador va a tener un id creamos dos
			 * contadores para que el id se vaya
			 * incrementando.
			 */
			/*
			 * Probablemente vayamos a crear una clase
			 * que se llame precios para poder crear la
			 * hora el tipo y la cantidad de dinero por
			 * hora.
			 */
			case "1":
				do {
				System.out.println(
						"1.Añadir salas\n" + "2.Añadir ordenadores\n" + "3.Eliminar salas\n"
								+ "4.Eliminar ordenadores\n" + "5.Eliminacion avanzada\n"+"6.Activar/Desactivar\n"+"7.Salir");
				opcion = teclado2.tipoString("string");
				switch (opcion) {
				case "1":
				case "2":
					array_equipos_aux.clear();
					array_equipos_aux=(ArrayList)array_equipos.clone();
					array_equipos.clone();
					array_equipos=(ArrayList)objeto_main.añadirSalas(array_equipos, opcion).clone();
					array_equipos_aux.clear();
					

					
					
					break;
				case "3":
				case "4":
					array_equipos_aux.clear();
					array_equipos_aux=(ArrayList)objeto_main.eliminarSalas_main(array_equipos, opcion, array_precios).clone();
					array_equipos.clear();
					array_equipos=(ArrayList)array_equipos_aux.clone();
					array_equipos_aux.clear();
					/*coger el array de precios*/
					array_precios.clear();
					array_precios=(ArrayList)objeto_main.getArray_precios_aux().clone();
					objeto_main.limpiarArray();
					break;
				case "5":
					System.out.println("1.Eliminacion de ordenador específico\n"
							+ "2.Eliminacion de sala específica");
					do {
						opcion = teclado2.tipoString("string");
					} while (!opcion.equals("1") && !opcion.equals("2"));
					if (opcion.equals("1")) {
						tipo = "ordenador";
					} else if (opcion.equals("2")) {
						tipo = "sala";

					}

					do {
						if (opcion.equals("1")) {
							System.out
									.println("Inserte el id del ordenador que desea eliminar");
						} else if (opcion.equals("2")) {
							System.out.println("Inserte el id de la sala que desea eliminar");
						}
						System.out.println("Escriba exit para salir");
						do {
							id = teclado2.int_exit("string");
						} while (id.equalsIgnoreCase("") && !id.equalsIgnoreCase("exit"));
						if (!id.equalsIgnoreCase("exit")) {
							iterador_equipos = array_equipos.iterator();
							while (iterador_equipos.hasNext() && array_equipos.size() >= 1) {
								objeto_aux = iterador_equipos.next();
								// System.out.println("id:
								// "+iterador_equipos.getId());
								if (objeto_aux.id == Integer.parseInt(id)
										&& objeto_aux.tipo.equalsIgnoreCase(tipo)) {
									System.out.println("boorado: " + objeto_aux.id);
									array_precios_aux = (ArrayList) objeto_aux.eliminarSalas(array_precios, objeto_aux.id, tipo).clone();
									array_precios.clear();
									array_precios = (ArrayList) array_precios_aux.clone();
									array_precios_aux.clear();
									iterador_equipos.remove();
									if (tipo.equalsIgnoreCase("sala")) {
										contador_salas--;
									} else if (tipo.equalsIgnoreCase("ordenador")) {
										contador_ordenadores--;
									}

								}
							}
						}
					} while (!id.equalsIgnoreCase("exit"));
					for (precios string : array_precios) {
						if (string.tipo.equalsIgnoreCase(tipo)) {
							System.out.print("rango: ");
							string.imprimirRangos();
							System.out.print(" \nNombre: " + string.tarifa);
						}
					}
					break;
				case "6":
					cambiarEstado();
					break;
				default:
						break;
				}
				break;
				}while(!opcion.equals("7"));
			case "2":
				hacerReserva();
				break;
			case "3":
				System.out.println("1.Crear cuenta\n"+
			"2.Eliminar cuenta\n"+
						"3.Modificar cuenta");
				opcion=teclado2.tipoString("int");
				switch (opcion) {
				case "1":
					objeto_main.crearCuenta(all_privilegios);
					break;
				case "2":
					objeto_main.eliminarCuenta(usuario);
					break;
				case "3":
					//objeto_main.modificarAtributos(usuario);
					objeto_main.modificarCuenta(usuario);
					break;
				}
				break;
			case "4":
				do {
				System.out.println("1.Crear tarifa general\n" + "2.Crear tarifa específica.\n"
						+ "3.Modificar tarifa.\n"+
						"4.Eliminar tarifa\n"+"5.Salir");
				opcion = teclado2.tipoString("string");
				switch (opcion) {
				case "1":
					System.out.println("1.Aplicar tarifa general a las salas\n"
							+ "2.Aplicar tarifa general a los ordenadores\n"
							+ "3.Aplicar tarifa general a salas y ordenadores");
					do{
					opcion = teclado2.tipoString("int");
					}while(opcion.equals(""));
					switch (opcion) {
					case "1":
						System.out.println("Ingrese el precio por hora");
						do{
							cadena=teclado2.tipoString("double");
						}while(cadena.equals(""));
						precio_sala_hora =  Double.parseDouble(cadena);
						/*
						 * para el precio general se
						 * aplicara a todos los equipos
						 */
						existe = false;
						for (precios precios : array_precios) {
							if (precios.tarifa.equalsIgnoreCase("general")
									&& precios.tipo.equalsIgnoreCase("sala")) {
								existe = true;
								precios.setPrecio_hora(precio_sala_hora);
							}
						}
						if (existe == false) {
							array_rangos.clear();
							array_rangos.add(0);
							array_precios.add(new precios("general", 60, "sala", array_rangos,
									precio_sala_hora));
						}
						break;
					case "2":
						System.out.println("Ingrese el precio por hora");
						do{
							cadena=teclado2.tipoString("double");
						}while(cadena.equals(""));
						precio_sala_hora =  Double.parseDouble(cadena);
						/*
						 * para el precio general se
						 * aplicara a todos los equipos
						 */
						existe = false;
						for (precios precios : array_precios) {
							if (precios.tarifa.equalsIgnoreCase("general")
									&& precios.tipo.equalsIgnoreCase("ordenador")) {
								existe = true;
								precios.setPrecio_hora(precio_sala_hora);
							}
						}
						if (existe == false) {
							array_rangos.clear();
							array_rangos.add(0);
							array_precios.add(new precios("general", 60, "ordenador",
									array_rangos, precio_sala_hora));
						}
						break;
					case "3":
						System.out.println("Ingrese el precio por hora");
						do{
							cadena=teclado2.tipoString("double");
						}while(cadena.equals(""));
						precio_sala_hora =  Double.parseDouble(cadena);
						/*
						 * para el precio general se
						 * aplicara a todos los equipos
						 * no se pueden repetir las
						 * mismas tarifas generales si
						 * es asi decir al usuario cual
						 * quiere que se quede
						 */
						existe = false;
						for (precios precios : array_precios) {
							if (precios.tarifa.equalsIgnoreCase("general")
									&& precios.tipo.equalsIgnoreCase("sala")) {
								existe = true;
								precios.setPrecio_hora(precio_sala_hora);
							}
						}
						if (existe == false) {
							array_rangos.clear();
							array_rangos.add(0);
							array_precios.add(new precios("general", 60, "sala", array_rangos,
									precio_sala_hora));
							//System.out.println(array_precios.get(0).toString());
						}
						existe = false;
						for (precios precios : array_precios) {
							if (precios.tarifa.equalsIgnoreCase("general")
									&& precios.tipo.equalsIgnoreCase("ordenador")) {
								existe = true;
								precios.setPrecio_hora(precio_sala_hora);
							}
						}
						if (existe == false) {
							array_rangos.clear();
							array_rangos.add(0);
							array_precios.add(new precios("general", 60, "ordenador",
									array_rangos, precio_sala_hora));
						}
						break;
					}
					/*System.out.println(array_precios.get(0).toString());
					System.out.println(array_precios.get(1).toString());*/
					break;
				case "2":
					/*Aplicar tarifa*/

					array_precios_aux.clear();
					array_precios_aux=(ArrayList)array_precios.clone();
					array_precios.clone();
					array_precios=(ArrayList)objeto_main.aplicarTarifa(array_precios_aux, objeto_aux, array_equipos).clone();
					array_precios_aux.clear();

					break;
				case "3":
					do {
						System.out.println("3.¿De que categoria desea modificar la tarfia?\n"
								+ "1.Ordenador\n" + "2.Sala");
						opcion = teclado2.tipoString("int");
					} while (!opcion.equals("1") && !opcion.equals("2"));
					if (opcion.equals("1")) {
						tipo = "ordenador";
					} else if (opcion.equals("2")) {
						tipo = "sala";
					}
					System.out.println("Inserte el nombre de la tarifa");
					tarifa = teclado2.tipoString("string");
					if (objeto_precio.comprobarNombreTarifa(tarifa, tipo,
							array_precios) == false) {
						for (precios precios : array_precios) {
							if (precios.tarifa.equalsIgnoreCase(tarifa)
									&& precios.tipo.equalsIgnoreCase(tipo)) {
								/*aqui editamos los atributos*/

								precios.modificarAtributos( array_equipos, objeto_aux, objeto_sesion, array_precios);
							}
						}
					} else {
						System.out.println("Tarifa no encontrada");
					}

					break;
				case "4":
					System.out.println("Inserte el nombre de la tarifa que desea eliminar");
					tarifa=teclado2.tipoString("string");
					System.out.println("¿De que categoria desea eliminar la tarifa?\n"+
					"1.Ordenador\n"+
							"2.Sala\n"+
					"3.Ambos");
					do {
						opcion=teclado2.tipoString("int");
					}while(!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3"));
					if(opcion.equals("1")) {
						tipo="ordenador";
					}else if(opcion.equals("2")) {
						tipo="sala";
					}else if(opcion.equals("3")) {
						tipo="ambos";
					}
					if(tipo.equals("ambos")) {
						iterador_precios = array_precios.iterator();
						while(iterador_precios.hasNext()) {
							if(iterador_precios.next().getTarifa().equals(tarifa)) {
								iterador_precios.remove();
							}
						}
					}else {
						iterador_precios = array_precios.iterator();
						while(iterador_precios.hasNext()) {
							objeto_precio=iterador_precios.next();
							if(objeto_precio.getTarifa().equals(tarifa) && objeto_precio.getTipo().equals(tipo)) {
								iterador_precios.remove();
							}
						}
					}
					
					break;
				case "5":
					break;
				}
				}while(!opcion.equals("5"));
				break;
			case "5":
				/*System.out.println("holaa");
				System.out.println(array_precios.get(0).toString());
				System.out.println(array_precios.get(1).toString());*/
				verTarifas();
				break;
			default:
				System.out.println("Opcion inválida");
				break;
			}
		} while (!opcion.equals("6"));
		}
	}
	
	public ArrayList<precios> getArray_precios() {
		return array_precios;
	}

	public void setArray_precios(ArrayList<precios> array_precios) {
		this.array_precios = array_precios;
	}
	public void verTarifas() {
		System.out.println("hola");
		for (precios precio : array_precios) {
			if(precio.tipo.equals("ordenador")) {
				System.out.println("ordenador: "+precio.toString());
			}else if(precio.tipo.equals("sala")){
				System.out.println("sala: "+precio.toString());
			}
		}
	}

	public void cambiarEstado() {
		do {
			System.out.println("1.Modificar estado de salas\n"+
		"2.Modificar estado de ordenadores");
				opcion=teclado2.tipoString("string");
			}while(!opcion.equals("1") && !opcion.equals("2"));
			do {
			if(opcion.equals("1")) {
				System.out.println("Inserte el id de la sala");
				tipo="sala";
			}else {
				System.out.println("Inserte el id del ordenador");
				tipo="ordenador";
			}
				cadena=teclado2.tipoString("int");
			}while(cadena.equals(""));
			buscar_id=Integer.parseInt(cadena);
			for (equipos equipo : array_equipos) {
				if(equipo.id==buscar_id && equipo.getTipo().equals(tipo)) {
					if(equipo.getAveriado()==false) {
						System.out.println("Estado actual: disponible");
					}else {
						System.out.println("Estado actual: averiado");
					}
					System.out.println("1.Cambiar estado\n"+"2.Salir");
					do {
						opcion=teclado2.tipoString("string");
					}while(!opcion.equals("1") && !opcion.equals("2"));
					if(opcion.equals("1")) {
						equipo.cambiarEstado();
					}else {
						
					}
				}
			}
	}
	public void hacerReserva() {
		
	}
	public sesion_Administrador getSesion_administrador() {
		return objeto_sesion;
	}
}
