package co.edu.umanizales.battleships.controller;

import co.edu.umanizales.battleships.model.UserDTO;
import co.edu.umanizales.battleships.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "user")
public class UserController {

    @GetMapping(path = "userByCorreo{correo}")
    public @ResponseBody ResponseEntity<Object> findUserByCorreo(@PathVariable("correo") String correo){
        return userService.getUserByCorreo(correo);
    }

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getUsers()
    {
        return userService.listUsers();
    }







}
