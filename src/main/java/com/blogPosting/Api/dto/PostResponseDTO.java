package com.blogPosting.Api.dto;

import java.io.Serializable;

public record PostResponseDTO (Long id,
                               String title,
                               String nickname)
        implements Serializable{

}
