package lt2020.sveikinimai.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt2020.sveikinimai.dao.DBGreetingDao;
import lt2020.sveikinimai.entities.Greeting;
import lt2020.sveikinimai.model.GreetingFromService;

@Service("greetingService")
public class GreetingService {

//	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DBGreetingDao dbGreetingDao;

	public DBGreetingDao getDbGreetingDao() {
		return dbGreetingDao;
	}

	public void setDbGreetingDao(DBGreetingDao dbGreetingDao) {
		this.dbGreetingDao = dbGreetingDao;
	}

	@Transactional(readOnly = true)
	public Set<GreetingFromService> getGreetings() {
		return dbGreetingDao.findAll().stream()
				.map(greeting -> new GreetingFromService(greeting.getId(), greeting.getName(), greeting.getText(),
						greeting.getImage(), greeting.getAudio(), greeting.getType(), greeting.getDate()))
				.collect(Collectors.toSet());

	}

	@Transactional
	public GreetingFromService getGreeting(Long id) {
		var greeting = dbGreetingDao.findById(id).orElse(null);
		return new GreetingFromService(greeting.getId(), greeting.getName(), greeting.getText(), greeting.getImage(),
				greeting.getAudio(), greeting.getType(), greeting.getDate());
	}

	@Transactional
	public void createGreeting(GreetingFromService greeting) {

		var greeting1 = new Greeting(greeting.getName(), greeting.getText(), greeting.getImage(), greeting.getAudio(),
				greeting.getType(), greeting.getDate());

		dbGreetingDao.save(greeting1);

	}

	@Transactional
	public void updateGreeting(GreetingFromService greeting) {

		var updatedGreeting = dbGreetingDao.findById(greeting.getId()).orElse(null);

		updatedGreeting.setName(greeting.getName());
		updatedGreeting.setText(greeting.getText());
		updatedGreeting.setImage(greeting.getImage());
		updatedGreeting.setAudio(greeting.getAudio());
		updatedGreeting.setType(greeting.getType());
		updatedGreeting.setDate(greeting.getDate());

		dbGreetingDao.save(updatedGreeting);

	}

	@Transactional
	public void deleteGreeting(Long id) {
		dbGreetingDao.deleteById(id);
	}

//	@PostConstruct
//	private void postConstruct() {
//		Greeting greeting1 = new Greeting();
//
//		dbGreetingDao.save(greeting1);
//
//	}
//
//	@PreDestroy
//	public void preDestroy() {
//		dbGreetingDao
//	}

//	void deleteById(Long id);
//
//	Product findById(Long id);
//	@PostConstruct
//	public void init() {
//		log.info("Bean created, class:  " + getClass().getName() + ". Scope(default value): singleton");
//
//	}
//
//	@PreDestroy
//	public void destroy() {
//		log.info("Bean destroyed, class:  " + getClass().getName() + ". Scope(default value): singleton");
//	}
}
