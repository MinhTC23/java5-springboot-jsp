package com.example.assignment_java5.controller;

import com.example.assignment_java5.entity.Bill;
import com.example.assignment_java5.entity.BillProduct;
import com.example.assignment_java5.entity.CartDetail;
import com.example.assignment_java5.entity.Color;
import com.example.assignment_java5.entity.ProductDetails;
import com.example.assignment_java5.service.BillProductService;
import com.example.assignment_java5.service.BillService;
import com.example.assignment_java5.service.ProductDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private ProductDetailsService productDetailsService;

    @Autowired
    private BillService billService;

    @Autowired
    private BillProductService billProductService;

    @Autowired
    HttpServletRequest request;

    @GetMapping("/home")
    public String home(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page) {
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
            Page<ProductDetails> productDetailsPage = productDetailsService.paging(page, 8);
            model.addAttribute("productDetailss", productDetailsPage.getContent());
            model.addAttribute("totalPages", productDetailsPage.getTotalPages());
            return "home";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            Page<ProductDetails> productDetailsPage = productDetailsService.paging(page, 8);
            model.addAttribute("productDetailss", productDetailsPage.getContent());
            model.addAttribute("totalPages", productDetailsPage.getTotalPages());
            return "home";
        }
    }

    @GetMapping("/contact")
    public String contact(Model model) {
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
            return "contact";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            return "contact";
        }
    }

    @GetMapping("/introduce")
    public String introduce(Model model) {
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
            return "introduce";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            return "introduce";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-success")
    public String loginSuccess() {
        return "redirect:/home"; // Redirect tới trang home sau khi đăng nhập thành công
    }

    @GetMapping("/pay")
    public String pay(Model model) {
        try {
            HttpSession session = request.getSession();
            CartDetail cartDetail = (CartDetail) session.getAttribute("cartDetail");
            model.addAttribute("cartDetail", cartDetail);
            float totalsAmount = 0f;
            int quantity = 0;
            for (CartDetail cd : cartDetail.getList()
            ) {
                Float sum = cd.getUnitPrice() * cd.getNumber();
                totalsAmount += sum;
                quantity += cd.getNumber();
            }
            model.addAttribute("quantity", quantity);
            model.addAttribute("totalsAmount", totalsAmount);
            model.addAttribute("bill", new Bill());
            return "pay";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            model.addAttribute("totalsAmount", 0);
            return "pay";
        }
    }

    @PostMapping("/pay-ok")
    public String payOk(@Valid @ModelAttribute("bill") Bill bill, BindingResult result, Model model) {
        if (result.hasErrors()) {
            HttpSession session = request.getSession();
            CartDetail cartDetail = (CartDetail) session.getAttribute("cartDetail");
            model.addAttribute("cartDetail", cartDetail);
            int quantity = 0;
            for (CartDetail cd : cartDetail.getList()
            ) {
                quantity += cd.getNumber();
            }
            model.addAttribute("quantity", quantity);
            return "pay";
        }
        billService.add(bill);
        HttpSession session = request.getSession();
        CartDetail cartDetail = (CartDetail) session.getAttribute("cartDetail");
        model.addAttribute("cartDetail", cartDetail);
        Float totalsAmount = 0F;
        for (CartDetail cd : cartDetail.getList()
        ) {
            BillProduct billProduct = new BillProduct();
            Float sum = cd.getUnitPrice() * cd.getNumber();
            billProduct.setNumber(cd.getNumber());
            billProduct.setUnitPrice(cd.getUnitPrice());
            billProduct.setAmount(sum);
            billProduct.setProductDetails(cd.getProductDetails());
            billProduct.setBill(bill);
            billProductService.add(billProduct);
            totalsAmount += sum;
            model.addAttribute("billProduct", billProduct);
            model.addAttribute("totalsAmount", totalsAmount);
//            productDetailsService.updateNumber(cd.getNumber(), cd.getProductDetails().getId());
        }
        cartDetail.getList().removeAll(cartDetail.getList());
        model.addAttribute("quantity", 0);
        return "pay-done";
    }

    @GetMapping("/search-bill")
    public String searchView(Model model) {
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
            return "search-bill";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            return "search-bill";
        }
    }

    @GetMapping("/bill-search")
    public String search(Model model, @RequestParam("phoneNumber") String phoneNumber) {
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
            model.addAttribute("billSearchs", billProductService.search(phoneNumber));
            return "search-bill";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            model.addAttribute("billSearchs", billProductService.search(phoneNumber));
            return "search-bill";
        }
    }

    @GetMapping("/buy-now/{id}")
    public String buyNow(Model model, @PathVariable("id") Integer id) {
        try {
            HttpSession session1 = request.getSession();
            CartDetail cartDetail = (CartDetail) session1.getAttribute("cartDetail");
            model.addAttribute("cartDetail", cartDetail);
            int quantity = 0;
            for (CartDetail cd : cartDetail.getList()
            ) {
                quantity += cd.getNumber();
            }
            model.addAttribute("quantity", quantity);
            ProductDetails productDetails = productDetailsService.detail(id);
            BillProduct billProduct = new BillProduct();
            billProduct.setNumber(1);
            billProduct.setUnitPrice(productDetails.getCategory().getProductLine().getPrice());
            billProduct.setAmount(billProduct.getNumber() * billProduct.getUnitPrice());
            billProduct.setProductDetails(productDetails);
            model.addAttribute("billProduct", billProduct);
            model.addAttribute("bill", new Bill());
            HttpSession session = request.getSession();
            session.setAttribute("billProduct", billProduct);
            return "buy-now";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            ProductDetails productDetails = productDetailsService.detail(id);
            BillProduct billProduct = new BillProduct();
            billProduct.setNumber(1);
            billProduct.setUnitPrice(productDetails.getCategory().getProductLine().getPrice());
            billProduct.setAmount(billProduct.getNumber() * billProduct.getUnitPrice());
            billProduct.setProductDetails(productDetails);
            model.addAttribute("billProduct", billProduct);
            model.addAttribute("bill", new Bill());
            HttpSession session = request.getSession();
            session.setAttribute("billProduct", billProduct);
            return "buy-now";
        }
    }

    @PostMapping("/buy")
    public String buy(@Valid @ModelAttribute("bill") Bill bill, BindingResult result, Model model) {
        try {
            if (result.hasErrors()) {
                HttpSession session = request.getSession();
                CartDetail cartDetail = (CartDetail) session.getAttribute("cartDetail");
                model.addAttribute("cartDetail", cartDetail);
                int quantity = 0;
                for (CartDetail cd : cartDetail.getList()
                ) {
                    quantity += cd.getNumber();
                }
                model.addAttribute("quantity", quantity);
                return "buy-now";
            }
            HttpSession session1 = request.getSession();
            CartDetail cartDetail = (CartDetail) session1.getAttribute("cartDetail");
            model.addAttribute("cartDetail", cartDetail);
            int quantity = 0;
            for (CartDetail cd : cartDetail.getList()
            ) {
                quantity += cd.getNumber();
            }
            model.addAttribute("quantity", quantity);
            billService.add(bill);
            HttpSession session = request.getSession();
            BillProduct billProduct = (BillProduct) session.getAttribute("billProduct");
            billProduct.setBill(bill);
            Float totalsAmount = billProduct.getAmount();
            billProductService.add(billProduct);
            model.addAttribute("totalsAmount", totalsAmount);
            return "pay-done";
        } catch (NullPointerException e) {
            model.addAttribute("quantity", 0);
            billService.add(bill);
            HttpSession session = request.getSession();
            BillProduct billProduct = (BillProduct) session.getAttribute("billProduct");
            billProduct.setBill(bill);
            Float totalsAmount = billProduct.getAmount();
            billProductService.add(billProduct);
            model.addAttribute("totalsAmount", totalsAmount);
            return "pay-done";
        }
    }
}
