package com.bridgelabz.fundoonotes.Repository;

import org.springframework.data.repository.CrudRepository;

import com.bridgelabz.fundoonotes.model.Collaborater;


public interface CollaboratoreRepository extends CrudRepository<Collaborater, Long>
{
      Collaborater findById(long Id);
}
