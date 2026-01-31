package com.miles.music.core.service.complex;

import com.miles.music.core.dto.ComplexPlaylistDTO;
import com.miles.music.core.request.UpdatePlaylistRequest;
import jakarta.annotation.Nullable;

import java.util.List;

/**
 * @author Qimiao Chen
 * @since 2025/4/4 20:52
 **/
public interface PlaylistComplexService {


    List<ComplexPlaylistDTO> queryComplexPlaylist(List<Long> playlistIds, @Nullable Long userId);

    Long createOrUpdatePlaylist(Long playlistId, String name, Long songId, Long userId);

    void deletePlaylistByPlaylistId(Long playlistId);

    void updatePlaylist(UpdatePlaylistRequest updatePlaylistRequest);

    void deleteItemsBySongIds(List<Long> songIds);
}
