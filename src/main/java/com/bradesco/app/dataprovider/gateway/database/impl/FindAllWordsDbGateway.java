package com.bradesco.app.dataprovider.gateway.database.impl;

import com.bradesco.app.core.boundary.FindAllWordsBoundary;
import com.bradesco.app.core.model.Word;
import com.bradesco.app.dataprovider.gateway.database.entity.WordEntity;
import com.bradesco.app.dataprovider.gateway.database.mapper.WordEntityMapper;
import com.bradesco.app.dataprovider.gateway.database.repository.WordEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class FindAllWordsDbGateway implements FindAllWordsBoundary {

    private final WordEntityRepository wordEntityRepository;

    @Override
    public List<Word> execute(){
        log.info("Finding words in database..");
        List<WordEntity> list = wordEntityRepository.findAll();
        return list.stream().map(WordEntityMapper.INSTANCE::wordEntityToWord).collect(Collectors.toList());
    }
}
