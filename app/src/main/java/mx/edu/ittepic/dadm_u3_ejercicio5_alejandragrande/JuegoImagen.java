package mx.edu.ittepic.dadm_u3_ejercicio5_alejandragrande;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class JuegoImagen {
    private Bitmap icono;
    private float x, y;
    boolean visible;
    public JuegoImagen (int resource, float _x, float _y, Juego j)
    {
        icono=BitmapFactory.decodeResource(j.getResources(), resource);
        x = _x;
        y = _y;
        visible=true;
    }
    public void pintar(Canvas c, Paint p)
    {
        if (visible)
        {
            c.drawBitmap(icono, x, y, p);
        }
    }
    public boolean estaEnArea(float xp, float yp)
    {
        if(!visible)
        {
            return false;
        }
        float x2, y2;
        x2=x+icono.getWidth();
        y2=y+icono.getHeight();

        if((xp>=x && xp<=x2)&& (yp>=y && yp<=y2))
        {
            return true;
        }
        return false;
    }

    public void mover (float xp, float yp)
    {
        x=xp-(icono.getWidth()/2);
        y=yp-(icono.getHeight()/2);
    }

    public boolean colision( JuegoImagen objetoB)
    {
        float x2=x+icono.getWidth();
        float y2=y+icono.getHeight();

        if( objetoB.estaEnArea(x2,y))
        {
            //Caso 1
            return  true;

        }
        if( objetoB.estaEnArea(x,y))
        {
            //Caso 2
            return  true;

        }
        if( objetoB.estaEnArea(x2,y2))
        {
            //Caso 3
            return  true;

        }
        if( objetoB.estaEnArea(x,y2))
        {
            //Caso 4
            return  true;

        }
        return false;
    }

    public void hacerVisible(boolean v)
    {
        visible=v;
    }
}


