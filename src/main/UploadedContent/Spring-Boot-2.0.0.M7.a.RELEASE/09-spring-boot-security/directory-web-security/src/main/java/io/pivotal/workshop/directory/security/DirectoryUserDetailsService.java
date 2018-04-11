package io.pivotal.workshop.directory.security;

import io.pivotal.workshop.directory.domain.Person;
import io.pivotal.workshop.directory.repository.PersonRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DirectoryUserDetailsService  implements UserDetailsService {

	private PersonRepository repo;
	
	public DirectoryUserDetailsService(PersonRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    try {
            final Person person = this.repo.findByEmailIgnoreCase(username);
            return User.withDefaultPasswordEncoder().username(person.getEmail()).password(person.getPassword()).roles(person.getRole()).build();
        }catch(Exception ex){
	        ex.printStackTrace();
	        throw new UsernameNotFoundException(username);
        }
	}
}
