package com.sax.todobe.mapper;

import com.sax.todobe.dto.NoteDto;
import com.sax.todobe.entity.Note;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    NoteDto toDto(Note note);
    Note toEntity(NoteDto noteDto);
}
