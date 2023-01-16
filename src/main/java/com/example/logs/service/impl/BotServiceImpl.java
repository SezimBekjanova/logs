package com.example.logs.service.impl;

import com.example.logs.dao.BotDao;
import com.example.logs.models.Result;
import com.example.logs.service.BotService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BotServiceImpl extends TelegramLongPollingBot implements BotService {

    @Autowired
    private BotDao botDao;
    private List<String> membersIds;
    private SendMessage message;

    String rootPath = "C:\\Users\\User\\Downloads", exceptionSearch = "Provider connection exception", execSearch = "exec", serviceSearch = "/web-api/services/", orderSearch = "/web-api/orders,";

    @org.springframework.scheduling.annotation.Scheduled(cron = "0 */1 * * * *")
    public void getResult(){
        List<String> listMessage = new ArrayList<>();
//        for (int i = 0; i<errorLog().size(); i++){
//            listMessage.add(errorLog().get(i));
//            if(i==errorLog().size()-1)
//                listMessage.add("\n"+"_______________________________________");
//        }
//        if(!initLog().isEmpty()){
//            for (int i=0 ; i<initLog().size(); i++){
//                if(i==0)
//                    listMessage.add("\n"+(listMessage.size())+"."+initLog().get(i));
//                listMessage.add("\n"+(listMessage.size()+1)+"."+initLog().get(i));
//            }
        for (int i=0;i<errorLog().size();i++){
            listMessage.add(errorLog().get(i).getError()+" - "+ errorLog().get(i).getCount());
        }
        System.out.println(listMessage.size());
        SendMessage sendMessage = new SendMessage("5870984824", listMessage.toString());
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
    }
    public List<String> initLog() {
        List<String> listLogs = initFile();
        return listLogs;
    }
    @Override
    public List<Result> errorLog() {
        System.out.println("Шедулер2 начал работать: initLog " + LocalDateTime.now());
        List <String> listLogs = initFile2();
        List<String> allErrorList = new ArrayList<>();
        for(int i = 0; i<listLogs.size(); i++){
//            Matcher matcher = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3}) \\[([^\\]]+)\\] ([^ ]+) - ([^ ]+) ([^ ]+) ([^ ]+).*$").matcher(listLogs.get(i));
            Matcher matcher = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3})\\s+\\[(.+)\\]\\s+(.+)\\s+(\\bERROR)").matcher(listLogs.get(i));
            Matcher matcher1 =Pattern.compile("^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3}) \\[([^\\]]+)\\]  ([^ ]+) ([^ ]+).*$").matcher(listLogs.get(i));
            if(matcher.find())
                allErrorList.add(listLogs.get(i));
            else if(matcher1.find()){
                if(allErrorList.isEmpty())
                    allErrorList.add(listLogs.get(i));
                else {
                    for(int j = 0; j<allErrorList.size(); j++){
                        Matcher matcher2 = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3})\\s+\\[(.+)\\].*[-]").matcher(allErrorList.get(j));
                        Matcher matcher3 = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3})\\s+\\[(.+)\\].*[-]").matcher(listLogs.get(i));
                        if(matcher2.find() && matcher2.find())
                            if(matcher2.group().equals(matcher3.group()))
                                break;
                            else
                                allErrorList.add(listLogs.get(i));
                    }
                }
            }
        }
        for(int i=0; i<allErrorList.size(); i++)
            System.out.println(allErrorList.get(i));
        List<String> groups = new ArrayList<>();
        List<Result> results = new ArrayList<>();
        for (int i=0; i < allErrorList.size(); i++) {
            Pattern errorPattern = Pattern.compile("\\bERROR\\s+((.)+\\s)");
            Matcher errorMatcher = errorPattern.matcher(allErrorList.get(i));
            if (errorMatcher.find())
                groups.add(errorMatcher.group());
        }
        for(int i = 0; i<groups.size(); i++){
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
        return results;
    }

    @Override
    public String addMember(String id) {
        try {
            id = id.trim();
            membersIds.add(id);
            return "ok";
        } catch (Exception e){
            return "no";
        }
    }

    public List<String> initFile() {
        List<String> listLogs = new ArrayList<>();
        try {
            String fileName = "payment."+LocalDateTime.now()+".log";
            LocalDateTime current = LocalDateTime.parse("2022-12-28T22:25:18.055"), currentMinus10Min = current.minusMinutes(250), startDate;
            FileInputStream fileInputStream = new FileInputStream(rootPath + "/" + fileName);
            BufferedReader bd = new BufferedReader(new InputStreamReader(fileInputStream));
            String strLine;
            while ((strLine = bd.readLine()) != null) {
                strLine = strLine.trim();
                if (strLine.length() > 4 && strLine.startsWith("2022") && (strLine.contains("KmkServiceImpl") || strLine.contains("KmkProviderImpl"))) {
                    String start = strLine.substring(0, 23);
                    startDate = LocalDateTime.parse(start.replace(" ", "T"));
                    if (startDate.isBefore(current) && startDate.isAfter(currentMinus10Min)) {
                        listLogs.add(strLine);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listLogs;
    }
    public List<String> initFile2() {
        System.out.println("Шедулер2 начал работать: initFile2 " + LocalDateTime.now());
        List<String> listLogs = new ArrayList<>();
        try {
            String fileName = "payment." + LocalDate.now().toString() + ".log.log";
            System.out.println(rootPath + fileName);
            LocalDateTime current = LocalDateTime.parse("2022-12-28T22:25:18.055"), currentMinus10Min = current.minusMinutes(5), startDate;
            FileInputStream fileInputStream = new FileInputStream(rootPath + "/" + fileName);
            BufferedReader bd = new BufferedReader(new InputStreamReader(fileInputStream));
            String strLine;
            while ((strLine = bd.readLine()) != null) {
                strLine = strLine.trim();
                //String start = StringUtils.
                //String start = strLine.substring(0, 23);
                Matcher matcher = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3})").matcher(strLine);
                if(matcher.find()){
                    String start = matcher.group();
                    startDate = LocalDateTime.parse(start.replace(" ", "T"));
                    if (startDate.isBefore(current) && startDate.isAfter(currentMinus10Min)) {
                        listLogs.add(strLine);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLogs;
    }

    @Override
    public String getBotUsername() {
        return "@TestlogMpaBot"; //
    }

    @Override
    public String getBotToken() {
        return "5879608026:AAGXpJhRDl545vztmWDmpq87q_kGilEN2Io";
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (message == null) message = new SendMessage();
            if (!checkPermissions(update)) {
                message.setText("Вы не являетесь участником группы");
            } else {
                message.setText("OK");
            }
            message.setChatId(update.getMessage().getChatId().toString());
            execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkPermissions(Update update) {
        String id = update.getCallbackQuery() != null
                ? update.getCallbackQuery().getFrom().getId().toString()
                : update.getMessage().getFrom().getId().toString();

        return membersIds.stream().anyMatch(element -> element.equalsIgnoreCase(id));
    }

    @PostConstruct
    private void init() {
        membersIds = new ArrayList<>();
        membersIds.add("1399030539"); // Жыке
        membersIds.add("926104989"); // Степан
        membersIds.add("1845818236"); // Момоа
        membersIds.add("5223223194"); // Намке
        membersIds.add("5870984824"); // Sezim
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(this);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}