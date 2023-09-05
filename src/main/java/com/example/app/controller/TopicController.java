package com.example.app.controller;

import com.example.app.dto.request.TopicRequestDTO;
import com.example.app.dto.response.PageOfListResponse;
import com.example.app.dto.response.TopicResponseDTO;
import com.example.app.model.TopicEntity;
import com.example.app.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.example.app.controller.TopicController.TOPIC_CONTROLLER_PATH;

@RestController
@RequiredArgsConstructor
@RequestMapping("${base-url}" + TOPIC_CONTROLLER_PATH)
public class TopicController {

    public static final String TOPIC_CONTROLLER_PATH = "/topics";
    public static final String ID = "/{id}";

    private final TopicService topicService;

    @Operation(summary = "Create new topic")
    @ApiResponse(responseCode = "201", description = "Topic created")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TopicResponseDTO create(@Valid @RequestBody TopicRequestDTO topicDTO) {
        return topicService.create(topicDTO);
    }

    @Operation(summary = "Get topic by id")
    @ApiResponses(@ApiResponse(responseCode = "200", content =
    @Content(schema = @Schema(implementation = TopicEntity.class))))
    @GetMapping(ID)
    public TopicResponseDTO getById(@PathVariable("id") Long id) {
        return topicService.getById(id);
    }

    @Operation(summary = "Get all topics")
    @ApiResponses(@ApiResponse(responseCode = "200", content =
    @Content(schema = @Schema(implementation = TopicEntity.class))
    ))
    @GetMapping
    public PageOfListResponse<TopicResponseDTO> getAll(@RequestParam(value = "page") int page,
                                                          @RequestParam(value = "size") int size) {
        return topicService.getAll(page, size);
    }

    @Operation(summary = "Update topic by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Topic updated"),
            @ApiResponse(responseCode = "404", description = "Topic with that id not found")
    })
    @PutMapping(ID)
    public TopicResponseDTO update(@PathVariable Long id,
                                      @Valid @RequestBody TopicRequestDTO topicDTO) {
        return topicService.update(topicDTO, id);
    }

    @Operation(summary = "Delete topic by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Topic deleted"),
            @ApiResponse(responseCode = "404", description = "Topic with that id not found")
    })
    @DeleteMapping(ID)
    public void delete(@PathVariable Long id) {
        topicService.delete(id);
    }
}
