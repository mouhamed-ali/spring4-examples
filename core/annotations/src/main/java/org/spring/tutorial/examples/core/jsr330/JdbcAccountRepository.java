package org.spring.tutorial.examples.core.jsr330;

import javax.inject.Named;

@Named
public class JdbcAccountRepository implements AccountRepository {

	public long getContent() {
		return 99;
	}

}
