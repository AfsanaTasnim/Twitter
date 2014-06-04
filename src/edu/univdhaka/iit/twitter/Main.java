package edu.univdhaka.iit.twitter;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.univdhaka.iit.twitter.domain.Tweet;
import edu.univdhaka.iit.twitter.domain.User;
import edu.univdhaka.iit.twitter.repository.TweetDaoImpl;
import edu.univdhaka.iit.twitter.service.TweetService;
import edu.univdhaka.iit.twitter.service.TweetServiceImpl;
import edu.univdhaka.iit.twitter.service.UserService;
import edu.univdhaka.iit.twitter.service.UserServiceImpl;

/**
 * All the tweets are generated from
 * http://yes.thatcan.be/my/next/tweet/
 */

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        TweetService tweetService = new TweetServiceImpl();
        TweetDaoImpl tweetDao=new TweetDaoImpl();
        User user = new User();
        user.setFirstName("Bazlur");
        user.setLastName("Rahman");
        user.setEmailAddress("anm_brr@yahoo.com");
        user.setPassword("Bd647#td");
        userService.createNewUser(user);

        String[] tweets = {"I posted a discussion, end of the stupid content tracker git\" can mean anything, ",
                "PaaS Review : Looking for a programmer are; impatience, laziness.",
                "Ok I'm currently taking notes. Check out the finest software development. It forces you learn and.",
                "à¦†à¦œ à¦¶à¦°à¦¤à§‡à¦° à¦ªà§�à¦°à¦¥à¦® à¦¦à¦¿à¦¨, à¦�à¦–à¦¨à¦¿ à¦†à¦•à¦¾à¦¶à§‡ à¦¨à§€à¦²à§‡à¦° à¦®à¦¾à¦�à§‡ à¦¶à¦¾à¦¦à¦¾ à¦®à§‡à¦˜à§‡à¦° à¦›à§�à¦Ÿà§‹à¦›à§�à¦Ÿà¦¿ à¦¶à§�à¦°à§� à¦¨à¦¾ à¦¹à¦¤à§‡à¦‡ à¦¶à§‡à¦· à¦¹à§Ÿà§‡ à¦—à§‡à¦²à§‡à¦¾ à¦¬à§‡à§œà¦¾à¦²... !!",
                "Java gives you, the motto, your lifetime. "};

        for (String tweet : tweets) {
            tweetService.postTweet(tweet, user);
        }
        
        User user1 = new User();
        user1.setFirstName("Twitter");
        user1.setLastName("Robot");
        user1.setEmailAddress("robot@yahoo.com");
        user1.setPassword("Bd647#td");
        userService.createNewUser(user1);

        String[] tweets2 = {
                "JBoss Application Server renaming.... requests for kids...: A brief introduction of a CV like sticky.",
                "Just Rayhanur Rahman & Django :P :| ... : Rayhanur Rahman is almost done!!",
                "An article on cloud . works fine.. ! Ubuntu 13.04 will be great fun, I should be well... interesting.",
                "Java pundits will buy JRebel. I can..",
                "Every foreign language you really make use G+.  guys got skills... Guys, get a concurrency.",
                "Android - random... A book recommendation, one and ... grrr : Another day just animal names .. $6.2?",
                "The three attributes of lambda expressions and Me of the stupid content tracker git\" can you program...",
                "How to have been... I can exchange my talents and even shapes the latest Java Executing Linux Mint, if.",
                "Check out Birds Puzzle on Google Play How Remove Duplicate Rows from Java EE EAR with Dracula Theme, just?",
                "The answer is, Nothing. I thought, it was only be in bugs. A trivial exception was so easy to learn!",
                "Funny Indeed !!! Executing Linux.",
                "Things get some fresh entertainment, start reading linux kernel code, specially... know that have any.",
                "Loved it. if you please explain it a little about cutting off their development time, try Spring MVC 2nd."
        };

        for (String tweet : tweets2) {
            tweetService.postTweet(tweet, user1);
        }
        

    }
}
