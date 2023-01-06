package com.example.logs;

import com.example.logs.models.Result;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class LogsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogsApplication.class, args);
        List<String> list = new ArrayList<>();
        list.add("2022-12-28 00:00:35.531 [http-nio-8080-exec-43] 67ef6a6f034ab1ae - 7830 INFO  c.o.a.p.p.s.PaylerKgBankAcquiringServiceImpl - CustomerId by msisdn=996553388839, deviceId=67ef6a6f034ab1ae not found  | error message -> No entity found for query");
        list.add("2022-12-28 00:00:26.515 [http-nio-8080-exec-36] dd846398b6602dd5 - 0828 INFO  c.o.a.p.p.s.PaylerKgBankAcquiringServiceImpl - CustomerId by msisdn=996999605906, deviceId=dd846398b6602dd5 not found  | error message -> No entity found for query");
        list.add("2022-12-28 00:01:17.547 [http-nio-8080-exec-28] 18e26c61b95766b6 - 0780 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token (expired): eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiIxOGUyNmM2MWI5NTc2NmI2IiwidXNlcl9uYW1lIjoiOTk2OTk5OTk3NzAzIiwic2NvcGUiOlsiYWxsIl0sImF0aSI6IjhhMTk0MDgyLTFiOWMtNGI1OC05ODVkLTE2NjAwZTcwMGZlZSIsImV4cCI6MTY3MDg0NzgzMSwiYXV0aG9yaXRpZXMiOlsicGF5bWVudC5jcmVhdGUiLCJwYXltZW50LnJlYWQiXSwianRpIjoiMTQ2YjM1NzYtYTNhNy00NjJjLWFjM2UtMjVjNTAyMDQ1ZGViIiwiY2xpZW50X2lkIjoibW9iaWxlSWQyIn0.xzkUZ-8XpM9emj-5FsKVjQQCsk-_erhTGDLvseaEiko");
        list.add("2022-12-28 00:00:35.531 [http-nio-8080-exec-43] 67ef6a6f034ab1ae - 7830 INFO  c.o.a.p.p.s.PaylerKgBankAcquiringServiceImpl - CustomerId by msisdn=996553388839, deviceId=67ef6a6f034ab1ae not found  | error message -> No entity found for query");
        list.add("2022-12-28 00:00:26.515 [http-nio-8080-exec-36] dd846398b6602dd5 - 0828 INFO  c.o.a.p.p.s.PaylerKgBankAcquiringServiceImpl - CustomerId by msisdn=996999605906, deviceId=dd846398b6602dd5 not found  | error message -> No entity found for query");
        list.add("2022-12-28 00:00:40.216 [http-nio-8080-exec-2] 49aee07f2a74e343 - 3631 INFO  c.o.a.p.p.s.PaylerKgBankAcquiringServiceImpl - CustomerId by msisdn=996990700746, deviceId=49aee07f2a74e343 not found  | error message -> No entity found for query");
        list.add("2022-12-28 00:01:17.547 [http-nio-8080-exec-28] 18e26c61b95766b6 - 0780 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token (expired): eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiIxOGUyNmM2MWI5NTc2NmI2IiwidXNlcl9uYW1lIjoiOTk2OTk5OTk3NzAzIiwic2NvcGUiOlsiYWxsIl0sImF0aSI6IjhhMTk0MDgyLTFiOWMtNGI1OC05ODVkLTE2NjAwZTcwMGZlZSIsImV4cCI6MTY3MDg0NzgzMSwiYXV0aG9yaXRpZXMiOlsicGF5bWVudC5jcmVhdGUiLCJwYXltZW50LnJlYWQiXSwianRpIjoiMTQ2YjM1NzYtYTNhNy00NjJjLWFjM2UtMjVjNTAyMDQ1ZGViIiwiY2xpZW50X2lkIjoibW9iaWxlSWQyIn0.xzkUZ-8XpM9emj-5FsKVjQQCsk-_erhTGDLvseaEiko");
        list.add("2022-12-28 00:01:19.201 [http-nio-8080-exec-27] 18e26c61b95766b6 - 7937 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiIxOGUyNmM2MWI5NTc2NmI2IiwidXNlcl9uYW1lIjoiOTk2OTk5OTk3NzAzIiwic2NvcGUiOlsiYWxsIl0sImF0aSI6IjhhMTk0MDgyLTFiOWMtNGI1OC05ODVkLTE2NjAwZTcwMGZlZSIsImV4cCI6MTY3MDg0NzgzMSwiYXV0aG9yaXRpZXMiOlsicGF5bWVudC5jcmVhdGUiLCJwYXltZW50LnJlYWQiXSwianRpIjoiMTQ2YjM1NzYtYTNhNy00NjJjLWFjM2UtMjVjNTAyMDQ1ZGViIiwiY2xpZW50X2lkIjoibW9iaWxlSWQyIn0.xzkUZ-8XpM9emj-5FsKVjQQCsk-_erhTGDLvseaEiko");
        list.add("2022-12-28 00:01:20.267 [http-nio-8080-exec-38] 18e26c61b95766b6 - 5735 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
        list.add("2022-12-28 00:01:21.439 [http-nio-8080-exec-4] 18e26c61b95766b6 - 9149 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
        list.add("2022-12-28 00:01:21.974 [http-nio-8080-exec-19] 18e26c61b95766b6 - 1920 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
        list.add("2022-12-28 00:01:26.368 [http-nio-8080-exec-40] 3FB886FB-0894-4120-A5C4-12425DFA794A - 7293 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - 3FB886FB-0894-4120-A5C4-12425DFA794A");
        list.add("2022-12-28 00:01:26.368 [http-nio-8080-exec-40] 3FB886FB-0894-4120-A5C4-12425DFA794A - 7293 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
        list.add("2022-12-28 00:02:52.161 [http-nio-8080-exec-19] c2066ba11c100ea4 - 2045 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - c2066ba11c100ea4");
        list.add("2022-12-28 00:02:52.161 [http-nio-8080-exec-19] c2066ba11c100ea4 - 2045 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
        list.add("2022-12-28 00:02:52.172 [http-nio-8080-exec-24] c2066ba11c100ea4 - 4104 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - c2066ba11c100ea4");
        list.add("2022-12-28 00:02:52.172 [http-nio-8080-exec-24] c2066ba11c100ea4 - 4104 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
        list.add("2022-12-28 00:05:11.847 [http-nio-8080-exec-34] EE597DFD-75DD-4081-B488-B56EBE1E349E - 5604 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - EE597DFD-75DD-4081-B488-B56EBE1E349E");
        list.add("2022-12-28 00:05:11.847 [http-nio-8080-exec-34] EE597DFD-75DD-4081-B488-B56EBE1E349E - 5604 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
        list.add("2022-12-28 00:05:11.868 [http-nio-8080-exec-33] EE597DFD-75DD-4081-B488-B56EBE1E349E - 8401 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - EE597DFD-75DD-4081-B488-B56EBE1E349E");
        list.add("2022-12-28 00:05:11.868 [http-nio-8080-exec-33] EE597DFD-75DD-4081-B488-B56EBE1E349E - 8401 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
        list.add("2022-12-28 00:05:20.995 [http-nio-8080-exec-20] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 2671 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token (expired): eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiJCMDVBRkI5OS1DRjk0LTRFMEMtQjZBRS0wOTU0OTA2MkQ2RDEiLCJ1c2VyX25hbWUiOiI5OTY1NTUwMDE3NTciLCJzY29wZSI6WyJhbGwiXSwiYXRpIjoiNzc0ODZmZjUtMzhkNS00NjY0LWE0YzMtYzE5NTIwOWE0ODAwIiwiZXhwIjoxNjQ5MjI0ODUwLCJhdXRob3JpdGllcyI6WyJwYXltZW50LmNyZWF0ZSIsInBheW1lbnQucmVhZCJdLCJqdGkiOiJiMDYxN2Y2Zi1iODRhLTRjMTYtOGY1MS1mMTdlMDE4MWYzODkiLCJjbGllbnRfaWQiOiJtb2JpbGVJZDIifQ.Qn12ZVddR1AiOM3ot52xo0PENXxuDeIoauuXarsC-Mw");
        list.add("2022-12-28 00:05:21.151 [http-nio-8080-exec-48] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 6420 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXZpY2VfaWQiOiJCMDVBRkI5OS1DRjk0LTRFMEMtQjZBRS0wOTU0OTA2MkQ2RDEiLCJ1c2VyX25hbWUiOiI5OTY1NTUwMDE3NTciLCJzY29wZSI6WyJhbGwiXSwiYXRpIjoiNzc0ODZmZjUtMzhkNS00NjY0LWE0YzMtYzE5NTIwOWE0ODAwIiwiZXhwIjoxNjQ5MjI0ODUwLCJhdXRob3JpdGllcyI6WyJwYXltZW50LmNyZWF0ZSIsInBheW1lbnQucmVhZCJdLCJqdGkiOiJiMDYxN2Y2Zi1iODRhLTRjMTYtOGY1MS1mMTdlMDE4MWYzODkiLCJjbGllbnRfaWQiOiJtb2JpbGVJZDIifQ.Qn12ZVddR1AiOM3ot52xo0PENXxuDeIoauuXarsC-Mw");
        list.add("2022-12-28 00:05:21.253 [http-nio-8080-exec-51] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 4874 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
        list.add("2022-12-28 00:05:21.371 [http-nio-8080-exec-7] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 8143 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
        list.add("2022-12-28 00:05:21.498 [http-nio-8080-exec-6] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 2797 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
        list.add("2022-12-28 00:05:21.625 [http-nio-8080-exec-1] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 6924 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
        list.add("2022-12-28 00:05:21.734 [http-nio-8080-exec-3] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 3510 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
        list.add("2022-12-28 00:07:05.172 [http-nio-8080-exec-11] FF06D6C6-31BB-4DC7-BFE8-1AAB5B76C0F0 - 5639 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - FF06D6C6-31BB-4DC7-BFE8-1AAB5B76C0F0");
        list.add("2022-12-28 00:07:05.172 [http-nio-8080-exec-11] FF06D6C6-31BB-4DC7-BFE8-1AAB5B76C0F0 - 5639 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
        list.add("2022-12-28 00:07:05.176 [http-nio-8080-exec-39] FF06D6C6-31BB-4DC7-BFE8-1AAB5B76C0F0 - 0423 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - FF06D6C6-31BB-4DC7-BFE8-1AAB5B76C0F0");
        list.add("2022-12-28 00:07:05.176 [http-nio-8080-exec-39] FF06D6C6-31BB-4DC7-BFE8-1AAB5B76C0F0 - 0423 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
        list.add("2022-12-28 00:08:10.985 [http-nio-8080-exec-44] 2b620239fb874177 - 5105 INFO  c.o.s.a.s.i.HalykVirtualSenderCardServiceImpl - RESPONSE: HalykVirtualResponse(status=ERROR, message=Возникла ошибка сервиса. Повторите запрос позднее, data=null)");
        list.add("2022-12-28 00:09:15.871 [http-nio-8080-exec-25] 6af5bc7c8ad08364 - 0680 ERROR c.o.impl.service.AgentServiceImpl - NoResultException for userName: 996995717101");
        list.add("2022-12-28 00:09:15.883 [http-nio-8080-exec-25] 6af5bc7c8ad08364 - 0680 ERROR c.o.impl.service.PaymentServiceImpl - null");
        list.add("2022-12-28 00:09:15.946 [http-nio-8080-exec-25] 6af5bc7c8ad08364 - 0680 ERROR c.o.i.s.HalykCashierServiceImpl - On select halykCashierEntity by cashierId = null | error -> null");
        list.add("2022-12-28 00:09:35.538 [http-nio-8080-exec-28] cb5c56ef5e1b38f8 - 4799 ERROR c.o.impl.service.AgentServiceImpl - NoResultException for userName: 996995995570");
        list.add("2022-12-28 00:09:35.551 [http-nio-8080-exec-28] cb5c56ef5e1b38f8 - 4799 INFO  c.o.impl.service.PaymentServiceImpl - ELSE Phone:996995995570, SUBS:22107881");
        list.add("2022-12-28 00:09:35.552 [http-nio-8080-exec-28] cb5c56ef5e1b38f8 - 4799 ERROR c.o.impl.service.PaymentServiceImpl - null");
        list.add("2022-12-28 00:09:35.553 [http-nio-8080-exec-28] cb5c56ef5e1b38f8 - 4799 INFO  c.o.impl.service.AgentServiceImpl - static pin false");
        list.add("2022-12-28 00:09:35.615 [http-nio-8080-exec-28] cb5c56ef5e1b38f8 - 4799 ERROR c.o.i.s.HalykCashierServiceImpl - On select halykCashierEntity by cashierId = null | error -> null");
        list.add("2022-12-28 00:09:54.412 [http-nio-8080-exec-25] 5445a7bdc581d6c3 - 0199 INFO  c.o.a.p.m.s.MegaWithdrawServiceImpl - BILLING RESPONSE RESULT = b2.85");
        list.add("2022-12-28 00:09:54.418 [http-nio-8080-exec-13] cb5c56ef5e1b38f8 - 9155 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - cb5c56ef5e1b38f8");
        list.add("2022-12-28 00:09:54.418 [http-nio-8080-exec-13] cb5c56ef5e1b38f8 - 9155 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
        list.add("2022-12-28 00:09:54.418 [http-nio-8080-exec-4] cb5c56ef5e1b38f8 - 1680 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - cb5c56ef5e1b38f8");
        list.add("2022-12-28 00:09:54.418 [http-nio-8080-exec-4] cb5c56ef5e1b38f8 - 1680 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
        list.add("2022-12-28 00:09:54.422 [http-nio-8080-exec-4] cb5c56ef5e1b38f8 - 1680 INFO  c.o.i.s.AuthenticationFacadeImpl - SAVE FCM TOKEN IN DB AND CACHE");
        list.add("2022-12-28 00:09:54.423 [http-nio-8080-exec-13] cb5c56ef5e1b38f8 - 9155 INFO  c.o.i.s.AuthenticationFacadeImpl - SAVE FCM TOKEN IN DB AND CACHE");
        list.add("2022-12-28 00:09:54.424 [http-nio-8080-exec-4] cb5c56ef5e1b38f8 - 1680 INFO  c.o.impl.dao.HalykCashierDaoImpl - NO HALYK BANK ACCOUNT");
        list.add("2022-12-28 00:01:21.974 [http-nio-8080-exec-19] 18e26c61b95766b6 - 1920 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
        list.add("2022-12-28 00:01:22.352 [http-nio-8080-exec-23] 18e26c61b95766b6 - 4352 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
        list.add("2022-12-28 00:01:26.367 [http-nio-8080-exec-8] f1970fed79fe0ae4 - 1760 INFO  c.o.a.p.m.s.MegaWithdrawServiceImpl - http://10.230.164.101:4647/X_WALLET?LOGIN=DEV_BILL&PASSWORD=[PROTECTED]&TYPE_REQUEST=5&MSISDN=996558233148");
        list.add("2022-12-28 00:01:26.368 [http-nio-8080-exec-40] 3FB886FB-0894-4120-A5C4-12425DFA794A - 7293 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - 3FB886FB-0894-4120-A5C4-12425DFA794A");
        list.add("2022-12-28 00:01:26.368 [http-nio-8080-exec-40] 3FB886FB-0894-4120-A5C4-12425DFA794A - 7293 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
        list.add("2022-12-28 00:01:26.372 [http-nio-8080-exec-40] 3FB886FB-0894-4120-A5C4-12425DFA794A - 7293 INFO  c.o.i.s.AuthenticationFacadeImpl - SAVE FCM TOKEN IN DB AND CACHE");
        list.add("2022-12-28 00:01:26.375 [http-nio-8080-exec-8] f1970fed79fe0ae4 - 1760 INFO  c.o.a.p.m.s.MegaWithdrawServiceImpl - BILLING RESPONSE RESULT = b0");
        list.add("2022-12-28 00:02:52.167 [http-nio-8080-exec-19] c2066ba11c100ea4 - 2045 INFO  c.o.impl.dao.HalykCashierDaoImpl - NO HALYK BANK ACCOUNT");
        list.add("2022-12-28 00:02:52.170 [http-nio-8080-exec-19] c2066ba11c100ea4 - 2045 INFO  c.o.a.p.m.s.MegaWithdrawServiceImpl - http://10.230.164.101:4647/X_WALLET?LOGIN=DEV_BILL&PASSWORD=[PROTECTED]&TYPE_REQUEST=5&MSISDN=996551551581");
        list.add("2022-12-28 00:02:52.172 [http-nio-8080-exec-24] c2066ba11c100ea4 - 4104 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - c2066ba11c100ea4");
        list.add("2022-12-28 00:02:52.172 [http-nio-8080-exec-24] c2066ba11c100ea4 - 4104 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
        list.add("2022-12-28 00:02:52.176 [http-nio-8080-exec-24] c2066ba11c100ea4 - 4104 INFO  c.o.i.s.AuthenticationFacadeImpl - SAVE FCM TOKEN IN DB AND CACHE");
        list.add("2022-12-28 00:05:11.847 [http-nio-8080-exec-34] EE597DFD-75DD-4081-B488-B56EBE1E349E - 5604 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - EE597DFD-75DD-4081-B488-B56EBE1E349E");
        list.add("2022-12-28 00:05:11.847 [http-nio-8080-exec-34] EE597DFD-75DD-4081-B488-B56EBE1E349E - 5604 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
        list.add("2022-12-28 00:05:11.847 [http-nio-8080-exec-8] aa3491f3b00b4591 - 1126 INFO  c.o.i.s.AuthenticationFacadeImpl - FCM TOKEN NOT CHANGE!");
        list.add("2022-12-28 00:05:11.865 [http-nio-8080-exec-13] 20ef1bc31775e2dd - 2130 DEBUG c.o.impl.service.PaymentServiceImpl - Банковские услуги");
        list.add("2022-12-28 00:05:11.868 [http-nio-8080-exec-33] EE597DFD-75DD-4081-B488-B56EBE1E349E - 8401 ERROR c.o.impl.dao.NotificationDaoImpl - NO TOKENS FOUND FOR DEVICEID - EE597DFD-75DD-4081-B488-B56EBE1E349E");
        list.add("2022-12-28 00:05:11.868 [http-nio-8080-exec-33] EE597DFD-75DD-4081-B488-B56EBE1E349E - 8401 ERROR c.o.impl.dao.NotificationDaoImpl - Index 0 out of bounds for length 0");
        list.add("2022-12-28 00:05:21.371 [http-nio-8080-exec-7] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 8143 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
        list.add("2022-12-28 00:05:21.371 [http-nio-8080-exec-7] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 8143 INFO  c.o.s.w.s.s.CustomTokenEndpoint - AUTHORIZATION FAILED");
        list.add("2022-12-28 00:05:21.498 [http-nio-8080-exec-6] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 2797 INFO  c.o.s.w.s.s.CustomJdbcTokenStore - Failed to find refresh token for token null");
        list.add("2022-12-28 00:05:21.498 [http-nio-8080-exec-6] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 2797 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
        list.add("2022-12-28 00:05:21.498 [http-nio-8080-exec-6] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 2797 INFO  c.o.s.w.s.s.CustomTokenEndpoint - AUTHORIZATION FAILED");
        list.add("2022-12-28 00:05:21.625 [http-nio-8080-exec-1] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 6924 INFO  c.o.s.w.s.s.CustomJdbcTokenStore - Failed to find refresh token for token null");
        list.add("2022-12-28 00:05:21.625 [http-nio-8080-exec-1] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 6924 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
        list.add("2022-12-28 00:05:21.625 [http-nio-8080-exec-1] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 6924 INFO  c.o.s.w.s.s.CustomTokenEndpoint - AUTHORIZATION FAILED");
        list.add("2022-12-28 00:05:21.734 [http-nio-8080-exec-3] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 3510 INFO  c.o.s.w.s.s.CustomJdbcTokenStore - Failed to find refresh token for token null");
        list.add("2022-12-28 00:05:21.734 [http-nio-8080-exec-3] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 3510 ERROR c.o.s.w.s.s.CustomTokenEndpoint - Invalid refresh token: null");
        list.add("2022-12-28 00:05:21.734 [http-nio-8080-exec-3] A5595085-7DB1-46CC-B8D5-7AE4FF9F0E3E - 3510 INFO  c.o.s.w.s.s.CustomTokenEndpoint - AUTHORIZATION FAILED");
        List<String> listError = new ArrayList<>();
        List<String> listError1 = new ArrayList<>();
        List<Result> listerror = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Pattern pattern = Pattern.compile(".*\\bERROR\\b.*");
            Pattern pattern1 = Pattern.compile(".*\\berror\\b.*");
            Matcher matcher = pattern.matcher(list.get(i));
            Matcher matcher1 = pattern1.matcher(list.get(i));
            if (matcher.matches())
                listError.add(list.get(i));
            else if (matcher1.matches()) {
                Pattern pattern2 = Pattern.compile("\\s*(message -> )[\\w].*");
                Matcher matcher2 = pattern2.matcher(list.get(i));
                if (matcher2.find()) {
                    Pattern pattern3 = Pattern.compile("[.][A-Z]\\w*[ ]");
                    Matcher matcher3 = pattern3.matcher(list.get(i));
                    if (matcher3.find()) {
                        Result result = new Result();
                        result.setError(matcher3.group() + matcher2.group());
                        listerror.add(result);
                    }
                }
            }
        }
        for (int i = 0; i < listError.size(); i++) {
            if (!listError.isEmpty()) {
                Pattern pattern = Pattern.compile("[.][A-Z].*[:]");
                Matcher matcher = pattern.matcher(listError.get(i));
                if (matcher.find()) {
                    Result result = new Result();
                    result.setError(matcher.group());
                    listerror.add(result);
                } else
                    listError1.add(listError.get(i));
            }
        }
        for (int i = 0; i < listError1.size(); i++) {
            if (!listError1.isEmpty()) {
                Pattern pattern = Pattern.compile("[.][A-Z].*\\w[ - ]");
                Matcher matcher = pattern.matcher(listError1.get(i));
                if (matcher.find()) {
                    Result result = new Result();
                    result.setError(matcher.group());
                    listerror.add(result);
                }
            }
        }
        List<Result> listResult = new ArrayList<>();
        Result resultOne = new Result();
        listResult.add(resultOne);
        for (int i=0; i<listerror.size(); i++){
            for (int j=0; j<listResult.size(); j++){
                if(listerror.get(i).getError().equals(listResult.get(j).getError())) {
                    listResult.get(j).setCount(listResult.get(j).getCount() + 1);
                    break;
                }
                else if(j==listResult.size()-1){
                    Result result = new Result();
                    result.setCount(1);
                    result.setError(listerror.get(i).getError());
                    listResult.add(result);
                    break;
                }
            }
        }
        for (int i=0; i<listResult.size();i++)
            System.out.println(listResult.get(i));
    }

}
