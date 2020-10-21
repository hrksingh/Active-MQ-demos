package com.atrium.async;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer implements MessageListener {

	@Autowired
	MessageConverter messageConverter;

	@Autowired
	JmsTemplate jmsTemplate;

	public Email emailReceived() throws MessageConversionException, JMSException {
		Message message = jmsTemplate.receive();
		Email email = (Email) messageConverter.fromMessage(message);
		return email;

	}

	@Override
	public void onMessage(Message message) {
		System.out.println(" \r\n"
				+ "  __  __                                  ____               _               _ \r\n"
				+ " |  \\/  | ___  ___ ___  __ _  __ _  ___  |  _ \\ ___  ___ ___(_)_   _____  __| |\r\n"
				+ " | |\\/| |/ _ \\/ __/ __|/ _` |/ _` |/ _ \\ | |_) / _ \\/ __/ _ \\ \\ \\ / / _ \\/ _` |\r\n"
				+ " | |  | |  __/\\__ \\__ \\ (_| | (_| |  __/ |  _ <  __/ (_|  __/ |\\ V /  __/ (_| |\r\n"
				+ " |_|  |_|\\___||___/___/\\__,_|\\__, |\\___| |_| \\_\\___|\\___\\___|_| \\_/ \\___|\\__,_|\r\n"
				+ "                             |___/                                             \r\n"
				+ "");
		
		try {
			Email email = (Email) messageConverter.fromMessage(message);
			System.out.println(email);
		} catch (MessageConversionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
