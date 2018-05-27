package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

@Component
@Transactional
public class PublisherDao {

	@PersistenceContext
	EntityManager entityManager;
	
	public void save(Publisher entity) {
		entityManager.persist(entity);
	}

	public Publisher findById(long id) {		
		return entityManager.find(Publisher.class, id);
	}
	//https://vladmihalcea.com/the-hibernate-enable_lazy_load_no_trans-anti-pattern/
	public Publisher findByIdWithBooks(long id) {
		Publisher publisher = entityManager.find(Publisher.class, id);
		Hibernate.initialize(publisher.getBooks());
		return publisher;
	}
	
	
	public List<Publisher> getAll() {
		Query query = entityManager.createQuery("SELECT p FROM Publisher p");
		return query.getResultList();
	}


}