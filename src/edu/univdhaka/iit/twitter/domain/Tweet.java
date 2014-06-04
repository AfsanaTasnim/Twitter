package edu.univdhaka.iit.twitter.domain;

import java.sql.Date;


/**
 * Created by Bazlur Rahman Rokon on 12/28/13.
 */
public class Tweet {
    private int id;
    private String tweetText;
    private Date timestamp;
    private User tweetBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public User getTweetBy() {
        return tweetBy;
    }

    public void setTweetBy(User tweetBy) {
        this.tweetBy = tweetBy;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", tweetText='" + tweetText + '\'' +
                ", timestamp=" + timestamp +
                ", tweetBy=" + tweetBy +
                '}';
    }
}
