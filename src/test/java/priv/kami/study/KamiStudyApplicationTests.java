package priv.kami.study;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class KamiStudyApplicationTests {

    @Test
    void testGenerateToken() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "kami");

        String token = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "kami77")
                .setClaims(claims)
                .compact();

        System.out.println(token);
    }

    @Test
    void testParseToken() {
        Claims claims = Jwts.parser()
                .setSigningKey("kami77")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoia2FtaSIsImlkIjoxfQ.B7V6mBte3Tqy9RRwe4pmVL80gbpyDLJB_erUQSAWKqg")
                .getBody();
        System.out.println(claims);
    }

}
