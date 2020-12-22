package lt2020.sveikinimai.dao;

import java.util.Set;

import lt2020.sveikinimai.entities.Place;

public interface PlaceDao {

	Set<Place> getPlace();

	Place getPlace(Long id);

	void createPlace(Place place);

	void updatePlace(Place place);

	void deletePlace(Long id);

}
