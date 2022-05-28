package course.qa.spring.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/users")
public class HelloRestController {
    @GetMapping("/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return "Hello " + name + " from Spring MVC!";
    }

}
