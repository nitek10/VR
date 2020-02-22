package local;
import java.util.*;
public class entrada_salida {
	Scanner teclado=new Scanner(System.in);
	public entrada_salida(){
		
	}
	public String tipoString(String tipo_valor){
		String cadena="";
		cadena=teclado.nextLine();
		if(tipo_valor.equals("int")){
			try{
				Integer.parseInt(cadena);
			}catch (Exception e){
				System.out.println("no");
				cadena="";
			}
		}else if(tipo_valor.equals("double") || tipo_valor.equals("float")){
			try{
				Double.parseDouble(cadena);
			}catch (Exception e){
				cadena="";
			}
		}else{
			cadena=cadena;
		}
		System.out.println("cadena: "+cadena);
		return cadena;
	}
	public String int_exit(String tipo_valor){
		String cadena="";
		cadena=teclado.nextLine();
		if(cadena.equalsIgnoreCase("exit")){
			cadena=cadena;
		}else{
			try{
				Integer.parseInt(cadena);
			}catch (Exception e){
				System.out.println("no");
				cadena="";
			}
		}
		return cadena;
	}

}
