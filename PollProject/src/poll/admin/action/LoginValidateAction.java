package poll.admin.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import poll.admin.ActiveQuestion;
import poll.admin.DataAccess;
import poll.admin.DataAccessAdmin;
import poll.admin.Questions;
import poll.admin.Users;

import com.opensymphony.xwork2.ActionSupport;

public class LoginValidateAction extends ActionSupport {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	/*
	 * private String userid; private String password; private String userType;
	 */
	List<Questions> q=new ArrayList<Questions>();
	private int activePollId;
	
	public int getActivePollId() {
		return activePollId;
	}

	public void setActivePollId(int activePollId) {
		this.activePollId = activePollId;
	}

	public List<Questions> getQ() {
		return q;
	}

	public void setQ(List<Questions> q) {
		this.q = q;
	}

	private Users userBean;
	private ActiveQuestion quesBean;

	public ActiveQuestion getQuesBean() {
		return quesBean;
	}

	public void setQuesBean(ActiveQuestion quesBean) {
		this.quesBean = quesBean;
	}

	public Users getUserBean() {
		return userBean;
	}

	public void setUserBean(Users userBean) {
		this.userBean = userBean;
	}

	private ArrayList<Users> UserList;

	/*
	 * public String getUserType() { return userType; }
	 * 
	 * public void setUserType(String userType) { this.userType = userType; }
	 */

	public String execute() {

		//How to use session variables in a controller
		HttpSession sess = ServletActionContext.getRequest().getSession();
		//Set
		sess.setAttribute("demo", "Hello");
		//In a different Action
		HttpSession sessb = ServletActionContext.getRequest().getSession();
		String usevar = (String)sessb.getAttribute("demo");
		String result = DataAccessAdmin.validateLogin(userBean.getUid(),
				userBean.getPwd());
		String process = null;
		if (result == null) {
			process = "error";
		} else {
			userBean.setUtype(result);
			if (result.toLowerCase().equals("admin")) {
				
				process = "successAdmin";
			} else if (result.toLowerCase().equals("pollmaster")) {
				 
				sess.setAttribute("loggedInUid", userBean.getUid());
				
				process = checkStatus(userBean.getUid());
				
				if(process.equals("active")) {
					
					setQ(DataAccess.getQuestions());
					HttpSession sess3 = ServletActionContext.getRequest().getSession();
					sess3.setAttribute("quesList", q);
					
				}
				
			}
		}
		return process;

	}
	public String ReCheckStatus(){
		HttpSession sessb = ServletActionContext.getRequest().getSession();
		int loggedInUid= (Integer)sessb.getAttribute("loggedInUid");
		
		String process= checkStatus(loggedInUid);
		return process;
	}
	public String createUser() {

		setUserBean(DataAccessAdmin.createUser(userBean.getUtype()));
		if (userBean != null) {
			return "UserCreated";

		} else
			return "error";
	}

	public String getUsers() {
		UserList = DataAccessAdmin.getAllUsers();
		return "listpopulated";
	}

	public ArrayList<Users> getUserList() {
		return UserList;
	}

	public void setUserList(ArrayList<Users> userList) {
		UserList = userList;
	}

	public  String checkStatus(int id){
		setActivePollId(DataAccess.isPollMasterActive(id));
		if(activePollId != 0) {
			/*System.out.println("Hello");
			q=DataAccess.getQuestions();
			for(Questions qu : q) {
				System.out.println("q values in java class" + qu.question + qu.qno);
				for(String s : qu.options) {
					System.out.println(s);
				}
			}
			System.out.println("after data action"); */
			return "active";
		}
		else {
			System.out.println("Fail!");
			return "passive";
		}
	}
	public String getActiveQues(){
		setQuesBean(DataAccessAdmin.activeQuestion());
		return "success";
		
}

	
	
}
