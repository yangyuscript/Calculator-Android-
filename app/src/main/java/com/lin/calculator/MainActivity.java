package com.lin.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    //private float a;
    //private float b;
    //private int flag;//0表示除法 1表示乘法 2表示减法 3表示加法
    String result=null;
    private EditText et;
    private Button clear_btn;
    private Button del_btn;
    private Button division_btn;
    private Button multiple_btn;
    private Button seven_btn;
    private Button eight_btn;
    private Button nine_btn;
    private Button minus_btn;
    private Button four_btn;
    private Button five_btn;
    private Button six_btn;
    private Button plus_btn;
    private Button one_btn;
    private Button two_btn;
    private Button three_btn;
    private Button zero_btn;
    private Button dot_btn;
    private Button equal_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText)findViewById(R.id.editText);
        clear_btn=(Button)findViewById(R.id.clear_btn);
        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText("0");
            }
        });
        del_btn=(Button)findViewById(R.id.del_btn);
        del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=et.getText().toString();
                if(s.equals("0")||s.length()==1){
                    et.setText("0");
                }else{
                    et.setText(s.substring(0,s.length()-1));
                }
            }
        });
        dot_btn=(Button)findViewById(R.id.dot_btn);
        dot_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=et.getText().toString();
                String[] sa=s.split("\\+|-|\\*|/");//将算数表达式按照+，-，*，/分割，用来判断当前输入的数（即分割出来的数组最后一个元素）是否已经输入小数点.
                /*for(int i=0,len=sa.length;i<len;i++){
                    Log.i("tag:the array is:",sa[i]);
                }*/
                if(sa[sa.length-1].contains(".")){

                }else{
                    if(s.equals("/")||s.equals("*")||s.equals("+")||s.equals("-")){
                        et.setText("0.");
                    }else{
                        et.setText(s+".");
                    }
                }
            }
        });
        division_btn=(Button)findViewById(R.id.division_btn);
        division_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a_string=et.getText().toString();
                //if(a_string.equals("/")||a_string.equals("*")||a_string.equals("+")||a_string.equals("-")){
                String last_s=a_string.substring(a_string.length()-1,a_string.length());
                if(last_s.equals("/")||last_s.equals("*")||last_s.equals("+")||last_s.equals("-")){

                }else{
                    et.setText(a_string+"/");
                }
            }
        });
        multiple_btn=(Button)findViewById(R.id.multiple_btn);
        multiple_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a_string=et.getText().toString();
                String last_s=a_string.substring(a_string.length()-1,a_string.length());
                if(last_s.equals("/")||last_s.equals("*")||last_s.equals("+")||last_s.equals("-")){

                }else{
                    et.setText(a_string+"*");
                }
            }
        });
        minus_btn=(Button)findViewById(R.id.minus_btn);
        minus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a_string=et.getText().toString();
                String last_s=a_string.substring(a_string.length()-1,a_string.length());
                if(last_s.equals("/")||last_s.equals("*")||last_s.equals("+")||last_s.equals("-")){

                }else{
                    et.setText(a_string+"-");
                }
            }
        });
        plus_btn=(Button)findViewById(R.id.plus_btn);
        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a_string=et.getText().toString();
                String last_s=a_string.substring(a_string.length()-1,a_string.length());
                if(last_s.equals("/")||last_s.equals("*")||last_s.equals("+")||last_s.equals("-")){

                }else{
                    et.setText(a_string+"+");
                }
            }
        });
        equal_btn=(Button)findViewById(R.id.equal_btn);
        equal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String formula=et.getText().toString();
                getPM(formula);
                Log.i("tag 去除* /后算术式为是：",result);
                et.setText(formatResult(getResult(result)));
            }
        });
        one_btn=(Button)findViewById(R.id.one_btn);
        one_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=et.getText().toString();
                if(s.equals("0")||s.equals("/")||s.equals("*")||s.equals("+")||s.equals("-")){
                    et.setText("1");
                }else{
                    et.setText(s+"1");
                }
            }
        });
        two_btn=(Button)findViewById(R.id.two_btn);
        two_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=et.getText().toString();
                if(s.equals("0")||s.equals("/")||s.equals("*")||s.equals("+")||s.equals("-")){
                    et.setText("2");
                }else{
                    et.setText(s+"2");
                }
            }
        });
        three_btn=(Button)findViewById(R.id.three_btn);
        three_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=et.getText().toString();
                if(s.equals("0")||s.equals("/")||s.equals("*")||s.equals("+")||s.equals("-")){
                    et.setText("3");
                }else{
                    et.setText(s+"3");
                }
            }
        });
        four_btn=(Button)findViewById(R.id.four_btn);
        four_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=et.getText().toString();
                if(s.equals("0")||s.equals("/")||s.equals("*")||s.equals("+")||s.equals("-")){
                    et.setText("4");
                }else{
                    et.setText(s+"4");
                }
            }
        });
        five_btn=(Button)findViewById(R.id.five_btn);
        five_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=et.getText().toString();
                if(s.equals("0")||s.equals("/")||s.equals("*")||s.equals("+")||s.equals("-")){
                    et.setText("5");
                }else{
                    et.setText(s+"5");
                }
            }
        });
        six_btn=(Button)findViewById(R.id.six_btn);
        six_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=et.getText().toString();
                if(s.equals("0")||s.equals("/")||s.equals("*")||s.equals("+")||s.equals("-")){
                    et.setText("6");
                }else{
                    et.setText(s+"6");
                }
            }
        });
        seven_btn=(Button)findViewById(R.id.seven_btn);
        seven_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=et.getText().toString();
                if(s.equals("0")||s.equals("/")||s.equals("*")||s.equals("+")||s.equals("-")){
                    et.setText("7");
                }else{
                    et.setText(s+"7");
                }
            }
        });
        eight_btn=(Button)findViewById(R.id.eight_btn);
        eight_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=et.getText().toString();
                if(s.equals("0")||s.equals("/")||s.equals("*")||s.equals("+")||s.equals("-")){
                    et.setText("8");
                }else{
                    et.setText(s+"8");
                }
            }
        });
        nine_btn=(Button)findViewById(R.id.nine_btn);
        nine_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=et.getText().toString();
                if(s.equals("0")||s.equals("/")||s.equals("*")||s.equals("+")||s.equals("-")){
                    et.setText("9");
                }else{
                    et.setText(s+"9");
                }
            }
        });
        zero_btn=(Button)findViewById(R.id.zero_btn);
        zero_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=et.getText().toString();
                if(s.equals("0")||s.equals("/")||s.equals("*")||s.equals("+")||s.equals("-")){
                    et.setText("0");
                }else{
                    et.setText(s+"0");
                }
            }
        });
    }
    //将字符串中的* /全部去掉
    public void getPM(String s){
        char sChars[]=s.toCharArray();
        String a=null;
        String b=null;
        int ai=0;
        int bi=0;
        if(s.indexOf("/")!=-1||s.indexOf("*")!=-1) {
            Log.i("tag","进入判断。。。。。。。。。。。。。。。。。。");
            if (s.indexOf("/") < (s.indexOf("*")==-1?10000:s.indexOf("*"))&&s.indexOf("/")!=-1) {
                if (s.indexOf("/") != -1) {
                    //找到a
                    for (int i = s.indexOf("/") - 1; i >=0; i--) {
                        if (String.valueOf(sChars[i]).equals("/") || String.valueOf(sChars[i]).equals("*") || String.valueOf(sChars[i]).equals("-") || String.valueOf(sChars[i]).equals("+")) {
                            ai=i;
                            break;
                        } else {
                            if (a == null) {
                                a = String.valueOf(sChars[i]);
                            } else {
                                a = sChars[i] + a;
                            }
                            ai=i;
                        }
                    }
                    //找到b
                    for (int j = s.indexOf("/") + 1; j < s.length(); j++) {
                        if (String.valueOf(sChars[j]).equals("/") || String.valueOf(sChars[j]).equals("*") || String.valueOf(sChars[j]).equals("-") || String.valueOf(sChars[j]).equals("+")) {
                            bi=j;
                            break;
                        } else {
                            if (b == null) {
                                b = String.valueOf(sChars[j]);
                            } else {
                                b = b + sChars[j];
                            }
                            bi=j;
                        }
                    }
                    if(ai==0&&bi!=s.length()-1){
                        s=Float.parseFloat(a)/Float.parseFloat(b)+s.substring(bi,s.length());
                    }else if(ai!=0&&bi==s.length()-1){
                        s=s.substring(0,ai+1)+Float.parseFloat(a)/Float.parseFloat(b);
                    }else if(ai!=0&&bi!=s.length()-1){
                        s=s.substring(0,ai+1)+Float.parseFloat(a)/Float.parseFloat(b)+s.substring(bi,s.length());
                    }else{
                        s=String.valueOf(Float.parseFloat(a)/Float.parseFloat(b));
                    }
                    Log.i("tag:此时s是：",s);
                }
            } else {
                if (s.indexOf("*") != -1) {
                    //找到a
                    for (int i = s.indexOf("*") - 1; i >=0; i--) {
                        //Log.i("tag呵呵I：",i+"");
                        if (String.valueOf(sChars[i]).equals("/") || String.valueOf(sChars[i]).equals("*") || String.valueOf(sChars[i]).equals("-") || String.valueOf(sChars[i]).equals("+")) {
                            ai=i;
                            break;
                        } else {
                            if (a == null) {
                                a = String.valueOf(sChars[i]);
                                //Log.i("tag呵呵：",a);
                            } else {
                                a = sChars[i] + a;
                            }
                            ai=i;
                        }
                    }
                    //找到b
                    for (int j = s.indexOf("*") + 1; j < s.length(); j++) {
                        if (String.valueOf(sChars[j]).equals("/") || String.valueOf(sChars[j]).equals("*") || String.valueOf(sChars[j]).equals("-") || String.valueOf(sChars[j]).equals("+")) {
                            bi=j;
                            break;
                        } else {
                            if (b == null) {
                                b = String.valueOf(sChars[j]);
                            } else {
                                b = b + sChars[j];
                            }
                            bi=j;
                        }
                    }
                    //if(s.substring(0,ai+1))
                    //Log.i("tag:此时ai是：",ai+" "+sChars[ai]);
                    //Log.i("tag:此时bi是：",bi+" "+sChars[bi]);
                    //Log.i("tag:a和b是：",a+"   "+b);
                    if(ai==0&&bi!=s.length()-1){
                        s=Float.parseFloat(a)*Float.parseFloat(b)+s.substring(bi,s.length());
                    }else if(ai!=0&&bi==s.length()-1){
                        s=s.substring(0,ai+1)+Float.parseFloat(a)*Float.parseFloat(b);
                    }else if(ai!=0&&bi!=s.length()-1){
                        s=s.substring(0,ai+1)+Float.parseFloat(a)*Float.parseFloat(b)+s.substring(bi,s.length());
                    }else{
                        s=String.valueOf(Float.parseFloat(a)*Float.parseFloat(b));
                    }
                    //Log.i("tag:此时s是：",s);
                }
            }
            Log.i("tag:进入下一个getPM(s)时s是：",s);
            getPM(s);
        }else{
            Log.i("tag:最后一次转换s是：",s);
            result=s;
        }
    }
    public float getResult(String s){
        char[]  sChars=s.toCharArray();
        float result=0;
        Queue<String> queue_num=new LinkedList<String>();
        Queue<String> queue_formula=new LinkedList<String>();
        String p="";
        //String pause="";
        for(int i=0,len=sChars.length;i<len;i++){
           if(String.valueOf(sChars[i]).equals("+")||String.valueOf(sChars[i]).equals("-")){
               Log.i("tag:此时插入队列的运算符是：",String.valueOf(sChars[i]));
               queue_formula.offer(String.valueOf(sChars[i]));
               p="";
           }else{
               if(i<sChars.length-1){
                   if(String.valueOf(sChars[i+1]).equals("+")||String.valueOf(sChars[i+1]).equals("-")){
                       p=p+sChars[i];
                       Log.i("tag:此时插入队列的a是：",p);
                       queue_num.offer(p);
                   }else{
                       p=p+sChars[i];
                       Log.i("tag:fuck",p);
                   }
               }else{
                   Log.i("tag:此时插入队列的a是：",p+sChars[i]);
                   queue_num.offer(p+sChars[i]);
               }
           }
        }
        result+=Float.parseFloat(queue_num.poll());
        for(int i=0,len=sChars.length;i<len;i++){
            if(queue_num.peek()==null){
                break;
            }else{
                if(queue_formula.poll().equals("+")){
                    result+=Float.parseFloat(queue_num.poll());
                }else{
                    result-=Float.parseFloat(queue_num.poll());
                }
            }
        }
        return result;
    }
    //对结果进行格式化，建议最好将数据类型float改成double
    public String formatResult(float result){
        float haha=result;
        String finalResult;
        Log.i("tag the haha is ",String.valueOf(haha));
        if(String.valueOf(haha).contains(".")){
            if(String.valueOf(haha).split("\\.")[1].length()>2){
                DecimalFormat decimalFormat=new DecimalFormat(".0000");//对结果进行格式化
                finalResult=decimalFormat.format(haha);
            }else{
                DecimalFormat decimalFormat=new DecimalFormat(".00");//对结果进行格式化
                finalResult=decimalFormat.format(haha);
            }
        }else{
            finalResult=String.valueOf(result);
        }
        Log.i("tag,格式化后的结果是：",finalResult);
        return finalResult;
    }
}
