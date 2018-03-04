package jdf.jdfmonitorandroid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import jdf.jdfmonitorandroid.Manager.MyContext;
import jdf.jdfmonitorandroid.R;

/**
 * Created by gyl1 on 3/3/18.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }
    void initView(){
        nextBtn = (Button) findViewById(R.id.id_loginBtn);
        nextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_loginBtn:
                Log.i("tag","next");
                Intent intent = new Intent(MyContext.getInstance().getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }


    }
}
