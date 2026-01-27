package com.example.securelink.link;


//외부 응답용 DTO
public class LinkCreateResponse {
    private final String token;
    private final String expiresAt;

    public LinkCreateResponse(String token, String expiresAt){
        this.token = token;
        this.expiresAt = expiresAt;
    }


    //getter
    public String getToken() {
        return token;
    }

    public String getExpiresAt() {
        return expiresAt;
    }
}
