package lt2020.sveikinimai.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import lt2020.sveikinimai.entities.Place;

public interface DBPlaceDao extends JpaRepository<Place, String>, PlaceDao {
	default Set<Place> getPlace() {

		return (Set<Place>) this.findAll();

	}

	default Place getPlace(String title) {

		return this.findById(title).orElse(null);

	}

	default void createPlace(Place place) {
		this.save(place);

	}

	default void updatePlace(Place place) {
		this.save(place);
	}

	default void deletePlace(String title) {
		this.deleteById(title);
	}

}
