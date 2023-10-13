package com.example.app.service;

import com.example.app.dto.request.WidgetRequestDTO;
import com.example.app.dto.response.PageOfListResponse;
import com.example.app.dto.response.WidgetResponseDTO;

import java.util.UUID;

public interface WidgetService {

    WidgetResponseDTO create(WidgetRequestDTO widgetDTO);

    WidgetResponseDTO getById(UUID id);

    PageOfListResponse<WidgetResponseDTO> getAll(int page, int size);

    WidgetResponseDTO update(WidgetRequestDTO pwidgetDTOageDTO, UUID id);

    void delete(UUID id);
}
