package org.spring.tutorial.examples.core.qualifier;

import org.springframework.stereotype.Component;

@Component
public class JdbcAccountRepository implements AccountRepository {

	public long getContent() {
		return 99;
	}

}
