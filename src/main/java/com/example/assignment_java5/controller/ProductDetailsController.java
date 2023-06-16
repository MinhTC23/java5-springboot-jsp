package com.example.assignment_java5.controller;

import com.example.assignment_java5.entity.CartDetail;
import com.example.assignment_java5.entity.Category;
import com.example.assignment_java5.entity.ProductDetails;
import com.example.assignment_java5.service.CategoryService;
import com.example.assignment_java5.service.ProductDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/product-details/")
public class ProductDetailsController {

    private static final String URL = "F:/Study/Fpoly/Summer 2023/Block1/Java5/Assignment_Java5/";

    @Autowired
    private ProductDetailsService productDetailsService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    HttpServletRequest request;

    @GetMapping("view-all")
    public String getAll(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page) {
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
            Page<ProductDetails> productDetailsPage = productDetailsService.paging(page, 5);
            model.addAttribute("productDetailss", productDetailsPage.getContent());
            model.addAttribute("totalPages", productDetailsPage.getTotalPages());
            model.addAttribute("categorys", categoryService.getAll());
            model.addAttribute("pd", new ProductDetails());
            return "product-details";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            Page<ProductDetails> productDetailsPage = productDetailsService.paging(page, 5);
            model.addAttribute("productDetailss", productDetailsPage.getContent());
            model.addAttribute("totalPages", productDetailsPage.getTotalPages());
            model.addAttribute("categorys", categoryService.getAll());
            model.addAttribute("pd", new ProductDetails());
            return "product-details";
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
            model.addAttribute("productDetails", productDetailsService.detail(id));
            model.addAttribute("categorys", categoryService.getAll());
            model.addAttribute("pd", new ProductDetails());
            return "product-details-view-update";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            model.addAttribute("productDetails", productDetailsService.detail(id));
            model.addAttribute("categorys", categoryService.getAll());
            model.addAttribute("pd", new ProductDetails());
            return "product-details-view-update";
        }
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        productDetailsService.delete(id);
        model.addAttribute("pd", new ProductDetails());
        return "redirect:/product-details/view-all";
    }

    @PostMapping("add")
    public String add(@RequestParam("images") MultipartFile image
            , @RequestParam("code") String code
            , @RequestParam("name") String name
            , @RequestParam("number") Integer number
            , @RequestParam("category") Category category) {
        // Kiểm tra xem tệp tin đã được tải lên chưa
        if (!image.isEmpty()) {
            try {
                // Lấy mảng byte của ảnh đã tải lên
                byte[] bytes = image.getBytes();

                // Lưu ảnh vào địa chỉ mong muốn
                Path path = Paths.get("uploads/" + image.getOriginalFilename());
                Files.write(path, bytes);

                // Trả về thông báo thành công hoặc chuyển hướng tới trang khác
                ProductDetails productDetails = ProductDetails.builder().code(code).name(name).number(number).category(category).images(image.getOriginalFilename()).build();
                productDetailsService.add(productDetails);
                return "redirect:/product-details/view-all";
            } catch (IOException e) {
                // Xử lý ngoại lệ
                return "product-details";
            }
        } else {
            // Xử lý trường hợp tệp tin trống
            return "product-details";
        }
    }

    @PostMapping("update/{id}")
    public String update(@RequestParam("code") String code
            , @RequestParam("name") String name
            , @RequestParam("number") Integer number
            , @RequestParam("category") Category category
            , @PathVariable("id") Integer id) {
        ProductDetails productDetails = ProductDetails.builder().id(id).code(code).name(name).number(number).category(category).images(productDetailsService.detail(id).getImages()).status(1).build();
        productDetailsService.update(productDetails);
        return "redirect:/product-details/view-all";
    }
}
