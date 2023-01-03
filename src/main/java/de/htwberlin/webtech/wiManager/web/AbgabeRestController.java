package de.htwberlin.webtech.wiManager.web;

import de.htwberlin.webtech.wiManager.service.AbgabeService;
import de.htwberlin.webtech.wiManager.web.api.Abgabe;
import de.htwberlin.webtech.wiManager.web.api.AbgabeCreateOrUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class AbgabeRestController {

    private final AbgabeService abgabeService;

    public AbgabeRestController(AbgabeService abgabeService) {
        this.abgabeService = abgabeService;
    }


    @GetMapping(path = "/api/v1/abgaben")
    public ResponseEntity<List<Abgabe>> fetchAbgaben(){
        return ResponseEntity.ok(abgabeService.findAll());
    }

    @GetMapping(path = "api/v1/abgaben/{id}")
    public ResponseEntity<Abgabe> fetchAbgabeById(@PathVariable Long id){
        var abgabe = abgabeService.findById(id);
        return abgabe != null? ResponseEntity.ok(abgabe) : ResponseEntity.notFound().build();
    }

    @PostMapping(path="/api/v1/abgaben")
    public ResponseEntity<Void> createAbgabe(@RequestBody AbgabeCreateOrUpdateRequest request) throws URISyntaxException {
        var abgabe = abgabeService.create(request);
        URI uri = new URI("/api/v1/abgaben/" + abgabe.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path= "/api/v1/abgaben/{id}")
    public ResponseEntity<Abgabe> updateAbgabe(@PathVariable Long id, @RequestBody AbgabeCreateOrUpdateRequest request){
        var abgabe = abgabeService.update(id, request);
        return abgabe != null? ResponseEntity.ok(abgabe) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path= "/api/v1/abgaben/{id}")
    public ResponseEntity<Void> deleteAbgabe(@PathVariable Long id) {
        boolean successful = abgabeService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
