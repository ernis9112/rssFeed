public class ProxyConnection implements IConnection {
	
	public Database database = null;
    private String connStr = "jdbc:sqlite:database.db";

    public ProxyConnection() { 
    }
    
	@Override
	public void executeQuery(String query, String type, String sth) throws Exception {
		if(database == null){
			database = new Database(connStr);
		}
		database.executeQuery(query, type, sth);
	}
}
