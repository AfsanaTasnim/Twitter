package edu.univdhaka.iit.twitter.repository;

import java.util.List;

import edu.univdhaka.iit.twitter.domain.Tweet;

public interface TweetDao {
	public void create(Tweet tweet);

	public Tweet findOne(int id);

	public List<Tweet> findAll();

	public void delete(int id);

	public void update(Tweet tweet);

}
