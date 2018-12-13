package hello;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("client-1")
public interface Client1 {
    @RequestMapping(value = "/hello-client-1/{name}", method = RequestMethod.GET)
    String greet1(@PathVariable("name") String name);

}
