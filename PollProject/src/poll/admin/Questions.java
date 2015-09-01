package poll.admin;

import java.util.ArrayList;
import java.util.List;



public class Questions {
  String question;
  int qno;
  List<String> options =  new ArrayList<String>();
  
 
public List<String> getOptions() {
	return options;
}
public void setOptions(List<String> options) {
	this.options = options;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public int getQno() {
	return qno;
}
public void setQno(int qno) {
	this.qno = qno;
}



}
