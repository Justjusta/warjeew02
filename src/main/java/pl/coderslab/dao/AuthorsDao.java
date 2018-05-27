package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import pl.coderslab.entity.Author;
import pl.coderslab.entity.Publisher;

@Component
@Transactional
public class AuthorsDao {

	@PersistenceContext
	EntityManager entityManager;
	
	public void save(Author entity) {
		entityManager.persist(entity);
	}

	public Author findById(long id) {		
		return entityManager.find(Author.class, id);
	}
	
	public List<Author> getAll() {
		Query query = entityManager.createQuery("SELECT a FROM Author a");
		return query.getResultList();
	}


}