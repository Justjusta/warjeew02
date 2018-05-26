package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

@Controller
public class HomeController {

	@GetMapping("/")
	public String indexAction() {
		return "index";
	}

	@GetMapping("/testAction")
	@ResponseBody
	public String testAction() {
		return "testAction";
	}

	@Autowired
	private BookDao bookDao;

	@RequestMapping("/")
	@ResponseBody
	public String hello() {
				
		Book book = new Book();
		book.getPublisher();
			
	
		book.setTitle("Thinking in Java");
		bookDao.saveBook(book);
		return "Id dodanej książki to:" + book.getId();
	}

}