
 
	
 	

public class FlashCardApp {
	
	  static TUI appTUI = new TUI();
	  
	  //Begin appBegin = new Begin();

	int num = 0;
	FlashCard current;
	
	public void createCard() {
		int N = appTUI.promptCardNum();		
		
		for (int i = 0; i < N; i++){
			
			String[] QA = appTUI.promptCreate();		
			
		    current = new FlashCard(QA[0], QA[1]);
			
			System.out.println("Current flashcard question = " +  current.getChallenge());
			System.out.println("Current flashcard answer = " +  current.getResponse());
		}
		
		
	}
	
		
	
	
	
	public static void main(String args[]){
		
		appTUI.promptStart();
		
		
	}
	
}
