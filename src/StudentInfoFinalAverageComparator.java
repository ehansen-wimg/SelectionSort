import java.util.Comparator;

public class StudentInfoFinalAverageComparator implements Comparator<StudentInfo> {
	
	public StudentInfoFinalAverageComparator() {
		
	}
	
	@Override
	public int compare(StudentInfo s1, StudentInfo s2) {
		if(s1.getTotalAvg() < s2.getTotalAvg()) {
			return -1;
		}
		
		if(s1.getTotalAvg() > s2.getTotalAvg()) {
			return 1;
		}
		
		// must be equal!
		return 0;
	}
}
