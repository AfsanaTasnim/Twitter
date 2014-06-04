package edu.univdhaka.iit.twitter.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import edu.univdhaka.iit.twitter.domain.Tweet;
import edu.univdhaka.iit.twitter.domain.User;
import edu.univdhaka.iit.twitter.utils.DataConnectionPool;

public class TweetDaoImpl implements TweetDao {

	@Override
	public void create(Tweet tweet) {
		String query = "INSERT INTO Twitter "
				+ "(tweet_text, timestamp, tweet_by) " + "VALUES(?,?,?)";

		try {

			Connection connection = DataConnectionPool.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(query);

			preparedStatement.setString(1, tweet.getTweetText());
			preparedStatement.setDate(2, tweet.getTimestamp());
			preparedStatement
					.setString(3, tweet.getTweetBy().getEmailAddress());

			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Tweet findOne(int id) {
		String selectSQL="select * from Twitter where id=?";
		Tweet tweet=new Tweet();
		try {
			Connection dbConnection = DataConnectionPool.getConnection();
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(selectSQL);

			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				tweet.setId(rs.getInt(1));
				tweet.setTweetText(rs.getString(2));
				tweet.setTimestamp(rs.getDate(3));
				tweet.setTweetBy(new User());
				tweet.getTweetBy().setEmailAddress(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tweet;
	}

	@Override
	public List<Tweet> findAll() {
		String selectSQL="select * from Twitter";
		List<Tweet> allTweet =new ArrayList<>();
		try {
			Connection dbConnection = DataConnectionPool.getConnection();
			PreparedStatement preparedStatement = dbConnection
					.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Tweet tweet=new Tweet();
				tweet.setId(rs.getInt(1));
				tweet.setTweetText(rs.getString(2));
				tweet.setTimestamp(rs.getDate(3));
				tweet.setTweetBy(new User());
				tweet.getTweetBy().setEmailAddress(rs.getString(4));
				allTweet.add(tweet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return allTweet;

	}

	@Override
	public void delete(int id) {
		String deleteSQL = "DELETE from Twitter WHERE id = ?";
		PreparedStatement preparedStatement = null;
		try {
			Connection dbConnection = DataConnectionPool.getConnection();
			preparedStatement = dbConnection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Tweet tweet) {
		  try
		  {
		    // create our java preparedstatement using a sql update query
			  Connection conn = DataConnectionPool.getConnection();
			  PreparedStatement ps = conn.prepareStatement(
		      "UPDATE Twitter SET tweet_text = ?, timestamp = ?, tweet_by = ? WHERE id = ?");

		    // set the preparedstatement parameters
		    ps.setString(1,tweet.getTweetText());
		    ps.setDate(2,tweet.getTimestamp());
		    ps.setString(3,tweet.getTweetBy().getEmailAddress());
		    ps.setInt(4,tweet.getId());

		    // call executeUpdate to execute our sql update statement
		    ps.executeUpdate();
		    ps.close();
		  }
		  catch (SQLException se)
		  {
		    // log the exception
		    se.printStackTrace();
		  }
	}

}
