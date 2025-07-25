package com.secret.manager.controller;

import com.secret.manager.exception.DuplicateSecretKeyException;
import com.secret.manager.exception.SecretKeyNotFoundException;
import com.secret.manager.models.SecretDTO;
import com.secret.manager.services.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EncryptionController {

    @Autowired
    EncryptionService encryptionService;

    @PostMapping("/addSecret")
    public ResponseEntity<String> addSecretKey(@RequestBody SecretDTO secretDTO) {
        try {
            encryptionService.storeSecret(secretDTO);
        } catch (DuplicateSecretKeyException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("true");
    }

    @GetMapping("/getSecret/{secretKey}")
    public ResponseEntity<String> getSecretKey(@PathVariable String secretKey) {
        String secretValue = null;
        try {
            secretValue = encryptionService.getSecret(secretKey);
        } catch (SecretKeyNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(secretValue);
    }


}