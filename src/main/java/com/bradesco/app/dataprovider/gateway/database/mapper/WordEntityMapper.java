package com.bradesco.app.dataprovider.gateway.database.mapper;

import com.bradesco.app.core.model.Word;
import com.bradesco.app.dataprovider.gateway.database.entity.WordEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class WordEntityMapper {

    public static final WordEntityMapper INSTANCE = Mappers.getMapper(WordEntityMapper.class);

    public abstract Word wordEntityToWord(WordEntity wordEntity);

    public abstract WordEntity wordToWordEntity(Word word);

}
