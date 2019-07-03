package br.unisul.collegemanagement.subject;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public Subject create(Subject subject) {
        subject.setId(null);
        return subjectRepository.save(subject);
    }

    public Subject retrieveById(Integer id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public List<Subject> retrieveAll() {
        return subjectRepository.findAll();
    }

    public void deleteById(Integer id) {
        subjectRepository.deleteById(id);
    }

}
