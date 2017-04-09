//-----------------------------------------------------
//Assignment #4
//
//Written by: Seth Cole - 27795580, and Anne Ehresmann - 27858906
//-----------------------------------------------------
public interface Bill {
	
	/** 
	 * @return Returns a string representation of the calling object
	 */
	public String toString();
	
	/** Method for testing equality of two bills.
	 * @param obj An instance of the object class
	 * @return Boolean
	 */
	public boolean equals(Object obj);
	
	/** A method for setting the type of subscription
	 * @param sub an enumerated value of type subscription_type
	 */
	public void setSubType(subscription_type sub);
	
	/**
	 * Will present options to update the calling Bill
	 */
	public void update();
	
	/** Setter for numHours
	 * @param num an integer representing the number of hours
	 */
	public void setNumHours(int num);
	/** Setter for totalBill
	 * @param num A double representing the totalBill
	 */
	public void setTotalBill(double num);
	
	/** Getter for supplierId
	 * @return Long representing the supplierId
	 */
	public long getSupplierId();
	
	/** getter for billNumber
	 * @return Integer representing the bill number
	 */
	public int getBillNumber();

	/** Calls either getTotalBill() or getSubAmt() depending on the type of the calling bill.
	 * @return a double representing the money value of the bill.
	 */
	public double getMoney();
}
