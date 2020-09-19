
import java.io.IOException;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/check")
public class check extends HttpServlet {
	
	public static final long serialVersionUID=1L;
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		System.out.println("hi123");
		String requestdata=request.getReader().readLine();
		System.out.println(requestdata);
		
task p = (task) jsonObject.getObjectFromJSON(requestdata, task.class);
		

		Map<String, String> map = daolayer.checkstatus(p);

		String responseData = (String) jsonObject.getJSONFromObject(map);
		
		response.getWriter().write(responseData);
		
		response.flushBuffer();
	}

		
	}