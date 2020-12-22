package lt2020.sveikinimai.dao;

import java.util.Set;

import lt2020.sveikinimai.entities.Place;
import lt2020.sveikinimai.model.CreatePlaceCommand;

public interface PlaceDao {

	Set<Place> getPlace();

	Place getPlace(String title);

	void createPlace(CreatePlaceCommand place);

	void updatePlace(Place place);

	void deletePlace(String title);

	void updateGreeting(CreatePlaceCommand cmd);

}
