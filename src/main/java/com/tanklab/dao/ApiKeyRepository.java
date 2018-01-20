package com.tanklab.dao;


import com.tanklab.bean.JDBC_STATUS;

public interface ApiKeyRepository {
    public boolean apiInDBOrNot(String api_key);

    public JDBC_STATUS addOneApiKey();
}
