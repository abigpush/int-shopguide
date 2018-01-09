package com.bt.shopguide.api.controller.jsonp;

import com.bt.shopguide.api.vo.JsonResult;
import com.bt.shopguide.api.vo.JsonResultArrayWithPage;
import com.bt.shopguide.dao.entity.GoodsList;
import com.bt.shopguide.dao.service.IGoodsListService;
import com.bt.shopguide.dao.vo.PageDataVo;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by caiting on 2018/1/9.
 */
@RestController
@RequestMapping(value = "/m")
public class GoodsForMobileController {

    @Value("${page.pageSize}")
    private int pageSize = 20;
    @Value("${project.charset}")
    private String charset;

    @Autowired
    private IGoodsListService goodsListService;
    @Autowired
    private GoodsController goodsController;

    @RequestMapping(value = "/internal/goods")
    @ResponseBody
    public JsonResult getInternalGoods(@RequestParam(value = "page",defaultValue = "1") Integer pageIndex,
                               @RequestParam(value = "mall",required = false) String mallName,
                               @RequestParam(value = "category",required = false) String category,
                               @RequestParam(value = "nation",required = false) String nation,
                               @RequestParam(value = "id",required = false) Long id,
                               @RequestParam(value = "sync",required = false) Long syncTime){

        return goodsController.getGoodsList(pageIndex, mallName, category, nation, id, syncTime);
    }

    @RequestMapping(value = "/internal/goods/get-new")
    @ResponseBody
    public JsonResult getInternalNewGoods(@RequestParam(value = "page",defaultValue = "1") Integer pageIndex,
                               @RequestParam(value = "mall",required = false) String mallName,
                               @RequestParam(value = "category",required = false) String category,
                               @RequestParam(value = "nation",required = false) String nation,
                               @RequestParam(value = "id",required = false) Long id,
                               @RequestParam(value = "sync",required = false) Long syncTime){
        JsonResult result = new JsonResult();
        JsonResultArrayWithPage jrap = new JsonResultArrayWithPage();

        //组装分页组件
        PageDataVo<GoodsList> vo = new PageDataVo<>();
        vo.setPageIndex(pageIndex);
        vo.setPageSize(pageSize);
        Map<String,Object> condition = Maps.newHashMap();
        if(mallName!=null) condition.put("mallName",mallName);
        if(category!=null) condition.put("category",category);
        if(nation!=null&&nation.length()>0) condition.put("nation",nation);
        if(id!=null) condition.put("id",id);
        if(syncTime!=null) condition.put("syncTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(syncTime)));
        vo.setConditionMap(condition);
        goodsListService.selectGoodsListPage(vo);

        //获取分页数据
        jrap.setPageIndex(pageIndex);
        jrap.setPageSize(pageSize);
        jrap.setTotalCount(vo.getTotalCount());
//        jrap.setList(vo.getData());

        result.setResult(jrap);
        return result;
    }

    @RequestMapping(value = "/abroad/goods")
    @ResponseBody
    public JsonResult getAbroadGoods(@RequestParam(value = "page",defaultValue = "1") Integer pageIndex,
                               @RequestParam(value = "mall",required = false) String mallName,
                               @RequestParam(value = "category",required = false) String category,
                               @RequestParam(value = "id",required = false) Long id,
                               @RequestParam(value = "sync",required = false) Long syncTime){

        return goodsController.getGoodsList(pageIndex, mallName, category, "us", id, syncTime);
    }

    @RequestMapping(value = "/abroad/goods/get-new")
    @ResponseBody
    public JsonResult getAbroadNewGoods(@RequestParam(value = "page",defaultValue = "1") Integer pageIndex,
                                  @RequestParam(value = "mall",required = false) String mallName,
                                  @RequestParam(value = "category",required = false) String category,
                                  @RequestParam(value = "id",required = false) Long id,
                                  @RequestParam(value = "sync",required = false) Long syncTime){

        return this.getInternalNewGoods(pageIndex, mallName, category,"us", id, syncTime);
    }
}
