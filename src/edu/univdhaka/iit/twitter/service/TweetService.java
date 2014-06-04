package edu.univdhaka.iit.twitter.service;

import edu.univdhaka.iit.twitter.domain.Tweet;
import edu.univdhaka.iit.twitter.domain.User;

import java.util.List;

/**
 * Created by Bazlur Rahman Rokon on 12/28/13.
 */
public interface TweetService {
    public boolean postTweet(String tweetText, User postedBy);

    public List<Tweet> findAllTweet(User user);
}
