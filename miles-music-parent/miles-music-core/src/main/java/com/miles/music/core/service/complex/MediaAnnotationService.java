package com.miles.music.core.service.complex;

import com.miles.music.core.dto.UserStarResourceDTO;

/**
 * @author Qimiao Chen
 * @since 2025/4/3 11:28
 **/
public interface MediaAnnotationService {

    UserStarResourceDTO getUserStarResourceDTO(Long userId);
}
