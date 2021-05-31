package gul.selim.webbundle.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@WebService
@RestController()
@RequestMapping("/api/greeting")
public class GreetingService {

  @WebMethod  
  @RequestMapping(method = RequestMethod.POST, value = "/hi")
  public String sayHello(@RequestBody String name) {
    return "Hi, " + name;
  }
}