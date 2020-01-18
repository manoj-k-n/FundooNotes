package com.bridgelabz.fundoonotes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.fundoonotes.model.Notes;


public interface NoteRepository extends JpaRepository<Notes,Long>
{
  Notes findById(long id);
}
