package com.atrium.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmailProducer {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendEmail(final Email email) {
		System.out.println("Sending Email");
		jmsTemplate.convertAndSend(email);

	}
}
