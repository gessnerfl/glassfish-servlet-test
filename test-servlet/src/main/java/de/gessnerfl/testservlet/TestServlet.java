package de.gessnerfl.testservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();
        writer.append("\n------------------------------------------------------\n");
        writer.append("Request Parameters:");
        writer.append("\n------------------------------------------------------\n");
        writer.append("Request URL: "+req.getRequestURL().toString()+"\n");
        writer.append("Request URI: "+req.getRequestURI()+"\n");
        writer.append("Server Name: "+req.getServerName()+"\n");
        writer.append("Server Port: "+req.getServerPort()+"\n");
        writer.append("Local Name: "+req.getLocalName()+"\n");
        writer.append("Local Port: "+req.getLocalPort()+"\n");
        writer.append("Remote Host: "+req.getRemoteHost()+"\n");
        writer.append("Remote Port: "+req.getRemotePort()+"\n");
        writer.append("\n\n------------------------------------------------------\n");
        writer.append("Headers:");
        writer.append("\n------------------------------------------------------\n");
        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            String value = req.getHeader(key);
            writer.append("   "+key+": "+value+"\n");
        }
        writer.flush();
    }
}
