package com.example.app.service;

import com.example.app.dto.request.WidgetRequestDTO;
import com.example.app.dto.response.PageOfListResponse;
import com.example.app.dto.response.WidgetResponseDTO;

public interface WidgetService {

    WidgetResponseDTO create(WidgetRequestDTO widgetDTO);

    WidgetResponseDTO getById(Long id);

    PageOfListResponse<WidgetResponseDTO> getAll(int page, int size);

    WidgetResponseDTO update(WidgetRequestDTO pwidgetDTOageDTO, Long id);

    void delete(Long id);
}
