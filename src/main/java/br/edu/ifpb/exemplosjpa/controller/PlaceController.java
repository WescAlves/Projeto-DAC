package br.edu.ifpb.exemplosjpa.controller;

import br.edu.ifpb.exemplosjpa.model.Place;
import br.edu.ifpb.exemplosjpa.service.PlaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place")
public class PlaceController {

    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping
    public ResponseEntity<Place> create(@RequestBody Place place){
        return ResponseEntity.ok(placeService.create(place));
    }

    @GetMapping
    public List<Place> getAll(){
        return placeService.getAll();
    }

    @GetMapping("/{id}")
    public Place getById(@PathVariable Long id){
        return placeService.findById(id);
    }
}
