package edu.cps3500.app.service;

import java.util.List;

import edu.cps3500.app.domain.StockPE;

public interface StockService {
    public List<StockPE> getStockPEs(String ticker);

    public List<StockPE> getAllStocks();
}