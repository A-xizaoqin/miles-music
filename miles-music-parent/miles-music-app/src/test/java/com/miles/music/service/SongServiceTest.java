package com.miles.music.service;

import com.miles.music.BaseTest;
import com.miles.music.core.request.SongSearchRequest;
import com.miles.music.core.service.SongService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Qimiao Chen
 * @since 2025/4/9 18:25
 **/

public class SongServiceTest extends BaseTest {

    @Autowired
    private SongService songService;

    @Test
    public void searchTest() {
        SongSearchRequest songSearchRequest = new SongSearchRequest();

        songService.search(songSearchRequest);
    }
}
