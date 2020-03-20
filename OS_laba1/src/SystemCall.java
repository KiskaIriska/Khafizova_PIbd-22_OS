import java.util.ArrayList;

public class SystemCall {
	public String nameOfSystemCall;
	public int countOfArgs;
	public String systemCallInfo;
	public SystemCall(String nameOfSystemCall, int countOfArgs, String systemCallInfo){
		this.nameOfSystemCall = nameOfSystemCall; 
		this.countOfArgs = countOfArgs;
		this.systemCallInfo = systemCallInfo;
	}
	public void doCall(ArrayList<String> args){
		if(args.size() != countOfArgs)
		{
			String exceptionMessage = String.format("Неверное число аргументов %d, необходимо: %d", args.size(), countOfArgs);
			System.out.println(exceptionMessage);
		}
		System.out.print(nameOfSystemCall + ": ");
		for (int i = 0; i < args.size(); i++) {
			System.out.print(args.get(i) + " ");
		}
		System.out.println();
	}
	
	public String GetSystemCallInfo(){
		return "Системный вызов: " + this.nameOfSystemCall + "\t" +"Описание вызова: "+ this.systemCallInfo;
	}
}
