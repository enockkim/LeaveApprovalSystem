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
    
    @RequestMapping("/leaveApproverLogin")
    public String leaveApproverLogin() {
    	return "redirect:leaveApproverLogin.jsp";
    }
	
    
	@RequestMapping("/login")
	public ModelAndView createEmployee(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String[] validationResponse = leaveApproverDao.validate(username, password);
		
		mv.setViewName(validationResponse[1]);
		mv.addObject("error", validationResponse[0]);
		
		return mv;
		//Username and password validation
//		if (username.equals("Patrick") && password.equals("Patrick@123")) {
//			
//	        mv.setViewName("leaveApprover.jsp");
//	        return mv;
////			return "redirect:/leaveApprover";
//		}else {
//			String error = "Incorrect username or password.";
//	        mv.setViewName("leaveApproverLogin.jsp");
//	        mv.addObject("error", error);
//
//	        return mv;
////			return "redirect:/leaveApproverLogin";			
//		}		
	}
	
}
