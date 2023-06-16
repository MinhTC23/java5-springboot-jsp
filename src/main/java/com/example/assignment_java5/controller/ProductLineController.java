package com.example.assignment_java5.controller;

import com.example.assignment_java5.entity.CartDetail;
import com.example.assignment_java5.entity.ProductLine;
import com.example.assignment_java5.service.ManufacturerService;
import com.example.assignment_java5.service.ProductLineService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product-line/")
public class ProductLineController {

    @Autowired
    private ProductLineService productLineService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    HttpServletRequest request;

    @GetMapping("view-all")
    public String getAll(Model model) {
        try {
            HttpSession session = request.getSession();
            CartDetail cartDetail = (CartDetail) session.getAttribute("cartDetail");
            model.addAttribute("cartDetail", cartDetail);
            int quantity = 0;
            for (CartDetail cd : cartDetail.getList()
            ) {
                quantity += cd.getNumber();
            }
            model.addAttribute("quantity", quantity);
            model.addAttribute("productLines", productLineService.getAll());
            model.addAttribute("manufacturers", manufacturerService.getAll());
            model.addAttribute("pl", new ProductLine());
            return "product-line";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            model.addAttribute("productLines", productLineService.getAll());
            model.addAttribute("manufacturers", manufacturerService.getAll());
            model.addAttribute("pl", new ProductLine());
            return "product-line";
        }
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model) {
        try {
            HttpSession session = request.getSession();
            CartDetail cartDetail = (CartDetail) session.getAttribute("cartDetail");
            model.addAttribute("cartDetail", cartDetail);
            int quantity = 0;
            for (CartDetail cd : cartDetail.getList()
            ) {
                quantity += cd.getNumber();
            }
            model.addAttribute("quantity", quantity);
            model.addAttribute("productLine", productLineService.detail(id));
            model.addAttribute("manufacturers", manufacturerService.getAll());
            model.addAttribute("pl", new ProductLine());
            return "product-line-view-update";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            model.addAttribute("productLine", productLineService.detail(id));
            model.addAttribute("manufacturers", manufacturerService.getAll());
            model.addAttribute("pl", new ProductLine());
            return "product-line-view-update";
        }
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute("pl") ProductLine productLine, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("productLines", productLineService.getAll());
            model.addAttribute("manufacturers", manufacturerService.getAll());
            return "product-line";
        }
        productLineService.add(productLine);
        return "redirect:/product-line/view-all";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("pl") ProductLine productLine) {
        productLine.setId(id);
        productLine.setDateCreate(productLineService.detail(id).getDateCreate());
        productLine.setStatus(1);
        productLineService.update(productLine);
        return "redirect:/product-line/view-all";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        productLineService.delete(id);
        model.addAttribute("pl", new ProductLine());
        return "redirect:/product-line/view-all";
    }
}
