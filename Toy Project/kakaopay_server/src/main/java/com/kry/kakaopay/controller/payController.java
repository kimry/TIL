package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class payController {

    @RequestMapping(value = "payment", method = RequestMethod.POST)
    public String payment(String product, int price, int cnt){
        System.out.println("prodcut : " + product + ", price :  " + price + ", cnt :  " + cnt);
        return "안녕";
    }
}
