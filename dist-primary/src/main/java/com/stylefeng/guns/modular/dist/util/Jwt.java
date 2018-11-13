package com.stylefeng.guns.modular.dist.util;


import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

public class Jwt {

    public static void main(String[] args) {
     /*   String jwt= jjwt.sign("aaa",30L * 24L * 3600L * 1000L);
        System.out.println(jwt);*/
       /* String last= Jwt.unsign("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1MjQwMzg2NjM4NjMsInBheWxvYWQiOiJcImFhYVwiIn0.278yny0PjJhj1bmhPZ3JI3ecPONSPdwSmwE0X0qdnNA",String.class);
        System.out.println(last);*/
    }




    private static final String SECRET = "XX#1$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";

    private static final String EXP = "exp";

    private static final String PAYLOAD = "payload";


    /**
     * get jwt String of object
     * @param object
     *            the POJO object
     * @param maxAge
     *            the milliseconds of life time
     * @return the jwt token
     */
    public static <T> String sign(T object,String secret ,long maxAge) {
        try {
            final JWTSigner signer = new JWTSigner(secret);
            final Map<String, Object> claims = new HashMap<String, Object>();
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(object);
            claims.put(PAYLOAD, jsonString);
            claims.put(EXP, System.currentTimeMillis() + maxAge);
            return signer.sign(claims);
        } catch(Exception e) {
            return null;
        }
    }


    /**
     * get the object of jwt if not expired
     * @param jwt
     * @return POJO object
     */
    public static<T> T unsign(String jwt,String secret , Class<T> classT) {
        final JWTVerifier verifier = new JWTVerifier(secret);
        try {
            final Map<String,Object> claims= verifier.verify(jwt);
            if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {
                long exp = (Long)claims.get(EXP);
                long currentTimeMillis = System.currentTimeMillis();
                if (exp > currentTimeMillis) {
                    String json = (String)claims.get(PAYLOAD);
                    ObjectMapper objectMapper = new ObjectMapper();
                    return objectMapper.readValue(json, classT);
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
