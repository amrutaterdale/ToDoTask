import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




public class daolayer {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Task","root","root");
		
		return con;
	}
	
	public static Map<String, String> savereguser(registeredUser r) throws ClassNotFoundException, SQLException {

		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement("insert into registeredUser("
				+ "firstName,lastName,gender,email,dob,pwd,confirmPwd,regDate,status,id,randomno) values(?,?,?,?,?,?,?,?,?,?,?)");

		String firstName = r.getFirstName();
		String lastName = r.getLastName();
		//String password = r.getPassword();
		String gender = r.getGender();
		String email=r.getEmail();
		Date dob= r.dob;
		String pwd = r.getPwd();
		String confirmPwd=r.getConfirmPwd();
		Date regDate=r.getRegDate();
		int status=r.getStatus();
		int id=r.getId();
		int randomno=r.getRandomno();
//		System.out.println(regDate);
		sendEmail.sendemail(email,randomno);

		ps.setObject(1, firstName);
		ps.setObject(2, lastName);
		ps.setObject(3,  gender );
		ps.setObject(4, email);
		ps.setObject(5, dob);
		ps.setObject(6, pwd);
		ps.setObject(7, confirmPwd);
		ps.setObject(8,regDate);
		ps.setObject(9,status);
		ps.setObject(10,id);
		ps.setObject(11, randomno);
		int s = ps.executeUpdate();

		Map<String, String> map = new HashMap<>();

		if (s == 1) {
			map.put("msg", "done");

		} else {
			map.put("msg", "sorry");
		}
		return map;
		
		
	}
	
	public static ArrayList<registeredUser>getRegAllData() throws SQLException, ClassNotFoundException
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from registereduser;");
		
		ResultSet rs=ps.executeQuery();
		ArrayList<registeredUser>list=new ArrayList<>();
		
		while(rs.next())
		{
			registeredUser r=new registeredUser();
			r.setFirstName(rs.getString(1));
			r.setLastName(rs.getString(2));
			r.setGender(rs.getString(3));
			r.setEmail(rs.getString(4));
			r.setDob(rs.getDate(5));
			r.setPwd(rs.getString(6));
			r.setConfirmPwd(rs.getString(7));
			r.setRegDate(rs.getDate(8));
			r.setStatus(rs.getInt(9));
			r.setId(rs.getInt(10));
			
			list.add(r);
		}
		return list;
	}
	
	public static Map<String, String> savetask(task r) throws ClassNotFoundException, SQLException {

		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement("insert into alltask(tid,tname,tdesc,email,taskdate) values(?,?,?,?,?)");
		int tid=r.getTid();
		String tname = r.getTname();
		String tdesc = r.getTdesc();
		String email=r.getEmail();
		Date taskdate=r.getTaskdate();
		//String password = r.getPassword();
		
		

		ps.setObject(1, tid);
		ps.setObject(2, tname);
		ps.setObject(3, tdesc);
		ps.setObject(4, email);
		ps.setObject(5, taskdate);
		
		int status = ps.executeUpdate();
		//System.out.println(status);

		Map<String, String> map = new HashMap<>();

		if (status == 1) {
			map.put("msg", "done");

		} else {
			map.put("msg", "sorry");
		}
		return map;
	}
	
	public static ArrayList<task>getAlltask() throws SQLException, ClassNotFoundException
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from alltask;");
		
		ResultSet rs=ps.executeQuery();
		ArrayList<task>list=new ArrayList<>();
		
		while(rs.next())
		{
			task r=new task();
			r.setTid(rs.getInt(1));
			r.setTname(rs.getString(2));
			r.setTdesc(rs.getString(3));
			r.setChkbox(rs.getInt(4));
			r.setStatus(rs.getString(5));
			r.setEmail(rs.getString(6));
			r.setTaskdate(rs.getDate(7));
			
			list.add(r);
		}
		return list;
	}
	
	public static Map<String, String> updatetask(task p) {

		Map<String, String> map=new HashMap<String, String>();
		
		try {
			Connection con = getConnection();

			PreparedStatement ps = con.prepareStatement("update alltask set tname=?,tdesc=? where tid=?");

			ps.setString(1, p.getTname());
			ps.setString(2, p.getTdesc());
			ps.setInt(3, p.getTid());

			int status = ps.executeUpdate();
			System.out.println("updaate");
			//System.out.println(p.getTid());

			if (status == 1)
			{
				map.put("msg", "done");
			}
			else
			{
				map.put("msg", "sorry");
			}

		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return map;
	}
	
	public static Map<String,String> deletetask(task p) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("delete from alltask where tid=?");
		ps.setInt(1, p.getTid());
		
		int d=ps.executeUpdate();
		Map<String,String>m=new HashMap<>();
		
		if(d==1)
		{
			m.put("msg", "done");
		}
		else
			m.put("masg", "unsucess");
		
		return m;
		
	}
	
	public static Map<String, String> activateUser(registeredUser p) {

		Map<String, String> map=new HashMap<String, String>();
		
		try {
			Connection con = getConnection();

			PreparedStatement ps = con.prepareStatement("update registereduser set status=? where id=?");

			ps.setInt(1, 1);
			ps.setInt(2, p.getId());
			//ps.setInt(3, p.getTid());

			int status = ps.executeUpdate();
			System.out.println("updaate activation");

			if (status == 1)
			{
				map.put("msg", "done");
			}
			else
			{
				map.put("msg", "sorry");
			}

		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return map;
	}

	public static Map<String, String> deactivateUser(registeredUser p) {

		Map<String, String> map=new HashMap<String, String>();
		
		try {
			Connection con = getConnection();

			PreparedStatement ps = con.prepareStatement("update registereduser set status=? where id=?");

			ps.setInt(1, 0);
			ps.setInt(2, p.getId());
			//ps.setInt(3, p.getTid());

			int status = ps.executeUpdate();
			System.out.println("update deactivation");

			if (status == 1)
			{
				map.put("msg", "done");
			}
			else
			{
				map.put("msg", "sorry");
			}

		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return map;
	}
	
	public static Map<String, String> checkstatus(task p) {

		Map<String, String> map=new HashMap<String, String>();
		
		try {
			Connection con = getConnection();

			PreparedStatement ps = con.prepareStatement("update alltask set status=?,chkbox=? where tid=?");

			if(p.getChkbox()==1)
			{
			ps.setString(1, "complete");
			ps.setInt(2, 1);
			ps.setInt(3, p.getTid());
			}
			if(p.getChkbox()==0)
			{
				ps.setString(1, "incomplete");
				ps.setInt(2, 0);
				ps.setInt(3, p.getTid());
				}
			

			int status = ps.executeUpdate();
			System.out.println("updaate activation");

			if (status == 1)
			{
				map.put("msg", "done");
			}
			else
			{
				map.put("msg", "sorry");
			}

		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return map;
	}
	
	public static Map<String, String> saveloginuser(login r) throws ClassNotFoundException, SQLException {

		Connection con = getConnection();

		
		PreparedStatement ps = con.prepareStatement("insert into login(id,email,logindate) values(?,?,?)");
		int id=r.getId();
		String email = r.getEmail();
		Date logindate=r.getLogindate();
		//String password = r.getPassword();
		
		
		ps.setObject(1, id);
		ps.setObject(2, email);
		ps.setObject(3, logindate);
//		ps.setObject(3, tdesc);
//		ps.setObject(4, email);
//		ps.setObject(5, taskdate);
		
		int status = ps.executeUpdate();
		//System.out.println(status);

		Map<String, String> map = new HashMap<>();

		if (status == 1) {
			map.put("msg", "done");

		} else {
			map.put("msg", "sorry");
		}
		return map;
	}
	
	public static List<login> getAlllogin() throws SQLException, ClassNotFoundException
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from login");
		
		ResultSet rs=ps.executeQuery();
		ArrayList<login>list=new ArrayList<>();
		
		while(rs.next())
		{
			login r=new login();
			r.setId(rs.getInt(1));
			r.setEmail(rs.getString(2));
			r.setLogindate(rs.getDate(3));
			
			list.add(r);
		}
		return list;
	}
	
	public static String verifyuser(String eml,int randomno)
	{
//		Map m=new HashMap();
		System.out.println("hi");
		Properties properties=new Properties();
		properties.put("mail.smtp.user", constant.senderEmailId);
		properties.put("mail.smtp.host",constant.emailSmtpServer);
		properties.put("mail.smtp.port",constant.emailServerPort);
		
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.socketFactory.port",constant.emailServerPort);
		properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		
		properties.put("mail.smtp.socketFactory.fallback","false");
		
		
		javax.mail.Session session=javax.mail.Session.getDefaultInstance(properties,new javax.mail.Authenticator()
				{
			protected javax.mail.PasswordAuthentication getPasswordAuthentication()
					{
				return new javax.mail.PasswordAuthentication(constant.senderEmailId,constant.senderPass);
				}
	});
		 try
		 {
			 javax.mail.Message message=new MimeMessage(session);
			 message.setFrom(new InternetAddress(constant.senderEmailId));
			 message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(eml));
			 message.setSubject("Email verification code");
			 message.setText("your OTP is"+" "+randomno);
			 Transport.send(message);
			 System.out.println("message sent successfully");
			  return "done";
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 System.out.println("error in try");
			 return "error";
				}
		
		
	}

	
	


}
