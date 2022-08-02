@Author: Bruce Kuo

This is JPA using Hibernate's implementation to do orm mapping.
Mysql does not support ref cursor but any select statement that return one or more rows can use getResultList() method to get the result set as a list.

Entity can be easily persist to the database table.
All calls are using sessionFactory's session, Session session = this.sessionFactory.getCurrentSession()
Note that sessionFactor implements EntityManagerFactory but the interfaces are quite similar.

To select, insert, update and delete, the syntax is not quite like SQL as follows

		select all: session.createQuery("from Person") where sql will be like select * from Person so less verbal. 
		This is for HQL - Hibernate query language
		C: insert: session.persist(p)
		R: select by id: session.load(Person.class, new Integer(id))
		U: update: session.update(p)
		D: delete by id: session.delete(p);	
		
To run a stored procedure with no parameter, use syntax like

		Query query = session.createSQLQuery(
				"CALL get_all_persons()")
				.addEntity(Person.class);
		
To run a stored procedure with parameter, use syntax like

		Query query = session.createSQLQuery(
				"CALL get_that_person(:in_id)")
				.addEntity(Person.class)
				.setParameter("in_id", 6);


It is not limited to just CRUD operations and can be used for general purpose.

Out of Spring data JPA and Hibernate JPA, I prefer Hibernate JPA as it seems more powerful and much more flexible.

Hibernate JPA > Spring Data JPA using Hibernate > Raw JDBC > Spring Data JDBC

The end 


