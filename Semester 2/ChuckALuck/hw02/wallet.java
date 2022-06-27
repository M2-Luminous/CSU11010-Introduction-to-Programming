package hw02;

public class wallet {
	private double changeableMoney;
	
	public double getMoney()
	{
		return changeableMoney;
	}
	
	public void setMoney(double changeableMoney)
	{
		this.changeableMoney = changeableMoney;
	}
	
	public void add(double changeableMoney)
	{
		this.changeableMoney += changeableMoney;
	}
	
	public void subtract(double changeableMoney)
	{
		this.changeableMoney -= changeableMoney;
	}
}
