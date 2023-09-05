package com.example.app.service.impl;

import com.example.app.dto.request.TopicRequestDTO;
import com.example.app.dto.response.PageOfListResponse;
import com.example.app.dto.response.TopicResponseDTO;
import com.example.app.model.CategoryEntity;
import com.example.app.model.TopicEntity;
import com.example.app.repository.TopicRepository;
import com.example.app.service.TopicService;
import com.example.app.utils.exception.ApplicationNotFoundException;
import com.example.app.utils.mapper.TopicMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;

    @Override
    public TopicResponseDTO create(TopicRequestDTO topicRequest) {

        log.info("#create: Create topic, topic name - {}", topicRequest.getName());
        TopicEntity newTopic = topicMapper.toTopicEntity(topicRequest);
        topicRepository.save(newTopic);
        return topicMapper.toTopicResponse(newTopic);
    }

    @Override
    public TopicResponseDTO getById(Long id) {

        log.info("#getById: Get topic by id, id - {}", id);
        TopicEntity topic = topicRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("getById",
                        "Topic not found, topic-id - " + id));

        return topicMapper.toTopicResponse(topic);
    }

    @Override
    public PageOfListResponse<TopicResponseDTO> getAll(int page, int size) {

        log.info("#getAll: Get all topics, page - {}, size - {}", page, size);
        Page<TopicEntity> pageOfTopics = topicRepository.findAll(PageRequest.of(page, size));
        return PageOfListResponse.<TopicResponseDTO>builder()
                .elements(topicMapper.toTopicResponseList(pageOfTopics.getContent()))
                .size(size)
                .totalPage(pageOfTopics.getTotalPages())
                .build();
    }

    @Override
    public TopicResponseDTO update(TopicRequestDTO topicRequest, Long id) {

        log.info("#update: Update topic, id - {}", id);
        TopicEntity topicToUpdate = topicRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("update",
                        "Topic not found, topic-id - " + id));

        topicMapper.updateTopicEntity(topicToUpdate, topicRequest);
        return topicMapper.toTopicResponse(topicToUpdate);
    }

    @Override
    public void delete(Long id) {

        log.info("#delete: Delete topic by id, id - {}", id);
        try {
            topicRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ApplicationNotFoundException("delete",
                    "Topic not found, topic-id - " + id);
        }
    }
}
