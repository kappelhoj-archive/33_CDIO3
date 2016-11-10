package entity;

public class Tax extends Field{
	
	private int taxAmount;
	
	private int taxRate;
	
	public Tax (String name, int taxAmount, int taxRate){
		
		super(name);
		
		this.taxAmount = taxAmount;
		
		this.taxRate = taxRate;
	}
}
