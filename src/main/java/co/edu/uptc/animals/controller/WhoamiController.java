package co.edu.uptc.animals.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class WhoamiController {

    @GetMapping("/whoami")
    public String whoAmI() throws Exception {
        return java.net.InetAddress.getLocalHost().getHostName();
    }
}
