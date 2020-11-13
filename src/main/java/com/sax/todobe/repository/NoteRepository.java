package com.sax.todobe.repository;

import com.sax.todobe.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface NoteRepository extends JpaRepository<Note, Long> {
}
