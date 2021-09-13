package practica4;

import java.util.Scanner;

public class main {
	public static void main(String[] args)
	{
		byte opcion, posicion;
		banco cuenta = new banco();
		Scanner entrada = new Scanner(System.in);
		do 
		{
			System.out.println("\nBANCO\n");
			System.out.println("\n1. Crear cuenta.");
			System.out.println("\n2. Acceder a cuenta.");
			System.out.println("\n3. Salir.");
			System.out.println("\nIngrese la opción deseada: ");
			opcion = entrada.nextByte();
			switch(opcion)
			{
				case 1: cuenta.setCuenta(entrada); 			
				break;
				
				case 2: posicion = cuenta.iniciarSesion(entrada);
						
						if(posicion != -1)
							cuenta.menu(posicion, entrada);
						break;
							
				case 3: System.out.println("\nSalir");                   
			}
		}while(opcion != 3);	
		entrada.close();	
	}
}
