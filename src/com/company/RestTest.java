package com.company;

import com.company.foo.Foo;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

public class RestTest {

    private static final String BASE_URL = "http://localhost:8080/ioc/mvc/rest";

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        List allFoos = restTemplate.getForObject(BASE_URL + "/foos", List.class);
        System.out.println("All Foos: " + allFoos);

        Foo foo = restTemplate.getForObject(BASE_URL + "/foos/{id}", Foo.class, 1L);
        System.out.println("Foo: " + foo);

        URI location = restTemplate.postForLocation(BASE_URL + "/foos", new Foo("test"));
        System.out.println("Location: " + location);

        restTemplate.put(BASE_URL + "/foos/{id}", new Foo("test"), 1L);

        restTemplate.delete(BASE_URL + "/foos/{id}", 1L);
    }
}
