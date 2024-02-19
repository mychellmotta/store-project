package com.mychellmotta.storebackend.services;

import com.mychellmotta.storebackend.entity.State;
import com.mychellmotta.storebackend.repository.StateRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StateService {

    private final StateRepository stateRepository;

    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public List<State> findAll() {
        return stateRepository.findAll();
    }

    @Transactional
    public State insert(State state) {
        state.setInsertDate(new Date());
        return stateRepository.save(state);
    }

    @Transactional
    public State update(State state) {
        state.setUpdateDate(new Date());
        return stateRepository.save(state);
    }

    @Transactional
    public void delete(Long id) {
        stateRepository.deleteById(id);
    }
}
