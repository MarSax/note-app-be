package com.sax.todobe.service;

import com.sax.todobe.entity.Note;
import com.sax.todobe.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> findAllNotes() {
        return this.noteRepository.findAll();
    }

    public Note findNoteById(Long id) {
        return this.noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("note with id: " + id + " not found"));
    }

    public Note saveOrUpdateNote(Note note) {
        return this.noteRepository.save(note);
    }

    public void deleteNoteById(Long id) {
        this.noteRepository.deleteById(id);
    }
}
