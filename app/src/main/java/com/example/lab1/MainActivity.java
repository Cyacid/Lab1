package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText ed_name;
    private TextView tv_text,tv_name,tv_won,tv_cd,tv_pd;
    private RadioButton btn_sci,btn_paper,btn_rock;
    private Button btn_do;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_name = findViewById(R.id.ed_name);
        tv_text = findViewById(R.id.tv_pname);
        tv_name = findViewById(R.id.tv_name);
        tv_won = findViewById(R.id.tv_won);
        tv_cd = findViewById(R.id.tv_cd);
        tv_pd = findViewById(R.id.tv_pd);
        btn_sci = findViewById(R.id.btn_sci);
        btn_rock = findViewById(R.id.btn_rock);
        btn_paper = findViewById(R.id.btn_paper);
        btn_do = findViewById(R.id.btn_do);

        btn_do.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //判斷名字
                if(ed_name.length()<1){
                    tv_text.setText("請輸入玩家姓名!");
                }
                else{
                    tv_name.setText(String.format("名字\n%s",ed_name.getText().toString()));
                    if(btn_sci.isChecked()){
                        tv_pd.setText("我方出拳\n剪刀");
                    }
                    else if(btn_rock.isChecked()){
                        tv_pd.setText("我方出拳\n石頭");
                    }
                    else if(btn_paper.isChecked()){
                        tv_pd.setText("我方出拳\n布");
                    }
                    int com = (int) (Math.random()*3);

                    if(com==0){
                        tv_cd.setText("電腦出拳\n剪刀");
                    }
                    else if(com==1){
                        tv_cd.setText("電腦出拳\n石頭");
                    }
                    else if(com==2){
                        tv_cd.setText("電腦出拳\n布");
                    }

                    if((btn_sci.isChecked() && com==2)||(btn_paper.isChecked() && com==1)||(btn_rock.isChecked() && com==0)){
                        tv_won.setText("勝利者\n"+ed_name.getText().toString());
                        tv_text.setText("恭喜獲勝!");
                    }
                    else if((btn_sci.isChecked() && com==1)||(btn_paper.isChecked() && com==0)||(btn_rock.isChecked() && com==2)){
                        tv_won.setText("勝利者\n電腦");
                        tv_text.setText("可惜，電腦獲勝!");
                    }
                    else if((btn_sci.isChecked() && com==0)||(btn_paper.isChecked() && com==2)||(btn_rock.isChecked() && com==1)){
                        tv_won.setText("勝利者\n平手");
                        tv_text.setText("平局，再一局!");
                    }
                }
            }
        });

    }
}