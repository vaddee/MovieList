package movieproject.movielistproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import movieproject.movielistproject.domain.User;
import movieproject.movielistproject.domain.UserRepository;


// Tämä muuttaa käyttäjät sopivaksi spring securitylle
@Service
public class UserDetailServiceImplement implements UserDetailsService  {
	private final UserRepository userRepository;

	@Autowired
	public UserDetailServiceImplement(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {   
    	User currentUser = userRepository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, currentUser.getPasswordHash(), 
        		AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return user;
    }   
} 

