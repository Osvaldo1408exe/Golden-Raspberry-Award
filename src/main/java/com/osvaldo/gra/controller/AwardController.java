package com.osvaldo.gra.controller;

import com.osvaldo.gra.dto.AwardIntervalResponse;
import com.osvaldo.gra.service.AwardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/awards")
public class AwardController {

    private final AwardService awardService;

    public AwardController(AwardService awardService) {
        this.awardService = awardService;
    }

    @GetMapping("/intervals")
    public AwardIntervalResponse getAwardIntervals() {
        return awardService.calculateAwardIntervals();
    }
}
