package org.example.service.impl;

import org.example.repository.ShareholderBrandRepository;
import org.example.service.ShareholderBrandService;

import java.sql.SQLException;

public class ShareholderBrandServiceImpl implements ShareholderBrandService {
    ShareholderBrandRepository shareholderBrandRepository;
    public ShareholderBrandServiceImpl(ShareholderBrandRepository shareholderBrandRepository) {
        this.shareholderBrandRepository = shareholderBrandRepository;
    }

    @Override
    public void register(long shareholder_id, long brand_id) throws SQLException {
        shareholderBrandRepository.save(shareholder_id,brand_id);
    }

    @Override
    public void delete(long shareholder_id, long brand_id) throws SQLException {
        shareholderBrandRepository.delete(shareholder_id,brand_id);
    }
}
