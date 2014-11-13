
public class ProgressState implements State
{
	public void doAction(ProcessContext context) {
	   Logger.getInstance().addLog("Reading procces is in progress");
	   context.setState(this);	
	}

	public String toString(){
		return "Progress State";
	}
}
