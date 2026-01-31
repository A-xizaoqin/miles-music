package com.miles.music.com.miles.music.service.complex;

import com.miles.music.app.MilesMusicApplication;
import com.miles.music.core.service.PlayHistoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Qimiao Chen
 * @since 2025/4/17 10:41
 **/
@SpringBootTest(classes = MilesMusicApplication.class)
public class PlayHistoryServiceTest {

    @Autowired
    private PlayHistoryService playHistoryService;

    @Test
    public void cleanPlayHistoryTest() {
        playHistoryService.cleanPlayHistory(24);
    }

}
