package com.ionut.hplusapp.controller;

import com.ionut.hplusapp.model.*;
import com.ionut.hplusapp.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.task.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.*;

import javax.servlet.http.*;
import java.util.*;
import java.util.concurrent.*;

@Controller
public class SearchController {

    @Autowired
    ProductRepository productRepository;

    private AsyncTaskExecutor executor;

    @GetMapping("/search")
    public Callable<String> search(@RequestParam("search") String search, Model model,
                                   HttpServletRequest request) {
        System.out.println("In search controller");
        System.out.println("search criteria:" + search);
        System.out.println(request.isAsyncSupported());
        System.out.println("Thread from the servlet container: " + Thread.currentThread().getName());

        return ()-> {
            Thread.sleep(3000);
            System.out.println("Thread from the spring mvc task executor: " + Thread.currentThread().getName());
            List<Product> products = new ArrayList<>();
            products = productRepository.searchByName(search);
            model.addAttribute("products", products);
            return "search";
        };
    }

//        public DeferredResult<String> search(@RequestParam("search") String search, Model model,
//                                             HttpServletRequest request) {
//        DeferredResult<String> deferredResult = new DeferredResult<>();
//        System.out.println("In search controller");
//        System.out.println("search criteria:" + search);
//        System.out.println(request.isAsyncSupported());
//        System.out.println("Thread from the servlet container: " + Thread.currentThread().getName());
//
//        executor.execute(()-> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Thread from the spring mvc task executor: " + Thread.currentThread().getName());
//            List<Product> products = new ArrayList<>();
//            products = productRepository.searchByName(search);
//            model.addAttribute("products", products);
//            deferredResult.setResult("search");
//        });
//
//        return deferredResult;
//    }
}
