//package com.example.assignment_java5.security;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//
//@Configuration
//@EnableWebSecurity
//public class SocialConfig {
//
////    @Value("${spring.security.oauth2.client.registration.facebook.client-id}")
////    private String facebookClientId;
////
////    @Value("${spring.security.oauth2.client.registration.facebook.client-secret}")
////    private String facebookClientSecret;
//
//    @Value("${spring.security.oauth2.client.registration.google.client-id}")
//    private String googleClientId;
//
//    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
//    private String googleClientSecret;
//
//    @Bean
//    public ClientRegistrationRepository clientRegistrationRepository() {
//        return new InMemoryClientRegistrationRepository(
////                facebookRegistration(),
//                googleRegistration()
//        );
//    }
//
////    private ClientRegistration facebookRegistration() {
////        return ClientRegistration.withRegistrationId("facebook")
////                .clientId(facebookClientId)
////                .clientSecret(facebookClientSecret)
////                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
//////                .redirectUriTemplate("{baseUrl}/login/oauth2/code/{registrationId}")
////                .authorizationUri("https://www.facebook.com/v12.0/dialog/oauth")
////                .tokenUri("https://graph.facebook.com/v12.0/oauth/access_token")
////                .userInfoUri("https://graph.facebook.com/v12.0/me?fields=id,name,email")
////                .userNameAttributeName("id")
////                .clientName("Facebook")
////                .build();
////    }
//
//    private ClientRegistration googleRegistration() {
//        return ClientRegistration.withRegistrationId("google")
//                .clientId(googleClientId)
//                .clientSecret(googleClientSecret)
//                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
////                .redirectUriTemplate("{baseUrl}/login/oauth2/code/{registrationId}")
//                .authorizationUri("https://accounts.google.com/o/oauth2/v2/auth")
//                .tokenUri("https://www.googleapis.com/oauth2/v4/token")
//                .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
//                .userNameAttributeName("sub")
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE) // Thêm dòng này
//                .clientName("Google")
//                .build();
//    }
//}
