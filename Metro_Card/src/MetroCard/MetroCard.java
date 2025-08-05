package MetroCard;

public class MetroCard {
     private String cardId;
     private int balance;
     private int journeyCount;
 public MetroCard(String cardId,int balance) {
	 this.cardId= cardId;
	 this.balance = balance;
	 this.journeyCount = 0;
 }
 public String getCardId() {
	 return cardId;
 }
 public int getBalance() {
	 return balance;
 }
 public int getJourneyCount() {
	 return journeyCount;
 }
 public void incrementJourney() {
	 journeyCount++;
 }
 public void deductFare(int fare) {
	 balance -=fare;
 }
 public void recharge(int amount) {
	 balance += amount;
 }
}
