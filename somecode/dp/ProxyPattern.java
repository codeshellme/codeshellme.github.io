import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyPattern {
    public static void main(String[] args) {

    }
}

interface ServerInterface {
    void handleRequest();
}

class Server implements ServerInterface {
    public void handleRequest() {
        // 处理过程
        System.out.println("handle client request.");
    }
}

//class ServerProxy implements ServerInterface {
//    private Server server;
//
//    public ServerProxy(Server server) {
//        this.server = server;
//    }
//
//    public void handleRequest() {
//        long startTime = System.currentTimeMillis();
//
//        // 调用原始类
//        server.handleRequest();
//
//        long endTime = System.currentTimeMillis();
//
//        long reqTime = endTime - startTime;
//        System.out.println(reqTime);
//    }
//}

class ServerProxy extends Server {
    public void handleRequest() {
        long startTime = System.currentTimeMillis();

        // 调用原始类
        super.handleRequest();

        long endTime = System.currentTimeMillis();

        long reqTime = endTime - startTime;
        System.out.println(reqTime);
    }
}