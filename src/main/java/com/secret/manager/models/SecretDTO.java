package com.secret.manager.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SecretDTO {
    String key;
    String value;
}
