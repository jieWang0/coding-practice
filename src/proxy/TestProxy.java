package proxy;

import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        MyServer server = new MyServer();
        Server pServer = (Server) Proxy.newProxyInstance(server.getClass().getClassLoader(),
                server.getClass().getInterfaces(), new JHandler(server));
        pServer.print();
    }
}
