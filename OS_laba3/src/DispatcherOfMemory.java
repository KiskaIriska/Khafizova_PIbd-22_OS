import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class DispatcherOfMemory {
	private TableOfPages tableVirtualMemory;
	private int tableRealMemory;
	private Queue<Page> pageQueue;
	private int maxFrames;
	Random randomBits = new Random ();
	
	public DispatcherOfMemory(int RAM, int sizePage) {
		tableVirtualMemory = new TableOfPages();
		tableRealMemory = RAM;
		pageQueue = new PriorityQueue<Page>();
		maxFrames = RAM / sizePage;
		for (int i = 0; i < RAM*2; i++) {
			Page page = new Page(randomBits.nextInt()+1, false, i);
			tableVirtualMemory.add(page);
		}
	}
	public void insert(int pageIndex) {
		Object[] resultObjects;
    	Algorithm algorithm = new Algorithm(tableVirtualMemory, pageQueue);
    	Page page = tableVirtualMemory.Get(pageIndex);
    	 if(!page.getAvailability()){
    		 if(pageQueue.size() < maxFrames){
    			 page.setAvailability(true);
    			 pageQueue.add(page);
    		 }
    		 else if(pageQueue.size() == maxFrames) {
    			 resultObjects = algorithm.SecondChance(page);
    			 pageQueue = (Queue<Page>) resultObjects[0];
    			 tableVirtualMemory.setPagesRecords((LinkedList<Page>) resultObjects[1]);
    		 }
    	 }
	}
	public int getVirtualMemorySize(){
        return tableVirtualMemory.Size();
    }
}
