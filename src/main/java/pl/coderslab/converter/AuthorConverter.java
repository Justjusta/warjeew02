package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.dao.AuthorsDao;
import pl.coderslab.entity.Author;

public class AuthorConverter implements Converter<String, Author> {
	
	@Autowired
	private AuthorsDao dao;

	public Author convert(String source) {
		Author group = dao.findById(Integer.parseInt(source));
		return group;
	}
}