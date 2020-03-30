package org.example.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class RedisMessageSubscriber implements MessageListener
{
	@Override
	public void onMessage(Message message, byte[] pattern)
	{
		System.out.println("Message received: " + message.toString() + " pattern " + new String(pattern));
	}
}
