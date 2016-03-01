package cn.riilservice.joint.commons.v2.facade;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.ws.rs.*;

/**
 * 短信息 服务 rest api
 *
 * @author baiqw
 */

@Path("messages")
@Produces({ContentType.APPLICATION_JSON_UTF_8})
public interface MessageRestService {
    /**
     * 发送短信
     * @param phoneNumber 手机号
     * @return
     */
    @GET
    @Path("send/{phone_number}")
    RestResult send(@PathParam("phone_number") @NotEmpty(message = "电话不能为空") String phoneNumber, @QueryParam("content")  @NotEmpty(message = "短信内容不能为空") String content);

    /**
     * 发送验证码
     * @param phoneNumber 手机号
     * @return
     */
    @GET
    @Path("send/verification/code/{phone_number}")
    RestResult sendVerificationCode(@PathParam("phone_number")  @NotEmpty String phoneNumber);

    /**
     * 短信验证
     * @param phoneNumber 手机号
     * @param checkCode 验证码
     * @return
     */
    @GET
    @Path("verification/code/{phone_number}/{check_code}")
    RestResult verificationCode(@PathParam("phone_number")  @NotEmpty String phoneNumber, @PathParam("check_code")  @NotEmpty String checkCode);

}
