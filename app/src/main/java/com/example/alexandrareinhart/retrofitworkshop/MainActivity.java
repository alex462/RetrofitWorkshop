package com.example.alexandrareinhart.retrofitworkshop;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static final String ARTIST_NAME = "artist_name";
    public static final String SONG_TITLE = "song_title";

    @BindView(R.id.input_artist_editText)
    protected TextInputEditText artistEditText;
    @BindView(R.id.input_song_editText)
    protected TextInputEditText songEditText;

    private LyricsFragment lyricsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void onBackPressed() {

        if (lyricsFragment.isVisible()) {
            getSupportFragmentManager().beginTransaction().remove(lyricsFragment).commit();
        } else {
            super.onBackPressed();
        }
    }



    @OnClick(R.id.submit_button)
    protected void submitClicked() {

        if (artistEditText.getText().toString().isEmpty() || songEditText.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR. ALL FIELDS REQUIRED.", Toast.LENGTH_LONG).show();
        } else {

            lyricsFragment = LyricsFragment.newInstance();

            Bundle bundle = new Bundle();
            bundle.putString(ARTIST_NAME, artistEditText.getText().toString());
            bundle.putString(SONG_TITLE, songEditText.getText().toString());
            lyricsFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, lyricsFragment).commit();
        }
    }
}

