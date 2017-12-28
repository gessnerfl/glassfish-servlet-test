package de.gessnerfl.testservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();
        writer.append("Request URL: "+req.getRequestURL().toString()+"\n");
        writer.append("Request URI: "+req.getRequestURI()+"\n");
        writer.append("Server Name: "+req.getServerName()+"\n");
        writer.append("Server Port: "+req.getServerPort()+"\n");
        writer.append("Local Name: "+req.getLocalName()+"\n");
        writer.append("Local Port: "+req.getLocalPort()+"\n");
        writer.append("Remote Host: "+req.getRemoteHost()+"\n");
        writer.append("Remote Port: "+req.getRemotePort());
        writer.flush();
    }
}
