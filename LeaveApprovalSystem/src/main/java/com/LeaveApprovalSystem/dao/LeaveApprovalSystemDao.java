package com.LeaveApprovalSystem.dao;

import java.util.List;

import com.LeaveApprovalSystem.models.Employee;
import com.LeaveApprovalSystem.models.LeaveApplication;

public interface LeaveApprovalSystemDao {
	
	//Submit leave application
	public boolean submit(LeaveApplication leaveApplication);

	//Get pending leave applications
	public List<LeaveApplication> getPendingApplications();
	
	//Get denied and approved leave applications
	public List<LeaveApplication> getDeniedAndApprovedApplications();
	
	//Get leave applications according to Employee ID
	public List<LeaveApplication> getByEmployeeId(int employeeId);
	
	//Check existence of employee
	public int checkEmployeeId(int employeeId);
	
	//Amend leave application
	public boolean amend(LeaveApplication leaveApplication);
	
	//Get employee details by Employee ID to auto fill leave application form
	public List<Employee> getEmployeeData(int employeeId);
	
	//Get username and password of leave approver
	public String[] getLoginDetails(String username, String password);
	
	//Get application by application ID
	public List<LeaveApplication> getByApplicationId(int applicationId);
}
