import java.io.*;
import java.util.Scanner;

public class BillDriver {
	
	
	Scanner read = null;
	PrintWriter pw = null;
	Scanner key = null;
	
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
	public String printBills(){
		MyLinkedList<Bill> Bills = importBills();
		String ret = "";
		for(int i = 0; i<Bills.getSize(); i++){
			ret += Bills.findAt(i) + "\n";
		}
		return ret;
		
	}
	
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
