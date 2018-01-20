package com.tanklab.service.implService;

import com.tanklab.dao.ApiKeyRepository;
import com.tanklab.service.IAPIKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class APIKeyService implements IAPIKey {

    @Autowired
    private ApiKeyRepository apiKeyDao;

    @Override
    public boolean checkAPIKeyInDB(String api_key) {
        return apiKeyDao.apiInDBOrNot(api_key);
    }
}
