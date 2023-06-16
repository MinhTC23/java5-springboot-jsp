package com.example.assignment_java5.controller;

import com.example.assignment_java5.entity.CartDetail;
import com.example.assignment_java5.entity.Customer;
import com.example.assignment_java5.service.CustomerService;
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
@RequestMapping("/customer/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

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
            model.addAttribute("customers", customerService.getAll());
            model.addAttribute("ct", new Customer());
            return "customer";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            model.addAttribute("customers", customerService.getAll());
            model.addAttribute("ct", new Customer());
            return "customer";
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
            model.addAttribute("customer", customerService.detail(id));
            model.addAttribute("ct", new Customer());
            return "customer-view-update";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            model.addAttribute("customer", customerService.detail(id));
            model.addAttribute("ct", new Customer());
            return "customer-view-update";
        }
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute("ct") Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("customers", customerService.getAll());
            return "customer";
        }
        customerService.add(customer);
        return "redirect:/customer/view-all";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("ct") Customer customer) {
        customer.setId(id);
        customerService.update(customer);
        return "redirect:/customer/view-all";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        customerService.delete(id);
        model.addAttribute("ct", new Customer());
        return "redirect:/customer/view-all";
    }
}
