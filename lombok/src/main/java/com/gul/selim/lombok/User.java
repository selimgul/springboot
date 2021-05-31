package com.gul.selim.lombok;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {
    private Integer id;
    private String name;
}
