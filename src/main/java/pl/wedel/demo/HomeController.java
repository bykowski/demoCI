package pl.wedel.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public List<Dog> hello() {
        return dogRepo.findAll();
    }

    private DogRepo dogRepo;

    @Autowired
    public HomeController(DogRepo dogRepo) {
        this.dogRepo = dogRepo;
    }

    @PostMapping
    public void addDog() {
        dogRepo.save(new Dog("Burek"));
    }


}
