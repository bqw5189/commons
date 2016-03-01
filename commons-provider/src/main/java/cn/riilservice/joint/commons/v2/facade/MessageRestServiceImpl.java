package cn.riilservice.joint.commons.v2.facade;

import cn.riilservice.joint.commons.v2.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.PathParam;

/**
 * User: baiqw
 * Date: 14-12-9
 * Time: 下午3:45
 */
public class MessageRestServiceImpl implements MessageRestService {

    private static final Logger logger = LoggerFactory.getLogger(MessageRestServiceImpl.class);

    private MessageService messageService;

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public RestResult send(@PathParam("phone_number") String phoneNumber, @RequestParam("content")String content) {
        logger.debug("phone_number:{}, content:{}", phoneNumber,content);
        return RestResult.OK(messageService.send(phoneNumber, content));
    }

    @Override
    public RestResult sendVerificationCode(@PathParam("phone_number") String phoneNumber) {
        return RestResult.OK(messageService.sendVerificationCode(phoneNumber));
    }

    @Override
    public RestResult verificationCode(@PathParam("phone_number") String phoneNumber, @PathParam("check_code") String checkCode) {
        return RestResult.OK(messageService.verificationCode(phoneNumber, checkCode));
    }
}
