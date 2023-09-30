import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class GetInput {
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static Scanner scanner = new Scanner(System.in);
    
    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    
    public static int getIntegerInRange(String prompt, int min, int max) {
        int number = -1;

        while (number < min || number > max) {
            System.out.printf("%s (%d-%d): ", prompt, min, max);
            String input = scanner.nextLine();

            try {
                number = Integer.parseInt(input);
                
                if (number < min || number > max) {
                    System.out.printf("Number should be between %d and %d. Please try again.%n", min, max);
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        return number;
    }
    
    public static Person getPerson(String role) {
    	System.out.println("Enter " + role + " Details");
        
    	String name = GetInput.getString("First Name: ");
        String surname = GetInput.getString("Surname: ");
        String phoneNumber = GetInput.getString("Phone Number: ");
        String emailAddress = GetInput.getString("Email Address: ");
        String physicalAddress = GetInput.getString("Physical Address:");

        return new Person(name, surname, phoneNumber, emailAddress, physicalAddress);
    }
    
    public static LocalDate getDate(String prompt) { 
    	        
        while (true) {
            String inputDate = getString(prompt + " (e.g. 31/12/2023): ");
            
            if (isValidDateFormat(inputDate)) {
            	 try {
            		LocalDate date =  LocalDate.parse(inputDate, DATE_FORMATTER); // Parsing ensures a valid date
            		return date;
            		
                 } catch (DateTimeParseException e) {
                     System.out.println("Invalid date. Please try again.");
                 }
            } else {
            	 System.out.println("Invalid date format. Please try again.");
            }
        }
    }
    
    public static LocalDate stringToDate(String dateString) {
    	return LocalDate.parse(dateString, DATE_FORMATTER);
    }
    
    public static String dateToString(LocalDate inputDate) {
    	return inputDate.format(DATE_FORMATTER);
    }
    
    public static LocalDate formatDate(LocalDate inputDate) {
    	String stringDate = dateToString(inputDate);
    	return stringToDate(stringDate);
    }
    
    private static boolean isValidDateFormat(String inputDate) {
        String pattern = "\\d{2}/\\d{2}/\\d{4}";
        return inputDate.matches(pattern);
    }
    
    public static double getCost(String prompt) {
    	DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    	
    	while (true) {
    		String inputString = getString(prompt);
    		
    		try {
    			double cost = Double.parseDouble(inputString);
    			
    			if (cost > 0) {
    				return Double.parseDouble(decimalFormat.format(cost));
    			} else {
    				System.out.println("Invalid number. Must be greater than 0!");
    			}
    			
    		} catch (NumberFormatException e) {
    			System.out.println("Invalid input. Try again!");
    		}
    	}    	
    }
    
    public static String doubleToString(double inputNumber) {
    	 DecimalFormat decimalFormat = new DecimalFormat("#.##");
    	 String formattedNumber = decimalFormat.format(inputNumber);
    	 
    	 return formattedNumber;
  
    }
    
    private static void closeScanner() {
        scanner.close();
    }

    // Allows other classes to close the scanner when they no longer need to retrieve input
    public static void cleanup() {
        closeScanner();
    }

}
