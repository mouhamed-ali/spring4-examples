package org.spring.tutorial.examples.core.jsr330;


import javax.inject.Inject;
import javax.inject.Named;

@Named
/*
 * this is a jsr330 annotation equivalent to @Component
 * you have to add the javax.inject dependency in the pom to use it
 */
public class AccountServices {

	@Inject
	AccountRepository jpaAccountRepository;
	
	/*
	 * we have two beans of type AccountRepository
	 * to use jdbcAccountRepository try this :
	 * @Inject
	 * AccountRepository jdbcAccountRepository;
	 * to use jpaAccountRepository try this :
	 * @Inject
	 * AccountRepository jpaAccountRepository;
	 */
	
	public long returnHowMuchDoIHave() {

		return jpaAccountRepository.getContent();
	}
}
