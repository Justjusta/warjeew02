package pl.coderslab.web;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

	private final PublisherDao publisherDao;

	public PublisherController(PublisherDao publisherDao) {
		this.publisherDao = publisherDao;
	}

	@GetMapping("/test")
	@ResponseBody
	public void testPublisher() {
		Publisher publisher1 = publisherDao.findByIdWithBooks(1);
		System.out.println(publisher1.toString());
		List<Book> books = publisher1.getBooks();
		for (Book b : books) {
			System.out.println(b.getTitle());
		}
	}
}
