package mystructs.demo;

public class PollMasterWelcomeAction {
	
	private int userId;
	public String execute() {
		if(DataAccess.isPollMasterActive(userId)) {
			return "active";
		}
		else {
			return "passive";
		}
			
				
	}

}
