package com.example.assignment_java5.controller;

import com.example.assignment_java5.entity.CartDetail;
import com.example.assignment_java5.entity.Color;
import com.example.assignment_java5.service.ColorService;
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
@RequestMapping("/color/")
public class ColorController {

    @Autowired
    private ColorService colorService;

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
            model.addAttribute("colors", colorService.getAll());
            model.addAttribute("cl", new Color());
            return "color";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            model.addAttribute("colors", colorService.getAll());
            model.addAttribute("cl", new Color());
            return "color";
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
            model.addAttribute("color", colorService.detail(id));
            model.addAttribute("cl", new Color());
            return "color-view-update";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            model.addAttribute("color", colorService.detail(id));
            model.addAttribute("cl", new Color());
            return "color-view-update";
        }
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute("cl") Color color, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("colors", colorService.getAll());
            return "color";
        }
        colorService.add(color);
        return "redirect:/color/view-all";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("cl") Color color) {
        color.setId(id);
        color.setDateCreate(colorService.detail(id).getDateCreate());
        color.setStatus(1);
        colorService.update(color);
        return "redirect:/color/view-all";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        colorService.delete(id);
        model.addAttribute("cl", new Color());
        return "redirect:/color/view-all";
    }
}
