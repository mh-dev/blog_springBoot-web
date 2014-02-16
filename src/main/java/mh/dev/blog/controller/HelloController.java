package mh.dev.blog.controller;

import java.util.List;

import mh.dev.blog.model.Word;
import mh.dev.blog.service.WordService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "hello")
public class HelloController {

	@Autowired
	private WordService wordService;

	private Logger log = Logger.getLogger(HelloController.class);

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Word create(@RequestBody String text) {
		log.info(String.format("Try to add a Word with text %s to the database", text));
		Word word = wordService.byText(text);
		if (word == null) {
			word = wordService.createWord(text);
		}
		return word;
	}

	@RequestMapping
	@ResponseBody
	public List<Word> words() {
		log.info("Return all words");
		return wordService.all();
	}
}
