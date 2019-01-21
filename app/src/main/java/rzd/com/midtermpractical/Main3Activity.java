package rzd.com.midtermpractical;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    TextView txtvCustomerName, txtVServerName, txtVPaymentAmt, txtVTipPercent, txtVtiptotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        txtvCustomerName = findViewById(R.id.txtVCustomerNameAct3);
        txtVServerName = findViewById(R.id.txtVServerNameAct3);
        txtVPaymentAmt = findViewById(R.id.txtVPaymentAmtAct3);
        txtVTipPercent = findViewById(R.id.txtVTipPercentageAct3);
        txtVtiptotal = findViewById(R.id.txtVTipTotalAct3);

        Intent intent = getIntent();
        ModelClass modelClass = (ModelClass) intent.getSerializableExtra("sendingAct2toAct3");
        txtvCustomerName.setText(modelClass.getCustomerName());
        txtVServerName.setText(modelClass.getServerName());
        txtVPaymentAmt.setText(String.format("%.2f",modelClass.getPaymentAmount()));
        txtVTipPercent.setText(String.format("%.2f",modelClass.getTipPercentage()));
        txtVtiptotal.setText(String.format("%.2f",modelClass.getTipTotal()));
    }



    public void prevAct3(View v){
        finish();
    }
    public void exitAct3(View v){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    @Override
    public void finish(){
        Toast.makeText(getApplicationContext(),"Display TIP ALLOCATION", Toast.LENGTH_SHORT).show();
        super.finish();
    }
}
