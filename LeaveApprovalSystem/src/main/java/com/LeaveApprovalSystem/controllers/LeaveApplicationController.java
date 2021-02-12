package com.LeaveApprovalSystem.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.LeaveApprovalSystem.dao.LeaveApprovalSystemDao;
import com.LeaveApprovalSystem.models.Employee;
//import com.LeaveApprovalSystem.models.Employee;
import com.LeaveApprovalSystem.models.LeaveApplication;

@Controller
public class LeaveApplicationController {
	
	@Autowired
	LeaveApprovalSystemDao leaveApproverDao;
	
    private ModelAndView mv = new ModelAndView();

    //Maps "/leaveApprover" url and gets applications that are pending displaying them on a table in the view
    @RequestMapping("/leaveApprover")
    public ModelAndView getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List <LeaveApplication> pendingLeaveApplications = leaveApproverDao.getPendingApplications();
        mv.setViewName("leaveApprover.jsp");
        mv.addObject("pendingLeaveApplications", pendingLeaveApplications);

        return mv;
    }
    
    //Get leave application details for approver to view and deny/approve
    @RequestMapping("/viewApplicationDetails")
    public ModelAndView getByApplicationId(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	int applicationId = Integer.parseInt(request.getParameter("applicationId"));
        List <LeaveApplication> leaveApplicationDetails = leaveApproverDao.getByApplicationId(applicationId);
        mv.setViewName("viewApplicationDetails.jsp");
        mv.addObject("leaveApplicationDetails", leaveApplicationDetails);

        return mv;
    }
    
    @RequestMapping("/employeeHome")
    public ModelAndView getByEmployeeId(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	int employeeId = Integer.parseInt(request.getParameter("employeeId"));
    	System.out.println(employeeId);
        List <LeaveApplication> employeeLeaveApplications = leaveApproverDao.getByEmployeeId(employeeId);
        mv.setViewName("employeeHome.jsp");
        mv.addObject("employeeLeaveApplications", employeeLeaveApplications);

        return mv;
    }
    
    @RequestMapping("/leaveApproverLogin")
    public String leaveApproverLogin() {
    	return "redirect:leaveApproverLogin.jsp";
    }

    @RequestMapping("/employeeLogin")
    public String employeeLogin() {
    	return "redirect:employeeIdCheck.jsp";
    }
    
	@RequestMapping("/login")
	public ModelAndView createEmployee(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String[] logInDetails = leaveApproverDao.getLoginDetails(username, password);
		
//		return mv;
		//Username and password validation
		if (username.equals(logInDetails[0]) && password.equals(logInDetails[1])) {			
	        mv.setViewName("/leaveApprover");
//			return "redirect:/leaveApprover";
		}else {
			String error = "Incorrect username or password.";
	        mv.setViewName("leaveApproverLogin.jsp");
	        mv.addObject("error", error);
//			return "redirect:/leaveApproverLogin";			
		}
		return mv;
	}
	
	@RequestMapping("/apply")
	public ModelAndView openLeaveApplication(HttpServletRequest request, HttpServletResponse response) {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		mv.setViewName("leaveApplication.jsp");
		mv.addObject("employeeId", employeeId);
		
		return mv;
	}
	
	@RequestMapping("/submit")
	public ModelAndView submitLeaveApplication(HttpServletRequest request, HttpServletResponse response) {
//	    int applicationId;
	    int employeeId = Integer.parseInt(request.getParameter("employeeId"));
	    String leaveType = request.getParameter("leaveType");
	    int daysRequested = Integer.parseInt(request.getParameter("daysRequested"));
	    String applicationDate = request.getParameter("applicationDate");
	    String startDate = request.getParameter("startDate");
	    String endDate = request.getParameter("endDate");
//	    String remarks;
//	    String applicationStatus;
	    
	    boolean status = false;
	    List <LeaveApplication> leaveApplication = null;
	
	    status = leaveApproverDao.submit(new LeaveApplication(employeeId, leaveType, daysRequested, applicationDate, startDate, endDate));
	    if (status == true) {
//	    	leaveApplication = leaveApproverDao.getAll();
	        mv.setViewName("index.jsp");
	        mv.addObject("leaveApplication", leaveApplication);
	        System.out.println("success");
	    } else {
//	    	leaveApplication = leaveApproverDao.getAll();
	        mv.setViewName("index.jsp");
	        mv.addObject("leaveApplication", leaveApplication);
	        System.out.println("fail");
	    }
	    return mv;
	}
	
	@RequestMapping("/employeeIdCheck")
	public ModelAndView employeeIdCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        int status = leaveApproverDao.checkEmployeeId(employeeId);

        System.out.println(status);
        if (status == 1) {
        	mv.setViewName("/employeeHome");
        	mv.addObject("employeeId",employeeId);
        	System.out.println("valid employeeId");
        }else {
            String error = "The employee ID entered does not exist";
        	mv.setViewName("employeeIdCheck.jsp");
        	mv.addObject("error",error);
        	System.out.println("invalid employeeId");
        }
        
//        mv.addObject("pendingLeaveApplications", pendingLeaveApplications);

        return mv;
	}
}
