package lt2020.sveikinimai.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt2020.sveikinimai.dao.DBUserDao;
import lt2020.sveikinimai.entities.User;

//@ApiOperation(value = "UserService")
@Service
public class UserService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DBUserDao dbUserDao;

	@Transactional(readOnly = true)
	public List<User> getUsers() {
		log.debug("Inside getUsers() method");
		return dbUserDao.getUsers();

	}

	@Transactional
	public void createUser(User user) {
		log.debug("Inside createUser() method");
		dbUserDao.createUser(user);

	}

	@Transactional
	public void deleteUser(String username) {
		log.debug("Inside deleteUser() method");
		dbUserDao.deleteUser(username);

	}

//	@Transactional
//	public void deleteUserById(@PathVariable final Long id) {
//		dbUserDao.deleteById(id);
//	}

	// @RequestMapping("/findOldestUser")
	@Transactional
	public User findOldestUser() {
		return dbUserDao.findOldestUser();
	}

	@Transactional
	public User findByFirstnameAndLastname(String firstname, String lastname) {
		return dbUserDao.findByFirstnameAndLastname(firstname, lastname);
	}

	public DBUserDao getDbUserDao() {
		return dbUserDao;
	}

	public void setDbUserDao(DBUserDao dbUserDao) {
		this.dbUserDao = dbUserDao;
	}

//	@Autowired
//	private List<User> users;
//	@RequestMapping("/findUsersByName")
//	public User findByFirstnameAndLastname(String firstname, String lastname)
//
//	{
//		for (User user : users)
//			if (user.getFirstname().equals(firstname) && user.getLastname().equals(lastname)) {
//				return user;
//			}
//		return null;
	// }
//
//	@RequestMapping("/findOldestUser")
//	public User findOldestUser() {
//		return Collections.max(users, Comparator.comparingInt(u -> u.getAge()));
//	}
//	@RequestMapping(path = "/findUsersByName", method = RequestMethod.GET)
//	public User findUser(@RequestParam String firstname, @RequestParam String lastname) {
//		return userService.findByFirstnameAndLastname(firstname, lastname);
//	}
//
//	@RequestMapping(path = "/findOldestUser", method = RequestMethod.GET)
//	public User findOldestUser() {
//		return userService.findOldestUser();
//	}

}
