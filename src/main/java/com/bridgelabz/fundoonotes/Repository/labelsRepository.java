package com.bridgelabz.fundoonotes.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoonotes.model.Labels;
@Repository
public interface labelsRepository extends JpaRepository<Labels ,Long>
{
   Labels findById(long id);
}
