package com.example.securelink.link;

import java.time.LocalDateTime;

public class Link {
    private String token = "";
    private LinkStatus status;
    LocalDateTime createdAt = LocalDateTime.now();
    LocalDateTime expiresAt;

    public boolean isExpired(){

    }

    public boolean canUpload(){

    }

    public boolean canDownload(){

    }
}
