package br.edu.ifpb.exemplosjpa.controller;

import br.edu.ifpb.exemplosjpa.model.User;
import br.edu.ifpb.exemplosjpa.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create (@RequestBody User user){
        return ResponseEntity.ok(userService.create(user));
    }


    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userService.findById(id).orElseThrow();
    }

}
