package com.example.assignment_java5.controller;

import com.example.assignment_java5.entity.Capacity;
import com.example.assignment_java5.entity.CartDetail;
import com.example.assignment_java5.service.CapacityService;
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
@RequestMapping("/capacity/")
public class CapacityController {

    @Autowired
    private CapacityService capacityService;

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
            model.addAttribute("capacitys", capacityService.getAll());
            model.addAttribute("cp", new Capacity());
            return "capacity";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            model.addAttribute("capacitys", capacityService.getAll());
            model.addAttribute("cp", new Capacity());
            return "capacity";
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
            model.addAttribute("capacity", capacityService.detail(id));
            model.addAttribute("cp", new Capacity());
            return "capacity-view-update";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            model.addAttribute("capacity", capacityService.detail(id));
            model.addAttribute("cp", new Capacity());
            return "capacity-view-update";
        }
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute("cp") Capacity capacity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("capacitys", capacityService.getAll());
            return "capacity";
        }
        capacityService.add(capacity);
        return "redirect:/capacity/view-all";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("cp") Capacity capacity) {
        capacity.setId(id);
        capacity.setDateCreate(capacityService.detail(id).getDateCreate());
        capacity.setStatus(1);
        capacityService.update(capacity);
        return "redirect:/capacity/view-all";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        capacityService.delete(id);
        model.addAttribute("cp", new Capacity());
        return "redirect:/capacity/view-all";
    }
}
