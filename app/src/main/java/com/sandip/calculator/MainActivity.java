package com.sandip.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity {

    TextView result_TextView;
    TextView expression_TextView;

    String expr = "";
    String evalExpr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result_TextView = (TextView) findViewById(R.id.textView_result);
        expression_TextView = (TextView) findViewById(R.id.textView_expression);

        result_TextView.setMovementMethod(new ScrollingMovementMethod());
        expression_TextView.setMovementMethod(new ScrollingMovementMethod());
    }


    public void btn00(View view) {
        expr += "00";
        evalExpr += "00";
        expression_TextView.setText(expr);
    }

    public void btn0(View view) {
        expr += "0";
        evalExpr += "0";
        expression_TextView.setText(expr);
    }

    public void btnDot(View view) {
        expr += ".";
        evalExpr += ".";
        expression_TextView.setText(expr);
    }

    public void btn1(View view) {
        expr += "1";
        evalExpr += "1";
        expression_TextView.setText(expr);
    }

    public void btn2(View view) {
        expr += "2";
        evalExpr += "2";
        expression_TextView.setText(expr);
    }

    public void btn3(View view) {
        expr += "3";
        evalExpr += "3";
        expression_TextView.setText(expr);
    }

    public void btnSum(View view) {
        expr += "+";
        evalExpr += "+";
        expression_TextView.setText(expr);
    }

    public void btn4(View view) {
        expr += "4";
        evalExpr += "4";
        expression_TextView.setText(expr);
    }

    public void btn5(View view) {
        expr += "5";
        evalExpr += "5";
        expression_TextView.setText(expr);
    }

    public void btn6(View view) {
        expr += "6";
        evalExpr += "6";
        expression_TextView.setText(expr);
    }

    public void btnSub(View view) {
        expr += "-";
        evalExpr += "-";
        expression_TextView.setText(expr);
    }

    public void btn7(View view) {
        expr += "7";
        evalExpr += "7";
        expression_TextView.setText(expr);
    }

    public void btn8(View view) {
        expr += "8";
        evalExpr += "8";
        expression_TextView.setText(expr);
    }

    public void btn9(View view) {
        expr += "9";
        evalExpr += "9";
        expression_TextView.setText(expr);
    }

    public void btnMul(View view) {
        expr += "x";
        evalExpr += "*";
        expression_TextView.setText(expr);
    }

    public void btnAllClear(View view) {
        expr = "";
        evalExpr = "";
        expression_TextView.setText(null);
        result_TextView.setText(null);
    }

    public void btnMod(View view) {
        expr += "%";
        evalExpr += "%";
        expression_TextView.setText(expr);
    }

    public void btnDiv(View view) {
        expr += "÷";
        evalExpr += "/";
        expression_TextView.setText(expr);
    }

    public void btnClear(View view) {
        int len = expr.length();
        if(expr.equals(" ") | expr.equals("")){
            expression_TextView.setText(null);
            result_TextView.setText(null);
        }
        else{
            String substring = expr.substring(0,len-1);
            expr = substring;
            expression_TextView.setText(substring);
        }

        int len1 = evalExpr.length();
        if(evalExpr.equals(" ") | evalExpr.equals("")){
            expression_TextView.setText(null);
            result_TextView.setText(null);
        }
        else{
            evalExpr = evalExpr.substring(0,len1-1);
        }
    }

    public void btnEqual(View view) {
        try{
            if (evalExpr.equals("")) {
                result_TextView.setText(null);
            }
            else{
                Double result = evaluateExpr(evalExpr);
                String res = String.valueOf(result);
                result_TextView.setText(res);
            }
        }
        catch (Exception e){
            result_TextView.setText(R.string.invalid_operation);
        }

    }

    public static Double evaluateExpr(String expr){
        Expression expression = new ExpressionBuilder(expr).build();
        return expression.evaluate();
    }
}