package linyuju.formbindingtest.controller;

import linyuju.formbindingtest.model.userModel.UserRegModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserRegController
{
    //第一種@RequestParam作法，比較繁瑣
    @GetMapping("/user-regForm")
    public String userRegForm(Model model)
    {
        UserRegModel userregmodel = new UserRegModel();
        model.addAttribute("usermodel",userregmodel);
        return "user-reg";
    }
    @PostMapping("/user-regForm")
    public String userSignin(@RequestParam("uname") String uname,
                             @RequestParam String email,
                             @RequestParam String mobile,
                             @RequestParam String address,
                             Model model)  //抓UserRegModel物件來用，若名字不同要宣告(" ")
    {
        model.addAttribute("user",uname);
        return "user-signin";

    }

    //跳第三種作法@PostMapping+ binding讓使用者把Form送進model裡傳，使用@ModelAttribute+ th:object="${ }"+ th:field="*{ }"
    @PostMapping("/user-regForm02")
    public  String userSignin02(@ModelAttribute UserRegModel usermodel, Model model)
    {
        model.addAttribute("user",usermodel.getUname()); //此處Key=user，交給用model傳遞
        model.addAttribute("email",usermodel.getEmail()); //額外做傳email
        return "user-signin";
    }


}
