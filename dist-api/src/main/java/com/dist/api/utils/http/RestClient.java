package com.dist.api.utils.http;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * Created by huangpu on 2017/4/14.
 */
public class RestClient {

    private String url;

    private Map<String,String> uriVariables = Maps.newHashMap();

    private MultiValueMap<String,String> params = new LinkedMultiValueMap<String,String>();

    private Map<String,String[]> headers = Maps.newHashMap();

    private Object data;

    private MediaType contentType;

    private List<MediaType> acceptableMediaTypes = Lists.newArrayList();

    private RestClient(String url){
        this.url = url;
    }

    public static RestClient create(String url){

        return new RestClient(url);
    }

    public RestClient uriVariable(String key,String value){
        uriVariables.put(key,value);

        return this;
    }

    public RestClient addParam(String key,String value){
        params.add(key,value);

        return this;
    }


    public RestClient header(String headerName, String... headerValues){
        this.headers.put(headerName,headerValues);
        return this;
    }

    public RestClient contentType(MediaType contentType){
        this.contentType = contentType;

        return this;
    }

    public RestClient acceptableMediaType(MediaType mediaType){
        this.acceptableMediaTypes.add(mediaType);

        return this;
    }

    public RestClient body(Object data){
        this.data = data;

        return this;
    }

    public <T> T get(ParameterizedTypeReference<T> typeReference){

        return execute(HttpMethod.GET, typeReference);
    }

    public <T> T post(ParameterizedTypeReference<T> typeReference){

        return execute(HttpMethod.POST, typeReference);
    }

    public <T> T put(ParameterizedTypeReference<T> typeReference){

        return execute(HttpMethod.PUT, typeReference);
    }

    public <T> T patch(ParameterizedTypeReference<T> typeReference){

        return execute(HttpMethod.PATCH, typeReference);
    }

    public <T> T delete(ParameterizedTypeReference<T> typeReference){

        return execute(HttpMethod.DELETE, typeReference);
    }

    public <T> T execute(HttpMethod httpMethod, ParameterizedTypeReference<T> typeReference){
        URI uri = UriComponentsBuilder.fromUriString(url).queryParams(params).buildAndExpand(uriVariables).toUri();
        RequestEntity.BodyBuilder bodyBuilder = RequestEntity.method(httpMethod, uri);
       for (Map.Entry<String, String[]> map:headers.entrySet()){
           bodyBuilder.header(map.getKey(), map.getValue());
       }
        if (contentType!=null) {
            bodyBuilder.contentType(contentType);
        }
        if (!CollectionUtils.isEmpty(acceptableMediaTypes)) {
            bodyBuilder.accept(acceptableMediaTypes.toArray(new MediaType[acceptableMediaTypes.size()]));
        }

        RequestEntity<?> requestEntity = bodyBuilder.body(data);

        ResponseEntity<T> exchange = TokRestTemplate.exchange(requestEntity, typeReference);
        return exchange.getBody();
    }

}
