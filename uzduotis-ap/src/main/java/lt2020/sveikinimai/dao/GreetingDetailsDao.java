package lt2020.sveikinimai.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lt2020.sveikinimai.entities.GreetingDetails;

public interface GreetingDetailsDao extends JpaRepository<GreetingDetails, Long> {

}
