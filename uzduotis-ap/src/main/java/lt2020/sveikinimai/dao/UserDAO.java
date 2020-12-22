package lt2020.sveikinimai.dao;

import java.util.List;

import lt2020.sveikinimai.entities.User;

public interface UserDAO {

	List<User> getUsers();

	void createUser(User user);

	void deleteUser(String username);

}
