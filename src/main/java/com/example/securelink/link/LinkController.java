package com.example.securelink.link;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/links")
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService){
        this.linkService = linkService;
    }

    @PostMapping  //링크생성 DTO로 반환
    public LinkCreateResponse postLink(@RequestParam int expireTime) {
        Link link = linkService.createLink(expireTime);
        return new LinkCreateResponse(
                link.getToken(),
                link.getExpiresAt().toString()
        );
    }

    @PostMapping("/{token}/upload")  //업로드 엔드포인트
    public boolean upload(@PathVariable String token){
        return linkService.uploadFile(token);
    }

    @GetMapping("/{token}/download")  //다운로드 엔드포인트
    public boolean download(@PathVariable String token){
        return linkService.downloadFile(token);
    }

}
