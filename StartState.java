
public class StartState implements State
{
	public void doAction(ProcessContext context) {
	   Logger.getInstance().addLog("Reading procces is in start state");
	   context.setState(this);	
	}

	public String toString(){
		return "Start State";
	}
}
