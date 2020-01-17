package com.bridgelabz.fundoonotes.Repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.bridgelabz.fundoonotes.model.Notes;


public interface NoteRepository extends CrudRepository<Notes,Long>
{
  Notes findById(long Id);
}
