package bootrabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import bootrabbit.tcp.TcpServer;

@SpringBootApplication
public class BootRabbitIssue {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BootRabbitIssue.class);
        app.setWebEnvironment(false); // we do not want for instance the embedded Tomcat server to start
        ConfigurableApplicationContext appContext = app.run(args);
        bootrabbit.tcp.TcpServer footstepTCPServer = new bootrabbit.tcp.TcpServer();
        // the below is also not printed to stdout, however 'lsof -i :1337' shows that we are listening on 1337 nonetheless
        System.out.println("Starting TCP server for processing x, listening on port " + TcpServer.TCP_PORT + ".");
    }

}
