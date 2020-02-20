package com.bridgelabz.fundoonotes.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoonotes.model.Labels;
import com.bridgelabz.fundoonotes.model.User;
@Repository
public interface labelsRepository extends JpaRepository<Labels ,Long>
{
   Labels findById(long id);
   
   
   @Query("from Labels where user=:user")
  List<Labels> findAllById(User user);
}
