package com.tensquare.user.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * @author : TenYun
 * @date : 2019-06-08 11:29
 * @description :
 **/
public class ParseJwtTest {

    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE1NTk5NjQ0NDh9.myxRVlNdeCwATMebOHRiahxcRQacUug0-kJSYvDymYg";
        // 这里签名使用itcasts不会报错？
        Claims claims = Jwts.parser().setSigningKey("itcast").parseClaimsJws(token).getBody();
        System.out.println("id:" + claims.getId());
        System.out.println("subject: " + claims.getSubject());
        System.out.println("IssuedAt: " + claims.getIssuedAt());
    }
}
