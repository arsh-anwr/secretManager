package com.secret.manager.services;

import com.secret.manager.exception.DuplicateSecretKeyException;
import com.secret.manager.exception.SecretKeyNotFoundException;
import com.secret.manager.models.SecretDTO;
import com.secret.manager.models.SecretData;
import com.secret.manager.repository.SecretDataRepository;
import com.secret.manager.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EncryptionService {

    @Autowired
    EncryptUtils encryptUtils;

    @Autowired
    SecretDataRepository secretDataRepository;

    public void storeSecret(SecretDTO secretDTO) throws DuplicateSecretKeyException {
        SecretData secretData = SecretData.builder()
                .secretKey(secretDTO.getKey())
                .secretValue(encryptUtils.encrypt(secretDTO.getValue()))
                .build();

        if (secretDataRepository.findBySecretKey(secretData.getSecretKey()) != null) {
            throw new DuplicateSecretKeyException("Duplicate secret key found, Please use new key");
        }

        secretDataRepository.save(secretData);
    }

    public String getSecret(String secretKey) throws SecretKeyNotFoundException {
        SecretData secretData = secretDataRepository.findBySecretKey(secretKey);

        if (secretData == null) {
            throw new SecretKeyNotFoundException("Secret key not found, please use valid secret key");
        }

        return encryptUtils.decrypt(secretData.getSecretValue());
    }
}
