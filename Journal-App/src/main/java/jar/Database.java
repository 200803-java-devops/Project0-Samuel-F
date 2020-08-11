package jar;

import java.time.LocalDate;
import java.util.ArrayList;

public class Database {
    //entries
    private ArrayList<Entry> entries;

    //init instance
    public Database()
    {
        entries = new ArrayList<Entry>();
    }

    //adds entry
    public void addEntry(LocalDate dateTime, String entry)
    {
        entries.add(new Entry(dateTime, entry));
    }

    //search entry by date only
    public ArrayList<Entry> findEntries(LocalDate date)
    {
        ArrayList<Entry> find = new ArrayList<Entry>();
        for (Entry entry : entries) 
        {
            if (entry.getDate().equals(date))
            {
                find.add(entry);
            }
        }
        return find;
    }



    //delete entry
    public void delEntry(LocalDate date)
    {
        ArrayList<Entry> find = findEntries(date);
        for (Entry entry : find) {
            entries.remove(entry);
        }
    }
    

}