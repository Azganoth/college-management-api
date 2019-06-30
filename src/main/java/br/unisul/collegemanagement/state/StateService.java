package br.unisul.collegemanagement.state;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class StateService {

    private final StateRepository stateRepository;

    public State retrieveById(Integer id) {
        return stateRepository.findById(id).orElse(null);
    }

    public List<State> retrieveAll() {
        return stateRepository.findAll();
    }

}
