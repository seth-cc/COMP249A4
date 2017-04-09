//-----------------------------------------------------
//Assignment #4
//
//Written by: Seth Cole - 27795580, and Anne Ehresmann - 27858906
//-----------------------------------------------------
public class Driver {

	public static void main(String[] args) {
		BillDriver testBill = new BillDriver();
		System.out.println("Initial file contents: \n" + testBill.printBills());
		
		System.out.println("Adding bills...");
		Services addServ = new Services("215345 FakeSnow InstantMashPotatoes 1991 832010 333 76.0 453155.0".split("\\s+"));
		Subscriptions addSub = new Subscriptions("403252 BookAboutDogs ProfessionalPuppers 2000 130349 monthly 80009.0".split("\\s+"));
	
		testBill.addBill(addServ);
		testBill.addBill(addSub);
		
		System.out.println("Updated file contents: \n" + testBill.printBills());
		System.out.println("Attempting to add duplicate file...");
		testBill.addBill(addSub);
		
		System.out.println("Updating bill...");
		testBill.updateBill(185201);
		System.out.println("Removing bill...");
		testBill.removeBill(215345);
		System.out.println(testBill.find_highest_and_lowest_service());
	}

}
