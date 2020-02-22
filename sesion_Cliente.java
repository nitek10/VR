package local;

public class sesion_Cliente {
	public sesion_Cliente() {
		
	}
	
	public void gestionCliente(metodos_main objeto_main, String usuario) {
		System.out.println("Sesion Cliente");
		String opcion;
		entrada_salida teclado2=new entrada_salida();
		do {
			System.out.println("1.Ver tarifas\n"+"2.Ver salas/ordenadores disponibles\n"+"3.Hacer reserva\n"+"4.Cancelar reserva\n"+"5.Modificar perfil\n"+"6.Salir");
			do{
			opcion = teclado2.tipoString("int");
			}while(opcion.equals(""));
			switch(opcion) {
			case "1":
				objeto_main.verTarifas();
				break;
			case "2":
				//salas pcs disponibles
				break;
			case "3":
				//hacer reserva
				break;
			case "4":
				//cancelar reserva
				break;
			case "5":
				objeto_main.modificar_atributos_cliente(usuario);
				break;
			default:
				break;
			}
		}while(!opcion.equals("6"));
	}
}
