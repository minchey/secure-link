package com.example.securelink.link;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity<Void> upload(@PathVariable String token, @RequestParam("file")MultipartFile file) {

        UploadResult result = linkService.uploadFile(token, file);

        return switch (result) {
            case SUCCESS -> ResponseEntity.ok().build();                  // 200
            case NOT_FOUND -> ResponseEntity.notFound().build();          // 404
            case FORBIDDEN -> ResponseEntity.status(HttpStatus.FORBIDDEN).build(); // 403
        };
    }

    @GetMapping("/{token}/download")  //다운로드 엔드포인트
    public ResponseEntity<Void> download(@PathVariable String token) {

        UploadResult result = linkService.downloadFile(token);

        return switch (result) {
            case SUCCESS -> ResponseEntity.ok().build();
            case NOT_FOUND -> ResponseEntity.notFound().build();
            case FORBIDDEN -> ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        };
    }

}
