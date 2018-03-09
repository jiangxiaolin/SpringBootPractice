package cn.netrookie.controller;


import cn.netrookie.Entity.Film;
import cn.netrookie.common.Result;
import cn.netrookie.repository.FilmRepository;
import cn.netrookie.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private FilmService filmService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("jxl","wwww");
        return "index";
    }

    @RequestMapping(value = "/manage")
    public String manage(Model model){
        return "manage";
    }

    @RequestMapping(value = "/allfilms")
    public String show(Model model){
        Result result = Result.toDefault();
        List<Film> list = filmService.getFilmList();
        if(!list.isEmpty()){
            result.setMsg(list);
        } else{
            result.failed();
        }
        model.addAttribute(result);
        return "films";
    }

    @RequestMapping(value = "/vue")
    public String vue(){
        return "vue";
    }
}
