package local;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class precios {
	//ArrayList<String> array_tarifas = new ArrayList<String>();
	String tarifa;
	int tiempo=0;
	String tipo;
	ArrayList<Integer> array_rangos=new ArrayList<Integer>();
	Double precio_hora=0.0;
	public precios(String tarifa, int tiempo, String tipo, ArrayList<Integer> array_rangos, Double precio_hora) {
		//array_tarifas.add(tarifa);
		this.tarifa=tarifa;
		this.tiempo=tiempo;
		this.tipo=tipo;
		this.array_rangos=(ArrayList)array_rangos.clone();
		this.precio_hora=precio_hora;
		// TODO Auto-generated constructor stub
	}
	public precios() {
		
	}
	public String getTarifa() {
		return tarifa;
	}
	public void setTarifa(String tarifa) {
		this.tarifa = tarifa;
	}
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public ArrayList getRangos() {
		return array_rangos;
	}
	public void setRangos(ArrayList<Integer> array_rangos) {
		this.array_rangos.clear();
		this.array_rangos =(ArrayList) array_rangos.clone();
	}
	public Double getPrecio_hora() {
		return precio_hora;
	}
	public void setPrecio_hora(Double precio_hora) {
		this.precio_hora = precio_hora;
	}
	public void imprimirRangos() {
		if(array_rangos.size()>0) {
			//System.out.println("tamaño: "+array_rangos.size()+"\n");
		for(int j=0; j<array_rangos.size(); j++) {
			if(j==(array_rangos.size()-1)) {
				System.out.print(array_rangos.get(j));
			}else {
			System.out.print(array_rangos.get(j)+",");
			}
		}
		}
	}
	public String rangosString() {
		String rangos="";
		if(array_rangos.size()>0) {

		for(int j=0; j<array_rangos.size(); j++) {
			if(j==(array_rangos.size()-1)) {
				rangos +=array_rangos.get(j);
			}else {
			rangos +=array_rangos.get(j)+",";
			}
		}
		}
		return rangos;
	}
	public void limiarRangos() {
		array_rangos.clear();
	}
	@Override
	public String toString() {
		String rango="";
		for(int i=0; i<array_rangos.size(); i++) {
			if(i==(array_rangos.size()-1)) {
				rango += array_rangos.get(i);
			}else {
				rango += array_rangos.get(i)+",";
			}
		}
		return "\nNombre: "+tarifa+"\nPrecios: " + precio_hora +"\nRango: "+rango+"\nTiempo: " + tiempo + "\nTipo: " + tipo
				+"\n cantidad del rango: "+array_rangos.size();
	}
	
	
	public void eliminarModificacion(int a) {
		 Iterator<Integer> it = array_rangos.iterator(); 
		 int b=0;
	        while (it.hasNext()) { 
	        	b=it.next();
	            if(b==a) {
	            	it.remove();
	            }
	        }
		//System.out.println("ordenamiento final: "+rangos);
	}

	public void modificarAtributos(ArrayList<equipos> array_equipos, equipos objeto_aux, sesion_Administrador objeto_sesion, ArrayList<precios> array_precios){
		
		int contador_salas=0, contador_ordenadores=0;
		String cadena;
		for (equipos string : array_equipos) {
			if(string.tipo.equals("ordenador")){
				contador_ordenadores++;
			}else{
				contador_salas++;
			}
		}
		entrada_salida teclado2=new entrada_salida();
		int cantidad;
		String opcion, rangos_aux;
		ArrayList<Integer> array_rangos_aux = new ArrayList<Integer>();
		ArrayList<Integer> array_rangos_aux2 = new ArrayList<Integer>();
		do {
			System.out.println("¿Que desea modificar?\n" + "1.Rangos\n"
					+ "2.Precio/hora\n" + "3.Nombre\n" + "4.Tiempo"+"\n5.Salir");// poner
																		// los
																		// atributos
																		// de
																		// la
			do{															// tarifa
			opcion = teclado2.tipoString("int");
			}while(opcion.equals(""));
			switch (opcion) {
			case "1":
				if(tarifa.equalsIgnoreCase("general")) {
					System.out.println("Las tarifas generales no pueden modificar el rango");
				}else {
				System.out.println(
						"1.Añadir " + tipo + "\n" + "2.Eliminar " + tipo);
				do{
				opcion = teclado2.tipoString("int");
				}while(opcion.equals(""));
				if ((array_rangos.size() == contador_ordenadores)
						&& tipo.equals("ordenador")) {
					System.out.println(
							"Esta tarifa ya esta aplicada a todos los ordenadores posibles "
									+ array_rangos.size() + "/"
									+ contador_ordenadores);
				}
				if (array_rangos.size() == contador_salas
						&& tipo.equals("sala")) {
					System.out.println(
							"Esta tarifa ya esta aplicada a todas las salas posibles "
									+ array_rangos.size() + "/"
									+ contador_salas);
				}
				if (tipo.equals("ordenador")) {
					cantidad = contador_ordenadores;
				} else {
					cantidad = contador_salas;
				}
				if(array_rangos.size()>0) {
					if(array_rangos.get(0)==0 && tipo.equals("ordenador")) {
						System.out.println(
								"Esta tarifa ya esta aplicada a todos los ordenadores posibles ");
						cantidad=array_rangos.size();
					}else if(array_rangos.get(0)==0 && tipo.equals("sala")) {
						System.out.println(
								"Esta tarifa ya esta aplicada a todas las salas posibles ");
						cantidad=array_rangos.size();
					}
				}
				if (opcion.equals("1")
						&& array_rangos.size() < cantidad) {// si
																	// la
																	// tarifa
																	// es
																	// tipo
																	// all
																	// tiene
																	// todos
																	// los
																	// ordenadores
																	// pues
																	// entonces
																	// no
																	// se
																	// pueden
																	// añadir
																	// mas
					do {
						do {
						do {
							System.out.println(
									"Separe con una ',' los ordenadores/salas que le afectan esta tarifa. Separe con un '-' para establecer un rango.\n"
											+ "Escriba all para aplicarle la tarifa a todos los ordenadores");
							array_rangos_aux.clear();
							rangos_aux = teclado2.tipoString("string");

							array_rangos_aux = comprobar_rango(
									rangos_aux, array_rangos_aux, tipo,
									array_equipos);
							for(Integer i:array_rangos_aux) {
								if(Collections.frequency(array_rangos_aux2, i)==1) {
									System.out.println("no añadido");
								}else {
								array_rangos_aux2.add(i);
								System.out.println("añadido");
								}
							}
						} while (array_rangos_aux.size() == 0
								&& !rangos_aux.equalsIgnoreCase("all")  && !rangos_aux.equalsIgnoreCase("exit"));
						}while(!rangos_aux.equalsIgnoreCase("exit") && !rangos_aux.equalsIgnoreCase("all") );
						for (Integer integer : array_rangos_aux2) {
							System.out.println("numero: "+integer);
						}
						// tengo que
						// comprobar
						// que hasta
						// aqui todo
						// va bien
						// sumarlo
						// al nuevo
						// rango y
						// pasarlo
						// de nuevo.
						if (!rangos_aux.equalsIgnoreCase("all")) {
							// System.out.println("hola:
							// " +
							// rangos);
							// añadir
							// los
							// rangos
							for (Integer k : array_rangos_aux2) {
								if(Collections.frequency(array_rangos, k)==1) {
									System.out.println("no añadido");
								}else {
								array_rangos.add(k);
								System.out.println("añadido");
								}
							}
							Collections.sort(array_rangos);
							/*for (Integer k : array_rangos_aux2) {
								array_rangos_aux.add(k);
							}
							rangos_aux = "";
							if (array_rangos_aux.size() > 0) {

								for (int j = 0; j < array_rangos_aux
										.size(); j++) {
									if (j == (array_rangos_aux.size() - 1)) {
										rangos_aux += array_rangos_aux.get(j);
									} else {
										rangos_aux += array_rangos_aux.get(j)
												+ ",";
									}
								}
							}
							array_rangos_aux.clear();
							array_rangos_aux = comprobar_rango(
									rangos_aux, array_rangos_aux, tipo,
									array_equipos);*/
						} else {
							array_rangos.clear();
							array_rangos.add(0);
						}
					} while (!rangos_aux.equalsIgnoreCase("exit")
							&& !rangos_aux.equalsIgnoreCase("all"));
					if (rangos_aux.equalsIgnoreCase("all")) {
						array_rangos.set(0, 0);
					} else {

					}
				} else if (opcion.equals("2")) {
					/*
					 * eliminarlos
					 * de la tarifa
					 * no eliminar
					 * el ordenador
					 * en si
					 */
					if(array_rangos.size()>0) {
						if(array_rangos.get(0)==0) {
							array_rangos.clear();
							for (equipos equipo : array_equipos) {
								array_rangos.add(equipo.getId());
							}
						}
					}
					do {
					do {
						System.out.println(
								"Separe con una ',' los ordenadores/salas que le afectan esta tarifa. Separe con un '-' para establecer un rango.\n"
										+ "Escriba all para aplicarle la tarifa a todos los ordenadores"+"\nEscriba exit para salir");

						//limpiamos el rango en el que vamos a añadir nuevos numeros
						array_rangos_aux.clear();
						rangos_aux = teclado2.tipoString("string");
						array_rangos_aux = comprobar_rango(
								rangos_aux, array_rangos_aux, tipo,
								array_equipos);
					} while (array_rangos_aux.size() == 0
							&& !rangos_aux.equalsIgnoreCase("all") && !rangos_aux.equalsIgnoreCase("exit"));

					imprimirRangos();
					if(rangos_aux.equalsIgnoreCase("exit")) {
						
					}else {
					for (Integer k : array_rangos_aux) {
						eliminarModificacion(k);
					}




					if (!rangos_aux.equalsIgnoreCase("all")) {
						// System.out.println("hola:
						// " +
						// rangos);
						// añadir
						// los
						// rangos
						for (Integer k : array_rangos) {
							array_rangos_aux.add(k);
						}
						rangos_aux = "";
						if (array_rangos_aux.size() > 0) {

							for (int j = 0; j < array_rangos_aux
									.size(); j++) {
								if (j == (array_rangos_aux.size() - 1)) {
									rangos_aux += array_rangos_aux.get(j);
								} else {
									rangos_aux += array_rangos_aux.get(j)
											+ ",";
								}
							}
						}
						array_rangos_aux.clear();
						array_rangos_aux = comprobar_rango(
								rangos_aux, array_rangos_aux, tipo,
								array_equipos);
					} else {
						array_rangos.clear();
						array_rangos.add(0);
					}
					imprimirRangos();
					}
					}while(!rangos_aux.equalsIgnoreCase("exit"));
				}
				}
				break;
			case "2":
				System.out.println("Inserte el nuevo precio de la tarifa: "+tarifa);
				do {
					cadena=teclado2.tipoString("double");
				}while(cadena.equals(""));
				precio_hora=Double.parseDouble(cadena);
				break;
			case "3":
				System.out.println("Inserte el nuevo nombre de la tarifa: "+tarifa);
				do {
					System.out.println("Inserte el nombre de la tarifa");
					cadena = teclado2.tipoString("string");
				} while (comprobarNombreTarifa(cadena, tipo, array_precios) == false);
				setTarifa(cadena);
				break;
			case "4":
				System.out.println("Inserte el nuevo tiempo de la tarifa en minutos");
				if(tarifa.equalsIgnoreCase("general")) {
					System.out.println("El tiempo de la tarifa general no se puede modificar.");
				}else {
				do {
					cadena=teclado2.tipoString("int");
				}while(cadena.equals(""));
				setTiempo(Integer.parseInt(cadena));
				}
				break;
			}
			}while(!opcion.equals("5"));
	}


	public ArrayList<Integer> comprobar_rango(String rangos_aux, ArrayList<Integer> array_rangos2, String tipo,
			ArrayList<equipos> array_equipos) {
		boolean correcto = true;
		ArrayList<Integer> array_aux = new ArrayList<Integer>();
		int a, b, c;
		try {
			StringTokenizer st = new StringTokenizer(rangos_aux, ",");
			while (st.hasMoreTokens()) {
				c = Integer.parseInt(st.nextToken());
				System.out.println("c: " + c);
				array_rangos2.add(c);
			}
		} catch (Exception e) {
			correcto = false;
		}
		if (correcto == false) {
			try {
				array_rangos2.clear();
				correcto = true;
				StringTokenizer st = new StringTokenizer(rangos_aux, "-");
				while (st.hasMoreTokens()) {
					a = Integer.parseInt(st.nextToken());
					b = Integer.parseInt(st.nextToken());
					if (st.hasMoreTokens()) {
						correcto = false;
					}
					if (correcto == true) {
						if (a < b) {
							for (int i = a; i <= b; i++) {
								array_rangos2.add(i);
							}
						} else if (b < a) {
							for (int i = b; i <= a; i++) {
								array_rangos2.add(i);
							}
						} else {
							correcto = false;
						}
					}
				}
			} catch (Exception e) {
				correcto = false;
			}
		}

		if (correcto == true) {
			for (int i = 0; i < array_rangos2.size(); i++) {
				for (int j = 1 + i; j < array_rangos2.size(); j++) {
					if (array_rangos2.get(i) == array_rangos2.get(j)) {
						System.out.println("El numero: " + array_rangos2.get(j) + " esta repetido");
						correcto = false;
					}
				}
			}
		}

		if (correcto == false) {

		} else {
			for (equipos objeto : array_equipos) {
				array_aux.add(objeto.id);
			}
			/* comprobar que existe el ordenador */
			Collections.sort(array_rangos2);
			boolean existe = false;
			System.out.println("a: " + array_rangos2.get(array_rangos2.size() - 1));
			for (Integer i : array_rangos2) {
				if (array_aux.contains(i)) {
					/**/
				} else {
					correcto = false;
				}
			}
			for (Integer integer : array_rangos2) {
				System.out.println("numero: " + integer + " correcto: " + correcto);
			}
		}
		if (correcto == false) {
			array_rangos2.clear();
		}
		return array_rangos2;
	}
	public boolean comprobarNombreTarifa(String tarifa, String tipo, ArrayList<precios> array_precios) {
		boolean correcto = true;
		if (tipo.equalsIgnoreCase("ordenador") && array_precios.size() >= 1) {
			for (precios precios : array_precios) {
				if (precios.tipo.equalsIgnoreCase("ordenador") && precios.tarifa.equalsIgnoreCase(tarifa)) {
					correcto = false;
				}
				if (correcto == false) {
					System.out.println("Tarifa encontrada");
				}
			}
		} else if (tipo.equalsIgnoreCase("sala") && array_precios.size() >= 1) {
			for (precios precios : array_precios) {
				if (precios.tipo.equalsIgnoreCase("sala") && precios.tarifa.equalsIgnoreCase(tarifa)) {
					correcto = false;
				}
			}
			if (correcto == false) {
				System.out.println("Tarifa encontrada");
			}
		}

		return correcto;
	}

}
