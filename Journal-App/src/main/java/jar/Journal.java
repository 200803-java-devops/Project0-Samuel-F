package jar;

import java.util.Scanner;

public class Journal {
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);

        UserM note = new UserM();
        String menu = "0";

        while (!menu.equals("4"))
        {
            note.Homecreen();
            System.out.println("what are we doing today? ");
            System.out.println("1 - Add an entry");
            System.out.println("2 - Search for entries");
            System.out.println("3 - Delete entries");
            System.out.println("4 - BYE");
            menu = scan.nextLine();
            System.out.println();

            switch(menu)
            {
                case "1":
                note.addEntry();
                break;
                //case "2":
                //UserM.searchEntries();
                //break;
                //case "3":
                //UserM.delEntries();
                //break;
                case "4":
                System.out.println("Press 4 to quit program...");
                break;
                default:
                System.out.println("Error");
                break;


            }

        }
    }
    
}