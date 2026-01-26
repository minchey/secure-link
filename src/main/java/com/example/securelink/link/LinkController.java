package com.example.securelink.link;

public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService){
        this.linkService = linkService;
    }

    public Link postLink(int expireTime){
        return linkService.createLink(expireTime);
    }
}
