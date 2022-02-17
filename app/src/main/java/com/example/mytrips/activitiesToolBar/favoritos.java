package com.example.mytrips.activitiesToolBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.example.mytrips.R;

public class favoritos extends AppCompatActivity {
    Toolbar perfilToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        main();
    }

    private void main() {
        controls();
        back();
    }

    private void controls() {
    perfilToolbar = findViewById(R.id.toolbarPerfil);
    setSupportActionBar(perfilToolbar);
    perfilToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_baseline_keyboard_backspace_24));
    }

    private void back() {
        perfilToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //regresar al main
                finish();
            }
        });
    }
}