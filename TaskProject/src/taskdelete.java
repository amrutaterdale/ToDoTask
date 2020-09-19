import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/taskdelete")
public class taskdelete extends HttpServlet {
	
	private static final long serialVersionUID=1L;
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String requestdata=request.getReader().readLine();
		System.out.println(requestdata);
		
		task p=(task)jsonObject.getObjectFromJSON(requestdata, task.class);
		try
		{
			Map<String,String> m=daolayer.deletetask(p);
			
			String responseData = (String) jsonObject.getJSONFromObject(m);

			response.getWriter().write(responseData);

			response.flushBuffer();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
		}
		
		
	}