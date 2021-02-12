<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="ISO-8859-1">
      <title>Leave Application</title>
      <link rel="stylesheet"
         href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
         integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
         crossorigin="anonymous">
      <link rel="stylesheet",href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.min.css">
      <script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
      <script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
      <script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
      <script type="text/javascript" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
   </head>
   <body>
      <div class="container">
         <a href="index"><button type="button" class="btn btn-info">Home</button></a>
         <br> <br>
         <form action="submit" method="post">
            <div class="form-group">
               <label for="employeeId">Employee ID: ${employeeId}</label>
            </div>
            <div class="form-group">
               <label for="leaveType">Leave Type</label>
               <input type="text" class="form-control" id="leaveType" name="leaveType" >
            </div>
            <div class="form-group">
               <label for="daysRequested">Days Requested</label>
               <input type="text" class="form-control" id="daysRequested" name="daysRequested" >
            </div>
            <div class="form-group">
               <label for="applicationDate">Application Date</label>
               <input type="text" class="form-control" id="applicationDate" name="applicationDate" >
            </div>
            <div class="form-group">
               <label for="startDate">Start Date</label>
               <input type="text" class="form-control" id="startDate" name="startDate" >
            </div>
            <div class="form-group">
               <label for="endDate">End Date</label>
               <input type="text" class="form-control" id="endDate" name="endDate" >
            </div>
            <button type="submit" class="btn btn-outline-success">Submit</button>
         </form>
      </div>
   </body>
</html>