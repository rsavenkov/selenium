package ru.easyum.selenium;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

/**
 * Embedded jetty server
 */
public class TestServer extends AbstractHandler {
    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);

        if (target.contains("script.js")) {
            response.setContentType("text/javascript;charset=utf-8");
            response.getWriter().println("setTimeout(function afterTwoSeconds() {" +
                    "var p = document.createElement('p');" +
                    "var text = document.createTextNode('Async p tag');" +
                    "p.appendChild(text); document.body.appendChild(p);" +
                    "}, 8000)");
            return;
        }

        long start = System.currentTimeMillis();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        response.getWriter().println("<h1>Hello World</h1>" + "<h2 id='time'> Returned for " + (System.currentTimeMillis() - start) + " ms</h2>" +
                "<script src='/script.js'></script>");
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new TestServer());

        server.start();
        server.join();
    }
}