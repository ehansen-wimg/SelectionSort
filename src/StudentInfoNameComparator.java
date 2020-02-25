import java.util.Comparator;

public class StudentInfoNameComparator implements Comparator<StudentInfo> {
	public StudentInfoNameComparator() {
		
	}
	
	@Override
	public int compare(StudentInfo s1, StudentInfo s2) {
		return s1.getName().compareToIgnoreCase(s2.getName());
	}
}
