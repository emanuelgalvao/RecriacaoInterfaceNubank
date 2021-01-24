package com.emanuelgalvao.recriacaointerfacenubank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ImageView ivVisible;

    private LinearLayout llInvoice;
    private TextView tvInvoiceValue;
    private LinearLayout llAvailableLimit;

    private LinearLayout llBalance;
    private TextView tvBalanceValue;

    private boolean valuesHidden = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        LinearLayout btHideValues = findViewById(R.id.btHideValues);
        ivVisible = findViewById(R.id.ivVisible);

        llInvoice = findViewById(R.id.llInvoice);
        tvInvoiceValue = findViewById(R.id.tvInvoiceValue);
        llAvailableLimit = findViewById(R.id.llAvailableLimit);

        llBalance = findViewById(R.id.llBalance);
        tvBalanceValue = findViewById(R.id.tvBalanceValue);

        btHideValues.setOnClickListener(onClickListener());
    }

    @SuppressLint("NonConstantResourceId")
    private View.OnClickListener onClickListener() {
        return v -> {
            switch (v.getId()) {
                case R.id.btHideValues:
                    HideAndShowValues(valuesHidden);
                    break;
            }
        };
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void HideAndShowValues(boolean show) {

        if (!show) {
            ivVisible.setImageDrawable(getResources().getDrawable(R.drawable.ic_visible));
            llInvoice.setBackgroundColor(getResources().getColor(R.color.hide_background));
            llBalance.setBackgroundColor(getResources().getColor(R.color.hide_background));
            tvInvoiceValue.setVisibility(View.INVISIBLE);
            llAvailableLimit.setVisibility(View.INVISIBLE);
            tvBalanceValue.setVisibility(View.INVISIBLE);
        } else {
            ivVisible.setImageDrawable(getResources().getDrawable(R.drawable.ic_invisible));
            llInvoice.setBackgroundColor(getResources().getColor(R.color.show_background));
            llBalance.setBackgroundColor(getResources().getColor(R.color.show_background));
            tvInvoiceValue.setVisibility(View.VISIBLE);
            llAvailableLimit.setVisibility(View.VISIBLE);
            tvBalanceValue.setVisibility(View.VISIBLE);
        }

        valuesHidden = !valuesHidden;
    }
}