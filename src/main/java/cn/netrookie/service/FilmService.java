package cn.netrookie.service;


import cn.netrookie.Entity.Film;
import cn.netrookie.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    //返回全部用户
    public List<Film> getFilmList(){
        List<Film> tmp = filmRepository.findAll();

        return tmp;
    }


    public List<Film> getFilmByName(String name){

        List<Film> tmp = filmRepository.findByName(name);

        return tmp;
    }

}
