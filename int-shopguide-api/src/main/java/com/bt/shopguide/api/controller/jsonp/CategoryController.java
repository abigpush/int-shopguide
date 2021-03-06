package com.bt.shopguide.api.controller.jsonp;

import com.bt.shopguide.api.system.GlobalVariable;
import com.bt.shopguide.api.vo.JsonResult;
import com.bt.shopguide.api.vo.JsonResultArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caiting on 2017/10/10.
 */
@RequestMapping(value="/categorys")
@RestController
public class CategoryController {

    @RequestMapping(value = "")
    @ResponseBody
    public JsonResult getCategorys(@RequestParam(value = "nation",required = false) String nation){
        JsonResult jsonResult = new JsonResult();
        JsonResultArray jra = new JsonResultArray();
        if("us".equalsIgnoreCase(nation)){
            jra.setList(GlobalVariable.us_categorys);
        }else {
            jra.setList(GlobalVariable.categorys);
        }
        jsonResult.setResult(jra);
        return  jsonResult;
    }
}
