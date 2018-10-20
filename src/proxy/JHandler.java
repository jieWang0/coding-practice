package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JHandler implements InvocationHandler{
    MyServer server;
    public JHandler( MyServer server) {
        this.server = server;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JHandler call");
        return method.invoke(server,args);
    }
}
