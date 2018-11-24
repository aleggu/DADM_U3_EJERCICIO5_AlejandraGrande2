package mx.edu.ittepic.dadm_u3_ejercicio5_alejandragrande;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Bienvenidos extends View
{
    Imagen titulo, color, ninos, istart, play;
    MainActivity obj;
    public Bienvenidos(Context context)
    {
        super(context);
        titulo= new Imagen(R.drawable.welcome, 60, 100, this);
        color=new Imagen (R.drawable.color, 400, 700, this);
        ninos= new Imagen (R.drawable.ninos, 120, 1000, this);
        istart= new Imagen (R.drawable.start, 850, 950, this);
        play= new Imagen(R.drawable.juego, 850,1300, this);
        obj=(MainActivity)context;
    }

    public void onDraw(Canvas c)// "C" es la paleta y "P" los colores
    {
        //Este metodo es para dibujo
        Paint p = new Paint();
        titulo.pintar(c,p);
        color.pintar(c,p);
        ninos.pintar(c,p);
        istart.pintar(c,p);
        play.pintar(c,p);


    }
    public boolean onTouchEvent (MotionEvent e)
    {
        float xtoque=e.getX();
        float ytoque=e.getY();
        switch ( e.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if(istart.estaEnArea(xtoque, ytoque))
                {
                    Intent pantalla = new Intent(obj, Main2Activity.class);
                    obj.startActivity(pantalla);
                }
                if(play.estaEnArea(xtoque, ytoque))
                {
                    Intent pantalla2 = new Intent(obj, Main3Activity.class);
                    obj.startActivity(pantalla2);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

}
