package de.htwberlin.webtech.wiManager.web;

import de.htwberlin.webtech.wiManager.service.ModulService;
import de.htwberlin.webtech.wiManager.web.api.Modul;
import de.htwberlin.webtech.wiManager.web.api.ModulCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
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

    @PostMapping(path="/api/v1/modules")
    public ResponseEntity<Void> createModule(@RequestBody ModulCreateRequest request) throws URISyntaxException {
        var module = modulService.create(request);
        URI uri = new URI("/api/v1/modules/" + module.getId());
        return ResponseEntity.created(uri).build();
    }

}
