package jar;

import java.time.LocalDateTime;
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
    public void addEntry(LocalDateTime dateTime, String entry)
    {
        entries.add(new Entry(dateTime, entry));
    }

    //search entry by date only
    public ArrayList<Entry> findEntries(LocalDateTime dateTime)
    {
        ArrayList<Entry> find = new ArrayList<Entry>();
        for (Entry entry : entries) 
        {
            if (entry.getDateTime().toLocalDate().equals(dateTime.toLocalDate()))
            {
                find.add(entry);
            }
        }
        return find;
    }



    //delete entry
    public void delEntry(LocalDateTime dateTime)
    {
        ArrayList<Entry> find = findEntries(dateTime);
        for (Entry entry : find) {
            entries.remove(entry);
        }
    }
    

}