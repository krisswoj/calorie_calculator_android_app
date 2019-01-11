package domain;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.kuba.myapp.R;

public class TestRadioButton extends Activity {

    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private Button btnDisplay;

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        addListenerOnButton();
//
//    }

//    public void addListenerOnButton() {
//
//        radioSexGroup = findViewById(R.id.radioSex);
//        btnDisplay = findViewById(R.id.btnDisplay);
//
//        btnDisplay.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                // get selected radio button from radioGroup
//                int selectedId = radioSexGroup.getCheckedRadioButtonId();
//
//                // find the radiobutton by returned id
//                radioSexButton = findViewById(selectedId);
//
//                Toast.makeText(TestRadioButton.this,
//                        radioSexButton.getText(), Toast.LENGTH_SHORT).show();
//
//            }
//
//        });
//
//    }
}
