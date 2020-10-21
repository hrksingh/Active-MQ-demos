package com.atrium;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

	@Autowired
	MessageConverter messageConverter;

	@Autowired
	JmsTemplate jmsTemplate;

	public Email emailReceived() throws MessageConversionException, JMSException {
		Message message = jmsTemplate.receive();
		Email email = (Email) messageConverter.fromMessage(message);
		return email;

	}

}
