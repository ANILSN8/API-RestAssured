package pojoclassforseralizationanddeserialization;

public class PojoClassArray {
	String ename;
	String eId;
	String eemail;
	int[] ephonenum;
	
	public PojoClassArray(String ename,String eId,String eemail,int[] ephonenum) {
		this.ename=ename;
		this.eId=eId;
		this.eemail=eemail;
		this.ephonenum=ephonenum;
		
	}
	public PojoClassArray() {
		
	}
	
	
	public String getemployname() {
		return ename;
	}
	
	public void setemployname(String ename) {
		this.ename=ename;
	}
	
	public String getemployId() {
		return eId;
	}
	public void setemployId(String eId) {
		this.eId=eId;
	}
	public String getemployemail() {
		return eemail;
	}
	public void setemployemail(String eemail) {
		this.eemail=eemail;
	}
	public int[] getemployphonenum() {
		return ephonenum;
	}
	public void setemployphonenum(int[] ephonenum) {
		this.ephonenum=ephonenum;
	}
}
