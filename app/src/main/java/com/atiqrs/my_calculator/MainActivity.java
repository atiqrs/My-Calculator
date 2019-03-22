package com.atiqrs.my_calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView input1,input2,inputmid,output;
    float in1,in2,out;
    boolean div,mul,min,sum;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPoint,bEqual,bDel,bDiv,bMul,bMin,bSum;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        input1 = findViewById(R.id.input1);
        inputmid = findViewById(R.id.inputmid);
        input2 = findViewById(R.id.input2);
        output = findViewById(R.id.output);
        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        bPoint = findViewById(R.id.bPoint);
        bEqual = findViewById(R.id.bEqual);
        bDel = findViewById(R.id.bDel);
        bDiv = findViewById(R.id.bDiv);
        bMul = findViewById(R.id.bMul);
        bMin = findViewById(R.id.bMin);
        bSum = findViewById(R.id.bSum);

        Handle cal = new Handle();

        b0.setOnClickListener(cal);
        b1.setOnClickListener(cal);
        b2.setOnClickListener(cal);
        b3.setOnClickListener(cal);
        b4.setOnClickListener(cal);
        b5.setOnClickListener(cal);
        b6.setOnClickListener(cal);
        b7.setOnClickListener(cal);
        b8.setOnClickListener(cal);
        b9.setOnClickListener(cal);
        bPoint.setOnClickListener(cal);
        bEqual.setOnClickListener(cal);
        bDel.setOnClickListener(cal);
        bDiv.setOnClickListener(cal);
        bMul.setOnClickListener(cal);
        bMin.setOnClickListener(cal);
        bSum.setOnClickListener(cal);
        registerForContextMenu(bDel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about){
            Intent i = new Intent(MainActivity.this,About.class);
            startActivity(i);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.ac){
            input1.setText("");
            input2.setText("");
            inputmid.setText("");
            output.setText("");
            in1=0;
            in2=0;
            out=0;
            div=false;
            mul=false;
            min=false;
            sum=false;
        }
        return true;
    }

    private class Handle implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.b0)
                input1.setText(input1.getText().toString()+"0");
                if (view.getId() == R.id.b1)
                input1.setText(input1.getText().toString()+"1");
            if (view.getId() == R.id.b2)
                input1.setText(input1.getText().toString()+"2");
            if (view.getId() == R.id.b3)
                input1.setText(input1.getText().toString()+"3");
            if (view.getId() == R.id.b4)
                input1.setText(input1.getText().toString()+"4");
            if (view.getId() == R.id.b5)
                input1.setText(input1.getText().toString()+"5");
            if (view.getId() == R.id.b6)
                input1.setText(input1.getText().toString()+"6");
            if (view.getId() == R.id.b7)
                input1.setText(input1.getText().toString()+"7");
            if (view.getId() == R.id.b8)
                input1.setText(input1.getText().toString()+"8");
            if (view.getId() == R.id.b9)
                input1.setText(input1.getText().toString()+"9");
            if (view.getId() == R.id.bPoint)
                input1.setText(input1.getText().toString()+".");
            if (view.getId() == R.id.bDiv) {
                try {
                    input2.setText(input1.getText().toString());
                    inputmid.setText("/");
                    input1.setText("");

                    div = true;
                    mul = false;
                    min = false;
                    sum = false;

                    if(out!=0){
                        input2.setText(String.valueOf(out));
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, e.getMessage()+"", Toast.LENGTH_SHORT).show();
                }
            }

            if (view.getId() == R.id.bMul) {
                try {
                    input2.setText(input1.getText().toString());
                    inputmid.setText("*");
                    input1.setText("");

                    div =false;
                    mul =true;
                    min =false;
                    sum =false;

                    if(out!=0){
                        input2.setText(String.valueOf(out));
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, e.getMessage()+"", Toast.LENGTH_SHORT).show();
                }

            }
            if (view.getId() == R.id.bMin){
                try {
                    input2.setText(input1.getText().toString());
                    inputmid.setText("-");
                    input1.setText("");

                    div =false;
                    mul =false;
                    min =true;
                    sum =false;

                    if(out!=0){
                        input2.setText(String.valueOf(out));
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, e.getMessage()+"", Toast.LENGTH_SHORT).show();
                }
            }
            if (view.getId() == R.id.bSum){
                try {
                    input2.setText(input1.getText().toString());
                    inputmid.setText("+");
                    input1.setText("");

                    div =false;
                    mul =false;
                    min =false;
                    sum =true;

                    if(out!=0){
                        input2.setText(String.valueOf(out));
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, e.getMessage()+"", Toast.LENGTH_SHORT).show();
                }

            }

            if (view.getId() == R.id.bDel) try {
                String aa;
                if (input1.getText().toString().length() == 0) {
                    inputmid.setText("");
                    input2.setText("");
                }
                aa = input1.getText().toString();
                String a = aa.substring(0, aa.length() - 1);
                input1.setText(a);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Field is Empty", Toast.LENGTH_SHORT).show();
            }
            
            if (view.getId() == R.id.bEqual){
                try {
                    in2 = Float.parseFloat(input1.getText().toString());

                    if (div==true) {
                        in1 = Float.parseFloat(input2.getText().toString());
                        in2 = Float.parseFloat(input1.getText().toString());
                        out=in1/in2;
                        output.setText(out+"");
                    }
                    if (mul==true){
                        in1 = Float.parseFloat(input2.getText().toString());
                        in2 = Float.parseFloat(input1.getText().toString());
                        out=in1*in2;
                        output.setText(out+"");
                    }
                    if (min==true){
                        in1 = Float.parseFloat(input2.getText().toString());
                        in2 = Float.parseFloat(input1.getText().toString());
                        out=in1-in2;
                        output.setText(out+"");
                    }
                    if (sum==true){
                        in1 = Float.parseFloat(input2.getText().toString());
                        in2 = Float.parseFloat(input1.getText().toString());
                        out=in1+in2;
                        output.setText(out+"");
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, e.getMessage()+"", Toast.LENGTH_SHORT).show();
                }
            }
            
        }
    }
}