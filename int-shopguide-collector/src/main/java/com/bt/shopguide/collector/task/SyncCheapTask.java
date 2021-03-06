package com.bt.shopguide.collector.task;

import com.bt.shopguide.collector.util.HttpClientHelper;
import com.bt.shopguide.dao.entity.Coupon;
import com.bt.shopguide.dao.entity.GoodCheap;
import com.bt.shopguide.dao.service.ICouponService;
import com.bt.shopguide.dao.service.IGoodCheapService;
import com.bt.shopguide.dao.vo.PageDataVo;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by caiting on 2017/12/12.
 */
@Service
public class SyncCheapTask {
    Logger logger = Logger.getLogger(SyncGoodsTask.class);
    @Autowired
    private IGoodCheapService goodCheapService;
    @Value("${sync.pageSize}")
    private int PAGE_SIZE;
    @Value("${sync.waiting}")
    private long TIME_WAITING;
    @Value("${sync.errorWaiting}")
    private long TIME_ERROR_WAITING;
    @Value("${sync.cheap.apiUrl}")
    private String API_URL;

//    private String last_cheap_id_cfg_path=System.getProperty("user.dir")+ File.separator+"conf"+File.separator+"sync_cheap_id.ini";
    private String last_cheap_id_cfg_path="/sync_cheap_id.ini";
    private Properties prop;
    private long last_cheap_id;

    private HttpClientHelper helper;

    public SyncCheapTask(){
        prop = new Properties();
            logger.info("generate SyncCheapTask");
        try {
            prop.load(new FileInputStream(getClass().getResource(last_cheap_id_cfg_path).getFile()));
            this.last_cheap_id = Long.parseLong(prop.getProperty("last_id"));
            helper = HttpClientHelper.getInstance();
        } catch (IOException e) {
            logger.error("load sync_cheap_id.ini faild");
            this.last_cheap_id = 0;
        }catch(NumberFormatException e){
            logger.error("last_id is NaN in sync_cheap_id.ini");
            this.last_cheap_id = 0;
        }
        logger.info("last_cheap_id:+"+last_cheap_id);
    }

    public void execute(){
        logger.info("start SyncCheapTask");
        //正确读取配置才开始做事
        if(this.last_cheap_id>0){
            while(true){
                PageDataVo<GoodCheap> vo = new PageDataVo<>();
                vo.setPageSize(this.PAGE_SIZE);
                Map<String,Object> map = new HashMap<>();
                map.put("id",this.last_cheap_id);
                vo.setConditionMap(map);
                goodCheapService.selectGoodCheapPageOrderById(vo);
                logger.info("get page("+vo.getPageSize()+") after id("+this.last_cheap_id+")");
                if(vo.getData()!=null&&vo.getData().size()>0){
                    Gson gson = new Gson();
                    Map<String,String> param = new HashMap<>();
                    param.put("json",gson.toJson(vo.getData()));
                    try {
                        String content = this.helper.doPost(API_URL,param);
                        if(content!=null&& StringUtils.isNotEmpty(content)){
                            this.last_cheap_id = vo.getData().get(vo.getData().size()-1).getId();
                            this.writeToini();
                            logger.info("this.last_cheap_id updated:"+this.last_cheap_id);
                            try {
                                //每页上传后休息100ms
                                Thread.sleep(100);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }else{
                            //api访问存在问题，比如404，500等
                            logger.error("sync cheap to aip host faild!");
                            try {
                                Thread.sleep(this.TIME_ERROR_WAITING);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            continue;
                        }

                    }catch(Exception e){
                        e.printStackTrace();
                        logger.error("connect to aip host faild!");
                        try {
                            Thread.sleep(this.TIME_ERROR_WAITING);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        continue;
                    }
                }else{
                    //当前没有需要可上传，休息TIME_WAITING
                    try {
                        Thread.sleep(this.TIME_WAITING);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }

            }
        }
    }

    private void writeToini(){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(this.last_cheap_id_cfg_path);
            this.prop.put("last_id",String.valueOf(this.last_cheap_id));
            this.prop.store(fos, "modify");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("overrite sync_cheap_id.ini faild! last_cheap_id is:"+this.last_cheap_id);
        }finally{
            if(fos!=null) {
                try {
                    fos.flush();
                } catch (Exception e) {
                }
                try {
                    fos.close();
                } catch (Exception e) {
                }
            }


        }

    }

    public long getLast_cheap_id() {
        return this.last_cheap_id;
    }

    public static void main(String[] args) {
        String[] cfgs = new String[]{"classpath:applicationContext.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(cfgs);
        System.out.println("begin");
        ((SyncCheapTask)ctx.getBean("syncCheapTask")).execute();
    }
}
