//package br.com.lecom.rabbitmq;
//
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
//import org.springframework.stereotype.Component;
//
//import com.rabbitmq.client.Channel;
//
//@Component
//public class Receiver implements ChannelAwareMessageListener {
//
//	@Override
//	public void onMessage(Message message, Channel channel) throws Exception {
//		System.out.println("Received <" + new String(message.getBody()) + ">");
//	}
//
//}
