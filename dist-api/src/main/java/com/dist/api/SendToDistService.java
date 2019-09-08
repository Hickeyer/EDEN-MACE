package com.dist.api;

import com.dist.api.common.tip.DistResult;
import com.dist.api.utils.http.RestClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;

/**
 * @ClassName SendToDistService
 * @autor huangpu
 * @DATE 2019/9/7
 **/
public class SendToDistService {

    /**
     * 查询用户信息
     * @param prefix
     * @param userId
     * @return
     */
    public DistResult getUserInfo(String prefix,String userId){
        DistResult result= RestClient.create(prefix+"/api/v1/getUserInfo")
                .contentType(MediaType.APPLICATION_JSON)
                .acceptableMediaType(MediaType.APPLICATION_JSON)
                .addParam("userId",userId)
                .get(new ParameterizedTypeReference<DistResult>() {
                });
        return result;
    }

    /**
     * 邀请会员
     * @param prefix
     * @param body
     * @return
     */
    public DistResult inviteUser(String prefix,String body){
        DistResult result= RestClient.create(prefix+"/api/v1/memberAdd")
                .header("content-type", "text/xml,charset=utf-8")
                .contentType(MediaType.APPLICATION_JSON)
                .acceptableMediaType(MediaType.APPLICATION_JSON)
                .body(body)
                .post(new ParameterizedTypeReference<DistResult>() {
                });
        return result;
    }

    /**
     * 交易
     * @param prefix
     * @param body
     * @return
     */
    public DistResult trade(String prefix,String body){
        DistResult result= RestClient.create(prefix+"/api/v1/trade")
                .header("content-type", "text/xml,charset=utf-8")
                .contentType(MediaType.APPLICATION_JSON)
                .acceptableMediaType(MediaType.APPLICATION_JSON)
                .body(body)
                .post(new ParameterizedTypeReference<DistResult>() {
                });
        return result;
    }

    /**
     * 查询发展的下级会员
     * @param prefix
     * @param body
     * @return
     */
    public DistResult subordinate(String prefix,String body){
        DistResult result= RestClient.create(prefix+"/api/v1/subordinate")
                .header("content-type", "text/xml,charset=utf-8")
                .contentType(MediaType.APPLICATION_JSON)
                .acceptableMediaType(MediaType.APPLICATION_JSON)
                .body(body)
                .post(new ParameterizedTypeReference<DistResult>() {
                });
        return result;
    }



}

    
    