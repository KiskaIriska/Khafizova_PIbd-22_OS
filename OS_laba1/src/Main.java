
public class Main {

	public static void main(String[] args) throws Exception {
		Core core = new Core();
		core.Add(new Argument("file"));
		core.Add(new Argument(5));
		core.Run(0);
		core.Add(new Argument("file1"));
		core.Add(new Argument("fifdhg"));
		core.Run(2);
		core.Add(new Argument("73"));
		core.Add(new Argument(988));
		core.Add(new Argument("fl"));
		core.Add(new Argument("1237"));
		core.Run(3);
		core.Add(new Argument("file5"));
		core.Add(new Argument("file4"));
		core.Run(4);
		core.Run(5);
		
		System.out.println("\n" + "Список системных вызовов:");
		System.out.println(core.printSystemCalls());
	}
}
