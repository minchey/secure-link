package com.example.securelink.link;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/links")
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService){
        this.linkService = linkService;
    }

    @PostMapping //링크생성
    public Link postLink(@RequestParam int expireTime){
        return linkService.createLink(expireTime);
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
