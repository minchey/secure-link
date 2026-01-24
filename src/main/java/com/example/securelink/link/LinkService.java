package com.example.securelink.link;

import java.time.LocalDateTime;

public class LinkService {

    public Link createLink(int expireTime){
        LocalDateTime createTime = LocalDateTime.now();
        LocalDateTime expiresTime = createTime.plusHours(expireTime);
        LinkStatus status = LinkStatus.CREATED;
    }
}
