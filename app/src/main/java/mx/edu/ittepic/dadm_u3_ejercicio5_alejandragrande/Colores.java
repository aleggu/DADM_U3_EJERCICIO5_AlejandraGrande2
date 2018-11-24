package mx.edu.ittepic.dadm_u3_ejercicio5_alejandragrande;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class Colores extends View {

    ColoresImagen amarillo, verde, azul, rojo, violeta, negro;
    Main2Activity obj2;
    MediaPlayer mp;
    public Colores(Context context) {
        super(context);
        amarillo= new ColoresImagen(  R.drawable.yellow,250,350, this);
        verde= new ColoresImagen(  R.drawable.green,850,350, this);

        azul= new ColoresImagen(  R.drawable.blue,250,950, this);
        rojo= new ColoresImagen(  R.drawable.red,850,950, this);

        violeta= new ColoresImagen(  R.drawable.purple,250,1550, this);
        negro= new ColoresImagen(  R.drawable.black,850,1550, this);

        obj2=(Main2Activity)context;
    }

    public void onDraw(Canvas c)// "C" es la paleta y "P" los colores
    {
        //Este metodo es para dibujo
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        p.setTextSize(70);
        c.drawText("Toca el color y escucha su pronunciación", 100, 150, p);
        p.setTextSize(80);

        p.setColor(Color.YELLOW);
        c.drawText("YELLOW", 300, 850,p);
        amarillo.pintar(c,p);


        p.setColor(Color.GREEN);
        c.drawText("GREEN", 920, 850,p);
        verde.pintar(c,p);

        p.setColor(Color.BLUE);
        c.drawText("BLUE", 350, 1450,p);
        azul.pintar(c,p);

        p.setColor(Color.RED);
        c.drawText("RED", 970, 1450,p);
        rojo.pintar(c,p);

        p.setColor(Color.MAGENTA);
        c.drawText("VIOLET", 300, 2050,p);
        violeta.pintar(c,p);

        p.setColor(Color.BLACK);
        c.drawText("BLACK", 930, 2050,p);
        negro.pintar(c,p);
    }

    public boolean onTouchEvent (MotionEvent e)
    {
        float xtoque=e.getX();
        float ytoque=e.getY();
        switch ( e.getAction())
        {
            case MotionEvent.ACTION_DOWN:
               if(amarillo.estaEnArea(xtoque, ytoque))
                {
                    sonido(1);
                }
                if(verde.estaEnArea(xtoque, ytoque))
                {
                    sonido(2);
                }
                if(azul.estaEnArea(xtoque, ytoque))
                {
                    sonido(3);
                }
                if(rojo.estaEnArea(xtoque, ytoque))
                {
                    sonido(4);
                }
                if(violeta.estaEnArea(xtoque, ytoque))
                {
                    sonido(5);
                }
                if(negro.estaEnArea(xtoque, ytoque))
                {
                    sonido(6);
                }
                mp.start();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    public void sonido (int n)
    {
        switch (n)
        {
            case 1:
                mp=MediaPlayer.create(obj2, R.raw.yellow);
                break;
            case 2:
                mp=MediaPlayer.create(obj2, R.raw.green);
                break;
            case 3:
                mp=MediaPlayer.create(obj2, R.raw.blue);
                break;
            case 4:
                mp=MediaPlayer.create(obj2, R.raw.red);
                break;
            case 5:
                mp=MediaPlayer.create(obj2, R.raw.violet);
                break;
            case 6:
                mp=MediaPlayer.create(obj2, R.raw.black);
                break;
        }

    }
}
