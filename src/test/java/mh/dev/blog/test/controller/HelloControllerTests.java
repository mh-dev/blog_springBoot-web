package mh.dev.blog.test.controller;

import java.util.List;

import mh.dev.blog.Application;
import mh.dev.blog.controller.HelloController;
import mh.dev.blog.model.Word;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@WebAppConfiguration
@ActiveProfiles(value = "test")
@Transactional
@TransactionConfiguration(defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
public class HelloControllerTests {

	@Autowired
	private HelloController helloController;

	@Test
	public void addTest() {
		Assert.assertEquals(0, helloController.words().size());
		Word word = helloController.create("hello");
		List<Word> words = helloController.words();
		Assert.assertEquals(1, words.size());
		Word actual = words.get(0);
		Assert.assertEquals(word.getId(), actual.getId());
		Assert.assertEquals(word.getText(), actual.getText());
	}

	@Test
	public void addTestMultiple() {
		Assert.assertEquals(0, helloController.words().size());
		helloController.create("hello1");
		helloController.create("hello2");
		List<Word> words = helloController.words();
		Assert.assertEquals(2, words.size());
	}
}
