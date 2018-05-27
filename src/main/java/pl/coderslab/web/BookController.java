package pl.coderslab.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

@Controller
@RequestMapping("/book")
public class BookController {

	private final BookDao bookDao;

	public BookController(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("books", bookDao.getAll());
		
		Book book = bookDao.findById(1);
		List<Author> authors = book.getAuthors();
		
		return "book/list";
	}

}
