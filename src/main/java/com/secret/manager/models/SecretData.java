package com.secret.manager.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "secret_key_table")
@Data
@Builder
public class SecretData {

    @Id
    private String id;

    @Indexed(unique = true)
    private String secretKey;
    private String secretValue;
}
