package org.egreen.opensms.server.dao;

import org.egreen.opensms.server.entity.User;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
public interface UserDAOController extends DAOController<User,Long> {
    Integer check_email_validity(String email);

    User login(String username, String password);

    User varify_detail(String varification_code, Long user_id);


    User reset_password(String email);

    User searchUserByEmail(String email);
}
