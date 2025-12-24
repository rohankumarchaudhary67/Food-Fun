package com.foodnfun.backend.service;
import com.foodnfun.backend.entity.MenuItem;
import java.util.List;

public interface MenuItemsServices {

	MenuItem addMenuItem(MenuItem menuItem);

    List<MenuItem> getAllMenuItems();
}
