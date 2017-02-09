package org.kb141.security;

import org.kb141.domain.SecurityVO;
import org.kb141.mapper.SecurityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	SecurityMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		SecurityVO result = null;
		
		try {
			result = mapper.findByUserid(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result == null) {
			throw new UsernameNotFoundException(userid);
		}

		return new UserDetailsImpl(result);
	}

}
