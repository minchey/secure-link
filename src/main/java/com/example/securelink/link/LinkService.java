package com.example.securelink.link;

import java.time.LocalDateTime;
import java.util.UUID;

public class LinkService {

    //private final LinkRepository linkRepository;


    //링크생성
    public Link createLink(int expireTime) {
        String token = UUID.randomUUID().toString();
        LinkStatus status = LinkStatus.CREATED;
        LocalDateTime createAt = LocalDateTime.now();
        LocalDateTime expiresAt = createAt.plusHours(expireTime);

        return new Link(token, status, expiresAt);
    }

    //업로드 진행
    public boolean uploadFile(String token) {  //토큰으로 링크를 가져온다
        if (link.canUpload()) {
            link.markUploaded();
            return true;
        }
        return false;
    }

    //다운로드 진행
    public boolean downloadFile(String token) {  //토큰으로 링크를 가져온다
        if (link.canDownload()) {
            return true;
        }
        return false;
    }
}
