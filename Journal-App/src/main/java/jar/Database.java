package jar;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;




public class Database {
    Connection connection;

    /**
     * init instance
     * @throws SQLException
     */
    public Database() throws SQLException
    {
        connection = DBconnect.getConnect();
    }

    //adds entry
    public void addEntry(LocalDate date, String text)
    {
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO journal VALUES('" + date + "', '" + text + "')";
            //sql += "'" + date + "',";
            //sql += "'" + text + "')";
            System.out.println();
            System.out.println("Entry saved");
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Search entry by date only
     * @param date
     * @return
     */
    public ArrayList<Entry> findEntries(LocalDate date) 
    {
        ArrayList<Entry> find = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM journal WHERE entrydate = '" + date + "'");
            while(rs.next())
            {
                find.add(new Entry(date, rs.getString("journalentry")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return find;
    }



    /**
     * Delete entry
     * @param date
     */
    public void delEntry(LocalDate date)
    {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM journal WHERE entrydate = '" + date + "'");
            System.out.println();
            System.out.println("Entry deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

}