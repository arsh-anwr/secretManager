package com.secret.manager.repository;

import com.secret.manager.models.SecretData;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretDataRepository extends MongoRepository<SecretData, String> {
    SecretData findBySecretKey(String key);
}
