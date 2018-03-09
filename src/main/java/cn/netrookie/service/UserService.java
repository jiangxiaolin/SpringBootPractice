package cn.netrookie.service;


import cn.netrookie.Entity.User;
import cn.netrookie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //返回全部用户
    public List<User> getUserList(){
        List<User> tmp = userRepository.findAll();

        return tmp;
    }




}
