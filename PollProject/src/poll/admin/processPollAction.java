package poll.admin;

public class processPollAction {

	int pollId;
	int pollMaster;
	public String execute() {
		DataAccess.updatePollMaster(pollId,pollMaster);
		DataAccess.activatePoll(pollMaster,pollId);
		return "poll activated";
	}
	public int getPollId() {
		return pollId;
	}
	public void setPollId(int pollId) {
		this.pollId = pollId;
	}
	public int getPollMaster() {
		return pollMaster;
	}
	public void setPollMaster(int pollMaster) {
		this.pollMaster = pollMaster;
	}
}
