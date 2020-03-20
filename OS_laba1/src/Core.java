import java.util.ArrayList;
import java.util.HashMap;

public class Core {
	MyStack myStack;
	HashMap<Integer, SystemCall> SystemCalls;
	
	public Core()
	{
		this.myStack = new MyStack();
		this.SystemCalls = new HashMap<Integer, SystemCall>();		
		SystemCalls.put(0, new SystemCall("open", 3, "Работа с файлами"));
		SystemCalls.put(1, new SystemCall("close", 1, "Работа с файлами"));
		SystemCalls.put(2, new SystemCall("load", 2, "Управление процессами"));
		SystemCalls.put(3, new SystemCall("get", 4, "Работа с информацией"));
		SystemCalls.put(4, new SystemCall("create", 2, "Связь, коммуникация"));
	}
	
	public void Add(Argument arg) {
		this.myStack.push(arg);
	}
	
	public void Run(int id) throws Exception {
		ArrayList<Argument> args = new ArrayList<Argument>();
		if (SystemCalls.get(id) == null) {
			String exceptionMessage = String.format("Неверный системный вызов", id);
			System.out.println(exceptionMessage);
			return;
		}
		for (int i = 0; i < SystemCalls.get(id).countOfArgs; i++) {
			Argument arg = myStack.pop();
			if(arg != null) {
			args.add(arg);
			} else {
				String exceptionMessage = "Неверное количество аргументов системного вызова";
				System.out.println(exceptionMessage);
				return;
			}
		}
		SystemCalls.get(id).doCall(args);
	}
	
	public String printSystemCalls() {
		String result = "";
		for(int i = 0; i < 5; i++)
		{
			result = result + i + ": "+ SystemCalls.get(i).GetSystemCallInfo()+"\n";
		}	
		return result;
	}
	
}
