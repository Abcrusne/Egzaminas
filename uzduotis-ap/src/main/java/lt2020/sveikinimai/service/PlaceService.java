package lt2020.sveikinimai.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt2020.sveikinimai.dao.DBGreetingDao;
import lt2020.sveikinimai.dao.DBPlaceDao;
import lt2020.sveikinimai.entities.Place;
import lt2020.sveikinimai.model.PlaceFromService;

@Service
public class PlaceService {

	// private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DBPlaceDao dbPlacedao;

	@Autowired
	private DBGreetingDao dbGreetingDao;

	@Transactional(readOnly = true)
	public Set<PlaceFromService> getPlaces() {

		return dbPlacedao.findAll().stream()
				.map(p -> new PlaceFromService(p.getId(), p.getTitle(), p.getAddress(), p.getImage(), p.getPlaceType()))
				.collect(Collectors.toSet());
	}

	public PlaceFromService getPlace(long id) {
		var place = dbPlacedao.findById(id).orElse(null);
		return new PlaceFromService(place.getId(), place.getTitle(), place.getAddress(), place.getImage(),
				place.getPlaceType());

	}

	public void createPlace(PlaceFromService p) {

		dbPlacedao.save(new Place(p.getTitle(), p.getAddress(), p.getImage(), p.getPlaceType()));

	}

	public void updatePlace(PlaceFromService p, Long id) {
		if (dbPlacedao.findById(id).isPresent()) {
			var place = new Place(p.getTitle(), p.getAddress(), p.getImage(), p.getPlaceType());
			dbPlacedao.save(place);
		}
	}

	public void deletePlace(long id) {
		dbPlacedao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public List<PlaceFromService> getPlacesByName(String title) {
		List<Place> placesByTitle = dbPlacedao.findByTitleFragment(title);
		return placesByTitle.stream().map(place -> new PlaceFromService(place.getId(), place.getTitle(),
				place.getAddress(), place.getImage(), place.getPlaceType())).collect(Collectors.toList());
	}

	public DBPlaceDao getDbPlacedao() {
		return dbPlacedao;
	}

	public DBGreetingDao getDbGreetingDao() {
		return dbGreetingDao;
	}

	public void setDbPlacedao(DBPlaceDao dbPlacedao) {
		this.dbPlacedao = dbPlacedao;
	}

	public void setDbGreetingDao(DBGreetingDao dbGreetingDao) {
		this.dbGreetingDao = dbGreetingDao;
	}

}
