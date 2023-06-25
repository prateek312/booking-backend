package com.hostfully.application.controller;

import com.hostfully.application.model.Blocking;
import com.hostfully.application.service.BlockingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blockings")
public class BlockingController {

    @Autowired
    private BlockingService blockingService;

    @Autowired
    public BlockingController(BlockingService blockingService) {
        this.blockingService = blockingService;
    }

    @PostMapping
    public Blocking createBlocking(@RequestBody Blocking blocking) {
        return blockingService.createBlocking(blocking);
    }

    @GetMapping
    public List<Blocking> getAllBlockings() {
        return blockingService.getAllBlockings();
    }

    @GetMapping(value = "/{blockingId}")
    public Blocking getBlocking(@PathVariable("blockingId") Long blockingId) {
        return blockingService.getBlocking(blockingId);
    }

    @DeleteMapping(value = "/{blockingId}")
    public void cancelBlocking(@PathVariable("blockingId") Long blockingId) {
        blockingService.cancelBlocking(blockingId);
    }

    @PutMapping(value = "/{blockingId}/rebook")
    public Blocking rebookBlocking(@PathVariable("blockingId") Long blockingId, @RequestBody Blocking blocking) {
        return blockingService.rebookBlocking(blockingId, blocking);
    }
}
