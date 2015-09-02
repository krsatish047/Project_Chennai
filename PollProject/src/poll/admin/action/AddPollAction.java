package poll.admin.action;

import java.util.ArrayList;
import java.util.List;

import poll.admin.DataAccess;

import com.opensymphony.xwork2.ActionSupport;

public class AddPollAction extends ActionSupport {

	private String add;
	private String Question;
	List<String> options = new ArrayList<String>();
	static int i = 0;
	static List<MyEntities> myEntities = new ArrayList<MyEntities>();
	private String opAdd;
//	List<String> optionAddList = new ArrayList<String>();

	// private String optionAdd[]=new String[100] ;

	public int getI() {
		return i;
	}

//	public List<String> getOptionAddList() {
//		return optionAddList;
//	}
//
//	public void setOptionAddList(List<String> optionAddList) {
//		this.optionAddList = optionAddList;
//	}

	public void setI(int i) {
		AddPollAction.i = i;
	}

	public String getOpAdd() {
		return opAdd;
	}

	public void setOpAdd(String opAdd) {
		this.opAdd = opAdd;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public List<MyEntities> getMyEntities() {
		return myEntities;
	}

	public void setMyEntities(List<MyEntities> myEntities) {
		AddPollAction.myEntities = myEntities;
	}

	public int getQuesNo() {
		return quesNo;
	}

	public void setQuesNo(int quesNo) {
		this.quesNo = quesNo;
	}

	public static int getNewPollId() {
		return newPollId;
	}

	public static void setNewPollId(int newPollId) {
		AddPollAction.newPollId = newPollId;
	}

	private int quesNo;
	private static int newPollId;

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String execute() {
		newPollId = DataAccess.getNoOfPolls();
		newPollId++;
		System.out.println("new poll id is " + newPollId);
		DataAccess.createTable("poll" + newPollId + "Questions", "poll"
				+ newPollId + "Options");
		DataAccess.addPollingEntry(newPollId);

		return "success";

	}

	public String dummy() {
		return "success";
	}

	public String EvaluateSubmit() {

		if (add.equals("addQuestion")) {
			//myEntities.get(i-1).value=options.get(i-1);
			System.out.println("add");
			quesNo = DataAccess.addQuestion(Question, newPollId);
//			for (MyEntities me : myEntities) {
//				options.add(me.value);
//			}
			for (String op : options)
				DataAccess.addOption(op, quesNo, newPollId);
			myEntities.clear();
			Question="";
			//JFrame frame= new JFrame();
			//JOptionPane.showMessageDialog(frame, "Question added successfully!");
//			ConfirmDialog.confirmDialog("Question added successfully!","title");
			return "added question";

		} else if (add.equals("completed")) {
			System.out.println("complete");
			return "completed";
		}
		
		else if (add.equals("addOption")) {
			//Question.value=Question;
			
			//System.out.println(optionAddList);
			if(i==1) {
				myEntities.get(0).value=options.get(0);
			}
			else if(i>1){
				myEntities.get(i-1).value=options.get(i-1);
			}

			MyEntities m = new MyEntities();

			m.id = i++;

			myEntities.add(m);

			return "added option";
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
	
	public String confirm(){
		if (add.equals("nextQuestion")) {
			return "addQuestion";
		}
		else if(add.equals("complete")) {
			return "complete";
		}
		return null;
		
	}
}
