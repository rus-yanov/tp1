package com.example.app.service.impl;

import com.example.app.dto.request.WidgetRequestDTO;
import com.example.app.dto.response.PageOfListResponse;
import com.example.app.dto.response.WidgetResponseDTO;
import com.example.app.model.WidgetEntity;
import com.example.app.repository.WidgetRepository;
import com.example.app.service.WidgetService;
import com.example.app.utils.exception.ApplicationNotFoundException;
import com.example.app.utils.mapper.WidgetMapper;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class WidgetServiceImpl implements WidgetService {

    private final WidgetRepository widgetRepository;
    private final WidgetMapper widgetMapper;

    @Override
    public WidgetResponseDTO create(WidgetRequestDTO widgetRequest) {

        log.info("#create: Create widget, widget name - {}", widgetRequest.getName());
        WidgetEntity newWidget = widgetRepository.save(widgetMapper
                .toWidgetEntity(widgetRequest));
        return widgetMapper.toWidgetResponse(newWidget);
    }

    @Override
    public WidgetResponseDTO getById(UUID id) {

        log.info("#getById: Get widget by id, id - {}", id);
        WidgetEntity widget = widgetRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("getById",
                        "Widget not found, widget-id - " + id));

        return widgetMapper.toWidgetResponse(widget);
    }

    @Override
    public PageOfListResponse<WidgetResponseDTO> getAll(int page, int size) {

        log.info("#getAll: Get all widgets, page - {}, size - {}", page, size);
        Page<WidgetEntity> pageOfWidgets = widgetRepository.findAll(PageRequest.of(page, size));
        return PageOfListResponse.<WidgetResponseDTO>builder()
                .elements(widgetMapper.toWidgetResponseList(pageOfWidgets.getContent()))
                .size(size)
                .totalPage(pageOfWidgets.getTotalPages())
                .build();
    }

    @Override
    public WidgetResponseDTO update(WidgetRequestDTO widgetRequest, UUID id) {

        log.info("#update: Update widget, id - {}", id);
        WidgetEntity widgetToUpdate = widgetRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("update",
                        "Widget not found, widget-id - " + id));

        widgetMapper.updateWidgetEntity(widgetToUpdate, widgetRequest);
        return widgetMapper.toWidgetResponse(widgetToUpdate);
    }

    @Override
    public void delete(UUID id) {

        log.info("#delete: Delete widget by id, id - {}", id);
        try {
            widgetRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ApplicationNotFoundException("delete",
                    "Widget not found, widget-id - " + id);
        }
    }
}
