package com.miles.music.core.service.complex;

import com.miles.music.core.dto.SearchResultDTO;
import com.miles.music.core.request.CommonSearchRequest;

/**
 * @author Qimiao Chen
 * @since 2025/4/10 21:39
 **/
public interface SearchService {

    SearchResultDTO search(CommonSearchRequest request);
}
