import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

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
		sort(studentInfo, new StudentInfoNameComparator());
		return Arrays.asList(studentInfo); 
	}
	
	public List<StudentInfo> avgSort(){
		sort(studentInfo, new StudentInfoFinalAverageComparator());
		return Arrays.asList(studentInfo);
	}

	private StudentInfo[] sort(StudentInfo[] students, Comparator<StudentInfo> comparator) {
		
        int n = students.length;
        
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (comparator.compare(students[j], students[min_idx]) == -1 ? true : false) {
                	min_idx = j;
                }
            }
            // Swap the found minimum element with the first
            // element
            StudentInfo temp = students[min_idx];
            students[min_idx] = students[i];
            students[i] = temp;
        }
        return students;
	}
}
