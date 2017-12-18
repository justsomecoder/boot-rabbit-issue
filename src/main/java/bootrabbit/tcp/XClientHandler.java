package bootrabbit.tcp;

import bootrabbit.producer.XEventProducer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Socket;

public class XClientHandler implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(XClientHandler.class);
    private Socket clientSocket;
    private ObjectMapper objectMapper;

    public XClientHandler(Socket clientSocket, XEventProducer eventProducer) {
        this.clientSocket = clientSocket;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void run() {
       // removed implementation
    }

}
