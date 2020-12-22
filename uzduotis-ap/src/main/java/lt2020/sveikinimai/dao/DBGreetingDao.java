package lt2020.sveikinimai.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lt2020.sveikinimai.entities.Greeting;

public interface DBGreetingDao extends JpaRepository<Greeting, Long>, GreetingDAO {

	default Set<Greeting> getProducts() {
		return (Set<Greeting>) this.findAll();
	}

	default Greeting getProduct(Long id) {
		return this.findById(id).orElse(null);

	}

	default void createGreeting(Greeting greeting) {
		this.save(greeting);
	}

//	@Modifying
//	@Query("update Product p SET p =:product"
	default void updateGreeting(Greeting greeting) {
		this.save(greeting);

	}

	default void deleteGreeting(Long id) {
		this.deleteById(id);
	}

//	@Modifying
//	@Query("delete p from Product p where p.id = :id")
//	void deleteById(Long id);

//	@Modifying
//	@Query("select p from Product p where p.id = :id")
//	Product findOneProductById(Long id);

	// Product getOne(Long id);

	@Query("select p from Greeting p where p.title like %:title%")
	Set<Greeting> getGreetingByTitle(@Param("title") String title);

	// Set<Greeting> findByTitle(String title);

	// {
//	 return this.findByTitle(title);
//	 }
//
//	
}
