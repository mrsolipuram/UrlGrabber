package com.urlgrabber.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.util.JSON;

/**
 * 
 * @author madhava
 *
 */
public class URLGrabberServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String url = req.getParameter("url");
		
		Map<String, Object> data = HtmlParse.getDatafromUrl(url);
		pushResponse(resp, JSON.serialize(data));
	}
	
	public void pushResponse(HttpServletResponse resp,Object o) throws IOException{
		PrintWriter out = resp.getWriter();
		out.write(o.toString());
		out.flush();
	}

}
