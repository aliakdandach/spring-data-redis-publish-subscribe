package org.example.subscriber;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber, Long>
{
	Optional<Subscriber> findByPhoneNumber(Long phoneNumber);
}