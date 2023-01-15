package com.example.logs;

import com.example.logs.models.Result;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.StringUtils;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@EnableScheduling
@SpringBootApplication
public class LogsApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(LogsApplication.class, args);
//        List<String> list = new ArrayList<>();
//        list.add("2022-01-12 11:11:53.242 [jmsContainer2-1]  ERROR c.o.a.p.m.j.c.JmsPhotoConsumerImpl - com.openpayment.account.provider.mega.jms.consumer.JmsPhotoConsumerImpl.onMessage(JmsPhotoConsumerImpl.java:76)");
//        list.add("2022-01-12 11:11:53.242 [jmsContainer2-1]  ERROR c.o.a.p.m.j.c.JmsPhotoConsumerImpl - org.springframework.jms.listener.AbstractMessageListenerContainer.doInvokeListener(AbstractMessageListenerContainer.java:746)");
//        list.add("2022-01-12 11:11:53.242 [jmsContainer2-1]  ERROR c.o.a.p.m.j.c.JmsPhotoConsumerImpl - org.springframework.jms.listener.AbstractMessageListenerContainer.invokeListener(AbstractMessageListenerContainer.java:684)");
//        list.add("2022-01-12 11:14:53.242 [jmsContainer2-1]  ERROR c.o.a.p.m.j.c.JmsPhotoConsumerImpl - com.openpayment.account.provider.mega.jms.consumer.JmsPhotoConsumerImpl.onMessage(JmsPhotoConsumerImpl.java:76)");
//        list.add("2022-01-12 11:11:53.242 [jmsContainer2-1]  ERROR c.o.a.p.m.j.c.JmsPhotoConsumerImpl - org.springframework.jms.listener.AbstractMessageListenerContainer.doExecuteListener(AbstractMessageListenerContainer.java:651)");
//        list.add("2022-01-12 11:11:53.242 [jmsContainer2-1]  ERROR c.o.a.p.m.j.c.JmsPhotoConsumerImpl - org.springframework.jms.listener.AbstractPollingMessageListenerContainer.doReceiveAndExecute(AbstractPollingMessageListenerContainer.java:317)");
//        list.add("2022-01-12 11:11:53.242 [jmsContainer2-1]  ERROR c.o.a.p.m.j.c.JmsPhotoConsumerImpl - org.springframework.jms.listener.AbstractPollingMessageListenerContainer.receiveAndExecute(AbstractPollingMessageListenerContainer.java:255)");
//        list.add("2022-01-12 11:11:53.242 [jmsContainer2-1]  ERROR c.o.a.p.m.j.c.JmsPhotoConsumerImpl - org.springframework.jms.listener.DefaultMessageListenerContainer$AsyncMessageListenerInvoker.invokeListener(DefaultMessageListenerContainer.java:1166)");
//        list.add("2022-01-12 11:11:53.242 [jmsContainer2-1]  ERROR c.o.a.p.m.j.c.JmsPhotoConsumerImpl - org.springframework.jms.listener.DefaultMessageListenerContainer$AsyncMessageListenerInvoker.executeOngoingLoop(DefaultMessageListenerContainer.java:1158)");
//        list.add("2022-01-12 11:11:53.242 [jmsContainer2-1]  ERROR c.o.a.p.m.j.c.JmsPhotoConsumerImpl - org.springframework.jms.listener.DefaultMessageListenerContainer$AsyncMessageListenerInvoker.run(DefaultMessageListenerContainer.java:1055)");
//        list.add("2022-01-12 11:11:53.242 [jmsContainer2-1]  ERROR c.o.a.p.m.j.c.JmsPhotoConsumerImpl - java.base/java.lang.Thread.run(Thread.java:829");
//        list.add("2022-12-28 00:18:52.359 [http-nio-8080-exec-21] 188a903a110ea16c - 0552 ERROR c.o.impl.service.PaymentServiceImpl - null");
//        list.add("2022-12-28 00:18:52.426 [http-nio-8080-exec-21] 188a903a110ea16c - 0552 ERROR c.o.i.s.HalykCashierServiceImpl - On select halykCashierEntity by cashierId = null | error -> null");
//        list.add("2022-12-28 00:19:37.816 [http-nio-8080-exec-11] 40e4a0592655ca5e - 1780 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token (expired): eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiI0MGU0YTA1OTI2NTVjYTVlIiwidXNlcl9uYW1lIjoiOTk2NTU2MTg1MDM3Iiwic2NvcGUiOlsiYWxsIl0sImF0aSI6ImZiYzQ3M2I0LTViZmEtNDQxYi1hOGRkLTQ4YTJiZjJiZjRiMSIsImV4cCI6MTY3MTczMTMyMiwiYXV0aG9yaXRpZXMiOlsicGF5bWVudC5jcmVhdGUiLCJwYXltZW50LnJlYWQiXSwianRpIjoiNTE1Nzc3MDAtOWJjOS00MGE0LThkYzgtNzNiMzlmN2Q4NTMwIiwiY2xpZW50X2lkIjoibW9iaWxlSWQyIn0.GMEk8WBR_HTrgCkJ_o75VvnG4rkgRe9ZaDKpJRwZmQY");
//        list.add("2022-12-28 00:19:37.921 [http-nio-8080-exec-45] 40e4a0592655ca5e - 3084 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiI0MGU0YTA1OTI2NTVjYTVlIiwidXNlcl9uYW1lIjoiOTk2NTU2MTg1MDM3Iiwic2NvcGUiOlsiYWxsIl0sImF0aSI6ImZiYzQ3M2I0LTViZmEtNDQxYi1hOGRkLTQ4YTJiZjJiZjRiMSIsImV4cCI6MTY3MTczMTMyMiwiYXV0aG9yaXRpZXMiOlsicGF5bWVudC5jcmVhdGUiLCJwYXltZW50LnJlYWQiXSwianRpIjoiNTE1Nzc3MDAtOWJjOS00MGE0LThkYzgtNzNiMzlmN2Q4NTMwIiwiY2xpZW50X2lkIjoibW9iaWxlSWQyIn0.GMEk8WBR_HTrgCkJ_o75VvnG4rkgRe9ZaDKpJRwZmQY");
//        list.add("2022-12-28 00:19:38.024 [http-nio-8080-exec-34] 40e4a0592655ca5e - 7311 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null2022-12-28 00:19:38.371 [http-nio-8080-exec-13] 40e4a0592655ca5e - 1504 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:19:38.457 [http-nio-8080-exec-24] 40e4a0592655ca5e - 9099 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:19:38.549 [http-nio-8080-exec-8] 40e4a0592655ca5e - 2598 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:19:38.640 [http-nio-8080-exec-43] 40e4a0592655ca5e - 2652 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:20:13.353 [http-nio-8080-exec-20] fff84aa7f702b7d6 - 9261 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - fff84aa7f702b7d6");
//        list.add("2022-12-28 00:20:13.353 [http-nio-8080-exec-20] fff84aa7f702b7d6 - 9261 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:20:52.517 [http-nio-8080-exec-4] a14b6abce55bea0e - 3085 ERROR c.o.i.s.AuthenticationFacadeImpl - FCM CACHE FAIL!");
//        list.add("2022-12-28 00:22:08.926 [http-nio-8080-exec-2] 9dc531fd10960a41 - 0544 ERROR c.o.impl.service.AgentServiceImpl - NoResultException for userName: 996553050901");
//        list.add("2022-12-28 00:22:08.940 [http-nio-8080-exec-2] 9dc531fd10960a41 - 0544 ERROR c.o.impl.service.PaymentServiceImpl - null");
//        list.add("2022-12-28 00:22:09.225 [http-nio-8080-exec-2] 9dc531fd10960a41 - 0544 DEBUG c.o.impl.service.PaymentServiceImpl - SMS code:5788");
//        list.add("2022-12-28 00:22:45.321 [http-nio-8080-exec-42] 4294239a19195a0c - 2576 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - 4294239a19195a0c");
//        list.add("2022-12-28 00:22:45.321 [http-nio-8080-exec-42] 4294239a19195a0c - 2576 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:22:45.364 [http-nio-8080-exec-12] 4294239a19195a0c - 0133 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - 4294239a19195a0c");
//        list.add("2022-12-28 00:22:45.364 [http-nio-8080-exec-12] 4294239a19195a0c - 0133 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:23:02.349 [http-nio-8080-exec-46] 9dc531fd10960a41 - 3321 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - 9dc531fd10960a41");
//        list.add("2022-12-28 00:23:02.349 [http-nio-8080-exec-46] 9dc531fd10960a41 - 3321 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:24:14.477 [http-nio-8080-exec-1] 2ee62d86e100db08 - 3905 ERROR c.o.impl.service.AgentServiceImpl - NoResultException for userName: 996551173434");
//        list.add("2022-12-28 00:24:39.376 [http-nio-8080-exec-50] E62BB9F5-4A91-47CF-8253-D94597666494 - 2009 ERROR c.o.impl.service.AgentServiceImpl - NoResultException for userName: 996755998807");
//        list.add("2022-12-28 00:24:39.387 [http-nio-8080-exec-50] E62BB9F5-4A91-47CF-8253-D94597666494 - 2009 ERROR c.o.impl.service.PaymentServiceImpl - null");
//        list.add("2022-12-28 00:24:39.453 [http-nio-8080-exec-50] E62BB9F5-4A91-47CF-8253-D94597666494 - 2009 ERROR c.o.i.s.HalykCashierServiceImpl - On select halykCashierEntity by cashierId = null | error -> null");
//        list.add("2022-12-28 00:24:43.964 [http-nio-8080-exec-20] a14b6abce55bea0e - 3793 ERROR c.o.i.s.AuthenticationFacadeImpl - FCM CACHE FAIL!");
//        list.add("2022-12-28 00:24:43.964 [http-nio-8080-exec-20] a14b6abce55bea0e - 3793 ERROR c.o.i.s.AuthenticationFacadeImpl - FCM CACHE FAIL!");
//        list.add("2022-12-28 00:24:43.964 [http-nio-8080-exec-20] a14b6abce55bea0e - 3793 ERROR c.o.i.s.AuthenticationFacadeImpl - FCM CACHE FAIL!");
//        list.add("2022-12-28 00:24:43.964 [http-nio-8080-exec-20] a14b6abce55bea0e - 3793 ERROR c.o.i.s.AuthenticationFacadeImpl - FCM CACHE FAIL!");
//        list.add("2022-12-28 00:24:43.964 [http-nio-8080-exec-20] a14b6abce55bea0e - 3793 ERROR c.o.i.s.AuthenticationFacadeImpl - FCM CACHE FAIL!");
//        list.add("2022-12-28 00:24:43.964 [http-nio-8080-exec-20] a14b6abce55bea0e - 3793 ERROR c.o.i.s.AuthenticationFacadeImpl - FCM CACHE FAIL!");
//        list.add("2022-12-28 00:25:27.534 [http-nio-8080-exec-50] d262e9c49736d2af - 2617 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - d262e9c49736d2af");
//        list.add("2022-12-28 00:25:27.534 [http-nio-8080-exec-50] d262e9c49736d2af - 2617 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:25:52.140 [http-nio-8080-exec-9] 2ee62d86e100db08 - 2056 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - 2ee62d86e100db08");
//        list.add("2022-12-28 00:25:52.141 [http-nio-8080-exec-9] 2ee62d86e100db08 - 2056 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:25:52.161 [http-nio-8080-exec-33] 2ee62d86e100db08 - 7458 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - 2ee62d86e100db08");
//        list.add("2022-12-28 00:25:52.161 [http-nio-8080-exec-33] 2ee62d86e100db08 - 7458 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:26:08.106 [http-nio-8080-exec-45] b8764e90b9597725 - 7665 ERROR c.o.impl.service.AgentServiceImpl - NoResultException for userName: 996558433212");
//        list.add("2022-12-28 00:26:08.119 [http-nio-8080-exec-45] b8764e90b9597725 - 7665 ERROR c.o.impl.service.PaymentServiceImpl - null");
//        list.add("2022-12-28 00:26:08.204 [http-nio-8080-exec-45] b8764e90b9597725 - 7665 ERROR c.o.i.s.HalykCashierServiceImpl - On select halykCashierEntity by cashierId = null | error -> null");
//        list.add("2022-12-28 00:26:21.430 [http-nio-8080-exec-9] d9e4a04dcc5ac2f9 - 1851 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:26:21.574 [http-nio-8080-exec-27] d9e4a04dcc5ac2f9 - 5119 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:26:21.709 [http-nio-8080-exec-10] d9e4a04dcc5ac2f9 - 1314 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:26:22.054 [http-nio-8080-exec-30] d9e4a04dcc5ac2f9 - 6889 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:26:22.254 [http-nio-8080-exec-43] d9e4a04dcc5ac2f9 - 7759 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:26:22.401 [http-nio-8080-exec-47] d9e4a04dcc5ac2f9 - 2356 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:26:38.571 [http-nio-8080-exec-33] b8764e90b9597725 - 8651 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - b8764e90b9597725");
//        list.add("2022-12-28 00:26:38.571 [http-nio-8080-exec-33] b8764e90b9597725 - 8651 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - b8764e90b9597725");
//        list.add("2022-12-28 00:26:38.571 [http-nio-8080-exec-33] b8764e90b9597725 - 8651 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:26:38.587 [http-nio-8080-exec-28] b8764e90b9597725 - 5678 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - b8764e90b9597725");
//        list.add("2022-12-28 00:26:38.587 [http-nio-8080-exec-28] b8764e90b9597725 - 5678 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:28:51.991 [http-nio-8080-exec-35] a73aedcb992bf532 - 8795 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - a73aedcb992bf532");
//        list.add("2022-12-28 00:28:51.991 [http-nio-8080-exec-35] a73aedcb992bf532 - 8795 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:00:35.531 [http-nio-8080-exec-43] 67ef6a6f034ab1ae - 7830 INFO  c.o.a.p.p.s.PaylerKgBankAcquiringServiceImpl - CustomerId by msisdn=996553388839, deviceId=67ef6a6f034ab1ae not found  | error message -> No entity found for query");
//        list.add("2022-12-28 00:00:26.515 [http-nio-8080-exec-36] dd846398b6602dd5 - 0828 INFO  c.o.a.p.p.s.PaylerKgBankAcquiringServiceImpl - CustomerId by msisdn=996999605906, deviceId=dd846398b6602dd5 not found  | error message -> No entity found for query");
//        list.add("2022-12-28 00:01:17.547 [http-nio-8080-exec-28] 18e26c61b95766b6 - 0780 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token (expired): eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiIxOGUyNmM2MWI5NTc2NmI2IiwidXNlcl9uYW1lIjoiOTk2OTk5OTk3NzAzIiwic2NvcGUiOlsiYWxsIl0sImF0aSI6IjhhMTk0MDgyLTFiOWMtNGI1OC05ODVkLTE2NjAwZTcwMGZlZSIsImV4cCI6MTY3MDg0NzgzMSwiYXV0aG9yaXRpZXMiOlsicGF5bWVudC5jcmVhdGUiLCJwYXltZW50LnJlYWQiXSwianRpIjoiMTQ2YjM1NzYtYTNhNy00NjJjLWFjM2UtMjVjNTAyMDQ1ZGViIiwiY2xpZW50X2lkIjoibW9iaWxlSWQyIn0.xzkUZ-8XpM9emj-5FsKVjQQCsk-_erhTGDLvseaEiko");
//        list.add("2022-12-28 00:00:35.531 [http-nio-8080-exec-43] 67ef6a6f034ab1ae - 7830 INFO  c.o.a.p.p.s.PaylerKgBankAcquiringServiceImpl - CustomerId by msisdn=996553388839, deviceId=67ef6a6f034ab1ae not found  | error message -> No entity found for query");
//        list.add("2022-12-28 00:00:26.515 [http-nio-8080-exec-36] dd846398b6602dd5 - 0828 INFO  c.o.a.p.p.s.PaylerKgBankAcquiringServiceImpl - CustomerId by msisdn=996999605906, deviceId=dd846398b6602dd5 not found  | error message -> No entity found for query");
//        list.add("2022-12-28 00:00:40.216 [http-nio-8080-exec-2] 49aee07f2a74e343 - 3631 INFO  c.o.a.p.p.s.PaylerKgBankAcquiringServiceImpl - CustomerId by msisdn=996990700746, deviceId=49aee07f2a74e343 not found  | error message -> No entity found for query");
//        list.add("2022-12-28 00:01:17.547 [http-nio-8080-exec-28] 18e26c61b95766b6 - 0780 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token (expired): eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiIxOGUyNmM2MWI5NTc2NmI2IiwidXNlcl9uYW1lIjoiOTk2OTk5OTk3NzAzIiwic2NvcGUiOlsiYWxsIl0sImF0aSI6IjhhMTk0MDgyLTFiOWMtNGI1OC05ODVkLTE2NjAwZTcwMGZlZSIsImV4cCI6MTY3MDg0NzgzMSwiYXV0aG9yaXRpZXMiOlsicGF5bWVudC5jcmVhdGUiLCJwYXltZW50LnJlYWQiXSwianRpIjoiMTQ2YjM1NzYtYTNhNy00NjJjLWFjM2UtMjVjNTAyMDQ1ZGViIiwiY2xpZW50X2lkIjoibW9iaWxlSWQyIn0.xzkUZ-8XpM9emj-5FsKVjQQCsk-_erhTGDLvseaEiko");
//        list.add("2022-12-28 00:01:19.201 [http-nio-8080-exec-27] 18e26c61b95766b6 - 7937 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiIxOGUyNmM2MWI5NTc2NmI2IiwidXNlcl9uYW1lIjoiOTk2OTk5OTk3NzAzIiwic2NvcGUiOlsiYWxsIl0sImF0aSI6IjhhMTk0MDgyLTFiOWMtNGI1OC05ODVkLTE2NjAwZTcwMGZlZSIsImV4cCI6MTY3MDg0NzgzMSwiYXV0aG9yaXRpZXMiOlsicGF5bWVudC5jcmVhdGUiLCJwYXltZW50LnJlYWQiXSwianRpIjoiMTQ2YjM1NzYtYTNhNy00NjJjLWFjM2UtMjVjNTAyMDQ1ZGViIiwiY2xpZW50X2lkIjoibW9iaWxlSWQyIn0.xzkUZ-8XpM9emj-5FsKVjQQCsk-_erhTGDLvseaEiko");
//        list.add("2022-12-28 00:01:20.267 [http-nio-8080-exec-38] 18e26c61b95766b6 - 5735 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:01:21.439 [http-nio-8080-exec-4] 18e26c61b95766b6 - 9149 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:01:21.974 [http-nio-8080-exec-19] 18e26c61b95766b6 - 1920 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:01:26.368 [http-nio-8080-exec-40] 3FB886FB-0894-4120-A5C4-12425DFA794A - 7293 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - 3FB886FB-0894-4120-A5C4-12425DFA794A");
//        list.add("2022-12-28 00:01:26.368 [http-nio-8080-exec-40] 3FB886FB-0894-4120-A5C4-12425DFA794A - 7293 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:02:52.161 [http-nio-8080-exec-19] c2066ba11c100ea4 - 2045 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - c2066ba11c100ea4");
//        list.add("2022-12-28 00:02:52.161 [http-nio-8080-exec-19] c2066ba11c100ea4 - 2045 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:02:52.172 [http-nio-8080-exec-24] c2066ba11c100ea4 - 4104 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - c2066ba11c100ea4");
//        list.add("2022-12-28 00:02:52.172 [http-nio-8080-exec-24] c2066ba11c100ea4 - 4104 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:05:11.847 [http-nio-8080-exec-34] EE597DFD-75DD-4081-B488-B56EBE1E349E - 5604 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - EE597DFD-75DD-4081-B488-B56EBE1E349E");
//        list.add("2022-12-28 00:05:11.847 [http-nio-8080-exec-34] EE597DFD-75DD-4081-B488-B56EBE1E349E - 5604 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:05:11.868 [http-nio-8080-exec-33] EE597DFD-75DD-4081-B488-B56EBE1E349E - 8401 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - EE597DFD-75DD-4081-B488-B56EBE1E349E");
//        list.add("2022-12-28 00:05:11.868 [http-nio-8080-exec-33] EE597DFD-75DD-4081-B488-B56EBE1E349E - 8401 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:05:20.995 [http-nio-8080-exec-20] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 2671 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token (expired): eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiJCMDVBRkI5OS1DRjk0LTRFMEMtQjZBRS0wOTU0OTA2MkQ2RDEiLCJ1c2VyX25hbWUiOiI5OTY1NTUwMDE3NTciLCJzY29wZSI6WyJhbGwiXSwiYXRpIjoiNzc0ODZmZjUtMzhkNS00NjY0LWE0YzMtYzE5NTIwOWE0ODAwIiwiZXhwIjoxNjQ5MjI0ODUwLCJhdXRob3JpdGllcyI6WyJwYXltZW50LmNyZWF0ZSIsInBheW1lbnQucmVhZCJdLCJqdGkiOiJiMDYxN2Y2Zi1iODRhLTRjMTYtOGY1MS1mMTdlMDE4MWYzODkiLCJjbGllbnRfaWQiOiJtb2JpbGVJZDIifQ.Qn12ZVddR1AiOM3ot52xo0PENXxuDeIoauuXarsC-Mw");
//        list.add("2022-12-28 00:05:21.151 [http-nio-8080-exec-48] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 6420 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiJCMDVBRkI5OS1DRjk0LTRFMEMtQjZBRS0wOTU0OTA2MkQ2RDEiLCJ1c2VyX25hbWUiOiI5OTY1NTUwMDE3NTciLCJzY29wZSI6WyJhbGwiXSwiYXRpIjoiNzc0ODZmZjUtMzhkNS00NjY0LWE0YzMtYzE5NTIwOWE0ODAwIiwiZXhwIjoxNjQ5MjI0ODUwLCJhdXRob3JpdGllcyI6WyJwYXltZW50LmNyZWF0ZSIsInBheW1lbnQucmVhZCJdLCJqdGkiOiJiMDYxN2Y2Zi1iODRhLTRjMTYtOGY1MS1mMTdlMDE4MWYzODkiLCJjbGllbnRfaWQiOiJtb2JpbGVJZDIifQ.Qn12ZVddR1AiOM3ot52xo0PENXxuDeIoauuXarsC-Mw");
//        list.add("2022-12-28 00:05:21.253 [http-nio-8080-exec-51] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 4874 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:05:21.371 [http-nio-8080-exec-7] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 8143 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:05:21.498 [http-nio-8080-exec-6] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 2797 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:05:21.625 [http-nio-8080-exec-1] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 6924 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:05:21.734 [http-nio-8080-exec-3] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 3510 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:07:05.172 [http-nio-8080-exec-11] FF06D6C6-31BB-4DC7-BFE8-1AAB5B76C0F0 - 5639 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - FF06D6C6-31BB-4DC7-BFE8-1AAB5B76C0F0");
//        list.add("2022-12-28 00:07:05.172 [http-nio-8080-exec-11] FF06D6C6-31BB-4DC7-BFE8-1AAB5B76C0F0 - 5639 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:07:05.176 [http-nio-8080-exec-39] FF06D6C6-31BB-4DC7-BFE8-1AAB5B76C0F0 - 0423 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - FF06D6C6-31BB-4DC7-BFE8-1AAB5B76C0F0");
//        list.add("2022-12-28 00:07:05.176 [http-nio-8080-exec-39] FF06D6C6-31BB-4DC7-BFE8-1AAB5B76C0F0 - 0423 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:08:10.985 [http-nio-8080-exec-44] 2b620239fb874177 - 5105 INFO  c.o.s.a.s.i.HalykVirtualSenderCardServiceImpl - RESPONSE: HalykVirtualResponse(status=ERROR, message=Возникла ошибка сервиса. Повторите запрос позднее, data=null)");
//        list.add("2022-12-28 00:09:15.871 [http-nio-8080-exec-25] 6af5bc7c8ad08364 - 0680 ERROR c.o.impl.service.AgentServiceImpl - NoResultException for userName: 996995717101");
//        list.add("2022-12-28 00:09:15.883 [http-nio-8080-exec-25] 6af5bc7c8ad08364 - 0680 ERROR c.o.impl.service.PaymentServiceImpl - null");
//        list.add("2022-12-28 00:09:15.946 [http-nio-8080-exec-25] 6af5bc7c8ad08364 - 0680 ERROR c.o.i.s.HalykCashierServiceImpl - On select halykCashierEntity by cashierId = null | error -> null");
//        list.add("2022-12-28 00:09:35.538 [http-nio-8080-exec-28] cb5c56ef5e1b38f8 - 4799 ERROR c.o.impl.service.AgentServiceImpl - NoResultException for userName: 996995995570");
//        list.add("2022-12-28 00:09:35.551 [http-nio-8080-exec-28] cb5c56ef5e1b38f8 - 4799 INFO  c.o.impl.service.PaymentServiceImpl - ELSE Phone:996995995570, SUBS:22107881");
//        list.add("2022-12-28 00:09:35.552 [http-nio-8080-exec-28] cb5c56ef5e1b38f8 - 4799 ERROR c.o.impl.service.PaymentServiceImpl - null");
//        list.add("2022-12-28 00:09:35.553 [http-nio-8080-exec-28] cb5c56ef5e1b38f8 - 4799 INFO  c.o.impl.service.AgentServiceImpl - static pin false");
//        list.add("2022-12-28 00:09:35.615 [http-nio-8080-exec-28] cb5c56ef5e1b38f8 - 4799 ERROR c.o.i.s.HalykCashierServiceImpl - On select halykCashierEntity by cashierId = null | error -> null");
//        list.add("2022-12-28 00:09:54.412 [http-nio-8080-exec-25] 5445a7bdc581d6c3 - 0199 INFO  c.o.a.p.m.s.MegaWithdrawServiceImpl - BILLING RESPONSE RESULT = b2.85");
//        list.add("2022-12-28 00:09:54.418 [http-nio-8080-exec-13] cb5c56ef5e1b38f8 - 9155 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - cb5c56ef5e1b38f8");
//        list.add("2022-12-28 00:09:54.418 [http-nio-8080-exec-13] cb5c56ef5e1b38f8 - 9155 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:09:54.418 [http-nio-8080-exec-4] cb5c56ef5e1b38f8 - 1680 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - cb5c56ef5e1b38f8");
//        list.add("2022-12-28 00:09:54.418 [http-nio-8080-exec-4] cb5c56ef5e1b38f8 - 1680 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:09:54.422 [http-nio-8080-exec-4] cb5c56ef5e1b38f8 - 1680 INFO  c.o.i.s.AuthenticationFacadeImpl - SAVE FCM TOKEN IN DB AND CACHE");
//        list.add("2022-12-28 00:09:54.423 [http-nio-8080-exec-13] cb5c56ef5e1b38f8 - 9155 INFO  c.o.i.s.AuthenticationFacadeImpl - SAVE FCM TOKEN IN DB AND CACHE");
//        list.add("2022-12-28 00:09:54.424 [http-nio-8080-exec-4] cb5c56ef5e1b38f8 - 1680 INFO  c.o.impl.dao.HalykCashierDaoImpl - NO HALYK BANK ACCOUNT");
//        list.add("2022-12-28 00:01:21.974 [http-nio-8080-exec-19] 18e26c61b95766b6 - 1920 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:01:22.352 [http-nio-8080-exec-23] 18e26c61b95766b6 - 4352 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:01:26.367 [http-nio-8080-exec-8] f1970fed79fe0ae4 - 1760 INFO  c.o.a.p.m.s.MegaWithdrawServiceImpl - http://10.230.164.101:4647/X_WALLET?LOGIN=DEV_BILL&PASSWORD=[PROTECTED]&TYPE_REQUEST=5&MSISDN=996558233148");
//        list.add("2022-12-28 00:01:26.368 [http-nio-8080-exec-40] 3FB886FB-0894-4120-A5C4-12425DFA794A - 7293 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - 3FB886FB-0894-4120-A5C4-12425DFA794A");
//        list.add("2022-12-28 00:01:26.368 [http-nio-8080-exec-40] 3FB886FB-0894-4120-A5C4-12425DFA794A - 7293 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:01:26.372 [http-nio-8080-exec-40] 3FB886FB-0894-4120-A5C4-12425DFA794A - 7293 INFO  c.o.i.s.AuthenticationFacadeImpl - SAVE FCM TOKEN IN DB AND CACHE");
//        list.add("2022-12-28 00:01:26.375 [http-nio-8080-exec-8] f1970fed79fe0ae4 - 1760 INFO  c.o.a.p.m.s.MegaWithdrawServiceImpl - BILLING RESPONSE RESULT = b0");
//        list.add("2022-12-28 00:02:52.167 [http-nio-8080-exec-19] c2066ba11c100ea4 - 2045 INFO  c.o.impl.dao.HalykCashierDaoImpl - NO HALYK BANK ACCOUNT");
//        list.add("2022-12-28 00:02:52.170 [http-nio-8080-exec-19] c2066ba11c100ea4 - 2045 INFO  c.o.a.p.m.s.MegaWithdrawServiceImpl - http://10.230.164.101:4647/X_WALLET?LOGIN=DEV_BILL&PASSWORD=[PROTECTED]&TYPE_REQUEST=5&MSISDN=996551551581");
//        list.add("2022-12-28 00:02:52.172 [http-nio-8080-exec-24] c2066ba11c100ea4 - 4104 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - c2066ba11c100ea4");
//        list.add("2022-12-28 00:02:52.172 [http-nio-8080-exec-24] c2066ba11c100ea4 - 4104 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:02:52.176 [http-nio-8080-exec-24] c2066ba11c100ea4 - 4104 INFO  c.o.i.s.AuthenticationFacadeImpl - SAVE FCM TOKEN IN DB AND CACHE");
//        list.add("2022-12-28 00:05:11.847 [http-nio-8080-exec-34] EE597DFD-75DD-4081-B488-B56EBE1E349E - 5604 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - EE597DFD-75DD-4081-B488-B56EBE1E349E");
//        list.add("2022-12-28 00:05:11.847 [http-nio-8080-exec-34] EE597DFD-75DD-4081-B488-B56EBE1E349E - 5604 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:05:11.847 [http-nio-8080-exec-8] aa3491f3b00b4591 - 1126 INFO  c.o.i.s.AuthenticationFacadeImpl - FCM TOKEN NOT CHANGE!");
//        list.add("2022-12-28 00:05:11.865 [http-nio-8080-exec-13] 20ef1bc31775e2dd - 2130 DEBUG c.o.impl.service.PaymentServiceImpl - Банковские услуги");
//        list.add("2022-12-28 00:05:11.868 [http-nio-8080-exec-33] EE597DFD-75DD-4081-B488-B56EBE1E349E - 8401 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - EE597DFD-75DD-4081-B488-B56EBE1E349E");
//        list.add("2022-12-28 00:05:11.868 [http-nio-8080-exec-33] EE597DFD-75DD-4081-B488-B56EBE1E349E - 8401 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
//        list.add("2022-12-28 00:05:21.371 [http-nio-8080-exec-7] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 8143 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:05:21.371 [http-nio-8080-exec-7] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 8143 INFO  c.o.s.w.s.s.CustomTokenEndpoint - AUTHORIZATION FAILED");
//        list.add("2022-12-28 00:05:21.498 [http-nio-8080-exec-6] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 2797 INFO  c.o.s.w.s.s.CustomJdbcTokenStore - Failed to find refresh token for token null");
//        list.add("2022-12-28 00:05:21.498 [http-nio-8080-exec-6] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 2797 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:05:21.498 [http-nio-8080-exec-6] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 2797 INFO  c.o.s.w.s.s.CustomTokenEndpoint - AUTHORIZATION FAILED");
//        list.add("2022-12-28 00:05:21.625 [http-nio-8080-exec-1] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 6924 INFO  c.o.s.w.s.s.CustomJdbcTokenStore - Failed to find refresh token for token null");
//        list.add("2022-12-28 00:05:21.625 [http-nio-8080-exec-1] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 6924 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:05:21.625 [http-nio-8080-exec-1] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 6924 INFO  c.o.s.w.s.s.CustomTokenEndpoint - AUTHORIZATION FAILED");
//        list.add("2022-12-28 00:05:21.734 [http-nio-8080-exec-3] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 3510 INFO  c.o.s.w.s.s.CustomJdbcTokenStore - Failed to find refresh token for token null");
//        list.add("2022-12-28 00:05:21.734 [http-nio-8080-exec-3] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 3510 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
//        list.add("2022-12-28 00:05:21.734 [http-nio-8080-exec-3] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 3510 INFO  c.o.s.w.s.s.CustomTokenEndpoint - AUTHORIZATION FAILED");
//            List<String> allErrorList = list;
//            List<String> listNew = new ArrayList<>();
//            List<String> resultList = new ArrayList<>();
//            List<String> listError1 = new ArrayList<>();
//            List<Result> listerror = new ArrayList<>();
//            for (int i = 0; i < allErrorList.size(); i++) {
//                Pattern pattern = Pattern.compile(".*\\bERROR\\b.*");
//                Pattern pattern1 = Pattern.compile(".*\\berror\\b.*");
//                Matcher matcher = pattern.matcher(allErrorList.get(i));
//                Matcher matcher1 = pattern1.matcher(allErrorList.get(i));
//                if (matcher.matches()){
//                    if(listNew.isEmpty()){
//                        listNew.add(allErrorList.get(i));
//                    }
//                        Pattern pattern4 = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3})\\s+\\[(.+)\\].*[-]");
//                        Matcher matcher4 = pattern4.matcher(allErrorList.get(i));
//                        for(int j=0;j<listNew.size(); j++){
//                            Matcher matcher5 = pattern4.matcher(listNew.get(j));
//                            if(matcher4.find()&& matcher5.find())
//                                if(matcher4.group().equals(matcher5.group())) {
//                                    break;
//                                }
//                                else {
//                                    listNew.add(allErrorList.get(i));
//                                }
//                        }
//                    }
//                else if (matcher1.matches()) {
//                    Pattern pattern2 = Pattern.compile("\\s*(message -> )[\\w].*");
//                    Matcher matcher2 = pattern2.matcher(allErrorList.get(i));
//                    if (matcher2.find()) {
//                        Pattern pattern3 = Pattern.compile("[.][A-Z]\\w*[ ]");
//                        Matcher matcher3 = pattern3.matcher(allErrorList.get(i));
//                        if (matcher3.find()) {
//                            Result result = new Result();
//                            result.setError(matcher3.group() + matcher2.group());
//                            listerror.add(result);
//                        }
//                    }
//                }
//            }
//            for (int i = 0; i < listNew.size(); i++) {
//                if (!listNew.isEmpty()) {
//                    Pattern pattern = Pattern.compile("[.][A-Z].*[:]");
//                    Matcher matcher = pattern.matcher(listNew.get(i));
//                    if (matcher.find()) {
//                        Result result = new Result();
//                        result.setError(matcher.group());
//                        listerror.add(result);
//                    } else
//                        listError1.add(listNew.get(i));
//                }
//            }
//            for (int i = 0; i < listError1.size(); i++) {
//                if (!listError1.isEmpty()) {
//                    Pattern pattern = Pattern.compile("[.][A-Z].*\\w[ - ]");
//                    Matcher matcher = pattern.matcher(listError1.get(i));
//                    if (matcher.find()) {
//                        Result result = new Result();
//                        result.setError(matcher.group());
//                        listerror.add(result);
//                    }
//                }
//            }
//            List<Result> listResult = new ArrayList<>();
//            Result resultOne = new Result();
//            listResult.add(resultOne);
//            for (int i=0; i<listerror.size(); i++){
//                for (int j=0; j<listResult.size(); j++){
//                    if(listerror.get(i).getError().equals(listResult.get(j).getError())) {
//                        listResult.get(j).setCount(listResult.get(j).getCount() + 1);
//                        break;
//                    }
//                    else if(j==listResult.size()-1){
//                        Result result = new Result();
//                        result.setCount(1);
//                        result.setError(listerror.get(i).getError());
//                        listResult.add(result);
//                        break;
//                    }
//                }
//                if (i==listerror.size()-1) {
//                    for (int k = 0; k < listResult.size(); k++){
//                        if(k==0){
//                            listResult.remove(k);
//                        }
//                        resultList.add("\n"+(k+1)+listResult.get(k).getError() + " - " + listResult.get(k).getCount());
//                    }
//                }
//            }
//        for(int i=0; i<resultList.size();i++)
//            System.out.println(resultList.get(i));
//
//        //        List<String> listError = new ArrayList<>();
////        List<String> listError1 = new ArrayList<>();
////        List<Result> listerror = new ArrayList<>();
////        for(int i=0; i<list.size(); i++)
////            System.out.println(list.get(i));
////        for (int i = 0; i < list.size(); i++) {
////            Pattern pattern = Pattern.compile(".*\\bERROR\\b.*");
////            Pattern pattern1 = Pattern.compile(".*\\berror\\b.*");
////            Matcher matcher = pattern.matcher(list.get(i));
////            Matcher matcher1 = pattern1.matcher(list.get(i));
////            if (matcher.matches())
////                listError.add(list.get(i));
////            else if (matcher1.matches()) {
////                Pattern pattern2 = Pattern.compile("\\s*(message -> )[\\w].*");
////                Matcher matcher2 = pattern2.matcher(list.get(i));
////                if (matcher2.find()) {
////                    Pattern pattern3 = Pattern.compile("[.][A-Z]\\w*[ ]");
////                    Matcher matcher3 = pattern3.matcher(list.get(i));
////                    if (matcher3.find()) {
////                        Result result = new Result();
////                        result.setError(matcher3.group() + matcher2.group());
////                        listerror.add(result);
////                    }
////                }
////            }
////        }
////        for (int i = 0; i < listError.size(); i++) {
////            if (!listError.isEmpty()) {
////                Pattern pattern = Pattern.compile("[.][A-Z].*[:]");
////                Matcher matcher = pattern.matcher(listError.get(i));
////                if (matcher.find()) {
////                    Result result = new Result();
////                    result.setError(matcher.group());
////                    listerror.add(result);
////                } else
////                    listError1.add(listError.get(i));
////            }
////        }
////        for (int i = 0; i < listError1.size(); i++) {
////            if (!listError1.isEmpty()) {
////                Pattern pattern = Pattern.compile("[.][A-Z].*\\w[ - ]");
////                Matcher matcher = pattern.matcher(listError1.get(i));
////                if (matcher.find()) {
////                    Result result = new Result();
////                    result.setError(matcher.group());
////                    listerror.add(result);
////                }
////            }
////        }
////        List<Result> listResult = new ArrayList<>();
////        Result resultOne = new Result();
////        listResult.add(resultOne);
////        for (int i=0; i<listerror.size(); i++){
////            for (int j=0; j<listResult.size(); j++){
////                if(listerror.get(i).getError().equals(listResult.get(j).getError())) {
////                    listResult.get(j).setCount(listResult.get(j).getCount() + 1);
////                    break;
////                }
////                else if(j==listResult.size()-1){
////                    Result result = new Result();
////                    result.setCount(1);
////                    result.setError(listerror.get(i).getError());
////                    listResult.add(result);
////                    break;
////                }
////            }
////        }
////        for (int i=0; i<listResult.size();i++)
////            System.out.println(listResult.get(i));
//
//
////        for(int i=0; i<list.size(); i++){
////            Pattern pattern = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3}) \\[([^\\]]+)\\] ([^ ]+) - ([^ ]+) ([^ ]+) ([^ ]+).*$");
////            Matcher matcher = pattern.matcher(list.get(i));
////            if(matcher.find()){
////
////            }
////        }
//
//        //^(\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}\.\d{3}) \[([^\]]+)\] ([^ ]+) - ([^ ]+) ([^ ]+) ([^ ]+).*$
//        ^(\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}\.\d{3}) \[([^\]]+)\]  ([^ ]+) ([^ ]+).*$  все ошибки
//    }

//String rootPath = "C:\\Users\\User\\Downloads";
//        List<String> listLogs = new ArrayList<>();
//        try {
//            String fileName = "payment." + LocalDate.now().toString() + ".log.log";
//            LocalDateTime current = LocalDateTime.parse("2022-12-28T23:59:59.852"), currentMinus10Min = current.minusMinutes(10), startDate;
//            FileInputStream fileInputStream = new FileInputStream(rootPath + "/" + fileName);
//            BufferedReader bd = new BufferedReader(new InputStreamReader(fileInputStream));
//            String strLine;
//            while ((strLine = bd.readLine()) != null) {
//                strLine = strLine.trim();
//                    //String start = StringUtils.
//                    //String start = strLine.substring(0, 23);
//                    Matcher matcher = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3})").matcher(strLine);
//                    if(matcher.find()){
//                        String start = matcher.group();
//                    startDate = LocalDateTime.parse(start.replace(" ", "T"));
//                    if (startDate.isBefore(current) && startDate.isAfter(currentMinus10Min)) {
//                        listLogs.add(strLine);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        List<String> allErrorList = new ArrayList<>();
//        for(int i = 0; i<listLogs.size(); i++){
//            Matcher matcher = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3}) \\[([^\\]]+)\\] ([^ ]+) - ([^ ]+) ([^ ]+) ([^ ]+).*$").matcher(listLogs.get(i));
//            Matcher matcher1 =Pattern.compile("^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3}) \\[([^\\]]+)\\]  ([^ ]+) ([^ ]+).*$").matcher(listLogs.get(i));
//            if(matcher.find())
//                allErrorList.add(listLogs.get(i));
//            else if(matcher1.find()){
//                if(allErrorList.isEmpty())
//                    allErrorList.add(listLogs.get(i));
//                else {
//                    for(int j = 0; j<allErrorList.size(); j++){
//                        Matcher matcher2 = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3})\\s+\\[(.+)\\].*[-]").matcher(allErrorList.get(j));
//                        Matcher matcher3 = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3})\\s+\\[(.+)\\].*[-]").matcher(listLogs.get(i));
//                        if(matcher2.find() && matcher2.find())
//                            if(matcher2.group().equals(matcher3.group()))
//                                break;
//                            else
//                                allErrorList.add(listLogs.get(i));
//                    }
//                }
//            }
//        }
//        List<String> groups = new ArrayList<>();
//        List<Result> results = new ArrayList<>();
//        for (int i=0; i < allErrorList.size(); i++) {
//            Pattern errorPattern = Pattern.compile("\\bERROR\\s+((.)+\\s)");
//            Matcher errorMatcher = errorPattern.matcher(allErrorList.get(i));
//            if (errorMatcher.find())
//                groups.add(errorMatcher.group());
//        }
//        for(int i = 0; i<groups.size(); i++){
//            if(results.isEmpty()){
//                Result result = new Result();
//                result.setError(groups.get(i));
//                result.setCount(1);
//                results.add(result);
//            }
//            else {
//                for(int j = 0 ; j<results.size(); j++){
//                    if(groups.get(i).equals(results.get(j).getError())){
//                        results.get(j).setCount(results.get(j).getCount()+1);
//                        break;
//                    }else if(j == results.size()-1) {
//                        Result result = new Result();
//                        result.setError(groups.get(i));
//                        result.setCount(1);
//                        results.add(result);
//                        break;
//                    }
//                }
//            }
//        }
//
//for(int i=0;i<results.size(); i++)
//    System.out.println(results.get(i));





            FileInputStream fstream = new FileInputStream("src/main/java/com/example/logs/log.txt");
// or using Scaner
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
//Read File Line By Line
            List<String> errors = new ArrayList<>(Collections.singletonList(br.readLine()));
            while ((strLine = br.readLine()) != null) {
                Pattern errorPattern = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3})\\s+\\[(.+)\\]\\s+(.+)\\s+-\\s+(\\d+)\\s+(\\bERROR)");
//                Pattern errorPattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3})\\s+\\[(.+)\\]\\s+(.+)\\s+(\\bERROR)");

                Matcher errorMatcher = errorPattern.matcher(strLine);
                if (errorMatcher.find()) {
                    errors.add(strLine);
                }
            }
            List<String> groups = new ArrayList<>();
            List<Result> results = new ArrayList<>();
            for (int i=0; i < errors.size(); i++) {
                Pattern errorPattern = Pattern.compile("\\bERROR\\s+((.)+\\s)");
                Matcher errorMatcher = errorPattern.matcher(errors.get(i));
                if (errorMatcher.find())
                        groups.add(errorMatcher.group());
                        if(results.isEmpty()){
                            Result result = new Result();
                            result.setError(groups.get(i));
                            result.setCount(1);
                            results.add(result);
                        }
                        else {
                            for(int j = 0 ; j<results.size(); j++){
                                if(groups.get(i).equals(results.get(j).getError())){
                                    results.get(j).setCount(results.get(j).getCount()+1);
                                    break;
                                }else if(j == results.size()-1) {
                                    Result result = new Result();
                                    result.setError(groups.get(i));
                                    result.setCount(1);
                                    results.add(result);
                                    break;
                                }
                            }
                        }
            }

        for(int i=0; i<results.size(); i++){
            System.out.println(results.get(i));
        }

    }

}
