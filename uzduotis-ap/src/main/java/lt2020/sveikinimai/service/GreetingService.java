package lt2020.sveikinimai.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt2020.sveikinimai.dao.DBGreetingDao;
import lt2020.sveikinimai.dao.GreetingDetailsDao;
import lt2020.sveikinimai.entities.Greeting;
import lt2020.sveikinimai.entities.GreetingDetails;
import lt2020.sveikinimai.model.CreateGreetingCommand;
import lt2020.sveikinimai.model.GreetingFromService;

@Service("greetingService")
public class GreetingService {

	@Autowired
	private DBGreetingDao dbGreetingDao;

	@Autowired
	private GreetingDetailsDao greetingDetailsDao;

	public GreetingService(DBGreetingDao dbGreetingDao, GreetingDetailsDao greetingDetailsDao) {
		super();
		this.dbGreetingDao = dbGreetingDao;
		this.greetingDetailsDao = greetingDetailsDao;
	}

	public DBGreetingDao getDbGreetingDao() {
		return dbGreetingDao;
	}

	public GreetingDetailsDao getGreetingDetailsDao() {
		return greetingDetailsDao;
	}

	public void setDbGreetingDao(DBGreetingDao dbGreetingDao) {
		this.dbGreetingDao = dbGreetingDao;
	}

	public void setGreetingDetailsDao(GreetingDetailsDao greetingDetailsDao) {
		this.greetingDetailsDao = greetingDetailsDao;
	}

	@Transactional(readOnly = true)
	public Set<GreetingFromService> getGreetings() {
		return dbGreetingDao.findAll().stream()
				.map(db -> new GreetingFromService(db.getId(), db.getText(), db.getImage(), db.getType(),
						db.getFirstname(), db.getLastname(), db.getTitle(), db.getGreetingDetails().getDate()))
				.collect(Collectors.toSet());

	}

	@Transactional
	public GreetingFromService getGreeting(Long id) {
		var greeting = dbGreetingDao.getGreeting(id);
		return new GreetingFromService(greeting.getId(), greeting.getText(), greeting.getImage(), greeting.getType(),
				greeting.getFirstname(), greeting.getLastname(), greeting.getTitle(),
				greeting.getGreetingDetails().getDate());
	}

	@Transactional
	public void createGreeting(CreateGreetingCommand greeting) {
		var greeting1 = new Greeting(greeting.getTitle(), greeting.getImage(), greeting.getText(), greeting.getType(),
				greeting.getFirstname(), greeting.getLastname());
		var greetingDetails = new GreetingDetails(greeting.getDate());
		var savedGreetingDetails = greetingDetailsDao.save(greetingDetails);
		greeting1.setGreetingDetails(savedGreetingDetails);
		dbGreetingDao.save(greeting1);
		// dbProductDao.createProduct(new Product(product.getTitle(),
		// product.getPrice(), product.getQuantity(), new
		// ProductDetails(product.getImage(), product.getDescription())));

	}

	@Transactional
	public void updateGreeting(GreetingFromService greeting) {
		var greeting1 = new Greeting(greeting.getTitle(), greeting.getImage(), greeting.getText(), greeting.getType(),
				greeting.getFirstname(), greeting.getLastname());
		var greetingDetails = new GreetingDetails(greeting.getDate());
		greeting1.setId(greeting.getId());
		greetingDetails.setId(greeting.getId());
		var savedGreetingDetails = greetingDetailsDao.save(greetingDetails);
		greeting1.setGreetingDetails(savedGreetingDetails);
		dbGreetingDao.updateGreeting(greeting1);

	}

	@Transactional
	public void deleteGreeting(Long id) {
		dbGreetingDao.deleteById(id);
	}

//	void deleteById(Long id);
//
//	Product findById(Long id);

}
