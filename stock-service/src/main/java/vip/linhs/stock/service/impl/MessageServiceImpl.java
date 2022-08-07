package vip.linhs.stock.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vip.linhs.stock.model.po.Message;
import vip.linhs.stock.model.po.Robot;
import vip.linhs.stock.service.MessageService;
import vip.linhs.stock.service.RobotService;
import vip.linhs.stock.util.HttpUtil;
import vip.linhs.stock.util.StockConsts;

@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    private RobotService robotService;

    @Autowired
    private CloseableHttpClient httpClient;

    @Override
    public void send(String body) {
        RobotUtil.sendWxMsg(body);
    }

    @Override
    public void sendMd(String title, String body) {
        RobotUtil.sendWxMsg(body);

    }

    private void sendDingding(String title, String body, String target, DingDingMessageType type) {
        RobotUtil.sendWxMsg(body);
    }

    private enum DingDingMessageType {
        Text, Markdown
    }

}
