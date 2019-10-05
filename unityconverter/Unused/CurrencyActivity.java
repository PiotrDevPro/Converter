package com.piotrdevelop.unityconverter.Unused;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.piotrdevelop.unityconverter.R;

import org.json.JSONObject;

public class CurrencyActivity extends AppCompatActivity {

    private AQuery aq;
    private EditText edCurrency;
    private Spinner spinner_from;
    private Spinner spinner_to;
    private TextView textView_from;
    private TextView textView_to;
    private Button btnConvert;
    String base_url = "http://rate-exchange.appspot.com/currency?";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    public void onCustomToggleClick(View view){
        Toast.makeText(this,"ClickClickClick",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currency);

        edCurrency = (EditText) findViewById(R.id.edCurrency);
        spinner_from = (Spinner) findViewById(R.id.spinner_from);
        spinner_to = (Spinner) findViewById(R.id.spinner_to);
        textView_from = (TextView) findViewById(R.id.textView_from);
        textView_to = (TextView) findViewById(R.id.textView_to);
        btnConvert = (Button) findViewById(R.id.btnConvert);

        aq = new AQuery(this);


//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currency_array, android.R.layout.simple_spinner_item);
/*        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_from.setAdapter(adapter);
        spinner_to.setAdapter(adapter);*/

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edCurrency.getText().toString().length() < 1) {

                    Toast.makeText(CurrencyActivity.this, "don't have a value", Toast.LENGTH_SHORT).show();
                } else {


                    final Double currency_from_value = Double.valueOf(edCurrency.getText().toString());
                    String from_currency = String.valueOf(spinner_from.getSelectedItem());
                    String to_currency = String.valueOf(spinner_to.getSelectedItem());

                    String url = base_url + "from" + from_currency + "to" + to_currency;


                    aq.ajax(url, JSONObject.class, new AjaxCallback<JSONObject>() {

                        @Override
                        public void callback(String url, JSONObject json, AjaxStatus status) {

                            if (json != null) {

                                //successful ajax call, show status code and json content
                                // Toast.makeText(aq.getContext(), status.getCode() + ":" + json.toString(), Toast.LENGTH_LONG).show();

                               /*try {

                                    Double rate = json.getDouble("rate");
                                    double the_result = currency_from_value + rate;
                                    textView_from.setText(edCurrency.getText().toString()+ " " + spinner_from.getSelectedItem().toString() + " = ");
                                    textView_to.setText(String.valueOf(the_result)+ " " + spinner_to.getSelectedItem().toString());*/

                                Toast.makeText(aq.getContext(),status.getCode() + ":" + json.toString(), Toast.LENGTH_SHORT).show();
                              /*  } catch (JSONException e){
                                    e.printStackTrace();
                                }
*/
                            } else {
                                //ajax error, show error code
                                Toast.makeText(aq.getContext(), "Error:" + status.getCode(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
