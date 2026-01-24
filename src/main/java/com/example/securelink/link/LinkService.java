package com.example.securelink.link;

import java.time.LocalDateTime;
import java.util.UUID;

public class LinkService {


    //링크생성
    public Link createLink(int expireTime){
        String token = UUID.randomUUID().toString();
        LinkStatus status = LinkStatus.CREATED;
        LocalDateTime createAt = LocalDateTime.now();
        LocalDateTime expiresAt = createAt.plusHours(expireTime);

        return new Link(token, status, expiresAt);
    }

    //업로드 진행
    public boolean uploadFile(Link link){
        if(link.canUpload()){
            link.markUploaded();
            return true;
        } return false;
    }
}
