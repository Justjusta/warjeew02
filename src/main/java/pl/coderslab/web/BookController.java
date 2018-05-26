package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.dao.BookDao;

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
		return "book/list";
	}

}
