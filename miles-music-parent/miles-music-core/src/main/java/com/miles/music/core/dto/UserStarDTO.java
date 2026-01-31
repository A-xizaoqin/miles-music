package com.miles.music.core.dto;

import com.miles.music.core.enums.EnumUserStarType;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Qimiao Chen
 * @since 2025/4/2 17:48
 **/
@Setter
@Getter
public class UserStarDTO {

    private Long userId;
    /**
     * @see EnumUserStarType
     */
    private Integer starType;
    private Long relationId;
    private Long gmtCreate;
    private Long gmtModify;
}
