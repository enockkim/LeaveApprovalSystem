<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
   <head>
      <title>Employee - Home</title>
      <link rel="stylesheet"
         href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
         integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
         crossorigin="anonymous">
   </head>
   <body>
      <div class="container">
      <a href="apply"><button type="button" class="btn btn-info">Apply for Leave</button></a>
      <h1>Leave Applications</h1>
         <table class="table table-striped table-bordered">
            <caption>Above are summaries of each leave application. Click download to download the leave application.</caption>
            <thead>
               <tr>
                  <th scope="col">Application ID</th>
                  <th scope="col">Employee ID</th>
                  <th scope="col">Leave Type</th>
                  <th scope="col">Days Requested</th>
                  <th scope="col">Application</th>
                  <th scope="col">Start Date</th>
                  <th scope="col">End Date</th>
                  <th scope="col">Remarks</th>
                  <th scope="col">Status</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${employeeLeaveApplications}" var="LeaveApplication">
                  <tr>
                     <td>
                        <c:out value="${LeaveApplication.applicationId}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.employeeId}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.leaveType}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.daysRequested}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.applicationDate}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.startDate}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.endDate}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.remarks}" />
                     </td>
                     <td>
                        <c:out value="${LeaveApplication.applicationStatus}" />
                     </td>
                     <td><a href="downloadLeaveApplication?applicationId=${LeaveApplication.applicationId}"><button
                        class="btn btn-outline-danger" type="button">Download</button></a></td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>
   </body>
</html>