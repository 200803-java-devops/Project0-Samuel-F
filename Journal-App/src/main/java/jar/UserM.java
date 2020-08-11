package jar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UserM {
    private Database database;
    private Scanner scan = new Scanner(System.in);
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/y HH:mm");
    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/y");

    public UserM()
    {
        database = new Database();
    }

    /**
     * Ask the user for a date and returns this value
     * A valid date is needed to stop asking
     * @return the date and time received from the user
     */
   private LocalDate readDate()
    {
        System.out.println("Enter date and time as mm/dd/yyyy");
        LocalDate date;
        try {
            date = LocalDate.parse(scan.nextLine(), dateFormatter);
        } catch (DateTimeParseException e) {
            System.out.println("Error invalid date entry");
            return readDate();        
        }
        return date;
    }

    /**
     * Ask user for journal entry and then add it to thee database
     */
    public void addEntry()
    {
        LocalDate date = readDate();
        System.out.println("How was your day today...");
        String text = scan.nextLine();
        database.addEntry(date, text);
    }

    /**
     * App home screen
     */
    public void Homecreen()
    {
        System.out.println();
        System.out.println("Welcome to your Journal");
        System.out.println("Today is: " + LocalDate.now().format(dateFormatter));
        System.out.println();
    }
}