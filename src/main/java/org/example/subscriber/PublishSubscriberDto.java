package org.example.subscriber;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublishSubscriberDto
{
	private Long id;
	private Long phoneNumber;
	private SubscriptionType subscriptionType;
}
