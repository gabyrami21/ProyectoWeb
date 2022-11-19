package com.example.Authentication.controller;

import com.example.Authentication.dto.UserAuth;
import com.example.Authentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/** Representa el controlador de iniciar sesion
 * @author Gabriela Ramirez
 * @author Laura Rozo
 */

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationService authService;

    /** Función: Realiza el inicio de sesión del usuario
    * @ Entradas:URL para poder iniciar sesión
    * @ Salidas:Retorna el usuario logeado
    *
     */
    @PostMapping("login")
    public UserAuth login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
        System.out.println(username);
        return authService.login(username, pwd);
    }
}
