package org.example.repository.impl;

import org.example.base.domain.BaseEntity;
import org.example.base.repository.impl.BaseEntityRepositoryImpl;
import org.example.domain.Brand;
import org.example.domain.Category;
import org.example.domain.Product;
import org.example.repository.ProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductRepositoryImpl extends BaseEntityRepositoryImpl implements ProductRepository {
    public ProductRepositoryImpl(Connection connection) {
        super(connection);
    }


    @Override
    protected String getEntityTableName() {
        return Product.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Product product = new Product();

        product.setId(
                resultSet.getLong(1)
        );
        product.setName(
                resultSet.getString(2)
        );
        product.setCreateDate(
                resultSet.getString(4)
        );
        product.setCategory(
                (Category) new CategoryRepositoryImpl(this.connection).findById(resultSet.getLong(4))
        );
        product.setBrand(
                (Brand) new BrandRepositoryImpl(this.connection).findById(resultSet.getLong(4))
        );

        return product;
    }

    @Override
    protected void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        Product product = (Product) entity;
        preparedStatement.setString(
                1,
                product.getName()
        );
        preparedStatement.setString(
                2,
                product.getCreateDate()
        );
        preparedStatement.setLong(
                3,
                product.getBrand().getId()
        );
        preparedStatement.setLong(
                4,
                product.getCategory().getId()
        );
    }

    @Override
    protected void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement, BaseEntity entity) throws SQLException {
        Product product = (Product) entity;
        preparedStatement.setString(
                1,
                product.getName()
        );
        preparedStatement.setString(
                2,
                product.getCreateDate()
        );
        preparedStatement.setLong(
                3,
                product.getBrand().getId()
        );
        preparedStatement.setLong(
                4,
                product.getCategory().getId()
        );
        preparedStatement.setLong(
                5,
                product.getId()
        );
    }

    @Override
    protected String[] getInsertColumnsForSecondApproach() {
        return new String[]{
                Product.NAME,
                Product.CREATE_DATE,
                Product.BRAND,
                Product.CATEGORY
        };
    }
}
