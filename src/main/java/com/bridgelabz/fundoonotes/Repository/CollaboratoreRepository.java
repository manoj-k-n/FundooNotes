package com.bridgelabz.fundoonotes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoonotes.model.Collaborater;

@Repository
public interface CollaboratoreRepository extends JpaRepository<Collaborater, Long>
{

}
