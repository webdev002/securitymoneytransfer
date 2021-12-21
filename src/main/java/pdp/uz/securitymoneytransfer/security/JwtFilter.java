package pdp.uz.securitymoneytransfer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import pdp.uz.securitymoneytransfer.service.MyAuthService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    MyAuthService myAuthService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //REQUESTDAN TOKENNI OLDIK
        String token = request.getHeader("Authorization");
        //TOKEN BORLIGI VA BEARER BILAN BOSHLANISHINI TEKSHIRAYAPMIZ
        if (token!=null && token.startsWith("Bearer")){
            //AYNAN TOKENNI OZINI QIRQIB OLDIK
            token =token.substring(7);
            //TOKENNI TEKSHIRIB OLDIK(TOKEN BUZILMAGANLIGI,MUDDDATI OTMAGANLIGI VA H.K)
            boolean validateToken = jwtProvider.validateToken(token);

            if (validateToken){
                //TOKENNINICHIDAN USERNAMENI OLDIK
                String userNameFromToken = jwtProvider.getUserNameFromToken(token);
                //USERNAME ORQALI USERDETAILSNI OLDIK
                UserDetails userDetails = myAuthService.loadUserByUsername(userNameFromToken);
                //USERDETAILS ORQALI AUTHENTICATION YARATIB OLDIK
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                //SISTEMAGA KIM KIRGANLIGINI ORNATDIK
                System.out.println(SecurityContextHolder.getContext().getAuthentication());
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            }
        }
      
        filterChain.doFilter(request,response);

    }
}
