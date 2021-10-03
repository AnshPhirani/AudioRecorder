package com.example.audiorecorder;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeAgo {

    public String getTimeAgo(long duration){
        Date now = new Date();

        long seconds = TimeUnit.MILLISECONDS.toSeconds(now.getTime() - duration);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - duration);
        long hour = TimeUnit.MILLISECONDS.toHours(now.getTime() - duration);
        long days = TimeUnit.MILLISECONDS.toDays(now.getTime() - duration);

        if(seconds < 60){
            return "Just now";
        }
        else if(minutes == 1){
            return "a minute ago";
        }
        else if(minutes > 1 && minutes < 60){
            return minutes + " minutes ago";
        }
        else if(hour == 1){
            return "an hour ago";
        }
        else if(hour > 1 && hour < 24){
            return hour + " hours ago";
        }
        else if(days == 1){
            return "a day ago";
        }
        else{
            return days + " days ago";
        }

    }

}
