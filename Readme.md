# Login Page
## Description
Used for authentication purpose.Filter method is used to validate the username.If user name is admin the page is redirected to index page of student details.
## Coding
     
## Login.jsp

    
    
    ```<html>
    <head></head>
    <title>Student Details</title>
    <body>
    <form method="post" action="LoginPage">
    USERNAME:<input type="text" 
    name="user"/><br/> <br/>
    PASSWORD:<input type="text" name="password"/><br/><br/>
    <input type = "submit" value="submit"/><br/><br/></form>
    <form action="error.html">  
    <input type = "submit" value="cancel"/><br/><br/>       </form>
    <img src="/images/col1.jpg" style="width:1000px;height:500px;"><br/>
    </body>
    </html>```

### error.html

    ```
    <html>
    <head></head>
    <title>error</title>
    <body>
    <h1>Incorrect User or password </h1>
    </body>
    </html>

    
    ```    

## LoginPage.java
    
       
       ```  import java.io.*;
         import javax.servlet.*;
         import javax.servlet.http.*;
         import javax.servlet.Filter.*;
         import javax.servlet.annotation.WebFilter;

         @WebFilter(filterName="Login2",urlPatterns="/LoginPage")
         public class LoginPage implements Filter   {
         public void init(FilterConfig fc) throws ServletException {}
         public void doFilter(ServletRequest request,ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
         PrintWriter out = response.getWriter();
         String user = request.getParameter("user");
         String pswd = request.getParameter("password");

         if(user.equals("admin"))
          {
         chain.doFilter(request, response);   
          }
         else
          {
            out.println("You have enter a wrong password");
            RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
            rs.include(request, response);
           }
           }
         public void destroy() { }
           }
```
## Login2.java

     ```
         import java.io.*;
         import javax.servlet.*;
         import javax.servlet.http.*;
         import javax.servlet.Filter;
         import javax.servlet.annotation.WebServlet;
         @WebServlet("/LoginPage")

         public class Login2 extends HttpServlet {

         public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
         {
         response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         String user = request.getParameter("user");
         String pswd = request.getParameter("password");
         out.println("Access granted "+user);

         response.sendRedirect("index.jsp");
         }
         }
```
# Index page 

## Description
This page contains fields required for student details which is used as an input for student pojo class. Insert,Update, Delete and Select operations can be made.

## Coding
## index.jsp
```
        <html>
        <head>
        <title>StudentDetails</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script>
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        </head>
        <link rel="shortcut icon" href="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOnO8OvBKUH9OxS5m63Qv2v-1Ch-tLoY9yXSnh94RKkTUEp6hScQ" type="image"/>
        <style>
        .jumbotron {
        background-image:url(https://www.google.co.in/imgres?imgurl=http%3A%2F%2Fwww.going2college.org%2Fimages%2Fgoing2collegelogo.png&imgrefurl=http%3A%2F%2Fwww.going2college.org%2F&docid=YwnyrkZpooR0SM&tbnid=GnSop74diZ-EUM%3A&vet=10ahUKEwi8l7mIrqbVAhWIwrwKHTuQAVI4ZBAzCAsoCTAJ..i&w=1200&h=292&bih=490&biw=1093&q=college%20images&ved=0ahUKEwi8l7mIrqbVAhWIwrwKHTuQAVI4ZBAzCAsoCTAJ&iact=mrc&uact=8);
        height:700px;
        background-repeat: no-repeat;
        background-size: cover;
        border-bottom:1px solid #ff6a00
        }
        #form{
        background-color:lightskyblue;
        }
        body{
        background-color:purple;
        }
        </style>
 
        <body>
        <div class ="container-fluid">
        <h1><div align="center">
        <div class ="well blue"> Request your need.. </div></div></h1>
        <div class ="jumbotron">
        <form action="InsertStudent" method="post">
        <h1 align="center">Student details</h1> 
        <table cellspacing=5 cellpadding=5 id="form" align="center">
        <tr><td>Name:</td>  <td><input type="text" name="name"/></td></tr>
        <tr><td>Reg_No:</td><td><input type="text" name="regno"/></td></tr> 
        <tr><td>Department:</td><td><input type="text" name="department"/></td></tr>
        <tr><td>Cgpa:</td><td> <input type="text" name="cgpa"/></td></tr>
        <tr><td>Sgpa:</td><td> <input type="text" name="sgpa"/></td></tr> 
        <tr><td>No_Of_Arears:</td><td> <input type="text" name="noofarears"/></td></tr>
        <tr><td>Attendance:</td><td><input type="text" name="attendance"/></td></tr>
        <tr><td>Result:</td><td><input type="text"name="result"/></td></tr>
        <tr><td>E-mail:</td><td><input type="text"name="email"/></td></tr>   
        <tr><td><center><input type="submit" value="SUBMIT"  ></center></td></tr>        
        </form>
        <form action="ViewAllDetails" method="get">
            <tr><td><center><input type="submit" value="DISPLAY"></center></td></tr>
        </form>
        <form action="delete.html" method="GET">
        <tr><td><center><input type="submit" value="DELETE"></center></td></tr>
        </form>
        <form action="update.html" method="GET">
        <tr><td><center><input type="submit" value="UPDATE"></center></td></tr>
        </form>

        </table>
        </div>
        </body>
        </html>
```
### update.html
 ```
        <html>
        <head><title>update</title></head>
        <body>
        <img src="/images/3.jpg" class="img-thumbnail" alt="Cinque Terre" width="304" height="236">
        <form action="EditStudent1"method="get">
        Name:<input type="text"name="name"/>
        <input type="submit"value="UPDATE"/>
        </form></body>
        </html>
```
 ### delete.html

      ```  <html>
        <head><title>delelete</title></head>
        <body>
        <form action="StudentDelete" method="GET">
        Name:<input type="text" name="name"><br/>
        <input type="submit"value="DELETE">
        </form>
        </body>
        </html>       

```
## Student_Pojo.java
```
       import java.util.*;  
       public class Student_Pojo
       {
       String name,department,attendance,result,email;
       private int regno,cgpa,sgpa,noofarears;
       public void setName(String name)
       {
        this.name = name;
       }
       public String getName()
       {
        return name;
       }
       public void setRegno(int regno)
       {
        this.regno = regno;
       }
       public int getRegno()
       {
        return regno;
       }
       public void setDepartment(String departemnt)
       {
        this.department = departemnt;
       }
       public String getDepartment()
       {
        return department;
       }
       public void setCgpa(int cgpa)
       {
        this.cgpa = cgpa;
       }
       public int getCgpa()
       {
        return cgpa;
       }
       public void setSgpa(int sgpa)
       {
        this.sgpa = sgpa;
       }
       public int getSgpa()
       {
        return sgpa;
       }
       public void setNoofarears(int noofarears)
       {
        this.noofarears = noofarears;
       }
       public int getNoofarears()
       {
        return noofarears;
       }
       public void setAttendance(String attendance)
       {
        this.attendance = attendance;
       }
       public String getAttendance()
       {
        return attendance;
       }
       public void setResult(String result)
       {
        this.result=result;
       }
       public String getResult()
       {
       return result;
       }
       public void setEmail(String email)
       {
       this.email=email;
       }
       public String getEmail()
       {
       return email;
       }
       }
```
## Student_Main.java
```
            import java.io.*; 
            import java.sql.*; 
            import java.sql.Date; 
            import java.text.ParseException;
            import javax.servlet.ServletException; 
            import javax.servlet.http.*; 
            public class Student_Main
            {
            public static Connection getConnection()
            {
            Connection con = null;
            try
            {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student1","root","");
            }
            catch(Exception e)
            {
            System.out.println(e);
            }
            return con;
            }
            }
```
## InsertStudent.java
       ```  
            import java.io.IOException;  
            import java.io.PrintWriter;  
            import java.util.Properties;
            import javax.mail.Message;
            import javax.mail.MessagingException;
            import javax.mail.PasswordAuthentication;
            import javax.mail.Session;
            import javax.mail.Transport;
            import javax.mail.internet.InternetAddress;
            import javax.mail.internet.MimeMessage;

            import java.io.*;
            import java.net.Authenticator;
            import java.util.*;

            import javax.servlet.ServletException;  
            import javax.servlet.annotation.WebServlet;  
            import javax.servlet.http.HttpServlet;  
            import javax.servlet.http.HttpServletRequest;  
            import javax.servlet.http.HttpServletResponse;  

            @WebServlet("/InsertStudent")
            public class InsertStudent extends HttpServlet
            {
            protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
            {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String name = request.getParameter("name");
            int regno = Integer.parseInt(request.getParameter("regno"));
            String department = request.getParameter("department");
            int cgpa = Integer.parseInt(request.getParameter("cgpa"));
            int sgpa = Integer.parseInt(request.getParameter("sgpa"));
            int noofarears = Integer.parseInt(request.getParameter("noofarears"));
            String attendance = request.getParameter("attendance");
            String result=request.getParameter("result");
            String email=request.getParameter("email");


            Student_Pojo spojo = new Student_Pojo();
            spojo.setName(name);
            spojo.setRegno(regno);
            spojo.setDepartment(department);
            spojo.setCgpa(cgpa);
            spojo.setSgpa(sgpa);
            spojo.setNoofarears(noofarears);
            spojo.setAttendance(attendance);
            spojo.setResult(result);
            spojo.setEmail(email);

            int status = Student_Operation.insert(spojo);
    
            if(status > 0)
            {
            out.println("Inserted successfully");
            InsertStudent.sendEmail(email);
            out.print("sending mail....");
            }
           else{  
           out.println("Sorry! unable to save record");  
           }  
           }
           public static void sendEmail(String to)
           {  
           final String username = "sindhuja.r@kggroup.com";
           final String password = "sindhu@123";
           Properties props = new Properties();
           props.put("mail.smtp.auth", "true");
           props.put("mail.smtp.starttls.enable", "false");
           props.put("mail.smtp.host", "webmail.kggroup.com");
           props.put("mail.smtp.port", "25");
           Session session = Session.getInstance(props,
           new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {
           return new PasswordAuthentication(username, password);
           }
           });
           try {
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress("sindhuja.r@kggroup.com"));
           message.setRecipients(Message.RecipientType.TO,
           InternetAddress.parse(to));
           message.setSubject("hello !!!");
           message.setText("This is an example program for crud operations and send mail.........,"
           + "\n\n No spam to my email, please!");
           Transport.send(message);
           System.out.println("Done");
           }
           catch (MessagingException e) 
           {
           throw new RuntimeException(e);
           //System.out.println("Username or Password are incorrect ... exiting !");
           }
           } 
           }
```
## EditStudent1.java
```
           import java.io.IOException;  
           import java.io.PrintWriter;  
  
           import javax.servlet.ServletException;  
           import javax.servlet.annotation.WebServlet;  
           import javax.servlet.http.HttpServlet;  
           import javax.servlet.http.HttpServletRequest;  
           import javax.servlet.http.HttpServletResponse; 

            @WebServlet("/EditStudent1")

            public class EditStudent1 extends HttpServlet
            {
            public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
            {
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            out.println("Update Operations");
            String name=request.getParameter("name");

            Student_Pojo pojo=Student_Operation.getResultMethod(name);
            out.print("<form action='EditStudent' method='post'>");  
            out.print("<table>");  
            out.print("<tr><td>Name:</td><td><input type='text'name='name' value='"+pojo.getName()+"'/></td></tr>");  
            out.print("<tr><td>Regno:</td><td><input type='text' name='regno' value='"+pojo.getRegno()+"'/></td></tr>");  
            out.print("<tr><td>Department:</td><td><input type='text' name='department' value='"+pojo.getDepartment()+"'/></td></tr>");  
            out.print("<tr><td>Cgpa:</td><td><input type='text' name='cgpa' value='"+pojo.getCgpa()+"'/></td></tr>");  
            out.print("<tr><td>Sgpa:</td><td><input type='text' name='sgpa' value='"+pojo.getSgpa()+"'/></td></tr>");
            out.print("<tr><td>Noofarears:</td><td><input type='text' name='noofarears' value='"+pojo.getNoofarears()+"'/></td></tr>");
            out.print("<tr><td>Attendance:</td><td><input type='text' name='attendance' value='"+pojo.getAttendance()+"'/></td></tr>");
            out.print("<tr><td>Result:</td><td><input type='text' name='result' value='"+pojo.getResult()+"'/></td></tr>");
            out.print("<tr><td>Email:</td><td><input type='text' name='email' value='"+pojo.getEmail()+"'/></td></tr>");

            out.print("</td></tr>");  
            out.print("<tr><td colspan='2'><input type='submit' value='changing'/></td></tr>");  
            out.print("</table>");  
            out.print("</form>");  
          
            out.close();  
            }
            }
```
## EditStudent.java
```
           import java.io.IOException;  
           import java.io.PrintWriter;  
  
           import javax.servlet.ServletException;  
           import javax.servlet.annotation.WebServlet;  
           import javax.servlet.http.HttpServlet;  
           import javax.servlet.http.HttpServletRequest;  
           import javax.servlet.http.HttpServletResponse; 

           @WebServlet("/EditStudent")

           public class EditStudent extends HttpServlet
           {
           protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
           {
           response.setContentType("text/html");
           PrintWriter out = response.getWriter();

           String name = request.getParameter("name");
           int regno = Integer.parseInt(request.getParameter("regno"));
           String department = request.getParameter("department");
           int cgpa = Integer.parseInt(request.getParameter("cgpa"));
           int sgpa = Integer.parseInt(request.getParameter("sgpa"));
           int noofarears = Integer.parseInt(request.getParameter("noofarears"));
           String attendance = request.getParameter("attendance");
           String result = request.getParameter("result");
           String email=request.getParameter("email");

           Student_Pojo spojo = new Student_Pojo();
           spojo.setName(name);
           spojo.setRegno(regno);
           spojo.setDepartment(department);
           spojo.setCgpa(cgpa);
           spojo.setSgpa(sgpa);
           spojo.setNoofarears(noofarears);
           spojo.setAttendance(attendance);
           spojo.setResult(result);
           spojo.setEmail(email);
           int status = Student_Operation.update(spojo);
           if(status>0)
           {
            System.out.println("updated successfully......");
           }

           else
           {
           System.out.println("update process going on....");
           }
           response.sendRedirect("ViewAllDetails");
           }
           }
```
## StudentDelete.java
  ```
          import java.io.IOException;  
          import javax.servlet.ServletException;  
          import javax.servlet.annotation.WebServlet;  
          import javax.servlet.http.HttpServlet;  
          import javax.servlet.http.HttpServletRequest;  
          import javax.servlet.http.HttpServletResponse;  
          @WebServlet("/StudentDelete")  
          public class StudentDelete extends HttpServlet {  
          protected void doGet(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
          String name=request.getParameter("name");    
          Student_Operation.delete(name);  
          response.sendRedirect("ViewAllDetails");  
          }  
          }
```
## ViewAllDetails.java
```
          import java.io.IOException;  
          import java.io.PrintWriter;  
          import java.util.List;  
  
          import javax.servlet.ServletException;  
          import javax.servlet.annotation.WebServlet;  
          import javax.servlet.http.HttpServlet;  
          import javax.servlet.http.HttpServletRequest;  
          import javax.servlet.http.HttpServletResponse;  
          @WebServlet("/ViewAllDetails")  
          public class ViewAllDetails extends HttpServlet {  
          protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
          response.setContentType("text/html");  
          PrintWriter out=response.getWriter();  
          //out.println("<a href='index.html'>Add New Employee</a>");  
          out.println("<h1>Student List</h1>");  
          
          List<Student_Pojo> list=Student_Operation.getViewAllDetails();  
          
          out.print("<table border='1' width='100%'");  
          out.print("<tr><th>Name</th><th>Regno</th><th>Department</th><th>Cgpa</th><th>Sgpa</th><th>Noofarears</th><th>Attendance</th><th>Result</th><th>Emailid</th></tr>");  
          for(Student_Pojo e:list){  
          out.print("<tr><td>"+e.getName()+"</td><td>"+e.getRegno()+"</td><td>"+e.getDepartment()+"</td><td>"+e.getCgpa()+"</td><td>"+e.getSgpa()+"</td><td>"+e.getNoofarears()+"</td><td>"+e.getAttendance()+"</td><td>"+e.getResult()+"</td><td>"+e.getEmail()+"</td></tr>");  
          }  
          out.print("</table>");  
          
          out.close();  
          }  
          }
```

## Student_Operation.java
```
            import java.io.*; 
            import java.sql.*; 
            import java.sql.Date; 
            import java.text.ParseException;
            import javax.servlet.ServletException; 
            import javax.servlet.http.*; 
            import java.util.*;

            public class Student_Operation
            {   

            public static int insert(Student_Pojo pojo)
            {
            int status=0;
            try{
            Connection con = Student_Main.getConnection();
            PreparedStatement pre = con.prepareStatement("insert into studregistration values(?,?,?,?,?,?,?,?,?)");
            //pre.executeUpdate("insert in studreg values(?,?,?,?,?,?,?)");
            pre.setString(1,pojo.getName());
            pre.setInt(2,pojo.getRegno());
            pre.setString(3,pojo.getDepartment());
            pre.setInt(4,pojo.getCgpa());
            pre.setInt(5,pojo.getSgpa());
            pre.setInt(6,pojo.getNoofarears());
            pre.setString(7,pojo.getAttendance());
            pre.setString(8,pojo.getResult());
            pre.setString(9,pojo.getEmail());
            status=pre.executeUpdate();
            con.close();
            }
            catch(Exception e)
            {
            System.out.println(e);
            }
            return status;
            }
           public static int update(Student_Pojo pojo)
           {
           int status=0;
           try
           {
           Connection con = Student_Main.getConnection();
           PreparedStatement pre = con.prepareStatement("update studregistration set regno=?,department=?,cgpa=?,sgpa=?,noofarears=?,attendance=?,result=?,email=? where name=?");
           pre.setInt(1,pojo.getRegno());
           pre.setString(2,pojo.getDepartment());
           pre.setInt(3,pojo.getCgpa());
           pre.setInt(4,pojo.getSgpa());
           pre.setInt(5,pojo.getNoofarears());
           pre.setString(6,pojo.getAttendance());
           pre.setString(7,pojo.getResult());
           pre.setString(8,pojo.getEmail());
           pre.setString(9,pojo.getName());
           status=pre.executeUpdate();
           con.close(); }
           catch(Exception e)
          {
           System.out.println(e);
          }
           return status;
          }
          public static Student_Pojo getResultMethod(String name)
          {
          Student_Pojo pojo=new Student_Pojo();
          try{
          Connection c=Student_Main.getConnection();
          PreparedStatement pre=c.prepareStatement("select * from studregistration where name=?");
          pre.setString(1,name);
          ResultSet rs=pre.executeQuery();
          while(rs.next())
          {
          pojo.setName(rs.getString(1));
          pojo.setRegno(rs.getInt(2));
          pojo.setDepartment(rs.getString(3));
          pojo.setCgpa(rs.getInt(4));
          pojo.setSgpa(rs.getInt(5));
          pojo.setNoofarears(rs.getInt(6));
          pojo.setAttendance(rs.getString(7));
          pojo.setResult(rs.getString(8));
          pojo.setEmail(rs.getString(9));
          }
          c.close();
          }
          catch(Exception e)
          {
          System.out.println(e);
          }
          return pojo;
          }
          public static List<Student_Pojo> getViewAllDetails(){  
          List<Student_Pojo> list=new ArrayList<Student_Pojo>();  
          try{  
          Connection con=Student_Main.getConnection();  
          PreparedStatement ps=con.prepareStatement("select * from studregistration");  
          ResultSet rs=ps.executeQuery();  
          while(rs.next()){  
          Student_Pojo  pojo=new Student_Pojo();  
          pojo.setName(rs.getString(1));
          pojo.setRegno(rs.getInt(2));
          pojo.setDepartment(rs.getString(3));
          pojo.setCgpa(rs.getInt(4));
          pojo.setSgpa(rs.getInt(5));
          pojo.setNoofarears(rs.getInt(6));
          pojo.setAttendance(rs.getString(7));
          pojo.setResult(rs.getString(8));
          pojo.setEmail(rs.getString(9));
          list.add(pojo);  
          }  
          con.close();  
          }catch(Exception e){e.printStackTrace();}  
          
          return list;  
          }  
          public static int delete(String name){  
          int status=0;  
          try{  
          Connection con=Student_Main.getConnection();  
          PreparedStatement ps=con.prepareStatement("delete from studregistration where name=?");  
          ps.setString(1,name);  
          status=ps.executeUpdate();  
              
          con.close();  
          }catch(Exception e){e.printStackTrace();}    
          return status;  
          }  
          }
```



 
  
  

