package pl.coderslab.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.AuthorsDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

@Controller
@RequestMapping("/book")
public class BookController {

	private final BookDao bookDao;
	private final PublisherDao publisherDao;
	private final AuthorsDao authorDao;

	public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorsDao authorDao) {
		this.bookDao = bookDao;
		this.publisherDao = publisherDao;
		this.authorDao = authorDao;
	}
	
	@ModelAttribute("publishers")
	public List<Publisher> getPublishers() {
	    return publisherDao.getAll();
	}
	@ModelAttribute("authors")
	public List<Author> getAuthors() {
	    return authorDao.getAll();
	}

	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("book", new Book());
		return "book/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(Model model,@ModelAttribute Book book) {
		bookDao.saveBook(book);
	    return "redirect:/book/list";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("books", bookDao.getAll());
		Book book = bookDao.findById(1);
		List<Author> authors = book.getAuthors();
		return "book/list";
	}
	
	@GetMapping("/edit/{id}")
	public String update(@PathVariable long id, Model model) {
		model.addAttribute("book", bookDao.findByIdWithAuthors(id));
		return "book/add";
	}

}
