package com.mychellmotta.storebackend.controller;

import com.mychellmotta.storebackend.entity.State;
import com.mychellmotta.storebackend.services.StateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/state")
public class StateController {

    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/")
    public List<State> getAll() {
        return stateService.getAll();
    }

    @PostMapping("/")
    public State insert(@RequestBody State state) {
        return stateService.insert(state);
    }

    @PutMapping("/")
    public State update(@RequestBody State state) {
        return stateService.update(state);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        stateService.delete(id);
        return ResponseEntity.ok().build();
    }
}
