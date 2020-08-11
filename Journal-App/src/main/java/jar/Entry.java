package jar;

import java.time.LocalDate;

public class Entry 
{
    private LocalDate date;
    private String entry;

    public Entry(LocalDate date, String entry) {
        this.date = date;
        this.entry = entry;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
        return date + " " + entry;
    }
}
