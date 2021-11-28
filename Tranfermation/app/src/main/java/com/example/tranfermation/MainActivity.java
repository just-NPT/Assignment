package com.example.tranfermation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tranfermation.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String baseST,baseND;
    private Spinner FirstSpinner,SecondSpinner;
    private Button enter;
    private TextView result;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstSpinner = findViewById(R.id.first_spinner);
        SecondSpinner = findViewById(R.id.second_spinner);
        enter = findViewById(R.id.enter);
        result = findViewById(R.id.Result);
        input = findViewById(R.id.input);

        String[] dropDownList = {"BIN","DEC","OCT","HEX"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, dropDownList);
        FirstSpinner.setAdapter(adapter);
        SecondSpinner.setAdapter(adapter);
        FirstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                baseST = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SecondSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                baseND = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = input.getText().toString();
                String res = "";
                long fst = 0,snd = 0;
                switch (baseST){
                    case "BIN": fst = 2; break;
                    case "DEC": fst = 10; break;
                    case "OCT": fst = 8; break;
                    case "HEX": fst = 16; break;
                }
                switch (baseND){
                    case "BIN": snd = 2; break;
                    case "DEC": snd = 10; break;
                    case "OCT": snd = 8; break;
                    case "HEX": snd = 16; break;
                }
                if(fst == 10){
                    res = DecimalToAny(s,snd);
                }else{
                    if(snd == 10){
                        res = AnyToDecimal(fst,s);
                    }else{
                        String temp = "";
                        temp = AnyToDecimal(fst,s);
                        res = DecimalToAny(temp,snd);
                    }
                }
                result.setText(res);
            }
        });
    }

    public String AnyToDecimal(long base,String num){
        long number = 0;
        long n ;
        String res = "";
        if(base == 16){
            int i=num.length()-1;
            int j=0;
            while (i>=0)
            {
                String dig=String.valueOf(num.charAt(i));
                switch (dig) {
                    case "A":
                        dig = "10";
                        break;
                    case "B":
                        dig = "11";
                        break;
                    case "C":
                        dig = "12";
                        break;
                    case "D":
                        dig = "13";
                        break;
                    case "E":
                        dig = "14";
                        break;
                    case "F":
                        dig = "15";
                        break;
                }
                number = number+(Long.parseLong(dig)*(long)Math.pow(base,j));
                i--;
                j++;

            }
        }else{
            n = Long.parseLong(num);
            int i=0;
            while (n>0)
            {
                int dig = (int) (n % 10);
                number=number+(long)(dig*Math.pow(base,i));
                i++;
                n=n/10;
            }
        }
        res=String.valueOf(number);
        return res;
    }

    public String DecimalToAny(String num,long base){
        long n;
        String res = "";
        n = Long.parseLong(num);
        while (n > 0) {
            int dig = (int) (n % base);
            if (base==16 && dig>9)
            {
                switch (dig)
                {
                    case 10:
                        res+="A";
                        break;
                    case 11:
                        res+="B";
                        break;
                    case 12:
                        res+="C";
                        break;
                    case 13:
                        res+="D";
                        break;
                    case 14:
                        res+="E";
                        break;
                    case 15:
                        res+="F";
                        break;
                }
            }
            else
            {
                res = res + Integer.toString(dig);
            }

            n = n / base;
        }
        res = reverseString(res);
        return res ;
    }

    public String reverseString(String res)
    {
        String newRes="";
        int i=res.length()-1;
        while(i>=0)
        {
            newRes+=String.valueOf(res.charAt(i));
            i--;
        }
        return newRes;
    }
}