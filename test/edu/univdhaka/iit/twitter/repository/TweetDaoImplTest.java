package edu.univdhaka.iit.twitter.repository;

import java.sql.Date;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import edu.univdhaka.iit.twitter.domain.Tweet;
import edu.univdhaka.iit.twitter.domain.User;

public class TweetDaoImplTest {
	private static final String FIRST_NAME = "Tehzeeb";
	private static final String LAST_NAME = "Mimi";
	private static final String EMAIL_ADDRESS = "tasnim780@yahoo.com";
	private static final String PASSWORD = "abcdef";

	private String TWEET = "I posted a discussion, end of the stupid content tracker git\" can mean anything";

	private User user;
	private Tweet tweet;
	private TweetDao tweetDao;

	@Before
	public void setUp() throws Exception {
		System.out.println("TweetServiceImplTest setup");

		user = new User();

		user.setFirstName(FIRST_NAME);
		user.setLastName(LAST_NAME);
		user.setEmailAddress(EMAIL_ADDRESS);
		user.setPassword(PASSWORD);

		tweet = new Tweet();
		tweet.setTweetText(TWEET);
		tweet.setTimestamp(new Date(new java.util.Date().getTime()));
		tweet.setTweetBy(user);

		tweetDao = new TweetDaoImpl();
	}

	@Test
	public void createTest() {
		tweetDao.create(tweet);
	}
	public void testFindOne(){
		Tweet tweets=tweetDao.findOne(1);
		Assert.assertEquals(tweet, tweets);
	}
	@Test
	public void testFindAll(){
		tweetDao.findAll();
	}
	
	@Test
	public void testUpdate(){
		tweet.setTweetText("Success");
		tweet.setTimestamp(new Date(new java.util.Date().getTime()));
		user.setFirstName("Afsana");
		user.setLastName("Mimi");
		user.setEmailAddress("email@gmail.com");
		user.setPassword("afsana");
		tweet.setTweetBy(user);
		tweet.setId(1);
		tweetDao.update(tweet);
	}
	@Test
	public void testDelete(){
		tweetDao.delete(1);
	}

}
