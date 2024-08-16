package br.com.lecom.rabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/header")
public class RabbitMQHeaderWebController {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@PostMapping(value = "/producer")
	public String producer(@RequestParam("consomer") String consomer) {

		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setHeader("consomer", consomer);
		MessageConverter messageConverter = new SimpleMessageConverter();
		Message message = messageConverter.toMessage("RabbitMQHeaderMessage", messageProperties);
		amqpTemplate.send("header-exchange", "", message);

		return "Message sent to the RabbitMQ Header Exchange Successfully";
	}
}