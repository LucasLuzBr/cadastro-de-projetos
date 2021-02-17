package br.com.projeto.controller;

import br.com.projeto.model.Cargo;
import br.com.projeto.model.Funcionario;
import br.com.projeto.repository.CargoRepository;
import br.com.projeto.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FuncionarioController {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    CargoRepository cargoRepository;

    @GetMapping("/funcionario/list")
    public String listFuncionarios(Model model) {

        model.addAttribute("funcionarios", funcionarioRepository.findAll());

        return "/funcionario/list";
    }

    @GetMapping("/funcionario/add")
    public String addFuncionario(Model model) {

        model.addAttribute("funcionario", new Funcionario());
        model.addAttribute("cargos", cargoRepository.findAll());

        return "/funcionario/add";
    }

    @PostMapping("/funcionario/save")
    public String saveFuncionario(Funcionario funcionario) {

        funcionarioRepository.save(funcionario);

        return "redirect:/funcionario/list";
    }
}
