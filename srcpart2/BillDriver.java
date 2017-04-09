import java.io.*;
import java.util.Scanner;
//-----------------------------------------------------
//Assignment #4
//
//Written by: Seth Cole - 27795580, and Anne Ehresmann - 27858906
//-----------------------------------------------------
public class BillDriver {
	
	
	private Scanner read = null;
	private PrintWriter pw = null;
	private Scanner key = null;
	
	/** Adds a new bill to the file Bills.txt
	 * @param newBill An object of type bill
	 */
	public void addBill(Bill newBill){
		MyLinkedList<Bill> Bills = importBills();
		boolean exists = false;
		for(int i = 0; i < Bills.getSize(); i++){
				if(newBill.equals(Bills.findAt(i))){
					exists = true;
					break;
				
			}
		}
		if(!exists){
			
			try{
				pw = new PrintWriter(new FileOutputStream("Bills.txt", true));
			}
			catch(Exception e){
				System.out.println(e);
			}
			
			pw.println(newBill);
			pw.close();
		}
		else{
			System.out.println("That bill already exists in the file. Closing streams...");
		}
	
	}
	
	/** A method which will call the update method of the specified bill
	 * @param billNum An integer value equal to that of the billNumber of the bill to be updated
	 */
	public void updateBill(int billNum){
	
		MyLinkedList<Bill> Bills = importBills();
		int i = 0;
		
		boolean Exist = false;
		for(i = 0; i < Bills.getSize(); i++){
			
				if(Bills.findAt(i).getBillNumber() == billNum){
					Exist = true;
					break;
				}
			}
	
		if(Exist)Bills.findAt(i).update();
		
			
		else System.out.println("No bill with that bill number was found!");
			
			try{
				pw = new PrintWriter(new FileOutputStream("Bills.txt"));
			}
			catch(Exception e){
				System.out.println(e);
			}
		
			for(int k = 0; k < Bills.getSize(); k++){
				pw.println(Bills.findAt(k));
			}
			pw.close();
			
				
			}
	
	/** A method which will remove a bill from Bills.txt
	 * @param supNum a Long equal to the supplier number of the bill to be removed
	 */
	public void removeBill(long supNum){
		
		MyLinkedList<Bill> Bills = importBills();
		try{
			pw = new PrintWriter(new FileOutputStream("Bills.txt"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		for(int i = 0; i < Bills.getSize(); i++){

				if(Bills.findAt(i).getSupplierId() != supNum){
				pw.println(Bills.findAt(i));
				}
			}
		pw.close();
	}
		
		
	/** A method to calculate the total bills associated with one supplier
	 * @param supId A long equal to the supplierNumber of the supplier whos bills are to be calculated
	 * @return Returns a value of type double representing the total bills
	 */
	public double findSupplierTotalBills(long supId){
		MyLinkedList<Bill> Bills = importBills();

		double total = 0;
		for(int i = 0; i < Bills.getSize(); i++){

				if(Bills.findAt(i).getSupplierId() == supId){
				total += Bills.findAt(i).getMoney();
				}
			}

		return total;
		
	}
	
	/** A method finding the service with the highest cost and the lowest cost
	 * @return Returns a string stating which services have the highest and lowest cost
	 */
	public String find_highest_and_lowest_service(){
		MyLinkedList<Bill> Bills = importBills();
		double highest = 0, lowest = 999999999;
		int highindex = -1, lowindex = -1;
		
		for(int i = 0; i< Bills.getSize(); i++)
			if(Bills.findAt(i) instanceof Services){
				Services temp = (Services)Bills.findAt(i);
				if(temp.getHourRate() > highest){
					highest = temp.getHourRate();
					highindex = i;
				}
				if(temp.getHourRate() < lowest){
					lowest = temp.getHourRate();
					lowindex = i;
				}
				
			}
		Services lowService = (Services)Bills.findAt(lowindex), highService = (Services)Bills.findAt(highindex);
		return "The lowest cost service is " + lowService.getCompanyName() + ", they offer "+ lowService.getServiceName() + " services.\nThe highsest cost service is " +highService.getCompanyName() + ", They offer " +highService.getServiceName()+" services.";
	}
	/** A method for printing the contents of Bills.txt in the console
	 * @return returns a string of all bills.
	 */
	public String printBills(){
		MyLinkedList<Bill> Bills = importBills();
		String ret = "";
		for(int i = 0; i<Bills.getSize(); i++){
			ret += Bills.findAt(i) + "\n";
		}
		return ret;
		
	}
	
	/** Private helper method for importing all bills into a list of type MyLinkedList<Bill>
	 * @return Returns a MyLinkedList<Bill> that lists the content of Bills.txt
	 */
	private MyLinkedList<Bill> importBills(){
		
		MyLinkedList<Bill> Bills = new MyLinkedList<Bill>();
		try{
			read = new Scanner(new FileInputStream("Bills.txt"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		int index = 0;
		Bill tempBill = null;
		while(read.hasNextLine()){
			String temp = read.nextLine();
			String[] tokens = temp.split("\\s+");
			if(tokens.length == 7) tempBill = new Subscriptions(tokens);
			else if(tokens.length == 8) tempBill = new Services(tokens);
			else tempBill = null;
			Bills.addAt(tempBill, index);
			index++;		
		}
		read.close();
		return Bills;
	}

}
