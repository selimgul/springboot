package gul.selim.webbundle.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gul.selim.webbundle.model.OperandSet;

@WebService
@RestController()
@RequestMapping("/api/math")
public class MathService {

  @WebMethod  
  @RequestMapping(method = RequestMethod.POST, value = "/add")
  public Integer add(@RequestBody OperandSet pOperandSet) {
    return pOperandSet.getP1() + pOperandSet.getP2();
  }
}