package de.htwberlin.webtech.wiManager.service;

import de.htwberlin.webtech.wiManager.persistance.ModulEntity;
import de.htwberlin.webtech.wiManager.persistance.ModulRepository;
import de.htwberlin.webtech.wiManager.web.api.Modul;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModulService {

    private final ModulRepository modulRepository;

    public ModulService(ModulRepository modulRepository) {
        this.modulRepository = modulRepository;
    }

    public List<Modul> findAll(){
        List<ModulEntity> modules = modulRepository.findAll();
        return modules.stream()
                .map(modulEntity -> new Modul(
                        modulEntity.getId(),
                        modulEntity.getModulName(),
                        modulEntity.getSemester(),
                        modulEntity.getArt(),
                        modulEntity.getForm(),
                        modulEntity.getSws(),
                        modulEntity.getLp()
                ))
                .collect(Collectors.toList());
    }
}
