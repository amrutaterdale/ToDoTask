

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class registeredSave
 */
@WebServlet("/registeredSave")
public class registeredSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestdata=request.getReader().readLine();
		System.out.println(requestdata);
		
		registeredUser ru=(registeredUser)jsonObject.getObjectFromJSON(requestdata, registeredUser.class);
		
		Map<String, String> map = null;
		try
		{
			map = daolayer.savereguser(ru);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		String responsedata = (String) jsonObject.getJSONFromObject(map);
		
		response.getWriter().write(responsedata);
		
		response.flushBuffer();
				
	}

}
