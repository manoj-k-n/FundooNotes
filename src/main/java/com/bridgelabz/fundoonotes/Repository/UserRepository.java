package com.bridgelabz.fundoonotes.Repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.bridgelabz.fundoonotes.model.User;

@Transactional
public interface UserRepository extends CrudRepository<User,String>
{
    User findOneByEmail(Object object);
    

}
