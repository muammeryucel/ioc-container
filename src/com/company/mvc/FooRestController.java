package com.company.mvc;

import com.company.foo.Foo;
import com.company.foo.JdbcFooRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/rest/foos")
public class FooRestController {

    private final JdbcFooRepository repository;

    public FooRestController(JdbcFooRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Foo>> getAllFoos() {

        List<Foo> foos = repository.findAll();
        return ResponseEntity.ok(foos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Foo> getFoo(@PathVariable("id") Long id) {

        Foo foo = repository.get(id);
        return ResponseEntity.ok(foo);
    }

    @PostMapping
    public ResponseEntity<?> createFoo(@RequestBody Foo foo) {

        repository.create(foo);

        Long id = foo.getId();
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(id).toUri()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFoo(@PathVariable("id") Long id, @RequestBody Foo foo) {

        foo.setId(id);
        repository.update(foo);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFoo(@PathVariable("id") Long id) {

        repository.delete(id);
        return ResponseEntity.ok().build();
    }
}
