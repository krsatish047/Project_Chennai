package poll.admin;

import java.util.List;
import java.util.Arrays;

import com.opensymphony.xwork2.ActionSupport;

public class ManagePollAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<String> pollMaster;
	private List<Integer> pollId;
	private List<Integer> activePolls;
	private Integer selectedPoll;

		public Integer getSelectedPoll() {
		return selectedPoll;
	}

	public void setSelectedPoll(Integer selectedPoll) {
		this.selectedPoll = selectedPoll;
	}

		public ManagePollAction() {
			pollMaster = DataAccess.getPollMasters();
			pollId = DataAccess.getPollIds();
			
	
	}
	
	@Override
	public String execute() {
		
		return SUCCESS;
	}
	public String activatePolls(){
		
		setActivePolls(DataAccess.activePolls());
		
		return "success";
	}
	
  public String activateThePoll(){
	  
	  DataAccess.activatePoll(selectedPoll);
	  return "pollActivated";
  }
	public List<Integer> getActivePolls() {
		return activePolls;
	}

	public void setActivePolls(List<Integer> activePolls) {
		this.activePolls = activePolls;
	}

	public List<String> getPollMaster() {
		return pollMaster;
	}

	public void setPollMaster(List<String> pollMaster) {
		this.pollMaster = pollMaster;
	}

	public List<Integer> getPollId() {
		return pollId;
	}

	public void setPollId(List<Integer> pollId) {
		this.pollId = pollId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
