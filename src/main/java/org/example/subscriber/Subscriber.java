package org.example.subscriber;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Setter
@Accessors(chain = true)
@RedisHash(value = "Subscriber",timeToLive = 10)
public class Subscriber
{
	private Long id;
	@Indexed
	private Long phoneNumber;
	private SubscriptionType subscriptionType;
}
