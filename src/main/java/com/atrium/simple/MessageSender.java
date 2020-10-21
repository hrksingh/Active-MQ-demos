package com.atrium.simple;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {

	/*
	 * URL of the JMS server. DEFAULT_BROKER_URL will just mean that JMS server is
	 * on localhost
	 * 
	 * default broker URL is : tcp://localhost:61616"
	 */
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	private static String queueName = "MESSAGE_QUEUE";

	public static void main(String[] args) throws JMSException {
		System.out.println("url = " + url);

		/*
		 * Getting JMS connection from the JMS server and starting it
		 */
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();

		/*
		 * Creating a non transactional session to send/receive JMS message.
		 */
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createQueue(queueName);

		MessageProducer producer = session.createProducer(destination);
		TextMessage message = session.createTextMessage("Hi , How are you?");

		producer.send(message);

		System.out.println("Message '" + message.getText() + ", Sent Successfully to the Queue");


		connection.close();
	}
}