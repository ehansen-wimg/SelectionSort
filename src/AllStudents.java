import java.util.List;
import java.util.Arrays;

public class AllStudents {
	
	StudentInfo[] studentInfo = null;
	
	public AllStudents() {
		
	}
	
	public StudentInfo[] getStudentInfo() {
		if(studentInfo == null) {
			return new StudentInfo[0];
		}
		return this.studentInfo;
	}
	
	public void setStudentInfo(StudentInfo[] studentData) throws AllStudentsException {
		int maxLength = studentData.length;
		if(maxLength > 15) {
			throw new AllStudentsException("Received more than the max of 15 student records!");
		}
		int firstEmptyIndex = 0;
		while(firstEmptyIndex < maxLength) {
			if(studentData[firstEmptyIndex] == null) {
				// found the first empty slot...assume rest are empty as well
				break;
			} else {
				firstEmptyIndex++;
			}
		}
		// either we found the first empty slot or we've touched the entire studentData array
		studentInfo = new StudentInfo[firstEmptyIndex + 1];
		System.arraycopy(studentData, 0, studentInfo, 0, studentInfo.length);
	}
	
	public void clearStudentInfo() {
		studentInfo = null;
	}
	
	public int getStudentCount() {
		if(studentInfo == null) {
			return 0;
		}
		return studentInfo.length;
	}
	
	public List<StudentInfo> alphSort(){
		Arrays.sort(studentInfo, new StudentInfoNameComparator());
		return Arrays.asList(studentInfo); 
	}
	
	public List<StudentInfo> avgSort(){
		Arrays.sort(studentInfo, new StudentInfoFinalAverageComparator());
		return Arrays.asList(studentInfo);
	}

}
