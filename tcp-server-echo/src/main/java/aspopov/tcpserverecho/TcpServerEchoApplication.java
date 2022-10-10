package aspopov.tcpserverecho;

import aspopov.tcpserverecho.service.TcpService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TcpServerEchoApplication {

	public static void main(String[] args) throws InterruptedException {

		var ctx = SpringApplication.run(TcpServerEchoApplication.class, args);
		var tcpServer = ctx.getBean(TcpService.class);
		tcpServer.run();
	}

}
