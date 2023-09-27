package org.example.service;

import org.example.repository.ShareholderBrandRepository;

import java.sql.SQLException;

public interface ShareholderBrandService  {
    void register(long shareholder_id, long brand_id) throws SQLException;
    void delete(long shareholder_id, long brand_id) throws SQLException;
}
