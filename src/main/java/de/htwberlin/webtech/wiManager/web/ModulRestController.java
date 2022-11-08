package de.htwberlin.webtech.wiManager.web;

import de.htwberlin.webtech.wiManager.service.ModulService;
import de.htwberlin.webtech.wiManager.web.api.Modul;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ModulRestController {


    private final ModulService modulService;

    public ModulRestController(ModulService modulService) {
        this.modulService = modulService;
    }


    @GetMapping(path = "/api/v1/modules")
    public ResponseEntity<List<Modul>> fetchModules(){
        return ResponseEntity.ok(modulService.findAll());

    }

}
