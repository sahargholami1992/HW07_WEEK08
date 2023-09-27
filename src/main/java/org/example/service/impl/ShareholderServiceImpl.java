package org.example.service.impl;

import org.example.base.repository.BaseEntityRepository;
import org.example.base.service.impl.BaseEntityServiceImpl;
import org.example.service.ShareholderService;

public class ShareholderServiceImpl extends BaseEntityServiceImpl
        implements ShareholderService {
    public ShareholderServiceImpl(BaseEntityRepository baseRepository) {
        super(baseRepository);
    }
}
