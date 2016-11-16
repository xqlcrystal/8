package crystal.com.sharedpreferencetest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SharedPreferenceTest extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        sharedPreferences=getSharedPreferences("crystal",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        Button write=(Button)findViewById(R.id.write);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                editor.putString("time",simpleDateFormat.format(new Date()));
                editor.putInt("random",(int)Math.random()*100);

            }
        });

        Button read=(Button)findViewById(R.id.read);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time=sharedPreferences.getString("time",null);
                int random=sharedPreferences.getInt("random",0);
                Toast.makeText(SharedPreferenceTest.this,time+"\n"+random,Toast.LENGTH_LONG).show();
            }
        });
    }
}
