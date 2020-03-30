package com.web.portfolio.dao;

import com.web.portfolio.entity.Portfolio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "portfolioRepository")
public interface PortfolioRepository extends CrudRepository<Portfolio, Long>{

}