package com.ruoyi.site.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.site.mapper.WebMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.site.domain.WebMenu;
import com.ruoyi.site.service.IWebMenuService;
import com.ruoyi.common.core.text.Convert;

/**
 * 网站首页菜单Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-09
 */
@Service
public class WebMenuServiceImpl implements IWebMenuService 
{
    @Autowired
    private WebMenuMapper webMenuMapper;

    /**
     * 查询网站首页菜单
     * 
     * @param menuId 网站首页菜单ID
     * @return 网站首页菜单
     */
    @Override
    public WebMenu selectWebMenuById(Long menuId)
    {
        return webMenuMapper.selectWebMenuById(menuId);
    }

    /**
     * 查询网站首页菜单列表
     * 
     * @param webMenu 网站首页菜单
     * @return 网站首页菜单
     */
    @Override
    public List<WebMenu> selectWebMenuList(WebMenu webMenu)
    {
        return webMenuMapper.selectWebMenuList(webMenu);
    }

    /**
     * 新增网站首页菜单
     * 
     * @param webMenu 网站首页菜单
     * @return 结果
     */
    @Override
    public int insertWebMenu(WebMenu webMenu)
    {
        webMenu.setCreateTime(DateUtils.getNowDate());
        return webMenuMapper.insertWebMenu(webMenu);
    }

    /**
     * 修改网站首页菜单
     * 
     * @param webMenu 网站首页菜单
     * @return 结果
     */
    @Override
    public int updateWebMenu(WebMenu webMenu)
    {
        webMenu.setUpdateTime(DateUtils.getNowDate());
        return webMenuMapper.updateWebMenu(webMenu);
    }

    /**
     * 删除网站首页菜单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWebMenuByIds(String ids)
    {
        return webMenuMapper.deleteWebMenuByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除网站首页菜单信息
     * 
     * @param menuId 网站首页菜单ID
     * @return 结果
     */
    @Override
    public int deleteWebMenuById(Long menuId)
    {
        return webMenuMapper.deleteWebMenuById(menuId);
    }
}
