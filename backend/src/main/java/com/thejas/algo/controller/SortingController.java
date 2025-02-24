package com.thejas.algo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thejas.algo.model.SortRequest;
import com.thejas.algo.model.SortResponse;
import com.thejas.algo.service.SortingService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/sort")
// Allow frontend access
public class SortingController {
    private final SortingService sortingService;

    public SortingController(SortingService sortingService) {
        this.sortingService = sortingService;
    }

    @PostMapping
    public SortResponse sortArray(@RequestBody SortRequest request) {
        SortResponse response = new SortResponse();
        response.setSteps(sortingService.sortArray(request.getArray(), request.getAlgorithm()));
        return response;
    }
}