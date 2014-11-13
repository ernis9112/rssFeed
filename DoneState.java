
public class DoneState implements State
{
	public void doAction(ProcessContext context) {
	   Logger.getInstance().addLog("Reading is done");
	   context.setState(this);	
	}

	public String toString(){
		return "Done State";
	}
}
