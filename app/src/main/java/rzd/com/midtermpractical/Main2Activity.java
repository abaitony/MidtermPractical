package rzd.com.midtermpractical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    Button btnplus, btnminus, btnprev, btnnext;
    TextView txtVTipPercentage, txtVTipTotal;
    float mTip;
    float paymentAmt, tiptotal;
    String customerN, serverN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnplus = findViewById(R.id.btnPlusPlus);
        btnminus = findViewById(R.id.btnMinusMinus);
        btnprev = findViewById(R.id.btnPrevAct2);
        btnnext = findViewById(R.id.btnNextAct2);
        txtVTipPercentage = findViewById(R.id.txtVTipPercentage);
        txtVTipTotal = findViewById(R.id.txtVTipTotal);

        getIntentFromAct1();
        setOnClickListener();
    }


    private void setOnClickListener(){
        btnnext.setOnClickListener(this);
        btnprev.setOnClickListener(this);
        btnminus.setOnClickListener(this);
        btnplus.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnPlusPlus: plusplus(); break;
            case R.id.btnMinusMinus: minusminus(); break;
            case R.id.btnNextAct2: nextAct2(); break;
            case R.id.btnPrevAct2: prevAct2(); break;
        }
    }

    public void getIntentFromAct1(){
        Intent intent = getIntent();
        ModelClass modelClass = (ModelClass) intent.getSerializableExtra("sendingAct1Data");
        paymentAmt = modelClass.getPaymentAmount();
        serverN = modelClass.getCustomerName();
        customerN = modelClass.getCustomerName();
    }

    public void prevAct2() {
//        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
//        Toast.makeText(getApplicationContext(),"Display TIP INFORMATION", Toast.LENGTH_SHORT).show();
//        startActivity(intent);
        finish();
    }
    public void nextAct2(){
        Intent intent1 = new Intent(Main2Activity.this, Main3Activity.class);
        ModelClass modelClass = new ModelClass(customerN,serverN,paymentAmt,mTip,tiptotal);
        intent1.putExtra("sendingAct2toAct3", modelClass);
        Toast.makeText(getApplicationContext(),"Display TIP DETAILS",Toast.LENGTH_SHORT).show();
        startActivity(intent1);
    }
    public void display(float mTip, Float paymentAmt){
        txtVTipPercentage.setText(String.format("%.0f",mTip));
        tiptotal = paymentAmt * (mTip / 100);
        txtVTipTotal.setText(String.format("%.2f",tiptotal));
    }
    public void plusplus(){
        if(mTip >= 100)
            Toast.makeText(getApplicationContext(),"MAXIMUM TIP REACHED", Toast.LENGTH_SHORT).show();
        else {
            mTip = Float.parseFloat(txtVTipPercentage.getText().toString());
            mTip += 1.0;
            display(mTip,paymentAmt);
        }
    }
    public void minusminus(){
        if(mTip <= 0)
            Toast.makeText(getApplicationContext(), "MINIMUM TIP REACHED", Toast.LENGTH_SHORT).show();
        else{
        mTip = Float.parseFloat(txtVTipPercentage.getText().toString());
        mTip -= 1;
        display(mTip,paymentAmt);

        }
    }
    @Override
    public void finish(){
        Toast.makeText(getApplicationContext(),"Display TIP INFORMATION", Toast.LENGTH_SHORT).show();
        super.finish();
    }


}
