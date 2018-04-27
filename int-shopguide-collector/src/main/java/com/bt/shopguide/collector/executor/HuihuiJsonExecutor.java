package com.bt.shopguide.collector.executor;

import com.bt.shopguide.dao.entity.GoodsDetail;
import com.bt.shopguide.dao.entity.GoodsErrors;
import com.bt.shopguide.dao.entity.GoodsList;
import com.bt.shopguide.dao.service.IGoodsDetailService;
import com.bt.shopguide.dao.service.IGoodsErrorsService;
import com.bt.shopguide.dao.service.IGoodsListService;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by caiting on 2017/11/23.
 */

/** {
 "taskId": 2573546467,
 "seedId": 1397911,
 "createTime": "2017-11-27T17:03:59Z",
 "crawlTime": "2017-11-27T17:06:31Z",
 "pid": "4753794",
 "title": "先科 小型取暖器 倾倒断电 不伤眼                             ",
 "alltitle": "先科 小型取暖器 倾倒断电 不伤眼 29.9元包邮                            ",
 "price": "29.9元",
 "pubtime": "昨天13:48",
 "store": "天猫 ",
 "source": "价格网",
 "hot": "",
 "content": "<br/>                                                        天猫sast先科菲特专卖店39.9元，可领10元优惠券，实付29.9元包邮。先科 NSB-01 取暖器，两档温控，即开即热，底部设计倾倒开关，倾倒时会切断电源，采用加密坚固防护网罩高温，暗光不伤眼。冬天拿来暖暖脚是个不错的选择。                                                    ",
 "contentHTML": "<br/>                                                        <div class=\"goodccdt\"><p>天猫sast先科菲特专卖店39.9元，可领<a isconvert=\"1\" target=\"_blank\" href=\"https://uland.taobao.com/coupon/edetail?activityId=3923ffa397c4417b8661766df8eba42c&amp;itemId=557894801307&amp;nosrc=hds_ds&amp;dx=1&amp;nowake=1&amp;pid=mm_26322749_4094016_63792333\">10元优惠券</a>，实付29.9元包邮。先科 NSB-01 取暖器，两档温控，即开即热，底部设计倾倒开关，倾倒时会切断电源，采用加密坚固防护网罩高温，暗光不伤眼。冬天拿来暖暖脚是个不错的选择。</p><p><img nosrc=\"http://image.good.cc/images/good/loading.gif\" src=\"https://ofjn5tuqf.qnssl.com/192beb9606b6267c33f7a1f05673ce1b.jpg\"><img nosrc=\"http://image.good.cc/images/good/loading.gif\" src=\"https://ofjn5tuqf.qnssl.com/d14e360c1964b6d7540f0f735a9bf3c4.jpg\"><img nosrc=\"http://image.good.cc/images/good/loading.gif\" src=\"https://ofjn5tuqf.qnssl.com/20660169bdb93c48fb1c2264e96eca0b.jpg\"></p></div>                                                    ",
 "link": "https://detail.tmall.com/item.htm?id=557894801307",
 "reallink": "https://detail.tmall.com/item.htm?id=557894801307",
 "listImage": "https://ofjn5tuqf.qnssl.com/b8566cad656c79d90f8770408b99d594.jpg?imageView2/2/w/224/h/224",
 "docId": "1397911.4753794"
 }

 {
 "img": "http://oimageb5.ydstatic.com/image?id=-172346723140468161&product=gouwu",
 "canvas": "<canvas class=\"hui-history-axis\" width=\"720\" height=\"365\"></canvas><canvas class=\"hui-history-curve\" width=\"720\" height=\"365\"></canvas><canvas class=\"hui-history-canvas-tooltip\" note-type=\"tooltip-pointe\" width=\"720\" height=\"365\"></canvas><div class=\"hui-history-labels\"><div class=\"hui-history-time-axis\"><div class=\"hui-history-time-label-pc\" style=\"left:691px;\">4-18</div><div class=\"hui-history-time-label-pc\" style=\"left:580px;\">3-24</div><div class=\"hui-history-time-label-pc\" style=\"left:469px;\">2-27</div><div class=\"hui-history-time-label-pc\" style=\"left:358px;\">2-02</div><div class=\"hui-history-time-label-pc\" style=\"left:247px;\">1-08</div><div class=\"hui-history-time-label-pc\" style=\"left:136px;\">12-14</div><div class=\"hui-history-time-label-pc\" style=\"left:35px;\">11-18</div></div><div class=\"hui-history-price-axis\"><div class=\"hui-history-price-label\" style=\"top:-6px;\">300</div><div class=\"hui-history-price-label\" style=\"top:78px;\">250</div><div class=\"hui-history-price-label\" style=\"top:164px;\">200</div><div class=\"hui-history-price-label\" style=\"top:250px;\">150</div><div class=\"hui-history-price-label\" style=\"top:337px;\">100</div></div></div><div class=\"hui-history-most-price\"><dl style=\"top:55px;\"><dd>261.4</dd></dl><dl style=\"top:266px;\"><dd>145</dd></dl><dl style=\"top:165px;\" class=\"can-append\"><dd>199</dd></dl></div>",
 "ps": "亚马逊中国目前Z秒杀价139元包邮，低于以往国内推荐好价，适合新生儿各种姿势，多种玩法，喜欢的家长可以关注。",
 "CRAWL_TIME": 1524017911250,
 "pid": "48945761",
 "abstract": "早教益智与体能锻炼融合。躺着玩、坐着玩、爬着玩多种玩法。按动星星可切换模式，可拆卸玩偶，月亮小夜灯动物挂件可单独拆下来玩耍 ",
 "source": "亚马逊",
 "title": "FERSOAR F 烽索 HX20104 婴儿脚踏钢琴健身架 139元包邮",
 "url": "http://www.huihui.cn/deals/48945761",
 "content": "婴儿脚踏钢琴健身架，早教益智与体能锻炼融合。躺着玩、坐着玩、爬着玩多种玩法。按动星星可切换模式，可拆卸玩偶，月亮小夜灯动物挂件可单独拆下来玩耍。柔和护眼灯光、促进感官发育。走线紧密，活性环保印染，透气排湿。",
 "buyLink": "http://www.amazon.cn/gp/redirect.html?ie=UTF8&linkCode=ur2&tag=huihuichaozhigou-23&location=http://www.amazon.cn/mn/detailApp?asin=b076x4m5ns",
 "cat": "guonei",
 "SEED_ID": 75,
 "CREATE_TIME": 1524017973019,
 "reallink": "https://www.amazon.cn/mn/detailApp?asin=b076x4m5ns"
 }
 */
@Service
public class HuihuiJsonExecutor extends AbstractJsonExecutor {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(HuihuiJsonExecutor.class);

    @Autowired
    private IGoodsListService goodsListService;
    @Autowired
    private IGoodsDetailService goodsDetailService;
    @Autowired
    private IGoodsErrorsService goodsErrorsService;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String testJson="{\n" +
            " \"img\": \"http://oimageb5.ydstatic.com/image?id=-172346723140468161&product=gouwu\",\n" +
            " \"canvas\": \"<canvas class=\\\"hui-history-axis\\\" width=\\\"720\\\" height=\\\"365\\\"></canvas><canvas class=\\\"hui-history-curve\\\" width=\\\"720\\\" height=\\\"365\\\"></canvas><canvas class=\\\"hui-history-canvas-tooltip\\\" note-type=\\\"tooltip-pointe\\\" width=\\\"720\\\" height=\\\"365\\\"></canvas><div class=\\\"hui-history-labels\\\"><div class=\\\"hui-history-time-axis\\\"><div class=\\\"hui-history-time-label-pc\\\" style=\\\"left:691px;\\\">4-18</div><div class=\\\"hui-history-time-label-pc\\\" style=\\\"left:580px;\\\">3-24</div><div class=\\\"hui-history-time-label-pc\\\" style=\\\"left:469px;\\\">2-27</div><div class=\\\"hui-history-time-label-pc\\\" style=\\\"left:358px;\\\">2-02</div><div class=\\\"hui-history-time-label-pc\\\" style=\\\"left:247px;\\\">1-08</div><div class=\\\"hui-history-time-label-pc\\\" style=\\\"left:136px;\\\">12-14</div><div class=\\\"hui-history-time-label-pc\\\" style=\\\"left:35px;\\\">11-18</div></div><div class=\\\"hui-history-price-axis\\\"><div class=\\\"hui-history-price-label\\\" style=\\\"top:-6px;\\\">300</div><div class=\\\"hui-history-price-label\\\" style=\\\"top:78px;\\\">250</div><div class=\\\"hui-history-price-label\\\" style=\\\"top:164px;\\\">200</div><div class=\\\"hui-history-price-label\\\" style=\\\"top:250px;\\\">150</div><div class=\\\"hui-history-price-label\\\" style=\\\"top:337px;\\\">100</div></div></div><div class=\\\"hui-history-most-price\\\"><dl style=\\\"top:55px;\\\"><dd>261.4</dd></dl><dl style=\\\"top:266px;\\\"><dd>145</dd></dl><dl style=\\\"top:165px;\\\" class=\\\"can-append\\\"><dd>199</dd></dl></div>\",\n" +
            " \"ps\": \"亚马逊中国目前Z秒杀价139元包邮，低于以往国内推荐好价，适合新生儿各种姿势，多种玩法，喜欢的家长可以关注。\",\n" +
            " \"CRAWL_TIME\": 1524017911250,\n" +
            " \"pid\": \"48945761\",\n" +
            " \"abstract\": \"早教益智与体能锻炼融合。躺着玩、坐着玩、爬着玩多种玩法。按动星星可切换模式，可拆卸玩偶，月亮小夜灯动物挂件可单独拆下来玩耍 \",\n" +
            " \"source\": \"亚马逊\",\n" +
            " \"title\": \"FERSOAR F 烽索 HX20104 婴儿脚踏钢琴健身架 139元包邮\",\n" +
            " \"url\": \"http://www.huihui.cn/deals/48945761\",\n" +
            " \"content\": \"婴儿脚踏钢琴健身架，早教益智与体能锻炼融合。躺着玩、坐着玩、爬着玩多种玩法。按动星星可切换模式，可拆卸玩偶，月亮小夜灯动物挂件可单独拆下来玩耍。柔和护眼灯光、促进感官发育。走线紧密，活性环保印染，透气排湿。\",\n" +
            " \"buyLink\": \"http://www.amazon.cn/gp/redirect.html?ie=UTF8&linkCode=ur2&tag=huihuichaozhigou-23&location=http://www.amazon.cn/mn/detailApp?asin=b076x4m5ns\",\n" +
            " \"cat\": \"guonei\",\n" +
            " \"SEED_ID\": 75,\n" +
            " \"CREATE_TIME\": 1524017973019,\n" +
            " \"reallink\": \"https://www.amazon.cn/mn/detailApp?asin=b076x4m5ns\"\n" +
            " }";

    @Override
    public void execute(String json) {
        JsonObject obj = new JsonParser().parse(json).getAsJsonObject();

        String url= "";
        String mallName="";
        mallName = (obj.get("source")==null||obj.get("source").equals(JsonNull.INSTANCE))?"":obj.get("source").getAsString().trim().replace(" ","");
//        if("天猫".equals(mallName) || "亚马逊中国".equals(mallName)){
//            url = (obj.get("link")==null||obj.get("link").equals(JsonNull.INSTANCE))?"":obj.get("link").getAsString();
//        }else{
            url = (obj.get("reallink")==null||obj.get("reallink").equals(JsonNull.INSTANCE))?"":obj.get("reallink").getAsString();
//        }
        //爬虫可能会被反爬，导致关键字段没内容，这里用url当代表判断是否反爬，如果反爬，直接弃掉
        if(url.length()<1){
            return;
        }
        String pid = "cn_shopguide_goods_huihui_"+obj.get("pid").getAsString();
        logger.info("goods cache key:{}",new Object[]{pid});
        if(redisTemplate.opsForValue().get(pid)!=null){
            logger.info("huihui goods-{} has collected!",new Object[]{obj.get("pid")});
            return;
        }

        GoodsList glist = new GoodsList();
        GoodsDetail gdetail = new GoodsDetail();
        GoodsErrors gerror;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            glist.setTitle((obj.get("title")==null||obj.get("title").equals(JsonNull.INSTANCE))?"":obj.get("title").getAsString());
            glist.setDiscounts((obj.get("price")==null||obj.get("price").equals(JsonNull.INSTANCE))?"":obj.get("price").getAsString());
            String content = (obj.get("content")==null||obj.get("content").equals(JsonNull.INSTANCE))?"":obj.get("content").getAsString().replaceAll("<br/>","").trim();
            content = dealContent(content);
            if(content.length()>160)
                content = content.substring(0,160);
            glist.setShortContent(content);
            glist.setMallName(mallName);
//            glist.setGoodSourceName((obj.get("source")==null||obj.get("source").equals(JsonNull.INSTANCE))?"":obj.get("source").getAsString().trim());
            glist.setGoodSourceName("惠惠网");
            glist.setCreateTime(new Date());
            //商品分类
            String cate = (obj.get("cate")==null || obj.get("cate").equals(JsonNull.INSTANCE))?"":obj.get("cate").getAsString();
            String nation = (obj.get("nation")==null || obj.get("nation").equals(JsonNull.INSTANCE))?"":obj.get("nation").getAsString();

            if(StringUtils.isNotEmpty(cate)){
                glist.setCategory(cate);
            }
            if(StringUtils.isNotEmpty(nation)){
                glist.setNation(nation);
            }
            byte publish = 1;
            //? 这里需转链
            glist.setUrl(dealUrl(url));
//            glist.setSmallImageUrl(obj.get("img").getAsString());
            glist.setSmallImageUrl((obj.get("img")==null || obj.get("img").equals(JsonNull.INSTANCE))?"":obj.get("img").getAsString());
            glist.setPublish(publish);
            glist.setSyncTime(dealSyncTime(sdf.parse(obj.get("CRAWL_TIME").getAsString().replaceAll("T"," ").replaceAll("Z",""))));
            glist.setCreateTime(new Date());
            glist.setThumbs(Math.abs(new Random().nextInt()%20));
            //插入goodslist
            int n = 0;
            try {
                n = goodsListService.save(glist);
            }catch(Exception e){
                logger.error("insert into goods_list faild！{}",new Object[]{e.getMessage()});
                gerror = new GoodsErrors();
                gerror.setReason("insert into goods_list faild！"+e.getMessage());
            }
            if(n>0){
                String contentHtml = (obj.get("content")==null || obj.get("content").equals(JsonNull.INSTANCE))?null:obj.get("content").getAsString();
                contentHtml = dealContent(contentHtml);
                gdetail.setContentHtml(contentHtml.getBytes(charset));
                gdetail.setCreateTime(new Date());
                gdetail.setGoodsId(glist.getId());
                try {
                    goodsDetailService.save(gdetail);
                }catch(Exception e){
                    logger.error("insert into goods_detail faild！{}",new Object[]{e.getMessage()});
                    gerror = new GoodsErrors();
                    gerror.setReason("insert into goods_detail faild！"+e.getMessage());
                }
                redisTemplate.opsForValue().set(pid,"1",timeout, TimeUnit.DAYS);
            }
        } catch (Exception e){
            logger.error("save good faild with exception :" + e);
        }
    }

    public static void main(String[] args) {
        System.out.println(new HuihuiJsonExecutor().dealContent("[\"<div class=\\\"mb10 add-copper\\\"> \\n <span class=\\\"d-report orange link\\\" id=\\\"setTimeout\\\"> <i class=\\\"nj-icon nj-icon-warn\\\"></i> </span> \\n</div> \\n<div class=\\\"desc-con post-content\\\" data-outlink>\\n <p> </p>\\n <p> Craft 男士贴身层套装运动内衣采用平缝接缝技术，无束缚感，面料柔软舒适，为冬季中等强度的户外I运动提供保暖和排汗功能，常规剪裁，适合各种身材。 </p> \\n <p> 目前亚马逊<strong>镇店之宝价199元包邮</strong>，近期好价，限M码。 </p> \\n <div> \\n  <br> \\n </div> \\n <p></p> \\n <div class=\\\"con clearfix editor-frame frame\\\"> \\n </div>\\n</div>\",\"<div class=\\\"mdbcontent\\\">\\n <div class=\\\"dp-desc\\\"> \\n  <div class=\\\"mb10 add-copper\\\"> \\n   <span class=\\\"d-report orange link\\\" id=\\\"setTimeout\\\"> <i class=\\\"nj-icon nj-icon-warn\\\"></i> </span> \\n  </div> \\n  <div class=\\\"desc-con post-content\\\" data-outlink>\\n   <p> </p>\\n   <p> Craft 男士贴身层套装运动内衣采用平缝接缝技术，无束缚感，面料柔软舒适，为冬季中等强度的户外I运动提供保暖和排汗功能，常规剪裁，适合各种身材。 </p> \\n   <p> 目前亚马逊<strong>镇店之宝价199元包邮</strong>，近期好价，限M码。 </p> \\n   <div> \\n    <br> \\n   </div> \\n   <p></p> \\n   <div class=\\\"con clearfix editor-frame frame\\\"> \\n   </div>\\n  </div> \\n </div>\\n</div>\",\"\"]"));
    }
}
