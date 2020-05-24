package java300.server.Server_study04.src.server.user;

import java300.server.Server_study04.src.server.server.core.Request;
import java300.server.Server_study04.src.server.server.core.Response;
import java300.server.Server_study04.src.server.server.core.Servlet;

public class LoginServlet implements Servlet {
	@Override
	public void  service(Request request,Response response) {
		response.print("<html>"); 
		response.print("<head>"); 
		response.print("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">" ); 
		response.print("<title>");
		response.print("第一个servlet");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.print("欢迎回来:"+request.getParameter("uname"));
		response.print("</body>");
		response.print("</html>");
	}

}
