package com.atrium.async;

import javax.jms.JMSException;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.support.converter.MessageConversionException;

public class EmailConsumerRunner {
	public static void main(String[] args) throws InterruptedException, MessageConversionException, JMSException {
		ConfigurableApplicationContext context = SpringApplication.run(ActiveMq.class, args);
		EmailConsumer ec = context.getBean(EmailConsumer.class);
		Email emailReceived = ec.emailReceived();
		System.out.println(emailReceived);
		context.close();
	}

}
