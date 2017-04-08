

public class Subscriptions extends Bill {
	
	private long supplierId;
	private String supplierName, companyName;
	private int startYear, billNumber;
	private subscription_type subType;
	private double subAmt;

	
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
	


}
