package br.unisul.collegemanagement.professor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public Professor create(Professor professor) {
        professor.setId(null);
        return professorRepository.save(professor);
    }

    public Professor retrieveById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    public List<Professor> retrieveAll() {
        return professorRepository.findAll();
    }

    public void updateById(Professor professor, Long id) {
        if (!professorRepository.existsById(id)) {
            throw new IllegalArgumentException(
                    String.format("There's not a single fuckin one professor with the id: %d.", id));
        }

        professor.setId(id);
        professorRepository.save(professor);
    }

    public void deleteById(Long id) {
        professorRepository.deleteById(id);
    }

}
