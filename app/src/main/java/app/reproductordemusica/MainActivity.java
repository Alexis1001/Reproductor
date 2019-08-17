package app.reproductordemusica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.media.MediaPlayer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button stop,play,siguiente,atras;
    MediaPlayer mp3[]=new MediaPlayer[4];
    TextView texto;
    int item=0;
    ImageView imagen;
    ArrayList<Integer> portadas=new ArrayList<Integer>();
    ArrayList<String> autores=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.atras=(Button)findViewById(R.id.button_back);
        this.play=(Button)findViewById(R.id.button_play);
        this.stop=(Button)findViewById(R.id.button_pause);
        this.siguiente=(Button) findViewById(R.id.button_next);
        this.texto=(TextView)findViewById(R.id.TextView);
        this.imagen=(ImageView)findViewById(R.id.imagen);
        mp3[0]=MediaPlayer.create(MainActivity.this,R.raw.song1);
        mp3[1]=MediaPlayer.create(MainActivity.this,R.raw.song2);
        mp3[2]=MediaPlayer.create(MainActivity.this,R.raw.song3);
        mp3[3]=MediaPlayer.create(MainActivity.this,R.raw.song4);


        autores.add("Alexis ");
        autores.add("gama");
        autores.add("diego");
        autores.add("salva");

        portadas.add(R.drawable.rock1);
        portadas.add(R.drawable.rock2);
        portadas.add(R.drawable.rock3);
        portadas.add(R.drawable.rock4);





        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText("");
                Toast mensaje=Toast.makeText(getApplicationContext(),"reproduciendo",Toast.LENGTH_SHORT);
                mensaje.show();
                mp3[item].start();
                texto.setText(autores.get(item).toUpperCase());
                //imagen.setImageResource(portadas.get(item));
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp3[item].isPlaying()){
                    texto.setText("");
                    Toast mensaje=Toast.makeText(getApplicationContext(),"pausado",Toast.LENGTH_SHORT);
                    mensaje.show();
                    mp3[item].pause();
                   // imagen.setImageResource(portadas.get(item));
                    texto.setText(autores.get(item).toUpperCase());
                }
                else {
                    texto.setText("");
                    Toast mensaje = Toast.makeText(getApplicationContext(), "pausado", Toast.LENGTH_SHORT);
                    mensaje.show();
                    mp3[item].pause();
                    //imagen.setImageResource(portadas.get(item));
                    texto.setText(autores.get(item).toUpperCase());

                }
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(item>0){
                 if(mp3[item].isPlaying()){
                     texto.setText("");
                     Toast mensaje=Toast.makeText(getApplicationContext(),"atras",Toast.LENGTH_SHORT);
                     mensaje.show();
                     mp3[item].stop();
                     mp3[0]=MediaPlayer.create(MainActivity.this,R.raw.song1);
                     mp3[1]=MediaPlayer.create(MainActivity.this,R.raw.song2);
                     mp3[2]=MediaPlayer.create(MainActivity.this,R.raw.song3);
                     mp3[3]=MediaPlayer.create(MainActivity.this,R.raw.song4);
                     imagen.setImageResource(portadas.get(item));
                     item--;
                     imagen.setImageResource(portadas.get(item));
                     mp3[item].start();
                     texto.setText(autores.get(item).toUpperCase());
                 }
                 else{
                     texto.setText("");
                     Toast mensaje=Toast.makeText(getApplicationContext(),"atras",Toast.LENGTH_SHORT);
                     mensaje.show();
                     item--;
                     imagen.setImageResource(portadas.get(item));
                     mp3[item].start();
                     texto.setText(autores.get(item).toUpperCase());
                 }

              }
              else{
                  Toast mensaje=Toast.makeText(getApplicationContext(),"no pista anterior",Toast.LENGTH_SHORT);
                  mensaje.show();
              }

            }
        });

        siguiente.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(item<mp3.length-1){
                    if(mp3[item].isPlaying()){
                        texto.setText("");
                        Toast mensaje=Toast.makeText(getApplicationContext(),"siguiente",Toast.LENGTH_SHORT);
                        mensaje.show();
                        mp3[item].stop();
                        item++;
                        imagen.setImageResource(portadas.get(item));
                        mp3[item].start();
                        texto.setText(autores.get(item).toUpperCase());

                     }
                    else{
                        texto.setText("");
                        item++;
                        texto.setText(autores.get(item).toUpperCase());
                        mp3[item].start();

                    }

                 }

                else{
                    Toast mensaje=Toast.makeText(getApplicationContext(),"no pista siguinte",Toast.LENGTH_SHORT);
                    mensaje.show();
                }

            }

        });



    }


}
