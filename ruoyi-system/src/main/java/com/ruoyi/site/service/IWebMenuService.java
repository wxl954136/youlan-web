package com.ruoyi.site.service;

import java.util.List;
import com.ruoyi.site.domain.WebMenu;

/**
 * 网站首页菜单Service接口
 * 
 * @author ruoyi
 * @date 2020-12-09
 */
public interface IWebMenuService 
{
    /**
     * 查询网站首页菜单
     * 
     * @param menuId 网站首页菜单ID
     * @return 网站首页菜单
     */
    public WebMenu selectWebMenuById(Long menuId);

    /**
     * 查询网站首页菜单列表
     * 
     * @param webMenu 网站首页菜单
     * @return 网站首页菜单集合
     */
    public List<WebMenu> selectWebMenuList(WebMenu webMenu);

    /**
     * 新增网站首页菜单
     * 
     * @param webMenu 网站首页菜单
     * @return 结果
     */
    public int insertWebMenu(WebMenu webMenu);

    /**
     * 修改网站首页菜单
     * 
     * @param webMenu 网站首页菜单
     * @return 结果
     */
    public int updateWebMenu(WebMenu webMenu);

    /**
     * 批量删除网站首页菜单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWebMenuByIds(String ids);

    /**
     * 删除网站首页菜单信息
     * 
     * @param menuId 网站首页菜单ID
     * @return 结果
     */
    public int deleteWebMenuById(Long menuId);
}
