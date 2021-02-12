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
         <a href="employeeIdCheck"><button type="button" class="btn btn-info">Home</button></a>
         <br> <br>
         <h3>Enter your Employee ID</h3>
         <h3 style="color:red;">${error}</h3>
         <form action="employeeIdCheck" method="post">
            <div class="form-group">
               <label for="employeeId">Employee ID</label>
               <input type="text" class="form-control" id="employeeId" name="employeeId" >
            </div>            
            <button type="submit" class="btn btn-outline-success">Log In</button>
         </form>
      </div>
   </body>
</html>