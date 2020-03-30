package com.web.portfolio.controller;

import com.web.portfolio.entity.Investor;
import com.web.portfolio.service.PortfolioService;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio/investor")
public class InvestorController {
    @Autowired
    private PortfolioService service;
    
    @GetMapping(value = {"/", "/query"})
    public Iterable<Investor> query() {
        return service.getInvestorRepository().findAll();
    }
    
    @PostMapping(value = {"/", "/add"})
    @Transactional
    public Investor add(@RequestBody Map<String, String> map) {
        System.out.println(map);
        Investor investor = new Investor();
        investor.setUsername(map.get("username"));
        investor.setPassword(map.get("password"));
        investor.setEmail(map.get("email"));
        investor.setBalance(Integer.parseInt(map.get("balance")));
        investor.setCode(Integer.toHexString(investor.hashCode()));
        investor.setPass(Boolean.TRUE);
        service.getInvestorRepository().save(investor);
        return investor;
    }
    
    @DeleteMapping(value = {"/{id}", "/delete/{id}"})
    @Transactional
    public Boolean delete(@PathVariable("id") Long id) {
        service.getInvestorRepository().delete(id);
        return true;
    }
    
}
