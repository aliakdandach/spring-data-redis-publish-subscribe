package org.example.subscriber;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * The type Subscriber service.
 */
@Log4j2
@Service
@AllArgsConstructor
public class SubscriberService
{
	private final SubscriberRepository subscriberRepository;

	/**
	 * Add subscriber.
	 *
	 * @param subscriberId     the subscriber id
	 * @param phoneNumber      the phone number
	 * @param subscriptionType the subscription type
	 */
	public void addSubscriber(long subscriberId, long phoneNumber, SubscriptionType subscriptionType)
	{
		subscriberRepository.save(new Subscriber().setId(subscriberId).setPhoneNumber(phoneNumber).setSubscriptionType(subscriptionType));
	}

	/**
	 * Gets subscriber.
	 *
	 * @param subscriberId the subscriber id
	 * @return the subscriber
	 */
	public Subscriber getSubscriber(Long subscriberId)
	{
		return subscriberRepository.findByPhoneNumber(subscriberId).orElseThrow(SubscriberNotFoundException::new);
	}
}
