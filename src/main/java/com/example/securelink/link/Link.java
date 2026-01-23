package com.example.securelink.link;

import com.example.securelink.link.LinkStatus;
import java.time.LocalDateTime;

public class Link {
    String token = "";
    LinkStatus status;
    LocalDateTime expiresAt = LocalDateTime.now();
    LocalDateTime createdAt = LocalDateTime.now();

    public boolean isExpired(){

    }

    public boolean canUpload(){

    }

    public boolean canDownload(){

    }
}
