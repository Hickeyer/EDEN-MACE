package com.dist.api.utils.http;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Set;

/**
 * Created by huangpu on 2017/4/14.
 */
public abstract class TokRestTemplate {

    private static RestTemplate restTemplate;

    static {

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setDefaultMaxPerRoute(500);
        connectionManager.setMaxTotal(1000);

        CloseableHttpClient client = HttpClients.createMinimal(connectionManager);

        SSLContextBuilder builder = new SSLContextBuilder();
        builder = builder.useSSL();
        try {
            builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build(), new String[] { "TLSv1" },
                    null, new SkipHostnameVerifier());
            client=HttpClients.custom().setSSLSocketFactory(sslsf).build();
        }catch (Exception e){
            e.printStackTrace();
        }
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(client);
        restTemplate = new RestTemplate(requestFactory);
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));

    }

    public static <T> T getForObject(String url, Class<T> responseType, Object... uriVariables) throws RestClientException {

        return restTemplate.getForObject(url, responseType);
    }

    public static <T> T getForObject(String url, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {

        return restTemplate.getForObject(url, responseType, uriVariables);
    }

    public static <T> T getForObject(URI url, Class<T> responseType) throws RestClientException {

        return restTemplate.getForObject(url, responseType);
    }

    public static <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Object... uriVariables) throws RestClientException {

        return restTemplate.getForEntity(url, responseType, uriVariables);
    }

    public static <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {

        return restTemplate.getForEntity(url, responseType, uriVariables);
    }

    public static <T> ResponseEntity<T> getForEntity(URI url, Class<T> responseType) throws RestClientException {

        return restTemplate.getForEntity(url, responseType);
    }

    public static HttpHeaders headForHeaders(String url, Object... uriVariables) throws RestClientException {

        return restTemplate.headForHeaders(url, uriVariables);
    }

    public static HttpHeaders headForHeaders(String url, Map<String, ?> uriVariables) throws RestClientException {

        return restTemplate.headForHeaders(url, uriVariables);
    }

    public static HttpHeaders headForHeaders(URI url) throws RestClientException {

        return restTemplate.headForHeaders(url);
    }

    public static URI postForLocation(String url, Object request, Object... uriVariables) throws RestClientException {

        return restTemplate.postForLocation(url, request, uriVariables);
    }

    public static URI postForLocation(String url, Object request, Map<String, ?> uriVariables) throws RestClientException {

        return restTemplate.postForLocation(url, request, uriVariables);
    }

    public static URI postForLocation(URI url, Object request) throws RestClientException {

        return restTemplate.postForLocation(url, request);
    }

    public static <T> T postForObject(String url, Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {

        return restTemplate.postForObject(url, request, responseType, uriVariables);
    }

    public static <T> T postForObject(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {

        return restTemplate.postForObject(url, request, responseType, uriVariables);
    }

    public static <T> T postForObject(URI url, Object request, Class<T> responseType) throws RestClientException {

        return restTemplate.postForObject(url, request, responseType);
    }

    public static <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {

        return restTemplate.postForEntity(url, request, responseType, uriVariables);
    }

    public static <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {

        return restTemplate.postForEntity(url, request, responseType, uriVariables);
    }

    public static <T> ResponseEntity<T> postForEntity(URI url, Object request, Class<T> responseType) throws RestClientException {

        return restTemplate.postForEntity(url, request, responseType);
    }

    public static void put(String url, Object request, Object... uriVariables) throws RestClientException {

        restTemplate.put(url, request, uriVariables);
    }

    public static void put(String url, Object request, Map<String, ?> uriVariables) throws RestClientException {

        restTemplate.put(url, request, uriVariables);
    }

    public static void put(URI url, Object request) throws RestClientException {

        restTemplate.put(url, request);
    }

    public static void delete(String url, Object... uriVariables) throws RestClientException {

        restTemplate.delete(url, uriVariables);
    }

    public static void delete(String url, Map<String, ?> uriVariables) throws RestClientException {

        restTemplate.delete(url, uriVariables);
    }

    public static void delete(URI url) throws RestClientException {

        restTemplate.delete(url);
    }

    public static Set<HttpMethod> optionsForAllow(String url, Object... uriVariables) throws RestClientException {

        return restTemplate.optionsForAllow(url, uriVariables);
    }

    public static Set<HttpMethod> optionsForAllow(String url, Map<String, ?> uriVariables) throws RestClientException {

        return restTemplate.optionsForAllow(url, uriVariables);
    }

    public static Set<HttpMethod> optionsForAllow(URI url) throws RestClientException {

        return restTemplate.optionsForAllow(url);
    }

    public static <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Object... uriVariables) throws RestClientException {

        return restTemplate.exchange(url, method, requestEntity, responseType, uriVariables);
    }

    public static <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {

        return restTemplate.exchange(url, method, requestEntity, responseType, uriVariables);
    }

    public static <T> ResponseEntity<T> exchange(URI url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType) throws RestClientException {

        return restTemplate.exchange(url, method, requestEntity, responseType);
    }

    public static <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType, Object... uriVariables) throws RestClientException {

        return restTemplate.exchange(url, method, requestEntity, responseType, uriVariables);
    }

    public static <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType, Map<String, ?> uriVariables) throws RestClientException {

        return restTemplate.exchange(url, method, requestEntity, responseType, uriVariables);
    }

    public static <T> ResponseEntity<T> exchange(URI url, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType) throws RestClientException {

        return restTemplate.exchange(url, method, requestEntity, responseType);
    }

    public static <T> ResponseEntity<T> exchange(RequestEntity<?> requestEntity, Class<T> responseType) throws RestClientException {

        return restTemplate.exchange(requestEntity, responseType);
    }

    public static <T> ResponseEntity<T> exchange(RequestEntity<?> requestEntity, ParameterizedTypeReference<T> responseType) throws RestClientException {
        return restTemplate.exchange(requestEntity, responseType);
    }

    public static <T> T execute(String url, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor, Object... uriVariables) throws RestClientException {

        return restTemplate.execute(url, method, requestCallback, responseExtractor, uriVariables);
    }

    public static <T> T execute(String url, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor, Map<String, ?> uriVariables) throws RestClientException {

        return restTemplate.execute(url, method, requestCallback, responseExtractor, uriVariables);
    }

    public static <T> T execute(URI url, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor) throws RestClientException {

        return restTemplate.execute(url, method, requestCallback, responseExtractor);
    }

}