public class Stream {

	private int maxTimeOfStream;
	private String streamId;
	private int prioritetOfSteram;
	private String procId;

	public Stream(String streamId, int maxTimeOfStream, String procId) {
		this.streamId = streamId;
		this.procId = procId;
		this.maxTimeOfStream = maxTimeOfStream;
		this.prioritetOfSteram = prioritetOfSteram;
	}

	public int getPrioritet() {
		return prioritetOfSteram;
	}

	public String getStreamId() {
		return streamId;
	}

	public String getProcId() {
		return procId;
	}

	public int getMaxTimeOfStream() {
		return maxTimeOfStream;
	}

	public boolean isTime() {
		if (maxTimeOfStream <= 0) {
			return false;
		}
		return true;
	}

	public void timeReduction() {
		maxTimeOfStream--;
	}

}
