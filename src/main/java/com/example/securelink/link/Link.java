package com.example.securelink.link;

import java.time.LocalDateTime;


public class Link {
    private String token = "";
    private LinkStatus status;
    private LocalDateTime expiresAt;
    private final LocalDateTime createdAt = LocalDateTime.now();

    public Link(String token, LinkStatus status, LocalDateTime expiresAt){
        this.token = token;
        this.status = status;
        this.expiresAt = expiresAt;
    }

    public boolean isExpired() {
        LocalDateTime now = LocalDateTime.now();
        if (expiresAt.isBefore(now)) {
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

    public LinkStatus markUploaded(){
        return status = LinkStatus.UPLOADED;
    }


    public boolean canDownload() {
        if (!isExpired() && status.equals(LinkStatus.UPLOADED)) {
            return true;
        }
        return false;
    }

}
