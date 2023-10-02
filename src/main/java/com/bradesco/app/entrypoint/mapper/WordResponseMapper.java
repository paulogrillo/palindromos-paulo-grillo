package com.bradesco.app.entrypoint.mapper;

import com.bradesco.app.core.model.Word;
import com.bradesco.app.dto.WordResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class WordResponseMapper {

    public static final WordResponseMapper INSTANCE = Mappers.getMapper(WordResponseMapper.class);

    public abstract WordResponse convertWordToWordResponse(Word word);

    public abstract Word convertWordResponseToWord(WordResponse wordResponse);

    public abstract List<WordResponse> convertWordListToWordResponseList(List<Word> words);

}
