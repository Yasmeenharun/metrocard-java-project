package MetroCard;
 
public class CommandProcessor{
	private static final MetroCardService metroService=new MetroCardService();
	public static void process(String line) {
		if(line.trim().isEmpty())
			return ;
		String[] parts = line.split(" ");
		String command =parts[0];
	switch (command) {
		case "BALANCE":
			String cardId = parts[1];
			int amount =Integer.parseInt(parts[2]);
			metroService.addBalance(cardId,amount);
			break;
			
		case "CHECK_IN":
			cardId =parts[1];
			String passengerType = parts[2];
			String station = parts[3];
			metroService.CheckIn(cardId,passengerType,station);
			break;
		
		case "PRINT_SUMMARY" :
			metroService.printSummary();
			break;
			
		default:
			System.out.println("Unknown command:");
		}
	}
}

