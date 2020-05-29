import java.util.Queue;

public class Algorithm {
	private TableOfPages tableVirtualMemory;
	private Queue<Page> pageQueue;
	
	public Algorithm (TableOfPages tableVirtualMemory,Queue<Page> pageQueue) {
		this.tableVirtualMemory = tableVirtualMemory;
		this.pageQueue = pageQueue;
	}
	public Object[] SecondChance(Page page) {
		Object[] result = new Object[3];
		if (page.getR() == 0) {
			pageQueue.remove();
		}
		else {
			pageQueue.remove();
			pageQueue.add(page);
			page.setTime();
			page.setR(0);
			}
		 page.setAvailability(true);
	     result[0] = pageQueue;
         result[1] = tableVirtualMemory.getPagesRecords();
		return result;
	}

}
