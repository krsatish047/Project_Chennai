package poll.admin;

import java.util.ArrayList;
import java.util.List;

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
				process = checkStatus(userBean.getUid());
				
			}
		}
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
		if(DataAccess.isPollMasterActive(id)) {
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
	public String getActiveQues(){
		setQuesBean(DataAccessAdmin.activeQuestion());
		return "success";
		
}
	
}
