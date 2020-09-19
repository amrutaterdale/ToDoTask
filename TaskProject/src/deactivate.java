
import java.io.IOException;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deactivate")
public class deactivate extends HttpServlet {
	
	public static final long serialVersionUID=1L;
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		System.out.println("hi");
		String requestdata=request.getReader().readLine();
		System.out.println(requestdata);
		
registeredUser p = (registeredUser) jsonObject.getObjectFromJSON(requestdata, registeredUser.class);
		

		Map<String, String> map = daolayer.deactivateUser(p);

		String responseData = (String) jsonObject.getJSONFromObject(map);
		
		response.getWriter().write(responseData);
		
		response.flushBuffer();
	}

		
	}