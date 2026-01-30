package com.example.securelink.link;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class LinkService {

    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository){
        this.linkRepository =linkRepository;
    }

    //링크생성
    public Link createLink(int expireTime) {
        String token = UUID.randomUUID().toString();
        LinkStatus status = LinkStatus.CREATED;
        LocalDateTime createAt = LocalDateTime.now();
        LocalDateTime expiresAt = createAt.plusHours(expireTime);
        Link link = new Link(token, status, expiresAt);
        linkRepository.save(link);
        return link;
    }

    //업로드 진행
    public UploadResult uploadFile(String token) {  //토큰으로 링크를 가져온다
        Optional<Link> result = linkRepository.findByToken(token);
        if(result.isEmpty()){
            return UploadResult.NOT_FOUND;
        }
        Link link = result.get();
        if (!link.canUpload()) {
            return UploadResult.FORBIDDEN;
        }

        link.markUploaded();
        return UploadResult.SUCCESS;
    }

    //다운로드 진행 method
    public UploadResult downloadFile(String token) {  //토큰으로 링크를 가져온다
        Optional<Link> result = linkRepository.findByToken(token);
        if (result.isEmpty()) {
            return UploadResult.NOT_FOUND;
        }

        Link link = result.get();

        if (!link.canDownload()) {
            return UploadResult.FORBIDDEN;
        }

        return UploadResult.SUCCESS;
    }
}
