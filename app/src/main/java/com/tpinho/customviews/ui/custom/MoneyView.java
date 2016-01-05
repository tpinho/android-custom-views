package com.tpinho.customviews.ui.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tpinho.customviews.R;

import br.com.concretesolutions.canarinho.formatador.FormatadorValor;

import static android.os.Build.VERSION_CODES.LOLLIPOP;

/**
 * Created by tpinho on 1/4/16.
 */
public class MoneyView extends LinearLayout {

    private TextView textMoneyCurrency;
    private TextView textMoneyValue;

    public MoneyView(Context context) {
        super(context);
        init();
    }

    public MoneyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MoneyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(LOLLIPOP)
    public MoneyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_money, this);

        textMoneyCurrency = (TextView) findViewById(R.id.text_money_currency);
        textMoneyValue = (TextView) findViewById(R.id.text_money_value);

        setCurrency(R.string.default_currency);
        setValue(R.string.default_value);
    }

    public void setCurrency(@StringRes int text) {
        textMoneyCurrency.setText(text);
    }

    public void setCurrency(String text) {
        textMoneyCurrency.setText(text);
    }

    public void setValue(@StringRes int value) {
        setValue(getResources().getString(value));
    }

    public void setValue(String value) {
        textMoneyValue.setText(FormatadorValor.VALOR.formata(value));
    }

}