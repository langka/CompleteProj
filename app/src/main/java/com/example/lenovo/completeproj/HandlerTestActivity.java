package com.example.lenovo.completeproj;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by lenovo on 2016/7/27.
 */
public class HandlerTestActivity extends AppCompatActivity{
    Button button;
    TextView textView;
    ImageView imageView;
    Handler viewChanger = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            textView.setText("Bye bye,world");
            Log.d("viewChanger","Changed!");
        }
    };
    Handler handler1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            for(int i=0;i<=5;i++)
            Log.d("handler","1");
        }
    };
    Handler handler2 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            for(int i=0;i<=5;i++)
            Log.d("handler","2");
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_layout);
        button = (Button) findViewById(R.id.handler_bt);
        textView = (TextView)findViewById(R.id.handler_tv);
        imageView = (ImageView)findViewById(R.id.handler_iv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PictureThread().start();
            }
        });
        new MessageThread().start();
    }
    class MessageThread extends  Thread{
        @Override
        public void run() {
            Looper.prepare();
            final int i =0;
            Handler handler3 = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                   Log.d("handler","nice");
                }
            };

            Message msg = Message.obtain();
            handler1.sendMessage(msg);
            msg = Message.obtain();
            handler3.sendMessage(msg);
            msg = Message.obtain();
            handler3.sendMessage(msg);
            Looper.loop();

        }
    }
    class ChangeThread extends  Thread{
        @Override
        public void run() {
            viewChanger.post(new Runnable() {
                @Override
                public void run() {
                    textView.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("ooooooo");
                        }
                    });
                }
            });
        }
    }
    public Bitmap getPicture(String path){
//192.168.1.111
        Bitmap bitmap = null;
        try{
            ;
            URL url = new URL(path);



            URLConnection conn = url.openConnection();

            conn.connect();

            InputStream is = conn.getInputStream();

            if(is == null)
                Log.d("checkNull","input null");
            bitmap = BitmapFactory.decodeStream(is);
            if(bitmap == null)
                Log.d("checkNull","bitmap null");
        }
        catch(MalformedURLException e){
            Log.d("hhh","bug");
        }
        catch(IOException e){
            Log.d("hhh","bug2");
        }
        return bitmap;
    }
    Bitmap bitmap1;
    class PictureThread extends  Thread{
        @Override
        public void run() {
            bitmap1=getPicture("http://10.0.2.2:8080/xs/pic/android.png");
            try{
                Thread.sleep(2000);
            }
            catch (InterruptedException e){
                Log.d("pic msg","crash");
            }
            imageView.post(new Runnable() {
                @Override
                public void run() {
                    if(bitmap1 == null)
                        Log.d("checkNull","null");
                    imageView.setImageBitmap(bitmap1);
                }
            });
        }
    }
}
