package org.example.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.Executors;

@Configuration
public class RedisConfiguration
{
	//new PatternTopic("__key*__:*")
	@Bean
	public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory,
			MessageListenerAdapter messageListenerAdapter)
	{
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();

		container.setConnectionFactory(redisConnectionFactory);

		container.addMessageListener(messageListenerAdapter, new PatternTopic("__keyevent@0__:expired"));

		container.setTaskExecutor(Executors.newFixedThreadPool(10));

		return container;
	}

	@Bean
	public MessageListenerAdapter listenerAdapter(RedisMessageSubscriber redisMessageSubscriber)
	{
		return new MessageListenerAdapter(redisMessageSubscriber);
	}
}
