package org.spring.tutorial.examples.core.qualifier;

import org.springframework.stereotype.Component;

@Component
/*
 * @Component("jpaAccountRepositoryImpl")
 * we can use this annotation to change the name of the bean
 */
public class JpaAccountRepository implements AccountRepository {

	public long getContent() {
		return 0;
	}

}
