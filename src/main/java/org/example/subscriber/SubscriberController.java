package org.example.subscriber;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * The type Subscriber controller.
 */
@RestController
@RequestMapping("/subscriber")
@AllArgsConstructor
public class SubscriberController
{
	private SubscriberService subscriberService;

	/**
	 * Gets subscriber.
	 *
	 * @param subscriberId the subscriber id
	 * @return the subscriber
	 */
	@GetMapping("/{subscriberId}")
	@HystrixCommand(fallbackMethod = "zikofallback")
	public Subscriber getSubscriber(@PathVariable Long subscriberId)
	{
		return subscriberService.getSubscriber(subscriberId);
	}

	/**
	 * Publish subscriber.
	 *
	 * @param publishSubscriberDto the publish subscriber dto
	 */
	@PostMapping
	public void publishSubscriber(@RequestBody PublishSubscriberDto publishSubscriberDto)
	{
		subscriberService.addSubscriber(publishSubscriberDto.getId(), publishSubscriberDto.getPhoneNumber(),
				publishSubscriberDto.getSubscriptionType());
	}
}
