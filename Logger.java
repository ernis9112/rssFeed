import java.util.ArrayList;

public class Logger {
	
	private static Logger instance = null;
	private ArrayList<String> logMessages = new ArrayList<String>();

    private Logger()
    {
    }

    public static Logger getInstance()
    {
        if (instance == null)
        {
            instance = new Logger();
        }
        return instance;
    }

    public void addLog(String log)
    {
        logMessages.add(log);
    }

    public ArrayList<String> getLogMessages()
    {
        return logMessages;
    }
}
