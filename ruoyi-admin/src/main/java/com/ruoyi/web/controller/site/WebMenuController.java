package com.ruoyi.web.controller.site;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.site.domain.WebMenu;
import com.ruoyi.site.service.IWebMenuService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 网站首页菜单Controller
 * 
 * @author ruoyi
 * @date 2020-12-09
 */
@Controller
@RequestMapping("/site/menu")
public class WebMenuController extends BaseController
{
    private String prefix = "site/menu";

    @Autowired
    private IWebMenuService webMenuService;

    @RequiresPermissions("site:menu:view")
    @GetMapping()
    public String menu()
    {
        return prefix + "/menu";
    }

    /**
     * 查询网站首页菜单列表
     */
    @RequiresPermissions("site:menu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WebMenu webMenu)
    {
        startPage();
        List<WebMenu> list = webMenuService.selectWebMenuList(webMenu);
        return getDataTable(list);
    }

    /**
     * 导出网站首页菜单列表
     */
    @RequiresPermissions("site:menu:export")
    @Log(title = "网站首页菜单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WebMenu webMenu)
    {
        List<WebMenu> list = webMenuService.selectWebMenuList(webMenu);
        ExcelUtil<WebMenu> util = new ExcelUtil<WebMenu>(WebMenu.class);
        return util.exportExcel(list, "menu");
    }

    /**
     * 新增网站首页菜单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存网站首页菜单
     */
    @RequiresPermissions("site:menu:add")
    @Log(title = "网站首页菜单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WebMenu webMenu)
    {
        return toAjax(webMenuService.insertWebMenu(webMenu));
    }

    /**
     * 修改网站首页菜单
     */
    @GetMapping("/edit/{menuId}")
    public String edit(@PathVariable("menuId") Long menuId, ModelMap mmap)
    {
        WebMenu webMenu = webMenuService.selectWebMenuById(menuId);
        mmap.put("webMenu", webMenu);
        return prefix + "/edit";
    }

    /**
     * 修改保存网站首页菜单
     */
    @RequiresPermissions("site:menu:edit")
    @Log(title = "网站首页菜单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WebMenu webMenu)
    {
        return toAjax(webMenuService.updateWebMenu(webMenu));
    }

    /**
     * 删除网站首页菜单
     */
    @RequiresPermissions("site:menu:remove")
    @Log(title = "网站首页菜单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(webMenuService.deleteWebMenuByIds(ids));
    }
}
