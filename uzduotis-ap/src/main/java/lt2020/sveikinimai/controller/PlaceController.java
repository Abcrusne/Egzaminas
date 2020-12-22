package lt2020.sveikinimai.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lt2020.sveikinimai.entities.Place;
import lt2020.sveikinimai.model.CreatePlaceCommand;
import lt2020.sveikinimai.service.PlaceService;

@RestController
@Api(value = "places")
@RequestMapping(value = "/api/places")
public class PlaceController {

	@Autowired
	private PlaceService placeService;

	@Autowired
	public PlaceController(PlaceService placeService) {
		super();
		this.placeService = placeService;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get place", notes = "Returns all places")
	public Set<Place> getPlace() {

		return placeService.getPlace();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Get address by ID", notes = "Returns a single place by ID")
	public Place getPlace(@PathVariable String title) {
		return placeService.getPlace(title);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create place", notes = "Creates new place")
	public void createPlace(@RequestBody final CreatePlaceCommand cmd) {
		placeService.createPlace(cmd);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete place", notes = "deletes places by id")
	public void deletePlace(@ApiParam(value = "place id", required = true) @PathVariable final String title) {

		placeService.deletePlace(title);

	}
}
