package cn.netrookie.controller;

import cn.netrookie.Entity.Film;
import cn.netrookie.common.Result;
import cn.netrookie.repository.FilmRepository;
import cn.netrookie.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping(value="/films")
public class FilmController {
    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private FilmService filmService;

    @ResponseBody
    @RequestMapping(value="/show")
    public List<Film> showAllFilms(){
        List<Film> list = filmService.getFilmList();
        if(!list.isEmpty()){
            return list;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value="/add",produces="text/html;charset=UTF-8")
    public String addFilm(Model model, HttpServletRequest request){
        String name = request.getParameter("name");
        String url = request.getParameter("url");
        model.addAttribute("jxl","ssssss");
        if(!filmRepository.findByName(name).isEmpty()) {
            return "already exists!";
        }else {
            filmRepository.save(new Film(name,url));
            return name + "------ " + url;
    }
    }

    @ResponseBody
    @RequestMapping(value="/find")
    public Result findOne(HttpServletRequest request){
        Result result = Result.toDefault();
        String name=request.getParameter("name");
        if(!filmRepository.findByName(name).isEmpty()){
            result.setMsg(filmRepository.findByName(name));
        }else{
            result.failed();
        }
        return result;
    }
    @ResponseBody
    @RequestMapping(value="update")
    public Result updateInfo(Model model,HttpServletRequest request){
        Result result = Result.toDefault();
        String name = request.getParameter("name");
        String url = request.getParameter("url");
        Film film = filmRepository.findByNameAndUrl(name,url);
        if(film != null){
            film.setName(name);
            film.setUrl(url);
            filmRepository.save(film);
            result.setMsg(film);
        }
        return result;
    }
    @ResponseBody
    @RequestMapping(value="delete")
    public Result deleteFilm(Model model,HttpServletRequest request){
        Result result = Result.toDefault();
        String name = request.getParameter("name");
        String url = request.getParameter("url");
        Film film = filmRepository.findByNameAndUrl(name,url);
        if (film != null){
            filmRepository.delete(film.getId());
        }else{
            result.failed();
        }
        return result;
    }
}



