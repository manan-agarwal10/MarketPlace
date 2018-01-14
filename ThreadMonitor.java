package MarketPlace;

class ThreadMonitor {
	private String runningThread;

	public ThreadMonitor(String runningThread) {
		this.runningThread = runningThread;
	}

	public String getRunningThread() {
		return runningThread;
	}

	public void setRunningThread(String threadName) {
		runningThread = threadName;
	}
}