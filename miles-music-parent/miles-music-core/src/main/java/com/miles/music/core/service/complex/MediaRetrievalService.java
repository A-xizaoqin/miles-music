package com.miles.music.core.service.complex;

import com.miles.music.core.dto.CoverStreamDTO;
import com.miles.music.core.dto.SongStreamDTO;
import com.miles.music.core.io.local.LrcParser;


/**
 * @author Qimiao Chen
 * @since 2025/3/30 22:59
 **/
public interface MediaRetrievalService {


    CoverStreamDTO getSongCoverStreamDTO(Long songId, Integer size);

    CoverStreamDTO getAlbumCoverStreamDTO(Long albumId, Integer size);

    CoverStreamDTO getArtistCoverStreamDTO(Long artistId, Integer size);

    String getLyrics(String artistName, String songTitle);

    SongStreamDTO getSongStream(Long songId, Integer maxBitRate, String format, Boolean estimateContentLength);

    LrcParser.StructuredLyrics getLyricsBySongId(Long songId);

    SongStreamDTO getRawSongStream(Long songId);
}
