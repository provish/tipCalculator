package mad.app.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;

public class Launcher extends Activity {

	private EditText eTBill;
	private TextView tVBillPerPrsn;
	private TextView tVTip;
	private TextView tVBill;
	private NumberPicker nPTip;
	private NumberPicker nPPerson;
	private Button bTgetTip;
	private int people,tipPerc;
	private double bill,tip,eTBillAmount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		initialize();
		eTBill.setText("0.0");
		tVBill.setText("0.0");
		tVBillPerPrsn.setText("0.0");
		tVTip.setText("0.0");
		nPPerson.setMaxValue(100);
		nPPerson.setMinValue(1);
		nPPerson.setWrapSelectorWheel(true);
		nPTip.setMaxValue(100);
		nPTip.setMinValue(15);
		nPTip.setWrapSelectorWheel(true);
		bTgetTip.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				calc();
			}
		});
		nPTip.setOnValueChangedListener(new OnValueChangeListener(){

			@Override
			public void onValueChange(NumberPicker arg0, int oldVal, int newVal) {
				// TODO Auto-generated method stub
				tipPerc=newVal;
				calc();

			}
			
		});
		nPPerson.setOnValueChangedListener(new OnValueChangeListener(){

			@Override
			public void onValueChange(NumberPicker arg0, int oldVal, int newVal) {
				// TODO Auto-generated method stub
				people=newVal;
				calc();

			}
		});

	}

	private void initialize() {
		// TODO Auto-generated method stub
		eTBill=(EditText)findViewById(R.id.eTBill);
		tVBillPerPrsn=(TextView)findViewById(R.id.TVBillPerPerson);
		tVTip=(TextView)findViewById(R.id.TVTip);
		tVBill=(TextView)findViewById(R.id.TVBill);
		nPTip=(NumberPicker)findViewById(R.id.nPTip);
		nPPerson=(NumberPicker)findViewById(R.id.nPPerson);
		bTgetTip=(Button)findViewById(R.id.button1);
		tipPerc=15;
		people=1;
		bill=0;
		tip=0;
	}
	
	private void calc() {
		// TODO Auto-generated method stub
		eTBillAmount=Double.parseDouble(eTBill.getText().toString());
		if(eTBillAmount!=0){
			tip=eTBillAmount*tipPerc/100;
			bill=eTBillAmount+tip;
			tVBill.setText(Double.toString(bill));
			tVTip.setText(Double.toString(tip));
			bill=bill/people;
			tVBillPerPrsn.setText(Double.toString(bill));	
		}
	}
	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}


