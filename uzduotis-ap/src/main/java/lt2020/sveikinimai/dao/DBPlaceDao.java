package lt2020.sveikinimai.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lt2020.sveikinimai.entities.Place;

public interface DBPlaceDao extends JpaRepository<Place, Long> {

	@Query("select p from Place p where p.title like %?1%")
	List<Place> findByTitleFragment(String title);

	@Query("select p from Place p order by p.title asc")
	List<Place> findAll();

}
