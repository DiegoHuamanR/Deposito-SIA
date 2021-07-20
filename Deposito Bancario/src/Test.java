import java.io.File;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Archivos prueba= new Archivos();
		int cantidad=0;
		String s1=prueba.leerTextos("C:\\Users\\DIEGO\\Documents\\Deposito\\Deposito-SIA\\Deposito Bancario\\src\\Cuentas.txt");//conversion del txt a string
		System.out.println(s1);
		int num=0;
		int monto=0;
		LinkedList<String> numeros = new LinkedList<String>();
		Pattern p = Pattern.compile("\\d+");//Obtencion de los datos del txt
		Matcher m = p.matcher(s1); 
		while (m.find()) {
		   numeros.add(m.group());
		}	
		cantidad=(numeros.size()/2);
		Ordenamiento<String> g=new Ordenamiento<String>(cantidad);
		LinkedList<String> textos = new LinkedList<String>();
		Pattern pa = Pattern.compile("\\w+");
		Matcher ma = pa.matcher(s1); 
		while (ma.find()) {
		   textos.add(ma.group());
		}
		int a=1;
		int b=2;
		int c=1;
		int d=0;
		for(int i=0;i<numeros.size();i=i+2) {
			num=Integer.parseInt(numeros.get(i));
			monto=Integer.parseInt(numeros.get(c));
			g.insert(num,textos.get(a) , textos.get(b),monto);
			a=a+4;
			b=b+4;
			c=c+2;
			
		}
		System.out.println(g);
		System.out.println("\tBienvenidos al Banco SIA\n");
		
		int numerotarjeta;
		int tarjetadestino=0;
		int montodeposito;
		boolean resp;
		String nombre;
		String apellido;
		Scanner entrada= new Scanner(System.in);//Ingreso de la Tarjeta
		System.out.println("\tIngreso de Tarjeta ");
		System.out.println("Ingrese el numero de tarjeta: ");
		numerotarjeta=entrada.nextInt();
		resp=g.search(numerotarjeta);
		if(resp==true) {
			resp=false;
			while(resp==false) {
				System.out.println("Ingrese el numero de la cuenta que desea depositar: ");
				tarjetadestino=entrada.nextInt();
				resp=g.search(tarjetadestino);
				if(resp==false) {
					System.err.println("Ingrese de nuevo el numero de cuenta, no se encontro la cuenta");
				}
			}
			resp=false;
			System.out.println("\n\n");//Confirmacion de los datos
			System.out.println("\tConfirmación de datos\n");
			while(resp==false) {
				System.out.println("Ingrese el Numero de cuenta: ");
				tarjetadestino=entrada.nextInt();
				System.out.println("Ingrese el Nombre del propietario de la cuenta:");
				nombre=entrada.next();
				System.out.println("Ingrese el Apellido del propietario de la cuenta:");
				apellido=entrada.next();
				resp=g.search(tarjetadestino);
				if(resp==false) {
					System.err.println("Vuelva a Ingresar los datos para la confirmación, no se encontro la cuenta");
				}
			}
			System.out.println("\n\n");
			System.out.println("\tIngreso de Efectivo\n");//Ingreso del Deposito
			System.out.println("Ingrese el monto que desea depositar:");
			montodeposito=entrada.nextInt();
			g.montonuevo(tarjetadestino, montodeposito);
			
			
			
		}
		else {
			System.err.println("Tarjeta no encontrada");
		}
		System.out.println(g);//Mostrar los datos del txt para verificar los cambios
	}
	

}
