package br.com.lecom.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

	@Bean
	TopicExchange topicExchange() {
		return new TopicExchange("topic-exchange");
	}

//	@Bean
//	Binding topicBinding(Queue queue, TopicExchange topicExchange) {
//		return BindingBuilder.bind(queue).to(topicExchange).with(queue.getName());
//	}

	@Bean
	Binding topicBinding2(Queue queue, TopicExchange topicExchange) {
		return BindingBuilder.bind(queue).to(topicExchange).with("queue.#");
	}

	@Bean
	Binding topicBinding3(Queue queue, TopicExchange topicExchange) {
		return BindingBuilder.bind(queue).to(topicExchange).with("*.consomer.*");
	}

	@Bean
	Binding topicBinding4(Queue queue, TopicExchange topicExchange, ServerProperties serverProperties) {
		return BindingBuilder.bind(queue).to(topicExchange).with("*.*." + serverProperties.getPort());
	}

}