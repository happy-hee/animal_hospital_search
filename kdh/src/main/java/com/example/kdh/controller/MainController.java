package com.example.kdh.controller;

import com.example.kdh.domain.animal_company_info.AnimalCompanyInfoRepository;
import com.example.kdh.domain.business_hours.BusinessHoursRepository;
import com.example.kdh.domain.review.ReviewRepository;
import com.example.kdh.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@AllArgsConstructor
public class MainController extends ControllerExtension {

    private final UserRepository userRepository;
    private final AnimalCompanyInfoRepository animalCompanyInfoRepository;
    private final BusinessHoursRepository businessHoursRepository;
    private final ReviewRepository reviewRepository;

    @GetMapping("/")
    public String home(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        return "index";
    }

}
