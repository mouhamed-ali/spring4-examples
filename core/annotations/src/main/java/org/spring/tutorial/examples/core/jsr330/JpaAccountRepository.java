package org.spring.tutorial.examples.core.jsr330;

import javax.inject.Named;

@Named
public class JpaAccountRepository implements AccountRepository {

	public long getContent() {
		return 0;
	}

}
