package br.com.projeto.controller;

import br.com.projeto.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FuncionarioController {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @GetMapping("/funcionario/list")
    public String listFuncionarios(Model model) {

        model.addAttribute("funcionarios", funcionarioRepository.findAll());

        return "/funcionario/list";
    }
}
