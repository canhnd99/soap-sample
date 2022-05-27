package com.b2a.soapsample.controller;

import com.b2a.soapsample.service.TrackAndTraceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ws.vnpost.TrackAndTrace_Items_PublicResponseTrackAndTrace_Items_PublicResult;

@RestController
@RequestMapping("/items")
public class TrackAndTraceController {
    @Autowired
    TrackAndTraceServiceImpl trackAndTraceClient;

    @GetMapping("/trackAndTraceItemPublic")
    public ResponseEntity<TrackAndTrace_Items_PublicResponseTrackAndTrace_Items_PublicResult> trackAndTraceItemsPublic(
            @RequestParam String itemCode
    ) throws Exception {
        TrackAndTrace_Items_PublicResponseTrackAndTrace_Items_PublicResult result = trackAndTraceClient.trackAndTraceItemsPublic(itemCode);
        return ResponseEntity.ok(result);
    }
}
