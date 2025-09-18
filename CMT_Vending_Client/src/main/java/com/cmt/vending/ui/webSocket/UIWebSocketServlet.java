package com.cmt.vending.ui.webSocket;

import jakarta.servlet.annotation.WebServlet;
import org.eclipse.jetty.ee10.websocket.server.JettyWebSocketServlet;
import org.eclipse.jetty.ee10.websocket.server.JettyWebSocketServletFactory;

@WebServlet("/Vending")
public class UIWebSocketServlet extends JettyWebSocketServlet {
    @Override
    public void configure(JettyWebSocketServletFactory factory) {
        factory.register(UIWebSocketEndpoint.class);
    }

}
