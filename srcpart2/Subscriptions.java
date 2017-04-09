//-----------------------------------------------------
//Assignment #4
//
//Written by: Seth Cole - 27795580, and Anne Ehresmann - 27858906
//-----------------------------------------------------
import java.util.Scanner;

public class Subscriptions implements Bill {
	
	private long supplierId;
	private String supplierName, companyName;
	private int startYear, billNumber;
	private subscription_type subType;
	private double subAmt;

	
	/**Parameterized constructor
	 * @param tokens Array of tokens representing their associated values.
	 */
	public Subscriptions(String[] tokens){
		
		supplierId = Long.parseLong(tokens[0]);
		supplierName = tokens[1];
		companyName = tokens[2];
		startYear = Integer.parseInt(tokens[3]);
		billNumber = Integer.parseInt(tokens[4]);
		
		subAmt = Double.parseDouble(tokens[6]);
		
		if(tokens[5].equalsIgnoreCase("WEEKLY")) subType = subscription_type.WEEKLY;
		else if(tokens[5].equalsIgnoreCase("BI-WEEKLY")) subType = subscription_type.BIWEEKLY;
		else if(tokens[5].equalsIgnoreCase("MONTHLY")) subType = subscription_type.MONTHLY;
		else if(tokens[5].equalsIgnoreCase("BI-MONTHLY")) subType = subscription_type.BIMONTHLY;
		else if(tokens[5].equalsIgnoreCase("TRIMESTER")) subType = subscription_type.TRIMESTER;
		else if(tokens[5].equalsIgnoreCase("SEMESTER")) subType = subscription_type.SEMESTER;
		else if(tokens[5].equalsIgnoreCase("YEARLY")) subType = subscription_type.YEARLY;					
	}
	
	public String toString(){
		return supplierId + " " + supplierName + " " + companyName + " "+ startYear + " " + billNumber + " " + subType + " " + subAmt;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscriptions other = (Subscriptions) obj;
		if (billNumber != other.billNumber)
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (startYear != other.startYear)
			return false;
		if (Double.doubleToLongBits(subAmt) != Double.doubleToLongBits(other.subAmt))
			return false;
		if (subType != other.subType)
			return false;
		if (supplierId != other.supplierId)
			return false;
		if (supplierName == null) {
			if (other.supplierName != null)
				return false;
		} else if (!supplierName.equals(other.supplierName))
			return false;
		return true;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}

	public subscription_type getSubType() {
		return subType;
	}

	public void setSubType(subscription_type subType) {
		this.subType = subType;
	}

	public double getSubAmt() {
		return subAmt;
	}

	public void setSubAmt(double subAmt) {
		this.subAmt = subAmt;
	}
	
	/** Presents options for updating the subscription type of the bill.
	 * @see Bill#update()
	 */
	public void update(){
		Scanner key = new Scanner(System.in);
		System.out.println("You are attempting to update a subscription. You are currently able to update the type of subscription. \nPlease choose from the following list:");
		System.out.println("(1)WEEKLY \n(2)BIWEEKLY \n(3)MONTHLY \n(4)BIMONTHLY \n(5)TRIMESTER \n(6)SEMESTER \n(7)YEARLY");
		switch(key.nextInt()){
		case 1 : setSubType(subscription_type.WEEKLY);
				break;
		case 2 : setSubType(subscription_type.BIWEEKLY);
		break;
		case 3 : setSubType(subscription_type.MONTHLY);
		break;
		case 4 : setSubType(subscription_type.BIMONTHLY);
		break;
		case 5 : setSubType(subscription_type.TRIMESTER);
		break;
		case 6 : setSubType(subscription_type.SEMESTER);
		break;
		case 7 : setSubType(subscription_type.YEARLY);
		break;
		default : System.out.println("That is not an option!");
		break;
			
		}
	}
	public void setNumHours(int anum){
		
	}
	public void setTotalBill(double anum){
		
	}
	public double getMoney(){
		return getSubAmt();
	}

}
