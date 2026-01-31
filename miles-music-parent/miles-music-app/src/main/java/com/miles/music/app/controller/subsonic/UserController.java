package com.miles.music.app.controller.subsonic;

import com.miles.music.app.constant.ServerConstants;
import com.miles.music.app.enums.EnumSubsonicErrorCode;
import com.miles.music.app.exception.SubsonicCommonErrorException;
import com.miles.music.app.request.subsonic.UserRequest;
import com.miles.music.app.response.subsonic.SubsonicResponse;
import com.miles.music.app.response.subsonic.SubsonicUser;
import com.miles.music.app.response.subsonic.UserResponse;
import com.miles.music.app.response.subsonic.UsersResponse;
import com.miles.music.app.util.WebUtils;
import com.miles.music.core.dto.UserDTO;
import com.miles.music.core.enums.EnumYesOrNo;
import com.miles.music.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Qimiao Chen
 * @since 2025/4/5
 **/
@RestController
@RequestMapping(value = "/rest")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser")
    public UserResponse getUser(String username) {
        UserDTO currentUser = WebUtils.currentUser();
        if(!currentUser.getUsername().equals(username) && !WebUtils.currentUserIsAdmin()) {
            throw new SubsonicCommonErrorException(EnumSubsonicErrorCode.E_50);
        }
        UserDTO userDTO = userService.findByUsername(username);
        SubsonicUser subsonicUser = SubsonicUser
                .builder().username(userDTO.getUsername()).email(userDTO.getEmail())
                        .adminRole(EnumYesOrNo.YES.getCode().equals(userDTO.getIsAdmin()))
                        .nickName(userDTO.getNickName())
                .forcePasswordChange(userDTO.getForcePasswordChange()).build();

        return new UserResponse(subsonicUser);
    }

    @RequestMapping(value = "/getUsers")
    public UsersResponse getUsers() {
        if(!WebUtils.currentUserIsAdmin()) {
            throw new SubsonicCommonErrorException(EnumSubsonicErrorCode.E_50);
        }
        List<UserDTO> allUsers = userService.findAllUsers();
        List<SubsonicUser> users = allUsers.stream().map(userDTO -> {
            SubsonicUser subsonicUser = SubsonicUser
                    .builder().username(userDTO.getUsername()).email(userDTO.getEmail())
                    .adminRole(EnumYesOrNo.YES.getCode().equals(userDTO.getIsAdmin()))
                    .nickName(userDTO.getNickName())
                    .forcePasswordChange(userDTO.getForcePasswordChange()).build();
            return subsonicUser;
        }).toList();

        return new UsersResponse(UsersResponse.Users.builder().users(users).build());
    }

    @RequestMapping(value = "/createUser")
    public SubsonicResponse createUser(UserRequest userRequest) {
        if(!WebUtils.currentUserIsAdmin()) {
            throw new SubsonicCommonErrorException(EnumSubsonicErrorCode.E_50);
        }
        com.miles.music.core.request.UserRequest request = new com.miles.music.core.request.UserRequest();
        request.setUsername(userRequest.getUsername());
        request.setEmail(userRequest.getEmail());
        request.setPassword(userRequest.getPassword());
        request.setIsAdmin(Boolean.TRUE.equals(userRequest.getIsAdmin())? EnumYesOrNo.YES.getCode() : EnumYesOrNo.NO.getCode());
        request.setNickName(userRequest.getNickName());
        userService.createUser(request);

        return ServerConstants.SUBSONIC_EMPTY_RESPONSE;
    }


    @RequestMapping(value = "/updateUser")
    public SubsonicResponse updateUser(UserRequest userRequest) {
        String username = userRequest.getUsername();
        UserDTO currentUser = WebUtils.currentUser();
        if(!currentUser.getUsername().equals(username) && !WebUtils.currentUserIsAdmin()) {
            throw new SubsonicCommonErrorException(EnumSubsonicErrorCode.E_50);
        }

        com.miles.music.core.request.UserRequest request = new com.miles.music.core.request.UserRequest();
        request.setUsername(userRequest.getUsername());
        request.setEmail(userRequest.getEmail());
        request.setPassword(userRequest.getPassword());
        request.setIsAdmin(Boolean.TRUE.equals(userRequest.getIsAdmin())? EnumYesOrNo.YES.getCode() : EnumYesOrNo.NO.getCode());
        request.setNickName(userRequest.getNickName());
        userService.updateUser(request);
        return ServerConstants.SUBSONIC_EMPTY_RESPONSE;
    }

    @RequestMapping(value = "/deleteUser")
    public SubsonicResponse deleteUser (@RequestParam String username) {
        UserDTO currentUser = WebUtils.currentUser();
        if(!currentUser.getUsername().equals(username) && !WebUtils.currentUserIsAdmin()) {
            throw new SubsonicCommonErrorException(EnumSubsonicErrorCode.E_50);
        }
        userService.delByUsername(username);

        return ServerConstants.SUBSONIC_EMPTY_RESPONSE;
    }

    @RequestMapping(value = "/changePassword")
    public SubsonicResponse changePassword (@RequestParam String username,
                                @RequestParam String password) {
        UserDTO currentUser = WebUtils.currentUser();
        if(!currentUser.getUsername().equals(username) && !WebUtils.currentUserIsAdmin()) {
            throw new SubsonicCommonErrorException(EnumSubsonicErrorCode.E_50);
        }
        userService.changePassword(username, password);
        return ServerConstants.SUBSONIC_EMPTY_RESPONSE;
    }


}
