import BreezySwing.*;
import javax.swing.*;
import java.util.ArrayList;

public class GUI extends GBFrame {

	int index = 0;
	
	JTextArea outputArea = addTextArea("", 1,2,1,1);
	JButton newButton = addButton("New Student", 2,1,1,1);
	JButton printButton = addButton("Print Students", 2,2,1,1);
	
	ArrayList<StudentInfo> s = new ArrayList<StudentInfo>();
	
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == newButton) {
			if(index < 15) {
				AddDialog add = new AddDialog(this, s); 
				add.setVisible(true);
				index++;
			} else {
				error("Maximum student entries reached!");
			}
		} else if (buttonObj == printButton) {
			
		}
	}
	
	public void error(String e) {
		messageBox(e);
	}
	
	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.setVisible(true);
		gui.setSize(500, 500);
		gui.setTitle("Selection Sort Program");
	}
	
}
