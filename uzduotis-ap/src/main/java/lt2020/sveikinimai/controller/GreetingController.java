package lt2020.sveikinimai.controller;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt2020.sveikinimai.entities.GreetingType;
import lt2020.sveikinimai.model.CreateGreetingCommand;
import lt2020.sveikinimai.model.GreetingFromService;
import lt2020.sveikinimai.service.GreetingService;

@RestController
@Api(value = "greetings")
@RequestMapping(value = "/api/greetings")
public class GreetingController {

	@Autowired
	private final GreetingService greetingService;

	@Autowired
	public GreetingController(GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get greetings", notes = "Returns all greetings")
	public Set<GreetingFromService> getGreetings() {
		return greetingService.getGreetings();
	}

	@RequestMapping(path = "/{greetingId}", method = RequestMethod.GET)
	@ApiOperation(value = "Get greeting", notes = "Returns greeting with specified id")
	public GreetingFromService getGreeting(@PathVariable final Long greetingId) {
		return greetingService.getGreeting(greetingId);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create greeting", notes = "Creates new greeting")
	public Set<GreetingFromService> createGreeting(@RequestBody final CreateGreetingCommand cmd) {
		greetingService.createGreeting(new GreetingFromService(cmd.getName(), cmd.getText(), cmd.getImage(),
				cmd.getAudio(), cmd.getType(), cmd.getDate()));
		return greetingService.getGreetings();
	}

	@RequestMapping(path = "/{greetingId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ApiOperation(value = "Update greeting", notes = "Updates greeting with specified id")
	public void updateGreeting(@PathVariable final Long greetingId, @RequestBody CreateGreetingCommand cmd) {

		String name = cmd.getName();
		String text = cmd.getText();
		String image = cmd.getImage();
		String audio = cmd.getAudio();
		GreetingType type = cmd.getType();
		Date date = cmd.getDate();

		var greeting = new GreetingFromService(greetingId, name, text, image, audio, type, date);
		greetingService.updateGreeting(greeting);

	}

	@RequestMapping(path = "/{greetingId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete greeting ", notes = "Deletes greeting with specified id")
	public void deleteGreeting(@PathVariable final Long greetingId) {
		greetingService.deleteGreeting(greetingId);
	}

//	@RequestMapping(path = "/test", method = RequestMethod.GET)
//	public String forTestPurposes() {
//		return "Hello";
//	}

}
