package com.stylefeng.guns.modular.dist.service;

import com.stylefeng.guns.common.persistence.model.User;

public interface ITaskService {


    @Deprecated
    void upgradeLevel(String type);

    void clearData(User user);

    void clearAuthDB();

    void upgradeLevelVersionTwo(String identityType);

}
