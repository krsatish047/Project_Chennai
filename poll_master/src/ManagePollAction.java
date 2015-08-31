package mystructs.demo;

import java.util.List;
import java.util.Arrays;

import com.opensymphony.xwork2.ActionSupport;

public class ManagePollAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<String> pollMaster;
	private List<Integer> pollId;
	

		public ManagePollAction() {
			pollMaster = DataAccess.getPollMasters();
			pollId = DataAccess.getPollIds();
	
	}

	@Override
	public String execute() {
		
		return SUCCESS;
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
