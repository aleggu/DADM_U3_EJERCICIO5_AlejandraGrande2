package mx.edu.ittepic.dadm_u3_ejercicio5_alejandragrande;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;

public class ColoresImagen {
    private Bitmap icono;
    private float x, y;
    public ColoresImagen (int resource, float _x, float _y, Colores c)
    {
        icono=BitmapFactory.decodeResource(c.getResources(), resource);
        x = _x;
        y = _y;


    }
    public void pintar(Canvas c, Paint p)
    {

        c.drawBitmap(icono, x, y, p);

    }
    public boolean estaEnArea(float xp, float yp)
    {
        float x2, y2;
        x2=x+icono.getWidth();
        y2=y+icono.getHeight();

        if((xp>=x && xp<=x2)&& (yp>=y && yp<=y2))
        {
            return true;
        }
        return false;
    }

}
