//package com.auth.model;
//
//import java.sql.Date;
//import java.util.Map;
//import java.util.Set;
//
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.common.OAuth2RefreshToken;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//
//import com.auth.config.JwtJweAccessTokenConverter;
//import com.sun.istack.NotNull;
//
//public class CustomOAuthAccessToken implements OAuth2AccessToken {
//
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;
//
//	@Column
//	@NotNull
//	private String tokenId;
//	@Column
//	@NotNull
//	private OAuth2AccessToken token;
//	@Column
//	private String refreshToken;
//	@Column
//	@NotNull
//	private String authenticationId;
//	@Column
//	@NotNull
//	private String username;
//	@Column
//	@NotNull
//	private String clientId;
//	@Column
//	@NotNull
//	private String authentication;
//	@Column
//	private String tokenType;
//	@Column
//	private boolean isExpired;
//	@Column
//	private Date expiration;
//	@Column
//	private int expiresIn;
//	@Column
//	private String value;
//	@Column
//	private Map<String, Object> additionalInformation;
//	@Column
//	private Set<String> scope;
//
//	public OAuth2Authentication getAuthentication() {
//		return authentication;
//	}
//
//	public void setAuthentication(OAuth2Authentication authentication) {
//		this.authentication = JwtJweAccessTokenConverter..serialize(authentication);
//	}
//
//	public OAuth2RefreshToken getRefreshToken() {
//		return null;
//	}
//}