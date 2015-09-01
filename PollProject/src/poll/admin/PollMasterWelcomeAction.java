package poll.admin;

import java.util.ArrayList;
import java.util.List;

public class PollMasterWelcomeAction {
	
	List<Questions> q=new ArrayList<Questions>();
	//trial!
	private int userId=1;
	
	public List<Questions> getQ() {
		return q;
	}
	public void setQ(List<Questions> q) {
		this.q = q;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String execute() {
		
		
		
		if(DataAccess.isPollMasterActive(userId)) {
			System.out.println("Hello");
			q=DataAccess.getQuestions();
			for(Questions qu : q) {
				System.out.println("q values in java class" + qu.question + qu.qno);
				for(String s : qu.options) {
					System.out.println(s);
				}
			}
			System.out.println("after data action");
			return "active";
		}
		else {
			System.out.println("Fail!");
			return "passive";
		}
			
	}

}
