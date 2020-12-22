package lt2020.sveikinimai.service;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt2020.sveikinimai.dao.DBGreetingDao;
import lt2020.sveikinimai.dao.DBPlaceDao;
import lt2020.sveikinimai.entities.Place;
import lt2020.sveikinimai.model.CreatePlaceCommand;
import lt2020.sveikinimai.model.PlaceFromService;

@Service
public class PlaceService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DBPlaceDao dbPlacedao;

	@Autowired
	private DBGreetingDao dbGreetingDao;

	@Transactional(readOnly = true)
	public Set<Place> getPlace() {
		return dbPlacedao.getPlace();

	}

	public Place getPlace(String title) {

		return dbPlacedao.getPlace(title);

	}

	public void createPlace(CreatePlaceCommand cmd) {
		dbPlacedao.createPlace(new Place(cmd.getId(), cmd.getTitle(), cmd.getAddress(), cmd.getImage(),
				cmd.getPlaceType(), cmd.getGreeting()));

	}

	public void updatePlace(PlaceFromService p, String id) {
		if (dbPlacedao.findById(id).isPresent()) {
			var place = new Place(p.getId(), p.getTitle(), p.getAddress(), p.getImage(), p.getPlaceType());
			dbPlacedao.updatePlace(place);
		}
	}

	public void deletePlace(String title) {
		dbPlacedao.deleteById(title);
	}
}
