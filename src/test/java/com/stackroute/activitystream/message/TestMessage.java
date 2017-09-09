package com.stackroute.activitystream.message;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.activitystream.dao.MessageDAO;
import com.stackroute.activitystream.model.Message;


public class TestMessage {
	private static AnnotationConfigApplicationContext context;
	private static MessageDAO messageDao;
	private static Message message;
	
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.stackroute.activitystream");
		context.refresh();
	messageDao=(MessageDAO)context.getBean("messageDao");
	}
	
@Test
	public void sendMessageTestCase()
	{
		Message message=new Message();
		
		message.setId((int)(Math.random()*100000));
		message.setMessageContent("Hi How are you");
		message.setMessageTime(new Date());
		message.setMessageType("Text");
		message.setRecieverId("harsha@gmail.com");
		message.setSenderId("raju@gmail.com");
		
		
		
		assertEquals("success",true,messageDao.sendMessage(message));
		
		
	}
	
	
	

	
	
	
//@Test
	public void inBoxTestCase()
	{
		
		
		for(Message msg:messageDao.inBox("harsha@gmail.com"))
		{
			System.out.print("From "+msg.getSenderId());
			System.out.print(" message:  "+msg.getMessageContent());
			
			//System.out.print(" To "+msg.getRecieverId());
			System.out.println(" at "+msg.getMessageTime());
			
		}
	}
	
	
//@Test
		public void circleInBoxTestCase()
		{
			
			
			for(Message msg:messageDao.circleInBox(40159))
			{
				System.out.print("From "+msg.getSenderId());
				System.out.print(" message:  "+msg.getMessageContent());
				
				//System.out.print(" To "+msg.getRecieverId());
				System.out.println(" at "+msg.getMessageTime());
				
			}
		}
}
