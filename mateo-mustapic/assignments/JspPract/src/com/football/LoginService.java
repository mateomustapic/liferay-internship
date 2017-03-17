package com.football;

import java.util.HashMap;

/**
 * Created by Mateo on 3/17/2017.
 */
public class LoginService {

    HashMap<String , String> users = new HashMap<String, String>();

    public LoginService(){
        users.put("mateo", "MATEO MUSTAPIC");
        users.put("marko","MARKO CIKOS");
        users.put("kreso","KRESIMIR COKO");
        users.put("matea","MATEA PJANIC");
    }

    public boolean authenticate(String userId, String password){
        if (password == null || password.trim() == ""){
            return false;
        }
        return true;
    }
    public Users getUserDetails(String userId){
        Users user = new Users();
        user.setUserName(users.get(userId));
        return user;
    }

}
