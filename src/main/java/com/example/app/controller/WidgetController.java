package com.example.app.controller;

import com.example.app.dto.request.WidgetRequestDTO;
import com.example.app.dto.response.PageOfListResponse;
import com.example.app.dto.response.WidgetResponseDTO;
import com.example.app.model.WidgetEntity;
import com.example.app.service.WidgetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.example.app.controller.WidgetController.WIDGET_CONTROLLER_PATH;

@RestController
@RequiredArgsConstructor
@RequestMapping("${base-url}" + WIDGET_CONTROLLER_PATH)
public class WidgetController {

    public static final String WIDGET_CONTROLLER_PATH = "/widgets";
    public static final String ID = "/{id}";

    private final WidgetService widgetService;

    @Operation(summary = "Create new widget")
    @ApiResponse(responseCode = "201", description = "Topic created")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WidgetResponseDTO create(@Valid @RequestBody WidgetRequestDTO widgetDTO) {
        return widgetService.create(widgetDTO);
    }

    @Operation(summary = "Get widget by id")
    @ApiResponses(@ApiResponse(responseCode = "200", content =
    @Content(schema = @Schema(implementation = WidgetEntity.class))))
    @GetMapping(ID)
    public WidgetResponseDTO getById(@PathVariable("id") Long id) {
        return widgetService.getById(id);
    }

    @Operation(summary = "Get all widgets")
    @ApiResponses(@ApiResponse(responseCode = "200", content =
    @Content(schema = @Schema(implementation = WidgetEntity.class))
    ))
    @GetMapping
    public PageOfListResponse<WidgetResponseDTO> getAll(@RequestParam(value = "page") int page,
                                                       @RequestParam(value = "size") int size) {
        return widgetService.getAll(page, size);
    }

    @Operation(summary = "Update widget by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Widget updated"),
            @ApiResponse(responseCode = "404", description = "Widget with that id not found")
    })
    @PutMapping(ID)
    public WidgetResponseDTO update(@PathVariable Long id,
                                   @Valid @RequestBody WidgetRequestDTO widgetDTO) {
        return widgetService.update(widgetDTO, id);
    }

    @Operation(summary = "Delete widget by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Widget deleted"),
            @ApiResponse(responseCode = "404", description = "Widget with that id not found")
    })
    @DeleteMapping(ID)
    public void delete(@PathVariable Long id) {
        widgetService.delete(id);
    }
}
