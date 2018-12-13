package hello;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("client-2")
public interface Client2 {

    @RequestMapping("/hello-client-2/{name}")
    String greet2(@PathVariable("name") String name);

}
