package com.miles.music.com.miles.music.service.complex;

import com.miles.music.app.MilesMusicApplication;
import com.miles.music.core.service.complex.AlbumComplexService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Qimiao Chen
 * @since 2025/4/7 17:13
 **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MilesMusicApplication.class)
@Slf4j
public class AlbumComplexServiceTest {

    @Autowired
    private AlbumComplexService albumComplexService;

    @Test
    public void organizeAlbumsTest() {
        albumComplexService.organizeAlbums();
    }

}
