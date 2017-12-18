package bootrabbit.tcp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import bootrabbit.producer.XEventProducer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Component
public class TcpServer {
    ServerSocket serverSocket;
    ExecutorService threadPool;
    private XEventProducer eventProducer;
    public static final int TCP_PORT = 1337;

    @Autowired
    public void TcpServer(XEventProducer footstepEventProducer) throws IOException {
        serverSocket = new ServerSocket(TCP_PORT);
        threadPool = Executors.newCachedThreadPool();
        this.eventProducer = footstepEventProducer;
        startListen();
    }

    public void startListen() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            threadPool.submit(new XClientHandler(clientSocket,eventProducer));
        }
    }
}
