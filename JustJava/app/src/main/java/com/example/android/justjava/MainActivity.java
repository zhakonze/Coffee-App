/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
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
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view){
        if (quantity - 1 > 0) {
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        long price = calculatePrice();
        String msg;
        createOrderSummary(price);
        if (price > 0)
            msg = createOrderSummary(price);
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


    /**
     * This method displays the given price on the screen.
     */
//    private void displayPrice(int number) {
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(NumberFormat.getCurrencyInstance(Locale.US).format(number));
//    }

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

    private String createOrderSummary(long num) {
        String _name = "Zakhele Hakonze";
        String priceMessage = "Name: " + _name;
        priceMessage = priceMessage + "\n" + "Quantity: " + quantity;
        priceMessage = priceMessage + "\n" + "Total : $" + num;
        priceMessage = priceMessage + "\n" + "Thank you!";
        String summary = priceMessage;
        return summary;
    }

}