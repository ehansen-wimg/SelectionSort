import BreezySwing.*;
import javax.swing.*;
import java.util.ArrayList;

public class AddDialog extends GBDialog {
	boolean tyes = false;
	boolean qyes = false; 
	
	int qcount = 0;
	int tcount = 0; 
	double[] t = new double[5];
	double[] q = new double[8];
	 
	ArrayList<StudentInfo> students;
	
	JLabel nameLabel = addLabel("Name:", 1,1,1,1);
	JLabel tscoreLabel = addLabel("Test Scores:", 1,2,1,1);
	JLabel qscoreLabel = addLabel("Quiz Scores:", 1,3,1,1);
	JLabel hscoreLabel = addLabel("Homework Average:", 1,4,1,1);
	JTextField nameField = addTextField("", 2,1,1,1);
	DoubleField tscoreField = addDoubleField(0, 2,2,1,1);
	DoubleField qscoreField = addDoubleField(0, 2,3,1,1);
	DoubleField hscoreField = addDoubleField(0, 2,4,1,1);
	JButton goButton = addButton("Enter Student", 3,1,1,1);
	JButton addTestScore = addButton("Enter Test Score", 3,2,1,1);
	JButton addQuizScore = addButton("Enter Quiz Score", 3,3,1,1);

	
	public AddDialog(JFrame parent, ArrayList<StudentInfo> s) {
		super(parent);
		goButton.setEnabled(false);
		students = s;
	}
	
	public void error(String e) {
		messageBox(e);
	}
	
	public void buttonClicked(JButton buttonObj) {
		
		if(buttonObj == goButton) {
			double[] t2 = new double[tcount];
			double[] q2 = new double[qcount];
			
			for(int i = 0; i < t2.length; i++) {
				t2[i] = t[i];
			}
			
			for(int i = 0; i < q2.length; i++) {
				q2[i] = q[i];
			}
			if(hscoreField.isValidNumber()) {
				
			StudentInfo st = new StudentInfo(nameField.getText(), t2, q2, hscoreField.getNumber());
			students.add(st);
			dispose();
			
			}
		} else if(buttonObj == addTestScore) {
			if(tscoreField.isValidNumber() && tcount < 5) {
				t[tcount] = tscoreField.getNumber();
				tcount++;
				tyes = true;
				if(qyes == true) {
					goButton.setEnabled(true);
				}
			} else {
				error("Please only enter 5 valid test scores.");
			}
		} else if(buttonObj == addQuizScore) {
			if(qscoreField.isValidNumber() && qcount < 8) {
				q[qcount] = qscoreField.getNumber();
				qcount++;
				qyes = true;
				if(tyes == true) {
					goButton.setEnabled(true);
				}
			} else {
				error("Please only enter 8 valid quiz scores.");
			}
		}
	}

}
