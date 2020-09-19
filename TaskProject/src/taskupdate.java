

import java.io.IOException;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/taskupdate")
public class taskupdate extends HttpServlet {
	
	public static final long serialVersionUID=1L;
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String requestdata=request.getReader().readLine();
		
task p = (task) jsonObject.getObjectFromJSON(requestdata, task.class);
		

Map<String, String> map = daolayer.updatetask(p);

		String responseData = (String) jsonObject.getJSONFromObject(map);
		
		response.getWriter().write(responseData);
		
		response.flushBuffer();

	}

}
