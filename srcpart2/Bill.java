
public interface Bill {
	
	public String toString();
	
	public boolean equals(Object obj);
	
	public void setSubType(subscription_type sub);
	
	public void update();
	
	public void setNumHours(int num);
	public void setTotalBill(double num);
	
	public long getSupplierId();
	
	public int getBillNumber();

	public double getMoney();
}
