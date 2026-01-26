package com.example.securelink.link;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/links")
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService){
        this.linkService = linkService;
    }

    @PostMapping
    public Link postLink(@RequestParam int expireTime){
        return linkService.createLink(expireTime);
    }
}
