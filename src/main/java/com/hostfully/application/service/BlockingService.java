package com.hostfully.application.service;

import com.hostfully.application.model.Blocking;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlockingService {
    private final Map<Long, Blocking> blockings = new HashMap<>();

    public Blocking createBlocking(Blocking blocking) {
        long blockingId = generateBlockingId();
        blocking.setId(blockingId);
        blockings.put(blockingId, blocking);
        return blocking;
    }

    public Blocking getBlocking(Long blockingId) {
        return blockings.get(blockingId);
    }

    public void cancelBlocking(Long blockingId) {
        blockings.remove(blockingId);
    }

    public Blocking rebookBlocking(Long blockingId, Blocking blocking) {
        blockings.put(blockingId, blocking);
        return blocking;
    }

    private long generateBlockingId() {
        // Generate a unique blocking ID here (e.g., using a counter or UUID)
        // Replace the return statement with your actual implementation
        return System.currentTimeMillis();
    }

    public List<Blocking> getAllBlockings() {
        List<Blocking> blockingList = new ArrayList<Blocking>(blockings.values());
        return blockingList;
    }
}
