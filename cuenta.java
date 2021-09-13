package practica4;

public class cuenta {
	private String name; 
	private double saldo;
	private short pin;
	
	public cuenta(String name, double saldo, short pin)
	{
		this.name = name;
		this.saldo = saldo;
		this.pin = pin;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setSaldo(double saldo)
	{
		this.saldo = saldo;
	}
	
	public void setPin(short pin)
	{
		this.pin = pin;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getSaldo()
	{
		return saldo;
	}
	
	public short getPin()
	{
		return pin;
	}
	
	public void setDeposito(double deposito)
	{
		if(deposito > 0)
			saldo += deposito;
		
		else System.out.println("\nCantidad no valida.");
	}
	
	public void setRetiro(double retiro)
	{
		if(retiro <= saldo)
			saldo -= retiro;
		
		else System.out.println("\nEsa cantidad no es válida.");
	}


}
