package pl.coderslab.charity.sevices;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.InstitutionFormDTO;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repositories.InstitutionRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class InstitutionService {

    private InstitutionRepository institutionRepository;
    private ModelMapper mapper = new ModelMapper();

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public void addInstitution(InstitutionFormDTO data) {
        Institution institution = mapper.map(data, Institution.class);
        institutionRepository.save(institution);
    }

    public void deleteInstitution(Long id) {
        institutionRepository.delete(institutionRepository.getOne(id));
    }

    public InstitutionFormDTO getInstitution(Long id) {
        return mapper.map(institutionRepository.getOne(id), InstitutionFormDTO.class);
    }
}
