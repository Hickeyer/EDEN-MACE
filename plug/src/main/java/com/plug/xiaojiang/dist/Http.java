package com.plug.xiaojiang.dist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.plug.xiaojiang.dist.dto.DisMemberInfoDto;
import com.plug.xiaojiang.dist.dto.JSON;
import javafx.geometry.Pos;

public class Http {

    /**
     * 测试新增会员
     * @param args
     * @throws UnirestException
     * @throws JsonProcessingException
     */
    public static void main(String[] args) throws UnirestException, JsonProcessingException {
        DisMemberInfoDto disMemberInfoDto=new DisMemberInfoDto();
        disMemberInfoDto.setDisModelId("abc");
        Post(disMemberInfoDto,"http://localhost:80/disMemberInfo/add");
    }

    public static void Post(Object o,String url) throws UnirestException, JsonProcessingException {
        String info= JSON.get().writeValueAsString(o);
        HttpResponse<JsonNode> postResponse = Unirest.post(url)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(info)
                .asJson();
        System.out.println(postResponse.getBody().toString());
    }
}
