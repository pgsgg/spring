package com.ezen.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ezen.biz.dto.ProductVO;
import com.ezen.biz.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "product_detail" ,method = RequestMethod.GET )
	public String productDetailAction(ProductVO vo, Model model) {
		
		//상품 상세 조회
		ProductVO productVO =  productService.getProduct(vo);
		
		//JSP에 결과 조회
		model.addAttribute("productVO", productVO);
		return "product/productDetail";
	}
	
	@GetMapping("/category")
	public String productKindAction(ProductVO vo,Model model){
		
		List<ProductVO> productKindList = productService.getProductListByKind(vo.getKind());
		
		model.addAttribute("productKindList", productKindList);
		return "product/productKind";
	}
}
