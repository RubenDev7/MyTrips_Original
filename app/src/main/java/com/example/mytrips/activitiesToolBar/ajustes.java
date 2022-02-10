package com.example.mytrips.activitiesToolBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.example.mytrips.R;

public class ajustes extends AppCompatActivity {
    Toolbar ajustesToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
        main();
    }

    private void main() {
        controls();
        back();
    }

    private void controls() {
        ajustesToolbar = findViewById(R.id.toolbarAjustes);
        setSupportActionBar(ajustesToolbar);
        ajustesToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_baseline_keyboard_backspace_24));
    }

    private void back() {
        ajustesToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //regresar al main
                finish();
            }
        });
    }
}