package api.application.tracker.job.services;


import api.application.tracker.job.exceptions.TechStackNotFoundException;
import api.application.tracker.job.models.TechStack;
import api.application.tracker.job.repositories.TechStackRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechStackService {

    private final TechStackRepository techStackRepository;


    public TechStackService(TechStackRepository techStackRepository) {
        this.techStackRepository = techStackRepository;
    }

    public TechStack create(TechStack techStack){
        return techStackRepository.save(techStack);
    }

    public List<TechStack> getAll(Pageable pageable){
        return techStackRepository.findAll(pageable).getContent();
    }

    public TechStack getById(int techStackId){
        Optional<TechStack> stack = techStackRepository.findById(techStackId);

        try{
            return stack.get();
        }catch (Exception e){
            throw new TechStackNotFoundException("Tech stack " + techStackId + " not found.");
        }
    }

    public TechStack updateById(int techStackId,TechStack newTechStackInfo){
        TechStack stack = getById(techStackId);
        create(stack);
        return stack;
    }

    public TechStack deleteById(int techStackId){
        TechStack stack = getById(techStackId);
        techStackRepository.deleteById(techStackId);
        return stack;
    }
}
