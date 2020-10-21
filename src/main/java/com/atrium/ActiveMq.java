package com.atrium;

import javax.jms.JMSException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.support.converter.MessageConversionException;

@SpringBootApplication
public class ActiveMq {

	public static void main(String[] args) throws InterruptedException, MessageConversionException, JMSException {
		ConfigurableApplicationContext context = SpringApplication.run(ActiveMq.class, args);
		EmailProducer ep = context.getBean(EmailProducer.class);
		ep.sendEmail(new Email("abc@to.com", "xyz@from.com", "hello I am sending message through ActiveMQ"));
		System.out.println("Message Sent Successfully");
		context.close();

	}

}
