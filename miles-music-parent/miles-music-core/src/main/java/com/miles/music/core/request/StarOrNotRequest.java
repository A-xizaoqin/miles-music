package com.miles.music.core.request;

import com.miles.music.core.enums.EnumStarActionType;
import com.miles.music.core.enums.EnumUserStarType;
import lombok.*;

/**
 * @author Qimiao Chen
 * @since 2025/4/2 17:39
 **/
@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class StarOrNotRequest {

    private Long relationId;

    private EnumUserStarType startType;

    private Long userId;

    /**
     * @see  EnumStarActionType
     */
    private EnumStarActionType actionType;

}
