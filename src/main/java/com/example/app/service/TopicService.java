package com.example.app.service;

import com.example.app.dto.request.TopicRequestDTO;;
import com.example.app.dto.response.PageOfListResponse;
import com.example.app.dto.response.TopicResponseDTO;

import java.util.UUID;

public interface TopicService {

    TopicResponseDTO create(TopicRequestDTO topicDTO);

    TopicResponseDTO getById(UUID id);

    PageOfListResponse<TopicResponseDTO> getAll(int page, int size);

    TopicResponseDTO update(TopicRequestDTO topicDTO, UUID id);

    void delete(UUID id);

}
