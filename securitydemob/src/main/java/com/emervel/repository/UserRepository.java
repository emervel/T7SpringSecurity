package com.emervel.repository;

import com.emervel.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by guopm on 04/06/2017.
 */
public interface UserRepository extends CrudRepository<User,Long>{
    User findByEmail(String email);
}
