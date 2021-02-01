package ru.geekbrains.spring.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;
    private final ScoreService scoreService;

    @GetMapping("/")
    public String startPage() {
        return "Стартовая страница для неавторизованных пользователей";
    }

    @GetMapping("/score")
    public String homePage(Principal principal) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(principal.getName()).orElseThrow(() -> new UsernameNotFoundException(String.format("Пользователь '%s' не найден", principal.getName())));
        return "Домашняя страница для авторизованных пользователей. Приветствуем, " + user.getUsername();
    }

    @GetMapping("/score/get/current")
    public String getScoreOfCurrentUser(Principal principal) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(principal.getName()).orElseThrow(() -> new UsernameNotFoundException(String.format("Пользователь '%s' не найден", principal.getName())));
        return "Балл = " + user.getScoreId().getValue();
    }

    @GetMapping("/score/get/{id}")
    public String getScoreByUserId(@PathVariable Long id) throws UsernameNotFoundException {
        User user = userService.findUserById(id).orElseThrow(() -> new UsernameNotFoundException(String.format("Пользователь с id = %d не найден", id)));
        return "Балл = " + user.getScoreId().getValue();
    }

    @GetMapping("/score/inc")
    public String incScoreOfCurrentUser(Principal principal) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(principal.getName()).orElseThrow(() -> new UsernameNotFoundException(String.format("Пользователь '%s' не найден", principal.getName())));
        return "Балл = " + scoreService.incScore(user.getScoreId()).getValue();
    }

    @GetMapping("/score/dec")
    public String decScoreOfCurrentUser(Principal principal) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(principal.getName()).orElseThrow(() -> new UsernameNotFoundException(String.format("Пользователь '%s' не найден", principal.getName())));
        return "Балл = " + scoreService.decScore(user.getScoreId()).getValue();
    }

}
