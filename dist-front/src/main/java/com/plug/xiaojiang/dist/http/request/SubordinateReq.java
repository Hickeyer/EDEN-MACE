package com.plug.xiaojiang.dist.http.request;

public class SubordinateReq {

    //秘钥
    private String  secret;

    //名称
    private String  memberId;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
