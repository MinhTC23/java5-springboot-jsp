package com.example.assignment_java5.controller;

import com.example.assignment_java5.entity.CartDetail;
import com.example.assignment_java5.entity.Manufacturer;
import com.example.assignment_java5.service.ManufacturerService;
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
@RequestMapping("/manufacturer/")
public class ManufacturerController {

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
            model.addAttribute("manufacturers", manufacturerService.getAll());
            model.addAttribute("mn", new Manufacturer());
            return "manufacturer";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            model.addAttribute("manufacturers", manufacturerService.getAll());
            model.addAttribute("mn", new Manufacturer());
            return "manufacturer";
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
            model.addAttribute("manufacturer", manufacturerService.detail(id));
            model.addAttribute("mn", new Manufacturer());
            return "manufacturer-view-update";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            model.addAttribute("manufacturer", manufacturerService.detail(id));
            model.addAttribute("mn", new Manufacturer());
            return "manufacturer-view-update";
        }
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute("mn") Manufacturer manufacturer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("manufacturers", manufacturerService.getAll());
            return "manufacturer";
        }
        manufacturerService.add(manufacturer);
        return "redirect:/manufacturer/view-all";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("mn") Manufacturer manufacturer) {
        manufacturer.setId(id);
        manufacturer.setDateCreate(manufacturerService.detail(id).getDateCreate());
        manufacturer.setStatus(1);
        manufacturerService.update(manufacturer);
        return "redirect:/manufacturer/view-all";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        manufacturerService.delete(id);
        model.addAttribute("mn", new Manufacturer());
        return "redirect:/manufacturer/view-all";
    }
}
