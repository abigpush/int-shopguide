package com.bt.shopguide.dao.service.imp;

import com.bt.shopguide.dao.entity.Navigation;
import com.bt.shopguide.dao.mapper.NavigationMapper;
import com.bt.shopguide.dao.service.INavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caiting on 2018/1/9.
 */
@Service
public class NavigationService implements INavigationService {
    @Autowired
    NavigationMapper navigationMapper;

    @Override
    public List<Navigation> getValid() {
        return navigationMapper.selectByStatus(0);
    }
}
