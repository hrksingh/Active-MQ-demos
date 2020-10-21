package com.atrium;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

@Configuration
@EnableJms
public class JmsConfig {

	private static final String EMAIL_QUEUE = "email_queue";

	@Bean
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL(ActiveMQConnection.DEFAULT_BROKER_URL);
		activeMQConnectionFactory.setTrustedPackages(Arrays.asList("com.atrium"));
		return activeMQConnectionFactory;

	}

	@Bean // Serialize message content to json using TextMessage
	public MessageConverter Converter() {
		return new SimpleMessageConverter();
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestinationName(EMAIL_QUEUE);
		return template;
	}

}
