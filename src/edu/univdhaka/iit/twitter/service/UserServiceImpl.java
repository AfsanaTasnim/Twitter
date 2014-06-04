package edu.univdhaka.iit.twitter.service;

import edu.univdhaka.iit.twitter.domain.User;
import edu.univdhaka.iit.twitter.repository.TwitterFactory;

import java.util.List;

/**
 * Created by Bazlur Rahman Rokon on 12/28/13.
 */
public class UserServiceImpl implements UserService {
    @Override
    public boolean createNewUser(User user) {
        System.out.println("createNewUser() new user = " + user);

        user.setId(TwitterFactory.getGeneratedUserId());
        TwitterFactory.getUserList().add(user);

        System.out.println("new user created successfully");
        return true;
    }

    @Override
    public List<User> findAllUser() {
        System.out.println("findAllUser()");

        return TwitterFactory.getUserList();
    }
}
