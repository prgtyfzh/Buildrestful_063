/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.a.project212;

import java.util.HashMap;
import java.util.Map;
import model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */

//mendefinisikan layanan web Restful
@RestController
public class ProductServiceController {
    //penggunaan hash map untuk menyimpan data
    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        honey.setDisc(10);
        honey.setPrice(65000);
        productRepo.put(honey.getId(), honey);
        
        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        almond.setDisc(10);
        almond.setPrice(65000);
        productRepo.put(almond.getId(), almond);
    }
    
    //menentukan request url (/products/{id}) method DELETE untuk mengakses rest endpoint
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }
    
    //menentukan request url (/products/{id}) method PUT untuk mengakses rest endpoint
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        //menambahkan conditional statement untuk id yang tidak ditemukan
        if(!productRepo.containsKey(id)){
        return new ResponseEntity<>("ID NOT FOUND", HttpStatus.NOT_FOUND);
        } else {
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
        }
    }
    
    //menentukan request url (/products) method POST untuk mengakses rest endpoint
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        //menambahkan conditional statement untuk id yang sudah digunakan
        if(productRepo.containsKey(product.getId())) {
        return new ResponseEntity<>("SORRY, ID HAS BEEN USED", HttpStatus.NOT_FOUND);
        }else{
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
        }
    }
    
    //menentukan request url (/products) method GET untuk mengakses rest endpoint
    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }
    
}
