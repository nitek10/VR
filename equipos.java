package proyecto;

public class equipos {
	boolean disponible=true;
	String tarifa, tipo;
	Double precio_hora;
	int id;
	String fecha_entrada, fecha_salida;
	public equipos(int id, String tipo) {
		this.id=id;
		this.tipo=tipo;
	}
}
