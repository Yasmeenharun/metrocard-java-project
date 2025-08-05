package MetroCard;

public class FareCalculator {
    public static int getFare(String passengerType,int journey) {
    	int fullFare = 0;
    	
    	if(passengerType.equals(Constants.ADULT)) {
    		fullFare =Constants.ADULT_FARE;
       }else if (passengerType.equals(Constants.SENIOR_CITIZEN)){
    	   fullFare =Constants.SENIOR_CITIZEN_FARE;
       }else if(passengerType.equals(Constants.KID)) {
    	   fullFare =Constants.KID_FARE;
       }
    	//APPLY 50% discount only on the second journey
    	if(journey == 1) {
    		return fullFare/2;
    	}
    	return fullFare;
    }
  
  public static int calculatePenalty(int shortage) {
	  return(int)  Math.ceil(shortage *Constants.PENALTY_RATE);
  }
}
