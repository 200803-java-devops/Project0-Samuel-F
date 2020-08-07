package jar;

import java.time.LocalDateTime;

public class Entry 
{
    private LocalDateTime dateTime;
    private String entry;

    public Entry(LocalDateTime dateTime, String entry) {
        this.dateTime = dateTime;
        this.entry = entry;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry)
    {
        this.entry = entry;
    }

    @Override
    public String toString()
    {
        return dateTime + " " + entry;
    }
}
