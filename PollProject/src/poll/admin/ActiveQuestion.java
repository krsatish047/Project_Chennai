package poll.admin;

import java.util.HashMap;

public class ActiveQuestion {
	private int pollId;
	private int qno;
	private String question;
	private HashMap<Character, String> hmapOptions;
	
	
	
	public int getPollId() {
		return pollId;
	}
	public void setPollId(int pollId) {
		this.pollId = pollId;
	}
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public HashMap getHmapOptions() {
		return hmapOptions;
	}
	public void setHmapOptions(HashMap hmapOptions) {
		this.hmapOptions = hmapOptions;
	}


}
