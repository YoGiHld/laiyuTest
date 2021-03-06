package cn.laiyu.Util.TimeQuiz;

import cn.laiyu.PoJo.Room.Room;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static cn.laiyu.WebSocket.RoomWebSocket.GameBroadCast;

/**
 * Created by humac on 2017/7/6.
 */
public class VoteTimeQuiz implements Runnable{
    private int limitSec;

    private  Room room;
    private String message;
    public VoteTimeQuiz(int second,String message,Room room){
        limitSec=second;
        this.message=message;
        this.room=room;
    }
    @Override
    public void run( ) {
        while(limitSec > 0){
            --limitSec;
            System.out.println("remain sceconds:"+limitSec);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            GameBroadCast(room, message);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
