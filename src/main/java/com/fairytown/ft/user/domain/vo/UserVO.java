package com.fairytown.ft.user.domain.vo;

import java.sql.Date;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class UserVO implements UserDetails{
	private String	userId;
	private String	userPw;
	private String	userEmail;
	private String	userPhone;
	private String	loginSt;
	private Date 	userBirthDate;
	private String	userSt;
	private int		zipCode;
	private String	userAddress;
	private String	detailAddress;
	private String	userAdmin;
	private Date	userDate;
	private String	realName;
	
	// 토큰을 위한 멤버 변수 추가
    private String accessToken;
    private String refreshToken;
	
	//검색 필터
	private String	keyword;
	private String	type;

    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singletonList(new SimpleGrantedAuthority(this.userAdmin));
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.userPw;
	}
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userId;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
	    // userSt 값이 "B"인 경우 로그인을 실패하도록 false를 반환
	    return !"B".equals(this.userSt);
	}
}
