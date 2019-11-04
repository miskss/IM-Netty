package com.example.imnetty.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author peter
 * date: 2019-11-01 10:32
 **/
@Data
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 3885992367281012714L;

    private String uid;

    private String username;

    private String password;


    public UserVO convertTo(){
        UserVO userVO = new UserVO();
        userVO.setUid(this.uid);
        userVO.setUsername(this.username);
        return userVO;
    }

}
