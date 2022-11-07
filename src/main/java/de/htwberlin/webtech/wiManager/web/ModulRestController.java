package de.htwberlin.webtech.wiManager.web;

import de.htwberlin.webtech.wiManager.web.api.Modul;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ModulRestController {

    private List<Modul> modulesSem1;

    public ModulRestController() {
       modulesSem1 = new ArrayList<>();
       modulesSem1.add(new Modul(1, "Grundlagen der Programmierung", 1, "P", "SL/PCÜ", "2/2", 5));
       modulesSem1.add(new Modul(2, "Rechnernetze", 1, "P", "SL/PCÜ", "2/2", 5));
       modulesSem1.add(new Modul(3, "Einführung in die BWL und VWL", 1, "P", "SL", "4", 5));
       modulesSem1.add(new Modul(4, "Einführung in die Wirtschaftsinformatik", 1, "P", "SL", "2", 5));
       modulesSem1.add(new Modul(5, "Grundlagen des Software-Engineering", 1, "P", "SL/PCÜ", "2/2", 5));
       modulesSem1.add(new Modul(6, "Mathematik", 1, "P", "SL/BÜ", "4/2", 5));
    }

    @GetMapping(path = "/api/v1/modules")
    public ResponseEntity<List<Modul>> fetchModules(){
        return ResponseEntity.ok(modulesSem1);
    }

}
