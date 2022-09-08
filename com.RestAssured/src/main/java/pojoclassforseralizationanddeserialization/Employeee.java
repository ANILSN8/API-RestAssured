package pojoclassforseralizationanddeserialization;

public class Employeee {
	String sname;
	String s1234;
	Object spouse;
	public Employeee(String sname, String s1234, Object spouse) {
		super();
		this.sname = sname;
		this.s1234 = s1234;
		this.spouse = spouse;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getS1234() {
		return s1234;
	}
	public void setS1234(String s1234) {
		this.s1234 = s1234;
	}
	public Object getSpouse() {
		return spouse;
	}
	public void setSpouse(Object spouse) {
		this.spouse = spouse;
	}
	
	

}
