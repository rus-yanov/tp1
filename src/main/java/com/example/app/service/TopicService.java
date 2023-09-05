package com.example.app.service;

import com.example.app.dto.request.TopicRequestDTO;;
import com.example.app.dto.response.PageOfListResponse;
import com.example.app.dto.response.TopicResponseDTO;

public interface TopicService {

    TopicResponseDTO create(TopicRequestDTO topicDTO);

    TopicResponseDTO getById(Long id);

    PageOfListResponse<TopicResponseDTO> getAll(int page, int size);

    TopicResponseDTO update(TopicRequestDTO topicDTO, Long id);

    void delete(Long id);
}
