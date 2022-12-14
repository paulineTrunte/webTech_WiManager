package de.htwberlin.webtech.wiManager.service;

import de.htwberlin.webtech.wiManager.persistance.ModulEntity;
import de.htwberlin.webtech.wiManager.persistance.ModulRepository;
import de.htwberlin.webtech.wiManager.web.api.Modul;
import de.htwberlin.webtech.wiManager.web.api.ModulCreateOrUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModulService {

    private final ModulRepository modulRepository;

    public ModulService(ModulRepository modulRepository)
    {
        this.modulRepository = modulRepository;
    }

    public List<Modul> findAll(){
        List<ModulEntity> modules = modulRepository.findAll();
        return modules.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Modul create(ModulCreateOrUpdateRequest request) {
        var modulEntity = new ModulEntity(
                request.getModulName(),
                request.getSemester(),
                request.getArt(),
                request.getForm(),
                request.getSws(),
                request.getLp(),
                request.isBestanden(),
                request.isBelegt());
        modulEntity =modulRepository.save(modulEntity);
        return transformEntity(modulEntity);
    }

    public Modul findById(Long id) {
        var modulEntity = modulRepository.findById(id);
        return modulEntity.map(this::transformEntity).orElse(null);
    }

    public Modul update(Long id, ModulCreateOrUpdateRequest request) {
        var modulEntityOptional = modulRepository.findById(id);
        if(modulEntityOptional.isEmpty()) {
            return null;
        }

        var modulEntity = modulEntityOptional.get();
        modulEntity.setModulName(request.getModulName());
        modulEntity.setSemester(request.getSemester());
        modulEntity.setArt(request.getArt());
        modulEntity.setForm(request.getForm());
        modulEntity.setSws(request.getSws());
        modulEntity.setLp(request.getLp());
        modulEntity.setBelegt(request.isBelegt());
        modulEntity.setBestanden(request.isBestanden());
        modulEntity = modulRepository.save(modulEntity);

        return transformEntity(modulEntity);
    }


    public boolean deleteById(Long id) {
        if(!modulRepository.existsById(id)) {
            return false;
        }
        modulRepository.deleteById(id);
        return true;
    }



    private Modul transformEntity(ModulEntity modulEntity) {
        return new Modul(
                modulEntity.getId(),
                modulEntity.getModulName(),
                modulEntity.getSemester(),
                modulEntity.getArt(),
                modulEntity.getForm(),
                modulEntity.getSws(),
                modulEntity.getLp(),
                modulEntity.isBelegt(),
                modulEntity.isBestanden()
        );
    }
}
