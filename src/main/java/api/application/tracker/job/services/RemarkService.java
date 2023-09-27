package api.application.tracker.job.services;

import api.application.tracker.job.exceptions.RemarkNotFoundException;
import api.application.tracker.job.models.Remark;
import api.application.tracker.job.repositories.RemarkRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RemarkService {

    private final RemarkRepository remarkRepository;

    public RemarkService(RemarkRepository remarkRepository) {
        this.remarkRepository = remarkRepository;
    }

    public Remark create(Remark remark){
        return remarkRepository.save(remark);
    }

    public List<Remark> getAll(Pageable pageable){
        return remarkRepository.findAll(pageable).getContent();
    }

    public Remark get(int remarkId){
        Optional<Remark> remark = remarkRepository.findById(remarkId);

        try{
            return remark.get();
        }catch (Exception e){
            throw new RemarkNotFoundException("Remark with id " + remarkId + " not found");
        }
    }

    public Remark update(int remarkId,Remark newRemarkInfo){
        Remark remark = get(remarkId);

        if(!Objects.equals(remark.getContent(), newRemarkInfo.getContent()) && newRemarkInfo.getContent() != null){
            remark.setContent(newRemarkInfo.getContent());
        }

        if(remark.getDescriptor() != newRemarkInfo.getDescriptor() && newRemarkInfo.getDescriptor() != null){
            remark.setDescriptor(newRemarkInfo.getDescriptor());
        }

        return remark;
    }

    public Remark delete(int remarkId){
        Remark remark = get(remarkId);

        remarkRepository.deleteById(remarkId);

        return remark;
    }
}
