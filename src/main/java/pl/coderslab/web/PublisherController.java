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
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("publisher", new Publisher());
		return "publisher/add";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable long id, Model model) {
		model.addAttribute("publisher", publisherDao.findById(id));
		return "publisher/add";
	}
	
	@ModelAttribute("languages")
	public List<String> checkOptions() {
	    String a[] = new String[] {"java", "php", "ruby", "python"};
	    return Arrays.asList(a);
	}

	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String processForm(Model model,@ModelAttribute Publisher publisher) {
	    publisherDao.save(publisher);
	    return "publisher/success";
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
