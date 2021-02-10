package com.LeaveApprovalSystem.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.LeaveApprovalSystem.models.Employee;
import com.LeaveApprovalSystem.models.LeaveApplication;
import com.LeaveApprovalSystem.util.EmployeeUtil;
import com.LeaveApprovalSystem.util.LeaveApproverUtil;

public class LeaveApprovalSystemImpl implements LeaveApprovalSystemDao {

	public boolean submit(LeaveApplication leaveApplication) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<LeaveApplication> getPendingApplications() {
		    List <LeaveApplication> pendingLeaveApplications = null;
		    SqlSession session = LeaveApproverUtil.getSqlSessionFactory().openSession();
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
		// TODO Auto-generated method stub
		return null;
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
		String[] validationResponse = new String[2];
		try {
			if (username.equals("Patrick") && password.equals("Patrick@123")) {				
				validationResponse[0] = null;
				validationResponse[1] = "leaveApprover.jsp";
//			return "redirect:/leaveApprover";
			}else {
				validationResponse[0] = "Incorrect username or password.";
				validationResponse[1] = "leaveApproverLogin.jsp";
//			return "redirect:/leaveApproverLogin";			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return validationResponse;
	}

}
