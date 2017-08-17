package com.stackroute.activitystream.message;

import java.util.List;



public interface MessageDAO 
{

	boolean sendMessage(String reciever,Message message);
	boolean sendMessageCircle(int circleId,Message message);
	
	List<Message> inBox(String userId);
	List<Message> circleInBox(int circleId);
}
