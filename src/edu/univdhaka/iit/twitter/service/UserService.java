package edu.univdhaka.iit.twitter.service;

import edu.univdhaka.iit.twitter.domain.User;

import java.util.List;

/**
 * Created by Bazlur Rahman Rokon on 12/28/13.
 */
public interface UserService {
    public boolean createNewUser(User user);

    public List<User> findAllUser();

}
