import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
 
public class Database implements IConnection
{	
	public Connection connection = null;
	public Statement stmt = null;
	
	public Database(String connStr) throws Exception
	{
		this.connection = DriverManager.getConnection(connStr);
		this.stmt = this.connection.createStatement();
	}
	
	@Override
	public void executeQuery(String query, String type) throws Exception
    {
        int iTimeout = 30;
        String sMakeTable = "CREATE TABLE IF NOT EXISTS rssfeeds (date text, author text, category text, link text, title text, UNIQUE(title))";
        
        String sMakeInsert = "";
        String sMakeSelect = "";
        
        if(type.equals("insert"))
            sMakeInsert = query;
        
        if(type.equals("select"))
            sMakeSelect = query;

        try {
            try {
                stmt.setQueryTimeout(iTimeout);
                stmt.executeUpdate( sMakeTable );
                if(type.equals("insert"))
                    stmt.executeUpdate( sMakeInsert );
                if(type.equals("select")){
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
                }
            } finally {
                try {} catch (Exception ignore) {}
            }
        } finally {
            try {} catch (Exception ignore) {}
        }
    }
 
}
