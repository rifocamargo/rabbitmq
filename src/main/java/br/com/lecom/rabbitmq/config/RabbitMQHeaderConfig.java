package br.com.lecom.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQHeaderConfig {

	@Bean
	HeadersExchange headerExchange() {
		return new HeadersExchange("header-exchange");
	}

	@Bean
	Binding headerBinding(Queue queue, HeadersExchange headerExchange, ServerProperties serverProperties) {
		return BindingBuilder.bind(queue).to(headerExchange).where("consomer")
				.matches("consomer" + serverProperties.getPort());
	}

}