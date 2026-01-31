package com.miles.music.core.service.complex;

import com.miles.music.core.dto.AlbumDTO;
import com.miles.music.core.dto.ComplexAlbumDTO;
import com.miles.music.core.request.AlbumSearchRequest;

import java.util.List;

/**
 * @author Qimiao Chen
 * @since 2025/4/7 16:35
 **/
public interface AlbumComplexService {


    void organizeAlbums();


    List<AlbumDTO> getAlbumList2(AlbumSearchRequest albumSearchRequest);

    List<AlbumDTO> searchAlbumByArtist(Long artistId);

    List<ComplexAlbumDTO> getComplexAlbumList2(AlbumSearchRequest albumSearchRequest);

}
