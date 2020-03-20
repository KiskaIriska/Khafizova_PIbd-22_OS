
public class Main {

	public static void main(String[] args) throws Exception {
		Core core = new Core();
		core.Add("file");
		core.Add("123");
		core.Run(0);
		core.Add("file1");
		core.Add("fifdhg");
		core.Run(2);
		core.Add("73");
		core.Add("file1");
		core.Add("fl");
		core.Add("1237");
		core.Run(3);
		core.Add("file5");
		core.Add("file4");
		core.Run(4);
		core.Run(5);
		
		System.out.println("\n" + "Список системных вызовов:");
		System.out.println(core.printSystemCalls());


	}

}
