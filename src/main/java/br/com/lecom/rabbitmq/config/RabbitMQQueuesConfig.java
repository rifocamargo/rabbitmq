package br.com.lecom.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQQueuesConfig {

	@Bean
	Queue queue(ServerProperties serverProperties) {
		return new Queue("queue.consomer." + serverProperties.getPort(), false);
	}

}
