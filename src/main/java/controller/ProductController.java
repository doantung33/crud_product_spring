package controller;

import model.Product;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IServiceProduct;
import service.ServiceProduct;

@Controller
@RequestMapping("/products")
public class ProductController {
    IServiceProduct serviceProduct=new ServiceProduct();
    @GetMapping("")
    public ModelAndView list(){
        ModelAndView modelAndView=new ModelAndView("list","p",serviceProduct.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView formCreate(){
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("p",new Product());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Product product){
        serviceProduct.save(product);
        ModelAndView modelAndView=new ModelAndView("create","p",new Product());
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable int id, Model model){
        model.addAttribute("p",serviceProduct.findById(id));
        return "/edit";
    }
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id,@ModelAttribute Product product){
        serviceProduct.update(id,product);
        return "redirect:/products";
    }
    @GetMapping("/delete/{id}")
    public String formDelete(@PathVariable int id ,Model model){
        model.addAttribute("p",serviceProduct.findById(id));
        return "/delete";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        serviceProduct.remote(id);
        return "redirect:/products";
    }

}
