import java.io.*;
import java.util.Scanner;

public class Bill {
	
	
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
		
		boolean subExist = false, servExist = false;
		for(i = 0; i < Bills.getSize(); i++){
			if(Bills.findAt(i) instanceof Subscriptions){
				Subscriptions tempcheck = (Subscriptions) Bills.findAt(i);
				if(tempcheck.getBillNumber() == billNum){
					subExist = true;
					break;
				}
			}
			else if(Bills.findAt(i) instanceof Services){
				Services tempcheck = (Services) Bills.findAt(i);
				if(tempcheck.getBillNumber() == billNum){
					servExist = true;
					break;
				}
			}
		}
			if(subExist) updateSub((Subscriptions)Bills.findAt(i));
			if(servExist) updateServ((Services)Bills.findAt(i));
			if(!subExist && !servExist) System.out.println("No bill with that bill number was found!");
			
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
		
			if(Bills.findAt(i) instanceof Subscriptions){
				Subscriptions tempcheck = (Subscriptions) Bills.findAt(i);
				if(tempcheck.getSupplierId() != supNum){
				pw.println(Bills.findAt(i));
				}
			}
			else if(Bills.findAt(i) instanceof Services){
				Services tempcheck = (Services) Bills.findAt(i);
				if(tempcheck.getSupplierId() != supNum){	
					pw.println(Bills.findAt(i));
				}
			}
		}
		pw.close();
		}
		
		
	public double findSupplierTotalBills(long supId){
		MyLinkedList<Bill> Bills = importBills();

		double total = 0;
		for(int i = 0; i < Bills.getSize(); i++){
			System.out.println(i);
			if(Bills.findAt(i) instanceof Subscriptions){
				Subscriptions tempcheck = (Subscriptions) Bills.findAt(i);
				if(tempcheck.getSupplierId() == supId){
				total += tempcheck.getSubAmt();
				}
			}
			else if(Bills.findAt(i) instanceof Services){
				Services tempcheck = (Services) Bills.findAt(i);
				if(tempcheck.getSupplierId() == supId){	
					total += tempcheck.getTotalBill();
				}
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
			//Add incorrect formatting error!!
			Bills.addAt(tempBill, index);
			index++;		
		}
		read.close();
		return Bills;
	}
	
	private void updateSub(Subscriptions sub){
		key = new Scanner(System.in);
		System.out.println("You are attempting to update a subscription. You are currently able to update the type of subscription. \nPlease choose from the following list:");
		System.out.println("(1)WEEKLY \n(2)BIWEEKLY \n(3)MONTHLY \n(4)BIMONTHLY \n(5)TRIMESTER \n(6)SEMESTER \n(7)YEARLY");
		switch(key.nextInt()){
		case 1 : sub.setSubType(subscription_type.WEEKLY);
				break;
		case 2 : sub.setSubType(subscription_type.BIWEEKLY);
		break;
		case 3 : sub.setSubType(subscription_type.MONTHLY);
		break;
		case 4 : sub.setSubType(subscription_type.BIMONTHLY);
		break;
		case 5 : sub.setSubType(subscription_type.TRIMESTER);
		break;
		case 6 : sub.setSubType(subscription_type.SEMESTER);
		break;
		case 7 : sub.setSubType(subscription_type.YEARLY);
		break;
		default : System.out.println("That is not an option!");
		break;
			
		}
	}
	
	private void updateServ(Services serv){
		key = new Scanner(System.in);
		System.out.println("You are attempting to update a service bill. You are currently able to update the number of hours and the total bill. \nPlease enter both new values separated by a space: ");
		serv.setNumHours(key.nextInt());
		serv.setTotalBill(key.nextDouble());
	}
	public String toString(){
		String ret = "";
		if(this instanceof Services){
			Services temp = (Services)this;
			ret = temp.toString();
		}
		if(this instanceof Subscriptions){
			Subscriptions temp = (Subscriptions)this;
			ret = temp.toString();
			
		}
		return ret;
	}
	

}
