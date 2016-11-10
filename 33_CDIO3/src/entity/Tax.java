package entity;

public class Tax extends Field{
	
	private int taxRate;
	private int taxAmount;
	
	public Tax (String fieldName, int taxAmount, int taxRate){
		
		super(fieldName);
		
		this.taxAmount = taxAmount;
		
		this.taxRate = taxRate;
	}
}
