import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students==null)
			throw new IllegalArgumentException();
		else
			this.students=students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(students!=null) {
		if(index<0||index>students.length) {
			throw new IllegalArgumentException();
		}
		return students[index];}
		else
			throw new IllegalArgumentException();
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(student==null||index<0||index>students.length) {
				throw new IllegalArgumentException();
				}
		else
		{
			students[index]=student;
		}
		}
	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student==null) {
			throw new IllegalArgumentException();
			}
		else
		{
			Student[] extralist=new Student[students.length+1];
				extralist[0]=student;
			for(int i=1;i<extralist.length;i++)
			{
				extralist[i]=students[i-1];
			}
			students=extralist;
		}
	}
	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student==null) {
			throw new IllegalArgumentException();
			}
		else
		{
			Student[] extralist=new Student[students.length+1];
				
			for(int i=0;i<extralist.length;i++)
			{
				extralist[i]=students[i];
			}
			extralist[students.length+1]=student;
			students=extralist;
		}
		
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(student==null||index<0||index>students.length) {
			throw new IllegalArgumentException();
			}
		else {
		Student[] extralist=new Student[students.length+1];
		for(int i=0;i<index;i++)
		{
			extralist[i]=students[i];
		}
		extralist[index]=student;
		for(int i=index+1;i<extralist.length;i++)
		{
			extralist[i]=students[i-1];
		}
		students=extralist;
	}
	}
	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index<0||index>students.length) {
			throw new IllegalArgumentException();
			}
		
		Student[] extralist=new Student[students.length-1];
		for(int i=0;i<index;i++)
		{
			extralist[i]=students[i];
		}
		for(int i=index;i<extralist.length;i++)
		{
			extralist[i]=students[i+1];
		}
		students=extralist;
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student==null) {
			throw new IllegalArgumentException();
			}
		Student[] extralist=new Student[students.length-1];
		int index=0;
		for(int i=0;i<students.length;i++)
		{
			if(students[index].compareTo(student)==0)
			{remove(i);
			return;
			}
		}
		throw new IllegalArgumentException("student does not exist");
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index<0||index>students.length) {
			throw new IllegalArgumentException();
			}
		Student[] extralist=new Student[index];
		for(int i=0;i<=index;i++)
		{
			extralist[i]=students[i];
		}
		students=extralist;
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(student==null) {
			throw new IllegalArgumentException();
			}
		int index=0;
		for(int i=0;i<students.length;i++)
		{
			if(students[i].compareTo(student)==0)
				index=i;
				break;
		}
		Student[] extralist=new Student[index+1];
		for(int i=0;i<extralist.length;i++)
		{
				extralist[i]=students[i];
		}
		students=extralist;	
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index<0||index>students.length) {
			throw new IllegalArgumentException();
			}
		Student[] extralist=new Student[students.length-(index+1)];
		for(int i=0;i<extralist.length;i++)
		{
				extralist[i]=students[i+index+1];
		}
		students=extralist;
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student==null) {
			throw new IllegalArgumentException();
			}
		int index=0;
		for(int i=0;i<students.length;i++)
		{
			if(students[index].compareTo(student)==0)
			{index=i;
			break;
			}
		}
		Student[] extralist=new Student[students.length-(index+1)];
		for(int i=0;i<extralist.length;i++)
		{
				extralist[i]=students[i+index+1];
		}
		students=extralist;
		
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		Student temp;
		for(int i=0;i<students.length;i++) {
			for(int j=0;j<students.length-i;j++) {
				if(students[j-1].compareTo(students[j])==1)
				{
					temp=students[j-1];
					students[j-1]=students[j];
					students[j]=temp;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if(date==null)
			throw new IllegalArgumentException();
		int index=0;
		for(int i=0;i<students.length;i++)
		{
			if(students[i].getBirthDate().before(date)||students[i].getBirthDate().compareTo(date)==0)
			{
				index++;
			}
		}
		Student[] extralist=new Student[index+1];
		int j=0;
		for(int i=0;i<extralist.length;i++)
		{
			if(students[i].getBirthDate().before(date)||students[i].getBirthDate().compareTo(date)==0)
			{
				extralist[j++]=students[i];
			}
		}
		return extralist;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		if(firstDate==null||lastDate==null)
			throw new IllegalArgumentException();
		int index=0;
		for(int i=0;i<students.length;i++)
		{
			if((students[i].getBirthDate().after(firstDate)||students[i].getBirthDate().compareTo(firstDate)==0)&&(students[i].getBirthDate().before(lastDate)||students[i].getBirthDate().compareTo(lastDate)==0))
			{
				index++;
			}
		}
		Student[] extralist=new Student[index+1];
		int j=0;
		for(int i=0;i<students.length;i++)
		{
			if((students[i].getBirthDate().after(firstDate)||students[i].getBirthDate().compareTo(firstDate)==0)&&(students[i].getBirthDate().before(lastDate)||students[i].getBirthDate().compareTo(lastDate)==0))
			{
				extralist[j++]=students[i];
			}
		}
		return extralist;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {

		if(date==null)
			throw new IllegalArgumentException();
		
		Date d1=new Date(date.getDate()+days);
		//	Date d2=new Date(date.getDate()-days);
			int c=0,c1=0;
			if(date==null)
				throw new IllegalArgumentException();
			for(int i=0;i<students.length;i++){
				if(students[i].getBirthDate()==date || students[i].getBirthDate()==d1 ){
					c++;
				}
			}
			Student[] s =  new Student[c];
			for(int i=0;i<students.length;i++){
				if(students[i].getBirthDate()==date || students[i].getBirthDate()==d1 ){
					s[c1]=students[i];
					c1++;
				}
			}
			return s;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		int count=0;
		double maximum=students[0].getAvgMark();
		for(int i=0;i<students.length;i++)
		{
			if(students[i].getAvgMark()>maximum)
				maximum=students[i].getAvgMark();
		}
		for(int i=0;i<students.length;i++)
		{
			if(students[i].getAvgMark()==maximum)
				count++;
		}
		
		for(int i=0;i<students.length;i++)
		{
			if(students[i].getAvgMark()==maximum)
				count++;
		}
		Student[] s=new Student[count];
		count=0;
		for(int i=0;i<students.length;i++)
		{
			s[count]=students[i];
			count++;
		}
		return s;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
