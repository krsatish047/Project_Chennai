package poll.admin;

import com.opensymphony.xwork2.ActionSupport;

public class AddPollAction extends ActionSupport{

	private String add;
	private String Question;
	private String OptionA;
	private String OptionB;
	private String OptionC;
	private String OptionD;
	private int quesNo;
	private static int newPollId;
	
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getOptionA() {
		return OptionA;
	}
	public void setOptionA(String optionA) {
		OptionA = optionA;
	}
	public String getOptionB() {
		return OptionB;
	}
	public void setOptionB(String optionB) {
		OptionB = optionB;
	}
	public String getOptionC() {
		return OptionC;
	}
	public void setOptionC(String optionC) {
		OptionC = optionC;
	}
	public String getOptionD() {
		return OptionD;
	}
	public void setOptionD(String optionD) {
		OptionD = optionD;
	}
	public String execute() {
		newPollId = DataAccess.getNoOfPolls();
		newPollId++;
		System.out.println("new poll id is " + newPollId );
		DataAccess.createTable("poll" + newPollId + "Questions", "poll" + newPollId + "Options");
		DataAccess.addPollingEntry(newPollId);
		
		
		
		
		return "success";
		
	}
		public String dummy() {
		return "success";
	}
	public String EvaluateSubmit() {
	
		if(add.equals("addQuestion")) {
			System.out.println("add");
			quesNo = DataAccess.addQuestion(Question,newPollId);
			DataAccess.addOption(OptionA,quesNo,newPollId);
			DataAccess.addOption(OptionB,quesNo,newPollId);
			DataAccess.addOption(OptionC,quesNo,newPollId);
			DataAccess.addOption(OptionD,quesNo,newPollId);
			return "added question";
			
		}
		else if(add.equals("completed")) {
			System.out.println("complete");
			return "completed";
		}
		else {
			System.out.println("out");
		}
		return null;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
}
