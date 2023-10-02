package com.bradesco.app.dataprovider.gateway.database.impl;

import com.bradesco.app.core.boundary.InsertWordBoundary;
import com.bradesco.app.core.model.Word;
import com.bradesco.app.dataprovider.gateway.database.entity.WordEntity;
import com.bradesco.app.dataprovider.gateway.database.mapper.WordEntityMapper;
import com.bradesco.app.repository.WordEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class InsertWordDbGateway implements InsertWordBoundary {

    private final WordEntityRepository wordEntityRepository;

    @Override
    public Word execute(Word word) {
        final WordEntity wordEntity = wordEntityRepository.save(WordEntityMapper.INSTANCE.wordToWordEntity(word));
        return WordEntityMapper.INSTANCE.wordEntityToWord(wordEntity);
    }
}
