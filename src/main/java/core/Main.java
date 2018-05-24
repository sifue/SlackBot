package core;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import static core.Bot.bot;
import static core.Schedule.schedule;

public class Main {

    public static void main(String args[]) throws IOException {
        System.out.println(curriculum(time()));
        System.out.println(time());
        bot();
    }

    static LocalDateTime ldt(){
        return LocalDateTime.now();
    }

    static int time(){
        int year = ldt().getYear();
        int month = ldt().getMonth().getValue();
        int dayofmonth = ldt().getDayOfMonth();
        int n = 0;

        List<LocalDateTime> time = new ArrayList<>();
        time.add((LocalDateTime.of(year,month,dayofmonth,9,45)));
        for (int i=0; i<7; i++){
            time.add(time.get(n).plusMinutes(60));
            n++;
            if (i==2){
                time.add(LocalDateTime.of(year,month,dayofmonth,13,15));
                n++;
            }
        }
        int num = 0;
        int x = 0;
        int y = 1;

        for (int i=0; i<8; i++){
            if (ldt().isAfter(time.get(x)) && ldt().isBefore(time.get(y))){
                num = i;
                break;
            }else{
                x++;
                y++;
            }
        }
        if (ldt().isAfter(time.get(6))){
            num = 6;
        }
        return num;
    }

    static String curriculum(int num){
        String A = "";

        List<Schedule.schedule> basic = new ArrayList<>();
        basic.add(schedule.ProjectN);
        basic.add(schedule.ProjectN);
        basic.add(schedule.BasicProgram);
        int dow = ldt().getDayOfWeek().getValue();
        switch (dow){
            case 1:
                List<schedule> mon = new ArrayList<>();
                mon.add(schedule.英語_英作文);
                mon.add(schedule.英語_多読);
                mon.add(schedule.プログラミング);
                mon.add(schedule.放課後);
                basic.addAll(mon);
                A = basic.get(num).toString();
                break;
            case 2:
                List<schedule> tue = new ArrayList<>();
                tue.add(schedule.中国語_会話か英語_英作文);
                tue.add(schedule.中国語_会話かプログラミング);
                tue.add(schedule.大学受験_中学復習);
                tue.add(schedule.放課後);
                basic.addAll(tue);
                A = basic.get(num).toString();
                break;
            case 3:
                List<schedule> wed = new ArrayList<>();
                for (int i=0; i<3; i++){
                    wed.add(schedule.大学受験_中学復習);
                }
                wed.add(schedule.放課後);
                basic.addAll(wed);
                A = basic.get(num).toString();
                break;
            case 4:
                List<schedule> thu = new ArrayList<>();
                thu.add(schedule.大学受験_中学復習かBasicProgram);
                thu.add(schedule.英語_英作文);
                thu.add(schedule.プログラミング);
                thu.add(schedule.放課後);
                basic.addAll(thu);
                A = basic.get(num).toString();
                break;
            case 5:
                List<schedule> fri = new ArrayList<>();
                for (int i=0; i<2; i++){
                    fri.add(schedule.中国語_文法かプログラミング);
                }
                fri.add(schedule.進路学習);
                fri.add(schedule.放課後);
                basic.addAll(fri);
                A = basic.get(num).toString();
                break;
        }
        return A;
    }
}