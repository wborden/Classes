
import java.util.Scanner;

import java.io.FileReader;
	//import createCard;



	public class TUI extends FlashCardApp {
			
		
		
	public Scanner input = new Scanner(System.in);
	
	//if(input.next() == "!exit"){
		//System.exit(0);	}

	public void promptStart(){
		
		String reply = "";
		
		System.out.println("Would you like to import a previous study session?");
		System.out.println("Or would you like to create new cards?");
		System.out.println("Enter 'import' to import a session,"
				+ " or enter 'new' to begin creating new cards");		
		System.out.print("You may also enter '!quit' now, or anytime in the "
				+ "future to end you study session");
		System.out.println();
		 reply = input.nextLine().toLowerCase();
		if(reply.equals("import")) { System.out.print("nope, no import yet");}
		
		else if (reply.equals("new")){
			
			System.out.println("you made it here");
			
		this.createCard();
			
		 }
		
		else{
			System.exit(0);
		}
				
	}
	
	public int promptCardNum(){
		
		
		System.out.println("How Many Cards would you like to create?");
		int num = this.input.nextInt();
		
		return num;
		
	}
	
	public String[] promptCreate(){
		
		 String QA[] = {"", ""}; 
		
		System.out.println("Please enter the question or challenge");
		
		String q = this.input.next();
		QA[0] = q;
		System.out.println("Please enter the answer or response");
		String a = this.input.next();
		QA[1] = a;
		return QA;
	}
	
	
	
	
	
}
