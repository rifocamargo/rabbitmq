//package br.com.lecom.rabbitmq.config;
//
//import org.springframework.amqp.core.AcknowledgeMode;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import br.com.lecom.rabbitmq.Receiver;
//
//@Configuration
//public class RabbitMQReceiverConfig {
//
//	@Bean
//	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, Receiver receiver, Queue[] queues) {
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.setAcknowledgeMode(AcknowledgeMode.AUTO);
//		container.setQueues(queues);
//		container.setMessageListener(receiver);
//		return container;
//	}
//}
