package lt2020.sveikinimai.controller;

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
	@ApiOperation(value = "Get greetingss", notes = "Returns all greetingss")
	public Set<GreetingFromService> getGreetings() {
//		return productService.getProducts().stream()
//				.map(productIsServiso -> new ProductFromService(productIsServiso.getTitle(),
//						productIsServiso.getImage(), productIsServiso.getDescription(), productIsServiso.getPrice(),
//						productIsServiso.getQuantity(),
//						productIsServiso.getId()))
//				.collect(Collectors.toSet());
		return greetingService.getGreetings();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Get greeting", notes = "Returns greeting with specified id")
	public GreetingFromService getGreetingt(@PathVariable final Long id) {
		return greetingService.getGreeting(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create greeting", notes = "Creates new greeting")
	public void createProduct(@RequestBody final CreateGreetingCommand cmd) {
		greetingService.createGreeting(cmd);

	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ApiOperation(value = "Update greeting", notes = "Updates greeting with specified id")
	public void updateGreeting(@PathVariable Long id, @RequestBody CreateGreetingCommand cmd) {

		String text = cmd.getText();
		String image = cmd.getImage();
		String type = cmd.getType();
		String firstname = cmd.getFirstname();
		String lastname = cmd.getLastname();
		String title = cmd.getTitle();

		var greeting = new GreetingFromService(id, text, image, type, firstname, lastname, title);
		greetingService.updateGreeting(greeting);

	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete greeting ", notes = "Deletes greeting with specified id")
	public void deleteGreeting(@PathVariable final Long id) {
		greetingService.deleteGreeting(id);
	}

}
