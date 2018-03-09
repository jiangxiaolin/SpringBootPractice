package cn.netrookie.repository;

import cn.netrookie.Entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FilmRepository extends JpaRepository<Film, Long> {
    Film findById(Long id);

    @Query("from Film f where f.name like %:name%")
    List<Film> findByName(@Param("name")String name);

    Film findByNameAndUrl(@Param("name")String name,@Param("url")String url);
}
