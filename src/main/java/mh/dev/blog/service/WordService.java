package mh.dev.blog.service;

import java.util.List;

import mh.dev.blog.model.Word;
import mh.dev.blog.repository.WordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {

	@Autowired
	private WordRepository repository;

	public Word createWord(String text) {
		Word word = new Word();
		word.setText(text);
		return repository.save(word);
	}

	public Word byText(String text) {
		return repository.findByText(text);
	}

	public List<Word> all() {
		return repository.all();
	}

}
