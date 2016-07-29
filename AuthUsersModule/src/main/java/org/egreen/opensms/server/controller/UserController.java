package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.User;
import org.egreen.opensms.server.models.MailMail;
import org.egreen.opensms.server.service.AuthenticationController;
import org.egreen.opensms.server.service.UserDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by dewmal on 7/17/14.
 */
@Controller
@RequestMapping("fmms/auth/")
public class UserController {

    @Autowired
    private UserDAOService userDAOService;

    /**
     *
     * User SignUp
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "signup", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage signup(@RequestBody User user) {
        Long aLong = userDAOService.signup(user);
        ResponseMessage responseMessage = ResponseMessage.SUCCESS;
        responseMessage.setData(aLong);
        return ResponseMessage.SUCCESS;
    }

    /**
     *
     * User Update
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "update_user", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage edit_user(@RequestBody User user) {
        Long aLong = userDAOService.edit_user(user);
        ResponseMessage responseMessage = ResponseMessage.SUCCESS;
        responseMessage.setData(aLong);
        return responseMessage;
    }


/////////                                                                                                       ////////
///////////////////////////////////////////////////GET CONTROLLERS//////////////////////////////////////////////////////
/////////                                                                                                       ////////

    /**
     *
     * User Login
     *
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage login(@RequestParam("email") String email, @RequestParam("password") String password) {

        User res = userDAOService.login(email, password);
        ResponseMessage responseMessage;
        if(res != null){
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        }else{
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    /**
     *
     * Check Email Validity
     *
     * @param email
     * @return
     */
    @RequestMapping(value = "check_permision_level", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage check_email_validity(@RequestParam("email") String email) {
        User res = userDAOService.check_email_validity(email);
        ResponseMessage responseMessage;
        if(res != null){
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        }else{
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    /**
     *
     * Replace New Password
     *
     * @param email
     * @return
     */
    @RequestMapping(value = "reset_password", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage reset_password(@RequestParam("email") String email) {
        Integer res = userDAOService.reset_password(email);
        ResponseMessage responseMessage;
        if(res != null){
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        }else{
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    /**
     *
     * Varify Details
     *
     * @param varification_code
     * @param user_id
     * @return
     */
    @RequestMapping(value = "varify_details", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage varify_detail(@RequestParam("varification_code") String varification_code,@RequestParam("user_id")Long user_id) {
        //Integer res = userDAOService.check_email_validity(email);
        String res = userDAOService.varify_detail(varification_code,user_id);
        ResponseMessage responseMessage;
        if(res != null){
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        }else{
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    /**
     *
     * Get All User Details By User Id
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "get_all_user_details_by_userId", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage get_all_details_byUserId(@RequestParam("userId") Long userId) {
        User res = userDAOService.get_all_details_byUserId(userId);
        ResponseMessage responseMessage;
        if(res != null){
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        }else{
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;

    }

    /**
     *
     * Get All User Details
     *
     * @return
     */
    @RequestMapping(value = "get_all_user_details", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage get_all_user_details() {
        List<User> res = userDAOService.get_all_user_details();
        ResponseMessage responseMessage;
        if(res != null){
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        }else{
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    /**
     *
     *
     *
     *
     *
     * @param file
     * @return
     */
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(@RequestBody MultipartFile file){
        System.out.println("Name : "+file.getName());
        String name = "/home/pramoda-nf/Downloads/"+file.getName();

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + "!";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }



    @RequestMapping(value = "ob", method = RequestMethod.GET)
    @ResponseBody
    public User getob() {
        return new User();
    }


}
