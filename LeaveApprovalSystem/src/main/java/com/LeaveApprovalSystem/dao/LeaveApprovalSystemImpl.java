package com.LeaveApprovalSystem.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.LeaveApprovalSystem.models.Employee;
import com.LeaveApprovalSystem.models.LeaveApplication;
import com.LeaveApprovalSystem.util.LeaveApprovalSystemUtil;
import com.LeaveApprovalSystem.util.LeaveApproverUtil;

public class LeaveApprovalSystemImpl implements LeaveApprovalSystemDao {

	public boolean submit(LeaveApplication leaveApplication) {
	    boolean status = false;
	    SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
	    try {
	        session.insert("LeaveApplication.submit", leaveApplication);
	        session.commit();
	        status = true;
	        session.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    // TODO: handle exception
	    return status;
	}

	public List<LeaveApplication> getPendingApplications() {
		    List <LeaveApplication> pendingLeaveApplications = null;
		    SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
		    try {
		    	pendingLeaveApplications = session.selectList("LeaveApplication.getPendingApplications");
		        session.commit();
		        session.close();
	
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		return pendingLeaveApplications;
	}

	public List<LeaveApplication> getDeniedAndApprovedApplications() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<LeaveApplication> getByEmployeeId(int employeeId) {
	    List <LeaveApplication> employeeLeaveApplications = null;
	    SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
	    try {
	    	employeeLeaveApplications = session.selectList("LeaveApplication.getByEmployeeId", employeeId);
	        session.commit();
	        session.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return employeeLeaveApplications;
	}

	public boolean amend(LeaveApplication leaveApplication) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Employee> getEmployeeData(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getLoginDetails(String username, String password) {
		String[] logInDetails = new String[2];
		logInDetails[0] = "Patrick";
		logInDetails[1] = "Patrick@123";
		
		return logInDetails;
	}

	public int checkEmployeeId(int employeeId) {	    
	    int status = 0;
	    SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
	    try {
	    	status = session.selectOne("Employee.checkEmployeeId", employeeId);
	        session.commit();
	        session.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return status;
	}

	public List<LeaveApplication> getByApplicationId(int applicationId) {
	    List <LeaveApplication> employeeLeaveApplication = null;
	    SqlSession session = LeaveApprovalSystemUtil.getSqlSessionFactory().openSession();
	    try {
	    	employeeLeaveApplication = session.selectList("LeaveApplication.getByApplicationId", applicationId);
	        session.commit();
	        session.close();
	
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return employeeLeaveApplication;
	}

}
