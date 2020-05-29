import java.util.LinkedList;

public class TableOfPages {

	private LinkedList<Page> pagesRecords;
	
	public TableOfPages() {
		pagesRecords = new LinkedList<Page>();
	}
	
	public LinkedList<Page> getPagesRecords(){
		return pagesRecords;
	}
	
	public int Size() {
		return pagesRecords.size();
	}
	
	public Page Get(int index) {
		return pagesRecords.get(index);
	}

	public void add(Page page) {
		pagesRecords.add(page);
	}

	public void setPagesRecords(LinkedList<Page> pagesRecords) {
		this.pagesRecords = pagesRecords;
	}
}