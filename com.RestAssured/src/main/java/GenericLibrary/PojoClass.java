package GenericLibrary;

public class PojoClass {
	
	String createdBy;
	String ProjectName;
	String Status;
	int teamsize;
	


	public PojoClass(String createdBy, String projectName, String status, int temsize) {
		
		this.createdBy = createdBy;
		this.ProjectName = projectName;
		this.Status = status;
		this.teamsize = temsize;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public String getProjectName() {
		return ProjectName;
	}



	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}



	public String getStatus() {
		return Status;
	}



	public void setStatus(String status) {
		Status = status;
	}



	public int getTemsize() {
		return teamsize;
	}



	public void setTemsize(int temsize) {
		this.teamsize = temsize;
	}
	
	

}
