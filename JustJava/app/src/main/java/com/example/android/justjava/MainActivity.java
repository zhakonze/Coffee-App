/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    long  quantity = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view){
        if (quantity + 1 <= 50) {
            quantity = quantity + 1;
            displayQuantity(quantity);
        }
        else{
            Context context = getApplicationContext();
            CharSequence text = "Can't order more than 100 cup";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view){
        if (quantity - 1 > 0) {
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
        else{
            Context context = getApplicationContext();
            CharSequence text = "Can't order less than 1 cup";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText text = (EditText)findViewById(R.id._name_me);
        String _name = text.getText().toString();
        long price = calculatePrice();
        String msg;
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.Whip_checker);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.choclate_checker);
        boolean _chocolate = chocolateCheckBox.isChecked();
        boolean _hasWhipCream = whippedCreamCheckBox.isChecked();
        if (price > 0)
            msg = createOrderSummary(price, _hasWhipCream, _chocolate, _name);
        else
            msg = createErrorMsg();
        displayMessage(msg);


    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(long number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }


    private long calculatePrice() {
        return (quantity * 5);
    }

    private String createErrorMsg() {
        String _name = "Zakhele Hakonze";
        String priceMessage = "Name: " + _name;
        priceMessage = priceMessage + "\n" + "Please enter a valid quantity value";
        priceMessage = priceMessage + "\n" + "to proceed with your order";
        priceMessage = priceMessage + "\n" + "Thank you!";
        String summary = priceMessage;
        return summary;
    }

    private String createOrderSummary(long num, boolean _addWhipCream, boolean _addChocolate, String _name) {

        String priceMessage = "Name: " + _name;
        if (_addWhipCream == true)
        {
            priceMessage = priceMessage + "\n" + "Add Whipped Cream: $2/cup";
            num = (quantity * 2) + num;
        }
        if (_addChocolate == true)
        {
            priceMessage = priceMessage + "\n" + "Add Chocolate: $4/cup";
            num = (quantity * 4) + num;;
        }
        priceMessage = priceMessage + "\n" + "Quantity: " + quantity;
        priceMessage = priceMessage + "\n" + "Total : $" + num;
        priceMessage = priceMessage + "\n" + "Thank you!";
        String summary = priceMessage;
        return summary;
    }

}