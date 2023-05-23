package com.example.exa_3er_apellido_ap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import android.widget.MediaController;

public class AudioVideoActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnReproducir, btnDetener,btnLogout;
    private MediaPlayer reproductor;
    private VideoView vvVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_video);

        vvVideo = findViewById(R.id.vvVideo);
        btnReproducir = findViewById(R.id.btnReproducir);
        btnDetener = findViewById(R.id.btnDetener);
        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);
        btnReproducir.setOnClickListener(this);
        btnDetener.setOnClickListener(this);
        Uri path = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);//recursos externos
        MediaController mc = new MediaController(this);//instancia para controles de video y reproduccion
        vvVideo.setMediaController(mc);//Coloca los botones de reprocur, pausa y detener
        vvVideo.setVideoURI(path);//llamado del URI es para identificar el cursos video a reproducir
        vvVideo.setMediaController(new MediaController(this));//Integra los controles y el recurso URI
        vvVideo.start();//ejecucion
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnReproducir){
            play_mp1();
        }
        if(view.getId()==R.id.btnDetener){
            stop();
        }
        if(view.getId()==R.id.btnLogout){
            Intent intentLogin = new Intent(AudioVideoActivity.this, LoginActivity.class);
            startActivity(intentLogin);
            finish();
        }
    }
    private void play_mp1(){
        reproductor=MediaPlayer.create(this, R.raw.sonido);
        reproductor.start();
    }
    private void stop(){//inicia metodo
        reproductor.stop();
    }
}