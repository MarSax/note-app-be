package com.sax.todobe.facade;

import com.sax.todobe.dto.NoteDto;
import com.sax.todobe.entity.Note;
import com.sax.todobe.mapper.NoteMapper;
import com.sax.todobe.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteFacade {
    private final NoteService noteService;
    private final NoteMapper noteMapper;

    public NoteFacade(NoteService noteService, NoteMapper noteMapper) {
        this.noteService = noteService;
        this.noteMapper = noteMapper;
    }

    public List<NoteDto> findAllNotes() {
        return this.noteService.findAllNotes().stream()
                .map(noteMapper::toDto)
                .collect(Collectors.toList());
    }

    public NoteDto findNoteById(Long id) {
        return this.noteMapper.toDto(this.noteService.findNoteById(id));
    }

    public NoteDto saveOrUpdateNote(NoteDto noteDto) {
        return this.noteMapper.toDto(this.noteService.saveOrUpdateNote(this.noteMapper.toEntity(noteDto)));
    }

    public void deleteNoteById(Long id) {
        this.noteService.deleteNoteById(id);
    }
}
