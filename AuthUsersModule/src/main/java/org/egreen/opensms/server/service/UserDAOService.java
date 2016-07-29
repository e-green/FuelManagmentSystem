package org.egreen.opensms.server.service;

import org.egreen.opensms.server.dao.UserDAOController;
import org.egreen.opensms.server.entity.User;
import org.egreen.opensms.server.models.MailMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
@Service
public class UserDAOService {

    @Autowired
    private UserDAOController userDAOController;

    @Autowired
    private AuthenticationController authenticationController;

    @Autowired
    private MailMail mailMail;

    /**
     *
     * User SignUp
     *
     * @param user
     * @return
     */
    public Long signup(User user) {
        long user_id = new Date().getTime();
        user.setUser_id(user_id);

        String password = authenticationController.getEncryptWord(user.getPassword());
        user.setPassword(password);
        String encryptWord = authenticationController.getEncryptWord(user.getEmail());

//        mailMail.sendMail("voco.egreen@gmail.com", user.getEmail(),
//                "(VOCO)Voice Of Community",
//                "http://192.168.1.8:63342/LoginSystem#/verify/"+encryptWord+"/"+user_id+"");
        Long aLong = userDAOController.create(user);
        return user_id;
    }

    /**
     *
     * Update Gender
     *
     * @param user_id
     * @param gender
     * @return
     */
    public Long set_gender(Long user_id, String gender) {
        User read = userDAOController.read(user_id);

        Long update = userDAOController.update(read);
        return update;
    }

    /**
     *
     * Update DOB
     *
     * @param user_id
     * @param dob
     * @return
     */
    public Long set_dob(Long user_id, String dob) {
        User read = userDAOController.read(user_id);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timestamp dateofbirth = new Timestamp(date.getTime());

        Long update = userDAOController.update(read);
        return update;
    }

    /**
     *
     * Check Email Validity
     *
     * @param email
     * @return
     */
    public User check_email_validity(String email) {
        User res = userDAOController.searchUserByEmail(email);
        return res;
    }

    /**
     *
     * Get All Details By User Id
     *
     * @param userId
     * @return
     */
    public User get_all_details_byUserId(Long userId) {
        return userDAOController.read(userId);
    }


    /**
     *
     * User Login
     *
     * @param email
     * @param password
     * @return
     */
    public User login(String email, String password) {
        String userPassword = authenticationController.getEncryptWord(password);

        User user = userDAOController.searchUserByEmail(email);

        User returnUser;

        if(userPassword.equals(user.getPassword())){

            returnUser =  userDAOController.login(email, userPassword);
        }else{
            returnUser = null;
        }
        return  returnUser;
    }

    /**
     *
     * Update User
     *
     * @param user
     * @return
     */
    public Long edit_user(User user) {
        return userDAOController.update(user);
    }


    /**
     *
     * Varify User Details
     *
     * @param varification_code
     * @param user_id
     * @return
     */
    public String varify_detail(String varification_code, Long user_id) {
        User user = userDAOController.varify_detail(varification_code, user_id);
        String encryptWord = authenticationController.getEncryptWord(user.getEmail());
        String value;
        if (varification_code.equals(encryptWord)) {
            value = "VALID";
                       userDAOController.update(user);
        } else {
            value = "NOT VALID";
        }
        return value;
    }

    /**
     *
     * Reset Password
     *
     * @param email
     * @return
     */
    public Integer reset_password(String email) {
        User user =userDAOController.reset_password(email);
        String new_password = randomString(5);
        mailMail.sendMail("egreendeveloperteam@gmail.com", user.getEmail(),
                "(Egreen Team)Things go Better",
                "Your New Password :"+new_password+"");
        String encryptWord = authenticationController.getEncryptWord(new_password);
        user.setPassword(encryptWord);
        userDAOController.update(user);
        return 5;
    }

    /**
     *
     * Random String
     *
     * @param len
     * @return
     */
    private String randomString(int len){
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    /**
     *
     * get_all_user_details
     *
     * @return
     */
    public List<User> get_all_user_details() {

       return userDAOController.getAll();
    }
}
