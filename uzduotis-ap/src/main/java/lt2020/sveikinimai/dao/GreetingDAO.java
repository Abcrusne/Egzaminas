package lt2020.sveikinimai.dao;

import java.util.Set;

import lt2020.sveikinimai.entities.Greeting;

public interface GreetingDAO {

	Set<Greeting> getGreeting();

	Greeting getGreeting(Long id);

	void createGreeting(Greeting greeting);

	void updateGreeting(Greeting greeting);

	void deleteGreeting(Long id);

}
