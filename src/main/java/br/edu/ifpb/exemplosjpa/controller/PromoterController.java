package br.edu.ifpb.exemplosjpa.controller;

import br.edu.ifpb.exemplosjpa.model.Promoter;
import br.edu.ifpb.exemplosjpa.service.PromoterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/promoter")
public class PromoterController {

    private PromoterService promoterService;
    public PromoterController(PromoterService promoterService) {
        this.promoterService = promoterService;
    }
    @PostMapping
    public ResponseEntity<Promoter> create(@RequestBody Promoter promoter) {
        return ResponseEntity.ok(promoterService.create(promoter));
    }
    @GetMapping("/{id}")
    public Promoter getById(@PathVariable Long id){
        return promoterService.findById(id);
    }

}
