package com.kairos.examen

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable

import org.springframework.http.ResponseEntity;

import com.kairos.examen.ProductRepository

@RestController
@RequestMapping("/producto")
public class HelloController {
    @Autowired
    private ProductRepository productRepository


    @GetMapping("/{id}")
    def show( @PathVariable("id") Integer id,
              @RequestHeader(value="ID_CLIENT_SESSION") String ID_CLIENT_SESSION) {
        if(ID_CLIENT_SESSION == "78965088" ){
            if (id != null) {
                def product = productRepository.findById(id)
                return product
            }else{
                return new ResponseEntity<>( HttpStatus.NOT_FOUND)
            }
        }
    }

    @PostMapping
    public Product addNewProduct (@RequestHeader(value="ID_CLIENT_SESSION") String ID_CLIENT_SESSION,
            @RequestBody  Product newProduct) {
        if(ID_CLIENT_SESSION == "78965088" ) {
            productRepository.save(newProduct)
            return newProduct
        }
    }

    @GetMapping
    public @ResponseBody Iterable<Product> getAllUsers(
            @RequestHeader(value="ID_CLIENT_SESSION") String ID_CLIENT_SESSION) {
        if(ID_CLIENT_SESSION == "78965088" ){
            return  productRepository.findAll()
        }
    }

    @PutMapping("/{id}")
    public def update(@PathVariable("id") Integer id,
                      @RequestBody Product newProduct,
                      @RequestHeader(value="ID_CLIENT_SESSION") String ID_CLIENT_SESSION) {
        if(ID_CLIENT_SESSION == "78965088" ){
            def find = productRepository.findById(id)
            if (find != null ) {
                newProduct.id  = id
                productRepository.save(newProduct)
                return newProduct
            }else{
                return "404"
            }
        }else{
            return "unautorized"
        }

    }


}
