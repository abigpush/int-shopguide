package com.bt.shopguide.collector.executor;

import com.bt.shopguide.collector.system.GlobalVariable;
import com.bt.shopguide.collector.util.URLUtil;
import com.bt.shopguide.dao.service.IGoodsDetailService;
import com.bt.shopguide.dao.service.IGoodsErrorsService;
import com.bt.shopguide.dao.service.IGoodsListService;
import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Random;

/**
 * Created by caiting on 2017/10/25.
 */
public abstract class AbstractJsonExecutor {
    @Autowired
    protected RedisTemplate<String, String> redisTemplate;
    @Autowired
    protected IGoodsListService goodsListService;
    @Autowired
    protected IGoodsDetailService goodsDetailService;
    @Autowired
    protected IGoodsErrorsService goodsErrorsService;
    @Autowired
    protected GlobalVariable globalVariable;
    @Value("${project.charset}")
    protected String charset;
    @Value("${short_content_length}")
    protected int short_content_length;
    @Value("${redis.key_timeout}")
    protected int timeout;

    @Value("${affiliate.account.amazon}")
    protected String amazon_account;
    @Value("${affiliate.account.amazon.cn}")
    protected String amazon_cn_account;
    @Value("${affiliate.account.ebay}")
    protected String ebay_account;
    @Value("${affiliate.account.alimama}")
    protected String alimama_account;


    public abstract void execute(String json);

    protected String getMainDomain(String url) {
        String domain = "";
        domain = URLUtil.getMainDomain(url);
        //如果是乐天特殊处理
        if ("linksynergy.com".equalsIgnoreCase(domain)) {
            try {
                URL url1 = new URL(url);
                String path = url1.getQuery();
                String realUrl = URLUtil.getParameter(path, "RD_PARM1", "utf-8");
                if (realUrl != null) {
                    domain = getMainDomain(realUrl);
                } else {
                    realUrl = URLUtil.getParameter(path, "murl", "utf-8");
                    if (realUrl != null) {
                        domain = getMainDomain(realUrl);
                    }
                }
            } catch (MalformedURLException e) {

            }
        }
        return domain;
    }

    //处理抓取时间，分配在抓取时间+随机未来一小时以内
    protected Date dealSyncTime(Date d) {
        int ms = (int) Math.ceil(Math.random() * 3600 * 1000);
        return new Date(d.getTime() + ms);
    }

    //转链
    protected String dealUrl(String url) {
        String link = null;

        String domain = URLUtil.getDomain(url);
        String mainDomain = URLUtil.getMainDomain(url);
        //如果是美国亚马逊
        if ("amazon.com".equalsIgnoreCase(mainDomain)) {
            if (url.indexOf("tag=") > -1) {
                link = url.replaceAll("tag=[^&^=]*", "tag=" + amazon_account);
            } else {
                if (url.indexOf("?") > -1) {
                    link = url += "&tag=" + amazon_account;
                } else {
                    link = url += "?tag=" + amazon_account;
                }
            }
            //亚马逊中国
        } else if ("amazon.cn".equalsIgnoreCase(mainDomain)) {
            if (url.indexOf("tag=") > -1) {
                link = url.replaceAll("tag=[^&^=]*", "tag=" + amazon_cn_account);
            } else {
                if (url.indexOf("?") > -1) {
                    link = url += "&tag=" + amazon_cn_account;
                } else {
                    link = url += "?tag=" + amazon_cn_account;
                }
            }
            //ebay的链接处理
        } else if ("rover.ebay.com".equalsIgnoreCase(domain)) {
            link = url.replaceAll("campid=[^&^=]*", "campid=" + ebay_account);
        } else if ("uland.taobao.com".equalsIgnoreCase(domain)) {
            link = url.replaceAll("pid=[^&^=]*", "pid=" + alimama_account);
        } else {
            link = url;
        }

        return link;
    }

    /**
     * 处理内容或html内容，爬虫可能通过标签匹配出来多个容器里的内容，结果会是一个数组
     **/
    protected String dealContent(String content) {
        if (StringUtils.isEmpty(content)) {
            return "";
        }
        JsonElement ele;
        content = content.replace("\\\\n", "");
        try {
            ele = new com.google.gson.JsonParser().parse(content.trim());
        } catch (Exception e) {
            return content;
        }

        if (ele instanceof JsonArray) {
            JsonArray arr = (JsonArray) ele;
            StringBuffer sb = new StringBuffer();
            for (JsonElement e : ele.getAsJsonArray()) {
                sb.append(e.getAsString());
            }
            return sb.toString();
        }
        return content;
    }
}
