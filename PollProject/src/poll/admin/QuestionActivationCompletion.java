package poll.admin;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class QuestionActivationCompletion {
private String add;
private int qno;
public String execute() {

	System.out.println("hi");
	if(add.equals("Publish")) {
	
		System.out.println(qno);
		HttpSession sessb = ServletActionContext.getRequest().getSession();
		int pollId = (Integer)sessb.getAttribute("loggedInUid");
		DataAccessNew.updateActiveQuestion(pollId,qno);
		return "publish";
	}
	else if(add.equals("Return")) {
		return "return";
	}
	return "default";
	
}
public String getAdd() {
	return add;
}
public void setAdd(String add) {
	this.add = add;
}
public int getQno() {
	return qno;
}
public void setQno(int qno) {
	this.qno = qno;
}
}
