package org.example.repository;

import java.sql.SQLException;

public interface ShareholderBrandRepository {
    public void save(long shareholder_id, long brand_id) throws SQLException;
    public void delete(long shareholder_id, long brand_id) throws SQLException;
}
