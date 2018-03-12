package org.spring.tutorial.examples.core.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("myAccountServiceApi")
/*
 * @Lazy(true)
 * the bean will only be loaded with the spring context if it has been called
 */
public class AccountServices {

	@Autowired
	/*
	 * @Autowired(required=true)
	 * throws exception if the bean does not exist
	 * default value of required is false
	 */
	/*
	 * we have 2 beans of the same type AccountRepository. the solution is to use
	 * the qualifier annotation and give it the full name of the bean to use
	 */
	@Qualifier("jdbcAccountRepository")
	AccountRepository accountRepository;
	
	public long returnHowMuchDoIHave(){
		
		return accountRepository.getContent();
	}
	/*
	 * the second solution is to use the name of the bean as field . spring will
	 * search for a unique bean that implements your interface then he will try with @Qualifier
	 * finally he will look for a bean which its id is the name of the field mentioned in your code
	 * 
	 * @Autowired
	 * AccountRepository jdbcAccountRepository;
	 */
}
