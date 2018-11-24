package mx.edu.ittepic.dadm_u3_ejercicio5_alejandragrande;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Juego extends View {
    JuegoImagen amarillo, verde, azul, textoama, textoazu, textover, puntero;
    public Juego(Context context) {
        super(context);

        amarillo= new JuegoImagen(  R.drawable.yellow,150,350, this);
        verde= new JuegoImagen(  R.drawable.green,150,1050, this);
        azul= new JuegoImagen(  R.drawable.blue,150,1750, this);

        textoama= new JuegoImagen(  R.drawable.tyellow,700,500, this);
        textoazu= new JuegoImagen(  R.drawable.tblue,700,1100, this);
        textover= new JuegoImagen(  R.drawable.tgreen,700,1850, this);

        puntero=null;
    }

    public void onDraw(Canvas c)// "C" es la paleta y "P" los colores
    {
        //Este metodo es para dibujo
        Paint p = new Paint();
        p.setTextSize(70);
        p.setColor(Color.BLACK);
        c.drawText("Arrastra el texto al color que coresponda", 100, 150, p);
        amarillo.pintar(c,p);
        verde.pintar(c,p);
        azul.pintar(c,p);
        textover.pintar(c,p);
        textoazu.pintar(c,p);
        textoama.pintar(c,p);
    }

    public boolean onTouchEvent (MotionEvent e)
    {
        float xtoque=e.getX();
        float ytoque=e.getY();
        switch ( e.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if(textover.estaEnArea(xtoque, ytoque))
                {
                    puntero=textover;
                }
                if(textoazu.estaEnArea(xtoque, ytoque))
                {
                    puntero=textoazu;
                }
                if(textoama.estaEnArea(xtoque, ytoque))
                {
                    puntero=textoama;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (puntero!=null)
                {
                    puntero.mover(xtoque, ytoque);
                    if(puntero.colision(verde)&& puntero==textover)
                    {
                        verde.hacerVisible(false);
                        textover.hacerVisible(false);
                    }
                    if(puntero.colision(amarillo)&& puntero==textoama)
                    {
                        amarillo.hacerVisible(false);
                        textoama.hacerVisible(false);
                    }
                    if(puntero.colision(azul)&& puntero==textoazu)
                {
                    azul.hacerVisible(false);
                    textoazu.hacerVisible(false);
                }


                }

                break;
            case MotionEvent.ACTION_UP:
                puntero=null;
                break;
        }
        invalidate();
        return true;
    }
}
