import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.DatabaseMetaData;
 
public class Database
{
	
    public void executeQuery(String query) throws Exception
    {
        String sDriverName = "org.sqlite.JDBC";

        String sTempDb = "database.db";
        String sJdbc = "jdbc:sqlite";
        String sDbUrl = sJdbc + ":" + sTempDb;

        int iTimeout = 30;
        String sMakeTable = "CREATE TABLE IF NOT EXISTS rssfeeds (date text, author text, category text, link text, title text, UNIQUE(title))";
        String sMakeInsert = query;
        
        String sMakeSelect = "SELECT title from rssfeeds";
 
        // create a database connection
        Connection conn = DriverManager.getConnection(sDbUrl);
        try {
            Statement stmt = conn.createStatement();
            try {
                stmt.setQueryTimeout(iTimeout);
                stmt.executeUpdate( sMakeTable );
                stmt.executeUpdate( sMakeInsert );
                ResultSet rs = stmt.executeQuery(sMakeSelect);
                try {
                    while(rs.next())
                        {
                            String sResult = rs.getString("title");
                            System.out.println(sResult);
                        }
                } finally {
                    try { rs.close(); } catch (Exception ignore) {}
                }
            } finally {
                try { stmt.close(); } catch (Exception ignore) {}
            }
        } finally {
            try { conn.close(); } catch (Exception ignore) {}
        }
    }
 
}
