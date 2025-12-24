package com.foodnfun.backend.service.impl;
import com.foodnfun.backend.entity.MenuItem;
import com.foodnfun.backend.repository.MenuItemsRepository;
import com.foodnfun.backend.service.MenuItemsServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuItemsServiceImpl implements MenuItemsServices {

	private final MenuItemsRepository menuItemsRepository;

    public MenuItemsServiceImpl(MenuItemsRepository menuItemsRepository) {
        this.menuItemsRepository = menuItemsRepository;
    }

    @Override
    public MenuItem addMenuItem(MenuItem menuItem) {
        return menuItemsRepository.save(menuItem);
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemsRepository.findAll();
    }
}
