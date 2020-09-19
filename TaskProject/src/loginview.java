




import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/loginview")
public class loginview extends HttpServlet{
	private static final long serialVersionUID=1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		
		try {
			ArrayList<login> list = (ArrayList<login>) daolayer.getAlllogin();
			
//			System.out.println(list.get(1).tid);
			String responseData = (String)jsonObject.getJSONFromObject(list);
			System.out.println(responseData);
			
			response.getWriter().write(responseData);

			response.flushBuffer();
			

		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{		
			e.printStackTrace();
		}
	}
		
	}


