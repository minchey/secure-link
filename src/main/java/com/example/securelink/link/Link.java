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
            status = LinkStatus.EXPIRED;
            return true;
        }
        return false;
    }

    public boolean canUpload() {
        if (!isExpired() && status.equals(LinkStatus.CREATED)) {
            return true;
        }
        return false;
    }


    public boolean canDownload() {
        if (!isExpired() && status.equals(LinkStatus.UPLOADED)) {
            return true;
        }
        return false;
    }

}
