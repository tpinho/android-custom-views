package com.tpinho.customviews.ui.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.tpinho.customviews.R;
import com.tpinho.customviews.ui.custom.MoneyView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.button_main_click);
        button.setOnClickListener(view -> {
            Snackbar.make(view, getString(R.string.clicked, button.getText()), Snackbar.LENGTH_LONG).show();
        });

        final MoneyView moneyView = (MoneyView) findViewById(R.id.money_main_price);
        moneyView.setValue("50000");
    }

}
