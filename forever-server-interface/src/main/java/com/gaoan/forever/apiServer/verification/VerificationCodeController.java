package com.gaoan.forever.apiServer.verification;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "VerificationCodeController", description = "静态验证码控制器")
public class VerificationCodeController {

    /*
     * @ApiOperation(value = "前端-静态验证码")
     * 
     * @RequestMapping(value = "/static_code", method = { RequestMethod.GET })
     * public void statusCode(HttpServletRequest request) throws Exception {
     * 
     * }
     */
}
