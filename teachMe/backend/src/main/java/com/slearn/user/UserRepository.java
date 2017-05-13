package com.slearn.user;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by E-M on 4/22/2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {


    User findByEmail(String email);

    User findByUsername(String username);


}
