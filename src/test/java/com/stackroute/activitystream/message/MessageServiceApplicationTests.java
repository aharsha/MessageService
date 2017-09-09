package com.stackroute.activitystream.message;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.activitystream.dao.MessageDAO;
import com.stackroute.activitystream.model.Message;




@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT,classes=MessageServiceApplication.class)

public class MessageServiceApplicationTests {

	@Autowired
	MessageDAO messageDao;
	
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
		message.setTag("wish");
		
		
		
		assertEquals("success",true,messageDao.sendMessage(message));
		
		
	}

}
