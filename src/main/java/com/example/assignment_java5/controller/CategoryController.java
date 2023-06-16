package com.example.assignment_java5.controller;

import com.example.assignment_java5.entity.CartDetail;
import com.example.assignment_java5.entity.Category;
import com.example.assignment_java5.service.CapacityService;
import com.example.assignment_java5.service.CategoryService;
import com.example.assignment_java5.service.ColorService;
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
@RequestMapping("/category/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private CapacityService capacityService;

    @Autowired
    private ProductLineService productLineService;

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
            model.addAttribute("categorys", categoryService.getAll());
            model.addAttribute("colors", colorService.getAll());
            model.addAttribute("capacitys", capacityService.getAll());
            model.addAttribute("productLines", productLineService.getAll());
            model.addAttribute("ct", new Category());
            return "category";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            model.addAttribute("categorys", categoryService.getAll());
            model.addAttribute("colors", colorService.getAll());
            model.addAttribute("capacitys", capacityService.getAll());
            model.addAttribute("productLines", productLineService.getAll());
            model.addAttribute("ct", new Category());
            return "category";
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
            model.addAttribute("category", categoryService.detail(id));
            model.addAttribute("colors", colorService.getAll());
            model.addAttribute("capacitys", capacityService.getAll());
            model.addAttribute("productLines", productLineService.getAll());
            model.addAttribute("ct", new Category());
            return "category-view-update";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            model.addAttribute("category", categoryService.detail(id));
            model.addAttribute("colors", colorService.getAll());
            model.addAttribute("capacitys", capacityService.getAll());
            model.addAttribute("productLines", productLineService.getAll());
            model.addAttribute("ct", new Category());
            return "category-view-update";
        }
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute("ct") Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categorys", categoryService.getAll());
            model.addAttribute("colors", colorService.getAll());
            model.addAttribute("capacitys", capacityService.getAll());
            model.addAttribute("productLines", productLineService.getAll());
            return "category";
        }
        categoryService.add(category);
        return "redirect:/category/view-all";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("ct") Category category) {
        category.setId(id);
        category.setStatus(1);
        categoryService.update(category);
        return "redirect:/category/view-all";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        categoryService.delete(id);
        model.addAttribute("ct", new Category());
        return "redirect:/category/view-all";
    }
}
