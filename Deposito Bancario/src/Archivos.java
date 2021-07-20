import java.util.Scanner;
import java.io.*;



public class Archivos {//Lector de archivos txt
	
	public String leerTextos(String direccion) {
		String prueba="";
		
		try {
			BufferedReader p= new BufferedReader(new FileReader(direccion));
			
			String temp="";
			String pRead="";
			while((pRead=p.readLine())!=null) {
				temp=temp+pRead+"\n";
				
			}
			prueba=temp;
		}catch(Exception e) {
			System.err.println("No se encontro el archivo");
			}

		return prueba;
		
	}
}