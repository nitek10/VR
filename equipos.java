package local;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class equipos implements Comparable {
	boolean disponible = true, averiado = false;
	String tarifa, tipo;
	Double precio_hora;
	int id;
	String fecha_entrada, fecha_salida;

	public equipos(int id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public equipos() {
	}

	public boolean getAveriado() {
		return averiado;
	}
	public void serAveriado(boolean averiado) {
		this.averiado=averiado;
	}
	public String getTipo() {
		return tipo;
	}
	public void cambiarEstado() {
		if(averiado==false) {
			averiado=true;
		}else {
			averiado=false;
		}
	}
	public ArrayList eliminarSalas(ArrayList<precios> array_precios, int a, String tipo) {
		ArrayList<Integer> array_aux = new ArrayList<Integer>();
		System.out.println("adios");
		for (precios objeto : array_precios) {
			for (Integer i : objeto.array_rangos) {
				System.out.println("array_precios: " + i);
			}
		}
		int b = 0;
		for (precios precio : array_precios) {
			System.out.println("hola for" + a);
			if (precio.tipo.equalsIgnoreCase(tipo)) {
				array_aux.clear();
				array_aux = (ArrayList) precio.array_rangos.clone();
				Iterator<Integer> numero = array_aux.iterator();
				while (numero.hasNext()) {
					b = numero.next();
					if (b == a) {
						System.out.println("b: " + b + " ");
						numero.remove();
					}

				}
				// limpiar array
				precio.imprimirRangos();
				precio.limiarRangos();
				precio.setRangos(array_aux);
			}
		}
		System.out.println("hola");
		for (Integer integer : array_aux) {
			System.out.println("array_precios: " + integer);
		}
		return array_precios;
	}

	public static boolean isNumeric(String str) {
		return (str
				.matches(/* "[+-]?\\d*(\\.\\d+)?" */"[0-9]*") /*
																 * && str.equals(
																 * "") == false
																 */ );
	}

	

	@Override
	public int compareTo(Object objeto) {
		// TODO Auto-generated method stub
		int compareage = ((equipos) objeto).getId();
		/* For Ascending order */
		return this.id - compareage;
	}
}
