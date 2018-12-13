package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}

@RestController
class ServiceInstanceRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }
}


@RestController
class GreetingController{


    @Value("${spring.application.name}")
    private String applicationName;


    @Autowired
    private Client1 client1;

    @Autowired
    private Client2 client2;

    @RequestMapping("/client-1/{name}")
    public String greetingToClient1(@PathVariable String name) {
        return client1.greet1(name);
    }

    @RequestMapping("/hello-client-1/{name}")
    public String greetingClient1(@PathVariable String name) {
        return "Hello " + name + " . Here is " + applicationName;
    }

    @RequestMapping("/client-2/{name}")
    public String greetingToClient2(@PathVariable String name) {
        return client2.greet2(name);
    }

    @RequestMapping("/hello-client-2/{name}")
    public String greetingClient2(@PathVariable String name) {
        return "Hello " + name + " . Here is " + applicationName;
    }

}