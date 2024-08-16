package br.com.lecom.rabbitmq;

import java.io.BufferedReader;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.AccessControlException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitmqApplication.class);

	public static void main(String[] args) throws IOException {
		LOGGER.info("======================================================");
		String command = "ls -la";
		try {
			Process proc = Runtime.getRuntime().exec(command);
			BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line = "";
			LOGGER.info("'{}' can {}: yes", command, "execute");
			while ((line = reader.readLine()) != null) {
				LOGGER.info(line);
			}
			proc.waitFor();
		} catch (InterruptedException | AccessControlException e) {
			LOGGER.info("'{}' can {}: no", command, "execute");
			LOGGER.error(e.getMessage());
		} 
		LOGGER.info("======================================================");
		String path = System.getProperty("user.home");
		RabbitmqApplication.checkPermission(path, "read");
		RabbitmqApplication.checkPermission(path, "write");
		LOGGER.info("======================================================");
		path = System.getProperty("java.io.tmpdir");
		RabbitmqApplication.checkPermission(path, "read");
		RabbitmqApplication.checkPermission(path, "write");
		LOGGER.info("======================================================");
		Path tempFile = Files.createTempFile("hello", ".file");
		RabbitmqApplication.checkPermission(tempFile.toString(), "read");
		RabbitmqApplication.checkPermission(tempFile.toString(), "write");
		Files.deleteIfExists(tempFile);
		LOGGER.info("======================================================");
		path = RabbitmqApplication.class.getResource("").getPath();
		RabbitmqApplication.checkPermission(path, "read");
		RabbitmqApplication.checkPermission(path, "write");
		LOGGER.info("======================================================");
		path = "/home/ricardocamargo/repository/pocs/rabbitmq/target";
		RabbitmqApplication.checkPermission(path, "read");
		RabbitmqApplication.checkPermission(path, "write");
		LOGGER.info("======================================================");
		path = "/home/ricardocamargo/repository/pocs/rabbitmq";
		RabbitmqApplication.checkPermission(path, "read");
		RabbitmqApplication.checkPermission(path, "write");
		LOGGER.info("======================================================");

		SpringApplication.run(RabbitmqApplication.class, args);
	}
	
	public static void checkPermission(final String path, final String action) {
		SecurityManager securityManager = System.getSecurityManager();
		try {
			if(securityManager != null) {
				securityManager.checkPermission(new FilePermission(path, action));
			}			
			LOGGER.info("'{}' can {}: yes", path, action);
		} catch (Exception e) {
			LOGGER.info("'{}' can {}: no", path, action);
			LOGGER.error(e.getMessage());
		}
	}

}
