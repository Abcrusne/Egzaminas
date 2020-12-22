package lt2020.sveikinimai.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt2020.sveikinimai.PagingData;
import lt2020.sveikinimai.entities.User;
import lt2020.sveikinimai.model.CreateUserCommand;
import lt2020.sveikinimai.service.UserService;

@RestController
@Api(value = "user")
@RequestMapping(value = "/api/users")
public class UserController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private UserService userService;
	private PagingData pagingData;

	@Autowired
	public UserController(UserService userService, PagingData pagingData) {
		this.userService = userService;
		this.pagingData = pagingData;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public PagingData getPagingData() {
		return pagingData;
	}

	public void setPagingData(PagingData pagingData) {
		this.pagingData = pagingData;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get users", notes = "Returns registered users")
	public List<User> getUsers() {
		pagingData.setLimit(10);
		log.debug("Inside getUsers() method");
		return userService.getUsers();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create user", notes = "Creates users with data")
	public void createUser(
			@ApiParam(value = "User Data", required = true) @Valid @RequestBody final CreateUserCommand cmd) {
		User user = new User(cmd.getUsername(), cmd.getFirstname(), cmd.getLastname(), cmd.getEmail(), cmd.getAge());
		userService.createUser(user);
		log.debug("Created user with username: " + user.getUsername());
		// System.out.println("Created user with username: " + user.getUsername());
	}

	/* Apdoros užklausas: DELETE /api/users/<vartotojas> */
	@RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete user", notes = "Deletes user by username")
	public void deleteUser(@PathVariable final String username) {
		userService.deleteUser(username);
		log.debug("Deleting user: " + username);
		// System.out.println("Deleting user: " + username);
	}

	@RequestMapping(path = "findUsers", method = RequestMethod.GET)
	public User findUser(@RequestParam String firstname, @RequestParam String lastname) {
		log.debug("Find user by Fisrtname and lastname : " + firstname + lastname);
		return userService.findByFirstnameAndLastname(firstname, lastname);
	}

	@RequestMapping(path = "/oldestUser", method = RequestMethod.GET)
	public User findOldestUser() {
		log.debug("Inside findOldestUser() method");
		return userService.findOldestUser();
	}

}
