//package com.auth.repo;
//
//import org.springframework.data.repository.CrudRepository;
//
//public interface CustomOAuthAccessTokenRepository extends CrudRepository<CustomOAuthAccessToken, Long> {
//
//    List<CustomOAuthAccessToken> findByClientId(String clientId);
//
//    List<CustomOAuthAccessToken> findByClientIdAndUsername(String clientId, String username);
//
//    Optional<CustomOAuthAccessToken> findByTokenId(String tokenId);
//
//    Optional<CustomOAuthAccessToken> findByRefreshToken(String refreshToken);
//
//    Optional<CustomOAuthAccessToken> findByAuthenticationId(String authenticationId);
//}