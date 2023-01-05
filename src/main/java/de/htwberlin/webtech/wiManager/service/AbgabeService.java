package de.htwberlin.webtech.wiManager.service;

import de.htwberlin.webtech.wiManager.persistance.*;
import de.htwberlin.webtech.wiManager.web.api.Abgabe;
import de.htwberlin.webtech.wiManager.web.api.AbgabeCreateOrUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AbgabeService {

    private final AbgabeRepository abgabeRepository;

    public AbgabeService(AbgabeRepository abgabeRepository)
    {
        this.abgabeRepository = abgabeRepository;
    }

    public List<Abgabe> findAll(){
        List<AbgabeEntity> abgabe = abgabeRepository.findAll();
        return abgabe.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Abgabe create(AbgabeCreateOrUpdateRequest request) {
        var abgabeEntity = new AbgabeEntity(
                request.getSemester(),
                request.getModulName(),
                request.getFrist(),
                request.getNotificationMessage());
        abgabeEntity = abgabeRepository.save(abgabeEntity);
        return transformEntity(abgabeEntity);
    }

    public Abgabe findById(Long id) {
        var abgabeEntity = abgabeRepository.findById(id);
        return abgabeEntity.map(this::transformEntity).orElse(null);
    }

    public Abgabe update(Long id, AbgabeCreateOrUpdateRequest request) {
        var abgabeEntityOptional = abgabeRepository.findById(id);
        if(abgabeEntityOptional.isEmpty()) {
            return null;
        }

        var abgabeEntity = abgabeEntityOptional.get();
        abgabeEntity.setSemester(request.getSemester());
        abgabeEntity.setModulName(request.getModulName());
        abgabeEntity.setFrist(request.getFrist());
        abgabeEntity.setNotificationMessage(request.getNotificationMessage());
        abgabeEntity = abgabeRepository.save(abgabeEntity);

        return transformEntity(abgabeEntity);
    }


    public boolean deleteById(Long id) {
        if(!abgabeRepository.existsById(id)) {
            return false;
        }
        abgabeRepository.deleteById(id);
        return true;
    }



    private Abgabe transformEntity(AbgabeEntity abgabeEntity) {
        return new Abgabe(
                abgabeEntity.getId(),
                abgabeEntity.getSemester(),
                abgabeEntity.getModulName(),
                abgabeEntity.getFrist(),
                abgabeEntity.getNotificationMessage()
        );
    }

    public Optional<AbgabeEntity> get(long l) {
        return abgabeRepository.findById(l);
    }
}
