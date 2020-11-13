package com.sax.todobe.controller;

import com.sax.todobe.dto.NoteDto;
import com.sax.todobe.entity.Note;
import com.sax.todobe.facade.NoteFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/notes")
public class NoteController {
    private final NoteFacade noteFacade;

    public NoteController(NoteFacade noteFacade) {
        this.noteFacade = noteFacade;
    }

    @GetMapping
    public ResponseEntity<List<NoteDto>> findAllNotes() {
        return new ResponseEntity<>(this.noteFacade.findAllNotes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDto> findNoteById(@PathVariable Long id) {
        return new ResponseEntity<>(this.noteFacade.findNoteById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<NoteDto> saveNote(@RequestBody NoteDto noteDto) {
        return new ResponseEntity<>(this.noteFacade.saveOrUpdateNote(noteDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<NoteDto> updateNote(@RequestBody NoteDto noteDto) {
        return new ResponseEntity<>(this.noteFacade.saveOrUpdateNote(noteDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable Long id) {
        this.noteFacade.deleteNoteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
