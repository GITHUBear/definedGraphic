package com.github.githubear.definedgraphic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button button;
    private EditText editText;
    private polygon polView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.edit_text);
        polView=(polygon)findViewById(R.id.imgView);
        imageView=(ImageView)findViewById(R.id.image_view);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.button:
                imageView.setImageResource(R.drawable.scene);
                polView.setImageResource(R.drawable.scene);
                break;
            default:
                break;

        }
    }

}
