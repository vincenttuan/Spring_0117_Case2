package com.web.portfolio.dao;

import com.web.portfolio.entity.Watch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "watchRepository")
public interface WatchRepository extends CrudRepository<Watch, Long>{

}