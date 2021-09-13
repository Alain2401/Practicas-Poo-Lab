package practica4;

import java.util.Scanner;

public class banco {
	private String name; 
	private double saldo;
	private short pin; 
	private static byte i = 0; 
	private cuenta[] usuario = new cuenta[10]; 
	
	public void setCuenta(Scanner entrada) 
	{
		if(i == 10) 
		{
			System.out.println("\nLímite de cuentas.");
			return;
		}
		entrada.nextLine();
		System.out.println("\nIngresar nombre: ");
		name = entrada.nextLine();
		do 
		{
			System.out.println("\nIngresar monto para abrir cuenta: \n$");
			saldo = entrada.nextDouble();
		}while(saldo <= 0);
		do 
		{
			System.out.println("\nIngresar PIN de seguridad (4 dígitos): ");
			pin = entrada.nextShort();
		}while(pin < 1000 || pin > 9999);		
		usuario[i++] = new cuenta(name, saldo, pin); 
	}
	public byte iniciarSesion(Scanner entrada)
	{
		if(i == 0)
		{
			System.out.println("\nNo se puede acceder a ninguna cuenta porque no se creado ninguna.");
			return -1;
		}
		boolean cuentaExiste = false; 
		byte j = -1;
		entrada.nextLine();
		System.out.println("\nIngresar su nombre: ");
		name = entrada.nextLine();
		System.out.println("\nIngresar PIN: ");
		pin = entrada.nextShort();
		while(!cuentaExiste && ++j != i) 
		{
			if(pin == usuario[j].getPin())
				cuentaExiste = true;
		}
		if( cuentaExiste && name.equals(usuario[j].getName()) ) 
			return j;
		else System.out.println("\nIntentar nuevamente.");
		return -1; 
	}
	public void menu(byte posicion, Scanner entrada)
	{
		byte opcion; 		
		do
		{
			System.out.println("\nBienvenid@ " + usuario[posicion].getName());
			System.out.println("\n1. Hacer un depósito.");
			System.out.println("\n2. Hacer un retiro.");
			System.out.println("\n3. Ver datos de cuenta.");
			System.out.println("\n4. Cerrar sesión.");
			System.out.println("\nOpción : ");
			opcion = entrada.nextByte();
			switch(opcion)
			{
				case 1: System.out.println("\nIngresa la cantidad a depositar: ");
						saldo = entrada.nextDouble();
						usuario[posicion].setDeposito(saldo);
						break;
						
				case 2: System.out.println("\nIngresa la cantidad a retirar: ");
						saldo = entrada.nextDouble();
						usuario[posicion].setRetiro(saldo);
						break;
				
				case 3: getCuenta(posicion);
			}
			
		}while(opcion != 4);
	}
	private void getCuenta(byte posicion) 
	{
		System.out.println("\nNombre: " + usuario[posicion].getName());
		System.out.println("\nSaldo: $" + usuario[posicion].getSaldo());
		System.out.println("\nPIN: " + usuario[posicion].getPin());
	}
}
