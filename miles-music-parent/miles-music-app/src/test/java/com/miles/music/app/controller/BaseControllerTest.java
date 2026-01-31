package com.miles.music.app.controller;

import com.miles.music.app.MilesMusicApplication;
import com.miles.music.app.request.subsonic.SubsonicRequest;
import com.miles.music.core.util.MD5Utils;
import com.miles.music.dao.DO.UserDO;
import com.miles.music.dao.repository.UserRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

/**
 * @author Qimiao Chen
 * @since 2025/4/9 16:42
 **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MilesMusicApplication.class)
@ActiveProfiles("test")
@Slf4j
public class BaseControllerTest {

    @Value("${qm.user.default.username}")
    private String username;;

    @Autowired
    private UserRepository userRepository;

    @SneakyThrows
    public <T extends SubsonicRequest> T generateAuthedSubsonicResponse(Class<T> clazz) {
        T subsonicRequest = clazz.getConstructor().newInstance();
        subsonicRequest.setU(username);
        UserDO userDO = userRepository.findByUsername(username);
        String salt = UUID.randomUUID().toString();
        subsonicRequest.setS(salt);
        String token = MD5Utils.md5(userDO.getPassword() + salt);
        subsonicRequest.setT(token);
        subsonicRequest.setV("1.12.0");
        subsonicRequest.setC("qm-music-client");
        return subsonicRequest;
    }
}
