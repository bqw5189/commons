/*
 * Copyright 1999-2011 Alibaba Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.riilservice.joint.commons.v2.consumer;

import cn.riilservice.joint.commons.v2.service.MessageService;
import com.alibaba.dubbo.common.json.JSON;


/**
 * @author baiqw
 */
public class DemoAction {

    private MessageService messageService;

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void start() throws Exception {

        System.out.println("push:" + JSON.json(messageService.send("15801632955", "您的验证码:1234")));
        System.out.println("push:" + JSON.json(messageService.sendVerificationCode("15801632955")));
        System.out.println("check:" + JSON.json(messageService.verificationCode("15801632955", "1234")));

    }

}
