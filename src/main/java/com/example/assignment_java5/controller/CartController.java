package com.example.assignment_java5.controller;

import com.example.assignment_java5.entity.CartDetail;
import com.example.assignment_java5.entity.ProductDetails;
import com.example.assignment_java5.service.ProductDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductDetailsService productDetailsService;

    @Autowired
    HttpServletRequest request;

    private Boolean shouldShowButtons = false;

    @GetMapping("")
    public String cart(Model model) {
        try {
            HttpSession session = request.getSession();
            CartDetail cartDetail = (CartDetail) session.getAttribute("cartDetail");
            if (cartDetail.getList().isEmpty()) {
                shouldShowButtons = false;
                model.addAttribute("shouldShowButtons", shouldShowButtons);
                model.addAttribute("quantity", 0);
                return "cart";
            } else {
                model.addAttribute("cartDetail", cartDetail);
                float totalsAmount = 0f;
                int quantity = 0;
                for (CartDetail cd : cartDetail.getList()
                ) {
                    Float sum = cd.getUnitPrice() * cd.getNumber();
                    totalsAmount += sum;
                    quantity += cd.getNumber();
                }
                model.addAttribute("totalsAmount", totalsAmount);
                model.addAttribute("quantity", quantity);
                shouldShowButtons = true;
                model.addAttribute("shouldShowButtons", shouldShowButtons);
                return "cart";
            }
        } catch (NullPointerException e) {
            model.addAttribute("totalsAmount", 0);
            model.addAttribute("quantity", 0);
            return "cart";
        }
    }

    @GetMapping("/add/{id}")
    public String addCart(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        ProductDetails productDetails = productDetailsService.detail(id);
        CartDetail cartDetail = new CartDetail();
        cartDetail.setProductDetails(productDetails);
        cartDetail.setUnitPrice(productDetails.getCategory().getProductLine().getPrice());

        HttpSession session = request.getSession();
        CartDetail cartDetail1 = (CartDetail) session.getAttribute("cartDetail");
        if (cartDetail1 == null) {
            cartDetail1 = new CartDetail();
            session.setAttribute("cartDetail", cartDetail1);
        }
        cartDetail1.addItem(cartDetail);
        int quantity = 0;
        for (CartDetail cd : cartDetail1.getList()
        ) {
            quantity += cd.getNumber();
        }
        redirectAttributes.addFlashAttribute("quantity", quantity);
        return "redirect:/home";
    }

    @GetMapping("/remove/{index}")
    public String removeItem(@PathVariable("index") Integer index) {
        HttpSession session = request.getSession();
        CartDetail cartDetail = (CartDetail) session.getAttribute("cartDetail");
        cartDetail.getList().remove(index - 1);
        return "redirect:/cart";
    }

    @GetMapping("/remove-all")
    public String removeAllItem(Model model) {
        HttpSession session = request.getSession();
        CartDetail cartDetail = (CartDetail) session.getAttribute("cartDetail");
        cartDetail.getList().removeAll(cartDetail.getList());
        shouldShowButtons = false;
        model.addAttribute("shouldShowButtons", shouldShowButtons);
        model.addAttribute("quantity", 0);
        return "cart";
    }
}
