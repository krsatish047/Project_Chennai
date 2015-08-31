package mystructs.demo;

public class processPollAction {

	int pollId;
	String pollMaster;
	public String execute() {
		DataAccess.updatePollMaster(pollId,pollMaster);
		DataAccess.activatePoll(pollMaster);
		return "poll activated";
	}
	public int getPollId() {
		return pollId;
	}
	public void setPollId(int pollId) {
		this.pollId = pollId;
	}
	public String getPollMaster() {
		return pollMaster;
	}
	public void setPollMaster(String pollMaster) {
		this.pollMaster = pollMaster;
	}
}
