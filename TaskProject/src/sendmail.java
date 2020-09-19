


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
@WebServlet("/sendmail")
public class sendmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestdata=request.getReader().readLine();
		//System.out.println(requestdata);
		
		registeredUser ru=(registeredUser)jsonObject.getObjectFromJSON(requestdata, registeredUser.class);
		
		String email=ru.getEmail();
		int randomno=ru.getRandomno();
		
		String msg=daolayer.verifyuser(email,randomno);
		
		
		String responsedata = (String) jsonObject.getJSONFromObject(msg);
		
		response.getWriter().write(responsedata);
		
		response.flushBuffer();
				
	}

}
