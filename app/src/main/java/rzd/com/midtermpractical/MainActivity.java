package rzd.com.midtermpractical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mEditTxtCustomerName, mEditTxtServerNaame, mEditTxtPaymentAmount;
    String customerName, serverName;
    Float paymentAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTxtCustomerName = findViewById(R.id.editTxtCustomerNameAct1);
        mEditTxtServerNaame = findViewById(R.id.editTxtServerNameAct1);
        mEditTxtPaymentAmount = findViewById(R.id.editTxtPaymentAmtAct1);

    }

    public void exit(View v){
        finish();
    }
    public void next(View v){

        if(mEditTxtCustomerName.length() == 0){
            mEditTxtCustomerName.setError("Don't leave it empty.");}
        else if(mEditTxtServerNaame.length() == 0){
            mEditTxtServerNaame.setError("Don't leave it empty.");}
        else if(mEditTxtPaymentAmount.length() == 0){
            mEditTxtPaymentAmount.setError("Don't leave it empty.");}

        else {
            customerName = mEditTxtCustomerName.getText().toString();
            serverName = mEditTxtServerNaame.getText().toString();
            paymentAmount = Float.parseFloat(mEditTxtPaymentAmount.getText().toString());
            ModelClass modelClass = new ModelClass(customerName, serverName, paymentAmount);
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            intent.putExtra("sendingAct1Data", modelClass);
            Toast.makeText(getApplicationContext(),"Display TIP ALLOCATION",Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
    }
    @Override
    public void finish(){
        Toast.makeText(getApplicationContext(),"Exiting Application", Toast.LENGTH_SHORT).show();
        super.finish();
    }
}
