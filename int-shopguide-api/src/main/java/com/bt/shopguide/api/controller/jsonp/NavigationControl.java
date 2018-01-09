package com.bt.shopguide.api.controller.jsonp;

import com.bt.shopguide.api.vo.JsonResult;
import com.bt.shopguide.api.vo.JsonResultArray;
import com.bt.shopguide.dao.service.INavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by caiting on 2018/1/9.
 */
@Component
@RequestMapping(value = "/navigations")
public class NavigationControl {

    @Autowired
    private INavigationService navigationService;

    @RequestMapping(value = "")
    @ResponseBody
    public JsonResult getNavigations(){
        JsonResult jsonResult = new JsonResult();
        JsonResultArray jra = new JsonResultArray();
        jra.setList(navigationService.getValid());
        jsonResult.setResult(jra);
        return  jsonResult;
    }
}
