package org.kb141.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	static final String REQUEST_PARAM_NAME = "username";
	static final String COOKIE_NAME = "username";

	static final String URL_NAME = "urlname";
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);
		System.out.println("targetUrl : " + targetUrl);
		String id = request.getParameter(REQUEST_PARAM_NAME);
		
		if (id != null) {
			String username = ((UserDetails) authentication.getPrincipal()).getUsername();
			Cookie cookie = new Cookie(COOKIE_NAME, username);
			Cookie url = new Cookie(URL_NAME, targetUrl);
			response.addCookie(cookie);
			response.addCookie(url);
		} else {
			Cookie cookie = new Cookie(COOKIE_NAME, "");
			Cookie url = new Cookie(URL_NAME,"");
			cookie.setMaxAge(0);
			url.setMaxAge(0);
			response.addCookie(cookie);
			response.addCookie(url);
		}

		if (response.isCommitted()) {
			System.out.println("Can't redirect");
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(Authentication authentication) {
		String url = "";

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		List<String> roles = new ArrayList<String>();

		for (GrantedAuthority a : authorities) {
			roles.add(a.getAuthority());
		}

		if (isAdmin(roles)) {
			url = "/admin";
		} else if (isClient(roles)) {
			url = "/client";
		} else {
			url = "/accessDenied";
		}

		return url;
	}

	private boolean isAdmin(List<String> roles) {
		if (roles.contains("ROLE_ADMIN")) {
			return true;
		}
		return false;
	}

	private boolean isClient(List<String> roles) {
		if (roles.contains("ROLE_CLIENT")) {
			return true;
		}
		return false;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
}
