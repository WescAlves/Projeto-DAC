package br.edu.ifpb.exemplosjpa.controller;

import br.edu.ifpb.exemplosjpa.model.Purchase;
import br.edu.ifpb.exemplosjpa.service.PurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<Purchase> create (@RequestBody Purchase purchase){
        return ResponseEntity.ok(purchaseService.create(purchase));
    }


    @GetMapping
    public List<Purchase> getAll(){
        return purchaseService.getAll();
    }

    @GetMapping("/{id}")
    public Purchase getById(@PathVariable Long id){
        return purchaseService.findById(id).orElseThrow();
    }

}
