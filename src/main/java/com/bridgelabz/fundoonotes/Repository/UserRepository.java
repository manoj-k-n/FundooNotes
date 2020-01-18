package com.bridgelabz.fundoonotes.Repository;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bridgelabz.fundoonotes.model.User;

@Transactional
public interface UserRepository extends CrudRepository<User,String>
{
    User findOneByEmail(Object object);
    
//    @Query(value = "update user set is_email_verify=true where email=?1",nativeQuery = true)
//    void setVerified(String email);
}
