package com.company.mvc;

import com.company.foo.Foo;
import com.company.foo.FooService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

@Controller
@RequestMapping("/foo")
public class FooController {

    private final FooService fooService;

    public FooController(FooService fooService) {
        this.fooService = fooService;
    }

    @RequestMapping("/get/{path-var}")
    //@ResponseBody
    public String foo(ModelMap modelMap,
                      @RequestParam("date") @DateTimeFormat(pattern = "dd.MM.yyyy") Date requestParam,
                      @RequestBody String requestBody,
                      @RequestHeader("test-header") String requestHeader,
                      @PathVariable("path-var") String pathVariable) throws IOException {

        System.out.println("Hello from controller!");

        System.out.println("Request Param:"+requestParam);
        System.out.println("Request Body:"+requestBody);
        System.out.println("Request Header:"+requestHeader);
        System.out.println("Path Variable:"+pathVariable);

        Foo foo = fooService.createFoo("Test456");

        modelMap.addAttribute("model", foo);

/*        if(true) {
            throw new IllegalStateException("test-exception");
        }*/

        return "foo";
    }
}
