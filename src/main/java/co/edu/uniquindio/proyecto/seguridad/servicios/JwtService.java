package co.edu.uniquindio.proyecto.seguridad.servicios;
import java.security.Key;

import co.edu.uniquindio.proyecto.modelo.Usuario;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.expiration}")
    private long jwtExpiration;
    @Value("${jwt.refresh_expiration}")
    private long refreshExpiration;

    public static final long JWT_EXPIRATION_CAMBIO_CONTRASENA = 30 * 60 * 1000; // 30 minutos en milisegundos

    private final Key SECRET_KEY_CAMBIO_CONTRASENA = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(UserDetails userDetails) {
        return buildToken(new HashMap<>(), userDetails, jwtExpiration);
    }
    public String generateRefreshToken(UserDetails userDetails) {
        return buildToken(new HashMap<>(), userDetails, refreshExpiration);
    }
    private String buildToken(Map<String, Object> extraClaims, UserDetails userDetails, long
            expiration) {
        List<String> roles =
                userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        extraClaims.put("roles", roles);
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256).compact();

    }
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }
    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

    }
    private Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generarTokenCambioContrasena(Usuario usuario) {
        Date ahora = new Date();
        Date expiracion = new Date(ahora.getTime() + JWT_EXPIRATION_CAMBIO_CONTRASENA);

        return Jwts.builder()
                .setSubject(usuario.getEmail())
                .claim("codigoUsuario", usuario.getCodigo())
                .setIssuedAt(ahora)
                .setExpiration(expiracion)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY_CAMBIO_CONTRASENA)
                .compact();
    }

    public String obtenerEmail(String token) {

        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY_CAMBIO_CONTRASENA)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (JwtException e) {
            // Token inválido o expirado
            return null;
        }
    }

    public boolean validarTokenCambioContrasena(Usuario usuario, String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY_CAMBIO_CONTRASENA)
                    .parseClaimsJws(token)
                    .getBody();

            int codigoUsuario = (int) claims.get("codigoUsuario");

            if (codigoUsuario != usuario.getCodigo()) {
                return false;
            }

            Date fechaExpiracion = claims.getExpiration();

            if (fechaExpiracion.before(new Date())) {
                return false;
            }

            return true;
        } catch (JwtException e) {
            return false;
        }
    }

}