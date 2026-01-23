package com.example.securelink.link;

import java.time.LocalDateTime;

public class Link {
    private String token = "";
    private LinkStatus status;
    private LocalDateTime expiresAt;
    private final LocalDateTime createdAt = LocalDateTime.now();


    public boolean isExpired() {
        LocalDateTime now = LocalDateTime.now();
        if (expiresAt.isBefore(now)) {
            return true;
        }
        return false;
    }

    public boolean canUpload() {

    }


    public boolean canDownload() {
        if (!isExpired() && status.equals(LinkStatus.UPLOADED)) {
            return true;
        }
        return false;
    }

}
