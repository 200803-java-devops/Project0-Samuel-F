package jar;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserM {
    private Database database;
    private Scanner scan = new Scanner(System.in);
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/y HH:mm");
    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/y");

    public UserM() throws SQLException {
        database = new Database();
    }

    /**
     * Ask the user for a date and returns this value 
     * A valid date is needed to stop asking
     * 
     * @return the date and time received from the user
     */
    private LocalDate readDate() {
        System.out.println("Enter date as mm/dd/yyyy");
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
     * Ask user for journal entry and then add it to the database
     */
    public void addEntry() {
        LocalDate date = readDate();
        System.out.println("How was your day today...");
        String text = scan.nextLine();
        database.addEntry(date, text);
    }

    /**
     * Provide ability to search for saved entries from the database
     */
    public void searchEntries() {
        LocalDate dateTime = readDate();
        ArrayList<Entry> entries = database.findEntries(dateTime);
        if (entries.size() > 0)
        {
            System.out.println("Entries for the day: ");
            for (Entry entry : entries) {
                System.out.println(entry);
            }
        }else
        {
            System.out.println("No entries for the day");
        }
        scan.nextLine();
        
    }

    /**
     * Entries with date specified will be deleted from database
     */
    public void delEntries()
    {
        System.out.println("Entries with date specified will be deleted");
        LocalDate date = readDate();
        database.delEntry(date);
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
       //System.out.println("Today's journal entries:\n");
    }
}