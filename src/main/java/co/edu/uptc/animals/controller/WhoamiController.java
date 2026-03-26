package co.edu.uptc.animals.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class WhoamiController {

    @Value("${CONTAINER_NAME:unknown}")
    private String containerName;

    @GetMapping("/whoami")
    public String whoAmI() throws Exception {
        String hostname = java.net.InetAddress.getLocalHost().getHostName();
        return "Soy el contenedor " + hostname;
    }
}
