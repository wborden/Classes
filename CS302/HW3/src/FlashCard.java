
public class FlashCard {
	
	
	public FlashCard(String Q, String A){
		this.challenge = Q;
		this.response = A;
	}
	
	//public FlashCard newCard(){
		
		//FlashCard FlashCard = new FlashCard("","");
		
		//return FlashCard;
	//}
	
	public String getChallenge(){
		return challenge;
		
	}
	
	public String getResponse(){
		return response;
		
	}
	
	private String challenge;
	private String response;
	 

}
