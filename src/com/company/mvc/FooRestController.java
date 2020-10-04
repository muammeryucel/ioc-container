package com.company.mvc;

import com.company.foo.Foo;
import com.company.foo.FooService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest/foos")
public class FooRestController {

    @GetMapping
    public ResponseEntity<List<Foo>> getAllFoos() {

        System.out.println("Find all foos.");

        List<Foo> foos = Arrays.asList(new Foo("Foo1"), new Foo("Foo3"), new Foo("Foo2"));
        return ResponseEntity.ok(foos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Foo> getFoo(@PathVariable("id") Long id) {

        System.out.println("Find foo with id");

        Foo foo = new Foo("test");
        return ResponseEntity.ok(foo);
    }

    @PostMapping
    public ResponseEntity<?> createFoo(@RequestBody Foo foo) {

        System.out.println("Create foo and return id.");

        Long id = 123L;
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(id).toUri()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFoo(@PathVariable("id") Long id, @RequestBody Foo foo) {

        System.out.println("Update foo.");

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFoo(@PathVariable("id") Long id) {

        System.out.println("Delete foo with id.");
        return ResponseEntity.ok().build();
    }
}
