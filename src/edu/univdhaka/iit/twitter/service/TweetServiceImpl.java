package edu.univdhaka.iit.twitter.service;

import edu.univdhaka.iit.twitter.domain.Tweet;
import edu.univdhaka.iit.twitter.domain.User;
import edu.univdhaka.iit.twitter.repository.TwitterFactory;

import java.sql.Date;
import java.util.List;

/**
 * Created by Bazlur Rahman Rokon on 12/28/13.
 */
public class TweetServiceImpl implements TweetService {

    @Override
    public boolean postTweet(String tweetText, User postedBy) {
        System.out.println("postTweet() tweetText =" + tweetText + " by " + postedBy.getNaturalName());

        Tweet tweet = new Tweet();
        tweet.setId(TwitterFactory.getGeneratedTweetId());
        tweet.setTweetText(tweetText);
        tweet.setTimestamp(new Date(0));
        tweet.setTweetBy(postedBy);

        TwitterFactory.getTweetList().add(tweet);

        System.out.println("[ " + tweet.getId() + " ] = \"" + tweet.getTweetText() + "\" has been posted on " + tweet.getTimestamp().toString() + " by " + postedBy.getNaturalName());

        return true;
    }

    @Override
    public List<Tweet> findAllTweet(User user) {
        System.out.println("findAllTweet() by " + user.getNaturalName());

        List<Tweet> tweets = TwitterFactory.getTweetList();

        for (Tweet tweet : tweets) {
            if (!tweet.getTweetBy().equals(user)) {
                tweets.remove(tweet);
            }
        }
        return tweets;
    }
}
