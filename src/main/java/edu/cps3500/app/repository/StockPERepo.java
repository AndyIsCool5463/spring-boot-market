package edu.cps3500.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.cps3500.app.domain.StockPE;

@Repository
public interface StockPERepo extends CrudRepository<StockPE, Long> {

    StockPE findByTicker(String ticker);

    StockPE findByCompany(String name);

    List<StockPE> findAll();

    long count();
}