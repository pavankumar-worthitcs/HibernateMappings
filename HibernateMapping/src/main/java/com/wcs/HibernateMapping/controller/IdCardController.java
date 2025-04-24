package com.wcs.HibernateMapping.controller;
import com.wcs.HibernateMapping.dto.IdCard;
import com.wcs.HibernateMapping.service.IdCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class IdCardController {
    @Autowired
    IdCardService idCardService;

    @PostMapping("/saveIdCard")
    public IdCard saveIdCard(@RequestBody IdCard idCard) {
        return idCardService.saveIdCard(idCard);
    }

    @GetMapping("/fetchIdCardById")
    public IdCard fetchIdCardById(@RequestParam Long idCardId) {
        return idCardService.fetchIdCardById(idCardId);
    }

    @DeleteMapping("/deleteIdCardById")
    public IdCard deleteIdCardById(@RequestParam Long idCardId) {
        return idCardService.deleteIdCardById(idCardId);
    }

    @PutMapping("/updateIdCardById")
    public IdCard updateIdCardById(@RequestParam Long idCardId,@RequestBody IdCard newIdCard) {
        return idCardService.updateIdCardById(idCardId, newIdCard);
    }
}
