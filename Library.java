import java.io.*; 
import java.sql.*; 
import java.sql.Date; 
import java.text.ParseException;
import javax.servlet.ServletException; 
import javax.servlet.http.*; 
import java.text.SimpleDateFormat; 
import javax.servlet.annotation.*;



@WebServlet("/Library")

public class Library extends HttpServlet {
    private String novel,storybook,noofdailyusers,totalbookcount;
    public void init() throws ServletException {
        


novel="Novel";
storybook="StoryBook";
noofdailyusers="Daily_User_Count";
totalbookcount="Books_Available";


}

public void doGet(HttpServletRequest request, HttpServletResponse response) 
 throws ServletException, IOException { 

response.setContentType("text/html"); 
PrintWriter out = response.getWriter(); 

String novel=request.getParameter("novel"); 
String story=request.getParameter("story"); 
String usercount=request.getParameter("usercount"); 
String book_available=request.getParameter("book_available"); 


try{
 Class.forName("com.mysql.jdbc.Driver");
 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/knowledge", "root", "");
 PreparedStatement preparedstate=conn.prepareStatement("insert into library(novel,story,usercount,book_available) values(?,?,?,?)");
preparedstate.setString(1,novel); 
preparedstate.setString(2,story); 
preparedstate.setString(3,usercount); 
preparedstate.setString(4,book_available);
int i=preparedstate.executeUpdate(); 
if(i>0)  
out.println("<img src='/images/lib.jpg' alt='success'/>");

out.println(
    
"<table border=1><tr><th>"+novel+"</th><td>"+novel+"</td></tr><br>"+
"<tr><th>"+storybook+"</th><td>"+story+"</td></tr><br>"+
"<tr><th>"+noofdailyusers+"</th><td>"+usercount+"</td></tr><br>"+
"<tr><th>"+totalbookcount+"</th><td>"+book_available+"</td></tr><br>"

);

 conn.close();

 }
 catch(Exception e)
 {
 System.out.println(e);
 }
 } 
}
