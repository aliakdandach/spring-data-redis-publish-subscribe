package org.example.subscriber;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SubscriptionType
{
	MONTHLY(1, "Monthly"),
	WEEKLY(2, "Weekly");

	private int id;
	private String name;
}
