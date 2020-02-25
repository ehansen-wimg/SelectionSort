import java.util.Comparator;

public class StudentInfo {

	String name;
	double[] tests;
	double[] quizzes;
	double hw;
	
	public StudentInfo() {
		
	}
	
	public StudentInfo(String n, double[] t, double[] q, double h) {
		name = n;
		tests = t;
		quizzes = q;
		hw = h;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getQuizAvg() {
		double avg = 0;
		for(int i = 0; i < quizzes.length; i++) {
			avg = avg + quizzes[i];
		}
		
		avg = avg/quizzes.length;
		return avg;
	}
	
	public double getTestAvg() {
		double avg = 0;
		for(int i = 0; i < tests.length; i++) {
			avg = avg + tests[i];
		}
		
		avg = avg/tests.length;
		return avg;
	}
	
	public double getTotalAvg() {
		double avg = ((0.5 * getTestAvg()) + (0.3 * getQuizAvg()) + (0.2*hw));
		return avg; 
	}
	
	public String print() {
		String printable = (name + getTotalAvg());
		return printable;
	}
}
