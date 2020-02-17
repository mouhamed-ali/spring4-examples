package org.spring.tutorial.examples.jpa.service;

import org.spring.tutorial.examples.jpa.domain.User;
import org.spring.tutorial.examples.jpa.exceptions.MyAppException;
import org.spring.tutorial.examples.jpa.exceptions.MyDataBaseException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * @Transactional
 * to make all methods transactional
 */
public interface IUserService {

	@Transactional
	/*
	 * to make the createUser transactional
	 * this method will be rolled back only if a runtime exception (unchecked exception) is thrown
	 * spring will not rolled back the transaction is a checked exception is thrown
	 */
	int createUser(User user, boolean generateException, boolean generateRuntimeException) throws Exception;
	
	@Transactional(
			rollbackFor={MyDataBaseException.class}
			,noRollbackFor={MyAppException.class}
	)
	/*
	 * the rollback will be executed if an exception of type MyDataBaseException is generated
	 * and it will not be executed if an exception of type MyDataBaseException is generated
	 */
	int updateUser(User user, boolean generateDBExc, boolean generateMyAppExc, boolean generateException) throws Exception;
	
	@Transactional(readOnly=true,isolation=Isolation.REPEATABLE_READ)
	/*
	 * we must annotate the methods that do not require transactions (which allow us to select data) with readOnly = true to improve the performance of the application
	 * isolation = Isolation.REPEATABLE_READ allows you to lock lines until the transaction completes its job
	 */
	User findUserById(long id);
	
	@Transactional(isolation=Isolation.READ_UNCOMMITTED)
	/*
	 * READ_UNCOMMITTED is one of the Isolations Levels. it allows to read the data that are not committed when executing getAll.
	 * READ_COMMITED : read the committed data (from database)
	 * REPEATABLE_READ isolation level states that if a transaction reads one record from the database multiple times the result of
	 * all those reading operations must always be the same.
	 * SERIALIZABLE : READ_COMMITED + REPEATABLE_READ + prevent phantom reads -->
	 > PHANTOM READS: Data getting changed in current transaction by other transactions is called Phantom Reads.
	 	New rows can be added by other transactions, so you get different number of rows by firing same query in current transaction.
		In REPEATABLE READ isolation levels Shared locks are acquired. This prevents data modification when other transaction is reading
	 	the rows and also prevents data read when other transaction are modifying the rows. But this does not stop INSERT operation which
	  	can add records to a table getting modified or read on another transaction. This leads to PHANTOM reads.
		PHANTOM reads can be prevented by using SERIALIZABLE isolation level, the highest level. This level acquires RANGE locks thus 
		preventing READ, Modification and INSERT operation on other transaction until the first transaction gets completed.
	 */
	List<User> getAll();
	
	@Transactional("transactionManager")
	/*
	 * we can specify the name of the transaction manager we want to use
	 */
	void removeById(long id, boolean generateRuntimeException);

	@Transactional("transactionManager")
	void removeByIdNewTransaction(long id, boolean generateRuntimeException);
}
