package edu.univdhaka.iit.twitter.service;

import edu.univdhaka.iit.twitter.domain.Tweet;
import edu.univdhaka.iit.twitter.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Bazlur Rahman Rokon on 12/28/13.
 */
public class TweetServiceImplTest {
    private static final String FIRST_NAME = "Bazlur";
    private static final String LAST_NAME = "Rahman";
    private static final String EMAIL_ADDRESS = "anm_brr@yahoo.com";
    private static final String PASSWORD = "HXJD^%DAS";

    private String[] tweets = {"I posted a discussion, end of the stupid content tracker git\" can mean anything, ",
            "PaaS Review : Looking for a programmer are; impatience, laziness.",
            "Ok I'm currently taking notes. Check out the finest software development. It forces you learn and.",
            "আজ শরতের প্রথম দিন, এখনি আকাশে নীলের মাঝে শাদা মেঘের ছুটোছুটি শুরু না হতেই শেষ হয়ে গেলো বেড়াল... !!",
            "Java gives you, the motto, your lifetime. "};


    private TweetService tweetService;
    private UserService userService;
    private User user;

    @Before
    public void setUp() throws Exception {
        System.out.println("TweetServiceImplTest setup");

        tweetService = new TweetServiceImpl();
        userService = new UserServiceImpl();
        user = new User();

        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setEmailAddress(EMAIL_ADDRESS);
        user.setPassword(PASSWORD);

        userService.createNewUser(user);
    }

    @Test
    public void testPostTweet() throws Exception {
        for (String tweet : tweets) {
            boolean created = tweetService.postTweet(tweet, user);
            Assert.assertEquals(true, created);
        }
    }

    @Test
    public void testFindAllTweet() throws Exception {
        for (String tweet : tweets) {
            tweetService.postTweet(tweet, user);
        }
        List<Tweet> tweetList = tweetService.findAllTweet(user);
        Assert.assertEquals(tweetList.size(), tweets.length);
    }
}
