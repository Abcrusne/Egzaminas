
package lt2020.sveikinimai;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath*:application-context.xml" })
public class AppConfig {

//	@Bean
//	@Scope(value = "singleton")
//	public Greeting myBean() {
//		return new Greeting();
	// }
}