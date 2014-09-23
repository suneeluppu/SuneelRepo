import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StudentSrv extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
			{
		// TODO Auto-generated method stub
		System.out.println("this is doget method");
               System.out.println("this is doget method modified");
                 System.out.println("push into the master");
                System.out.println("push into the sun branch");
system.out.println("push into kumar branch");
system.out.println("push into kumar branch---------------");
		String sno=req.getParameter("sno");  
		String sname=req.getParameter("sname");
		String saddress=req.getParameter("saddress");
        PrintWriter pw = resp.getWriter() ;
       
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("load the driver class");
				//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sunil","tiger");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");  
				System.out.println("connection created ");
				 PreparedStatement ps=con.prepareStatement("insert into test.student(sno,sname,saddress)values(?,?,?)");
				 System.out.print("execute prepare statement");
				 ps.setString(1,sno);
				 ps.setString(2,sname);
				 ps.setString(3,saddress);
				 
				 
				 int i = ps.executeUpdate();
				
		          String msg=" ";
		          if(i!=0){  
		            msg="Record has been inserted";
		            pw.println("<font size='6' color=blue>" + msg + "</font>");  


		          }  
		          else{  
		            msg="failed to insert the data";
		            pw.println("<font size='6' color=blue>" + msg + "</font>");
		           }  
		          
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
		
	}
	
	

}
