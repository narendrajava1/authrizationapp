//package com.auth.model;
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.ElementCollection;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.MapKeyColumn;
//import javax.persistence.OneToMany;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.oauth2.provider.ClientDetails;
//
//import lombok.Data;
//
//@Data
////@Getter
////@Setter
//@Entity
//public class CustomClientDetails implements ClientDetails {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//    @Column
//    private String clientId;
//    @Column
//    private Set<String> resourceIds;
//    @Column
//    private boolean secretRequired;
//    @Column
//    private String clientSecret;
//    @Column
//    private boolean scoped;
//    @Column
//    private Set<String> scope;
//    @Column
//    private Set<String> authorizedGrantTypes;
//    @Column
//    private Set<String> registeredRedirectUri;
//    @Column
//    @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
//    private Collection<SimpleGrantedAuthority> authorities = Collections.emptySet();
//    
//    @Column
//    private Integer accessTokenValiditySeconds;
//    @Column
//    private Integer refreshTokenValiditySeconds;
//    @Column
//    private boolean autoApprove;
//    @Column
//    @ElementCollection(targetClass=String.class)
//    @MapKeyColumn(name="additionalInformation")
//    private Map<String, Object> additionalInformation;
//    @Column
//    private Set<String> autoApproveScopes;
//    
//    
//	@Override
//	public boolean isAutoApprove(String scope) {
//		if (autoApproveScopes == null) {
//			return false;
//		}
//		for (String auto : autoApproveScopes) {
//			if (auto.equals("true") || scope.matches(auto)) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	@Override
//	public String getClientId() {
//		// TODO Auto-generated method stub
//		return clientId;
//	}
//
//	@Override
//	public Set<String> getResourceIds() {
//		// TODO Auto-generated method stub
//		return resourceIds;
//	}
//
//	@Override
//	public boolean isSecretRequired() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public String getClientSecret() {
//		// TODO Auto-generated method stub
//		return clientSecret;
//	}
//
//	@Override
//	public boolean isScoped() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public Set<String> getScope() {
//		// TODO Auto-generated method stub
//		return scope;
//	}
//
//	@Override
//	public Set<String> getAuthorizedGrantTypes() {
//		// TODO Auto-generated method stub
//		return authorizedGrantTypes;
//	}
//	public void setAuthorities(Collection<SimpleGrantedAuthority> authorities) {
////		authorities=Collections.emptySet();
//		this.authorities = authorities;
//	}
//	@Override
//	public Set<String> getRegisteredRedirectUri() {
//		// TODO Auto-generated method stub
//		return registeredRedirectUri;
//	}
//
//	@Override
//	public Collection<GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
////		SimpleGrantedAuthority authority=new SimpleGrantedAuthority();
//		Set<GrantedAuthority> au=new HashSet<>();
//		au.addAll(authorities);
//		return au;
////		authorities.add(authority);
//	}
//	@Override
//	public Integer getAccessTokenValiditySeconds() {
//		// TODO Auto-generated method stub
//		return accessTokenValiditySeconds;
//	}
//
//	@Override
//	public Integer getRefreshTokenValiditySeconds() {
//		// TODO Auto-generated method stub
//		return refreshTokenValiditySeconds;
//	}
//
//	@Override
//	public Map<String, Object> getAdditionalInformation() {
//		// TODO Auto-generated method stub
//		return additionalInformation;
//	}
//}