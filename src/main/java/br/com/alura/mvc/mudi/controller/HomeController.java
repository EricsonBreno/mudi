package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.constant.Constable;
import java.util.IllformedLocaleException;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private PedidoRepository pedidorepository;

    @RequestMapping
    public String home(Model model) {

        List<Pedido> pedidos = pedidorepository.findAll();
        model.addAttribute("pedidos", pedidos);

        return "home";
    }

    @RequestMapping("/{status}")
    public String byStatus(@PathVariable("status") String status, Model model) {

        List<Pedido> pedidos = pedidorepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);
        return "home";
    }

    @ExceptionHandler(IllformedLocaleException.class)
    public String onError(){
        return "redirect:/home";
    }
}
