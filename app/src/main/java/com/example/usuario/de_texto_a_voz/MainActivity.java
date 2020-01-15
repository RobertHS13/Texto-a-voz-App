package com.example.usuario.de_texto_a_voz;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener
{
    private TextToSpeech textToSpeech;
    private EditText editText;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        final Button btnSpanish = ( Button ) findViewById( R.id.id.voz );
        final Button btnEnglish = ( Button ) findViewById( R.id.voz2 );
        final Button btnItalian = ( Button ) findViewById( R.id.voz3 );
        final Button btnFrance = ( Button ) findViewById( R.id.voz4 );
        final Button btnGermany = ( Button ) findViewById( R.id.voz5 );

        textToSpeech = new TextToSpeech( this, this );
        editText = ( EditText ) findViewById( R.id.et );

        //Español
        btnSpanish.setOnClickListener( new View.OnClickListener()
        {
            @Override public void onClick( View v )
            {
                textToSpeech.setLanguage( new Locale( "spa", "ESP" ) );
                speak( editText.getText().toString() );
            }
        } );

        //English
        btnEnglish.setOnClickListener( new View.OnClickListener()
        {
            @Override public void onClick( View v )
            {
                textToSpeech.setLanguage( Locale.ENGLISH );
                speak( editText.getText().toString() );
            }
        } );

        //Italian
        btnItalian.setOnClickListener( new View.OnClickListener()
        {
            @Override public void onClick( View v )
            {
                textToSpeech.setLanguage( Locale.ITALIAN );
                speak( editText.getText().toString() );
            }
        } );

        //France
        btnFrance.setOnClickListener( new View.OnClickListener()
        {
            @Override public void onClick( View v )
            {
                textToSpeech.setLanguage( Locale.FRANCE);
                speak( editText.getText().toString() );
            }
        } );

        //Germany
        btnGermany.setOnClickListener( new View.OnClickListener()
        {
            @Override public void onClick( View v )
            {
                textToSpeech.setLanguage( Locale.GERMANY);
                speak( editText.getText().toString() );
            }
        } );
    }

    @Override
    public void onInit( int status )
    {
        if ( status == TextToSpeech.LANG_MISSING_DATA | status == TextToSpeech.LANG_NOT_SUPPORTED )
        {
            Toast.makeText( this, "ERROR LANG_MISSING_DATA | LANG_NOT_SUPPORTED", Toast.LENGTH_SHORT ).show();
        }
    }

    private void speak( String str )
    {
        textToSpeech.speak( str, TextToSpeech.QUEUE_FLUSH, null );
        textToSpeech.setSpeechRate( 0.0f );
        textToSpeech.setPitch( 0.0f );
    }

    @Override
    protected void onDestroy()
    {
        if ( textToSpeech != null )
        {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}