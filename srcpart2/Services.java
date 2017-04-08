

public class Services extends Bill {
	
	private long supplierId;
	private String serviceName;
	private String companyName;
	private int startYear;
	private int billNumber;
	private int numHours;
	private double hourRate;
	private double totalBill;

	public Services(String[] tokens){
		supplierId = Long.parseLong(tokens[0]);
		serviceName = tokens[1];
		companyName = tokens[2];
		startYear = Integer.parseInt(tokens[3]);
		billNumber = Integer.parseInt(tokens[4]);
		numHours = Integer.parseInt(tokens[5]);
		hourRate = Double.parseDouble(tokens[6]);
		totalBill = Double.parseDouble(tokens[7]);
	}
	
	public String toString(){
		return supplierId +" "+ serviceName + " " + companyName + " " + startYear +" "+ billNumber+" "+numHours+" "+hourRate+" "+totalBill;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Services other = (Services) obj;
		if (billNumber != other.billNumber)
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (Double.doubleToLongBits(hourRate) != Double.doubleToLongBits(other.hourRate))
			return false;
		if (numHours != other.numHours)
			return false;
		if (serviceName == null) {
			if (other.serviceName != null)
				return false;
		} else if (!serviceName.equals(other.serviceName))
			return false;
		if (startYear != other.startYear)
			return false;
		if (supplierId != other.supplierId)
			return false;
		if (Double.doubleToLongBits(totalBill) != Double.doubleToLongBits(other.totalBill))
			return false;
		return true;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
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

	public int getNumHours() {
		return numHours;
	}

	public void setNumHours(int numHours) {
		this.numHours = numHours;
	}

	public double getHourRate() {
		return hourRate;
	}

	public void setHourRate(double hourRate) {
		this.hourRate = hourRate;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
}
