package poll.admin;

import com.opensymphony.xwork2.ActionSupport;


public class LoginValidateAction extends ActionSupport{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userid;
    private String password;
    private String userType;

    public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String execute() {
    String result=DataAccessAdmin.validateLogin(userid, password);
    	String process=null;
    	if (result==null){
    		process= "error";
    	}
    	else {
    		setUserType(result);
    		if (result.toLowerCase().equals("admin")){
    		process="successAdmin";
    		}
    		else if(result.toLowerCase().equals("pollmaster")){
    			process="successPollMaster";
    		}
    	}
    	return process;
    	
    }

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}

