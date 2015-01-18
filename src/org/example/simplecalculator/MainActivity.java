package org.example.simplecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText operand1;
	EditText operand2;
	Button btnPlus;
	Button btnSubtract;
	Button btnDivide;
	Button btnMultiply;
	Button btnClear;
	TextView fldResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// link operands from UI to src
		operand1 = (EditText) findViewById(R.id.OperandOne);
		operand2 = (EditText) findViewById(R.id.OperandTwo);

		// link buttons from UI to src
		btnPlus = (Button) findViewById(R.id.btnPlus);
		btnSubtract = (Button) findViewById(R.id.btnSubtract);
		btnDivide = (Button) findViewById(R.id.btnDivide);
		btnMultiply = (Button) findViewById(R.id.btnMultiply);
		btnClear = (Button) findViewById(R.id.btnClear);

		// link result textview to src
		fldResult = (TextView) findViewById(R.id.fldResult);

		// create onClickListeners for buttons
		// using in line class since theres only 4 lines each
		btnPlus.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				boolean error = false;
				float op1 = 0;
				float op2 = 0;
				try {
					op1 = Float.parseFloat(operand1.getText().toString());
					op2 = Float.parseFloat(operand2.getText().toString());
				} catch (NumberFormatException ex) {
					error = true;
					fldResult.setText("Enter numbers only");
				}

				if (!error) {
					float answer = op1 + op2;

					fldResult.setText(Float.toString(answer));
				}
			}
		});

		// Create listener for subtraction button
		btnSubtract.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				boolean error = false;
				float op1 = 0;
				float op2 = 0;
				try {
					op1 = Float.parseFloat(operand1.getText().toString());
					op2 = Float.parseFloat(operand2.getText().toString());
				} catch (NumberFormatException ex) {
					error = true;
					fldResult.setText("Enter numbers only");
				}

				if (!error) {
					float answer = op1 - op2;

					fldResult.setText(Float.toString(answer));
				}
			}
		});

		// Create listener for division button
		btnDivide.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				boolean error = false;
				float op1 = 0;
				float op2 = 0;
				
				try {
					op1 = Float.parseFloat(operand1.getText().toString());
					op2 = Float.parseFloat(operand2.getText().toString());
				} catch (NumberFormatException ex) {
					error = true;
					fldResult.setText("Enter numbers only");
				}

				if (!error) {
					if (op2 != 0) {
						float answer = op1 / op2;

						fldResult.setText(Float.toString(answer));
					} else
						fldResult.setText("Cannot Divide by Zero");
				}
			}
		});

		// Create listener for multiplication button
		btnMultiply.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				boolean error = false;
				float op1 = 0;
				float op2 = 0;
				try {
					op1 = Float.parseFloat(operand1.getText().toString());
					op2 = Float.parseFloat(operand2.getText().toString());
				} catch (NumberFormatException ex) {
					error = true;
					fldResult.setText("Enter numbers only");
				}

				if (!error) {
					float answer = op1 * op2;

					fldResult.setText(Float.toString(answer));
				}
			}
		});

		// create listener for clear button
		btnClear.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				operand1.setText("");
				operand2.setText("");
				fldResult.setText("0.0");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
