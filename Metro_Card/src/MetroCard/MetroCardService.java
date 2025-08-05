package MetroCard;
import java.util.*;
public class MetroCardService {
	//store all cards
	private Map<String, MetroCard> cards =new HashMap<>();
	
	//store total fare,discount for each station
	private Map<String, Integer> totalCollection = new HashMap<>();
	private Map<String, Integer>  totalDiscount = new HashMap<>();
	
	//store passenger count by station and type
	//using nested map
	private Map<String,Map<String, Integer>> passengerSummary = new HashMap<>();
     

public MetroCardService() {
	totalCollection.put(Constants.AIRPORT,0);
	totalCollection.put(Constants.CENTRAL,0);
	
	totalDiscount.put(Constants.AIRPORT,0);
	totalDiscount.put(Constants.CENTRAL,0);
	
	passengerSummary.put(Constants.AIRPORT,new HashMap<>());
	passengerSummary.put(Constants.CENTRAL,new HashMap<>());
}

	
	
	public void addBalance(String cardId, int Balance) {
    	 cards.put(cardId, new MetroCard(cardId,Balance));
     }
     public void CheckIn(String cardId,String passenger,String station) {
    	 MetroCard card =cards.get(cardId);
    	 
    	 int journeyCount = card.getJourneyCount();
    	 int fare = FareCalculator.getFare(passenger, journeyCount);
    	 
    	 // check balance
    	 if(card.getBalance() < fare) {
    		 int shortage = fare - card.getBalance();
    		 int penalty = FareCalculator.calculatePenalty(shortage);
    		 //recharge (s+p)
    		 card.recharge(shortage+penalty);
    		 totalCollection.put(station,totalCollection.get(station) + penalty);
    	 }
    	 //deduct fare
    	 card.deductFare(fare);
    	 //increase jc
    	 card.incrementJourney();
    	 //update tc
    	 
    	 int currentCollection = totalCollection.get(station);
    	 totalCollection.put(station, currentCollection + fare);
    	 //update discount 50%
    	 
    	 int fullFare = FareCalculator.getFare(passenger,0);
    	 if(journeyCount == 1) {
    		 int discount = fullFare - fare;
    		 int currentDiscount = totalDiscount.get(station);
    		 totalDiscount.put(station, currentDiscount + discount );
    	 }
    	 //update ps
    	 Map<String, Integer>stationMap = passengerSummary.get(station);
    	 int count = stationMap.getOrDefault(passenger,0);
    	 stationMap.put(passenger, count + 1);
     }
     public void printSummary() {
    	 
    	 for (String station : List.of("CENTRAL","AIRPORT")) {
    		 int collection = totalCollection.getOrDefault(station,0);
    		 int discount =totalDiscount.getOrDefault(station,0);
    		 
    		 System.out.println("TOTAL_COLLECTION  " + station + " " + collection + " " + discount);
    		 System.out.println("PASSENGER_TYPE_SUMMARY");
    		 
    		 Map<String, Integer>summary = passengerSummary.getOrDefault(station,new HashMap<>());
    		 List<String> types =List.of("ADULT","SENIOR_CITIZEN","KID");
    		 types.stream()
    		     .filter(summary::containsKey)
    		      .sorted((a, b) ->{
    		    	  int cmp = Integer.compare(summary.get(b),summary.get(a));
    		    	  if (cmp == 0) return types.indexOf(a) - types.indexOf(b);
    		    	  return cmp;
    		    	  
    		      })
    		      .forEach(type ->System.out.println(type + " "+ summary.get(type)));
    		 System.out.println();
    	 }
     }
     public MetroCard getCard(String cardId) {
    	 return cards.get(cardId);
     }
}
