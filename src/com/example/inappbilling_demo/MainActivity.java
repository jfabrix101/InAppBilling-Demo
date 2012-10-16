package com.example.inappbilling_demo;

import jfabrix101.billing.BillingConsts;
import jfabrix101.billing.BillingHelper;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView item1, item2, item3, itemTest;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        item1 = (TextView) findViewById(R.id.main_item1);
        item2 = (TextView) findViewById(R.id.main_item2);
        item3 = (TextView) findViewById(R.id.main_item3);
        itemTest = (TextView) findViewById(R.id.main_item_test);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	if (item.getItemId() == R.id.menu_billing) {
    		Intent intent = new Intent(this, MyBillingActivity.class);
    		startActivity(intent);
    	}
    	return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	
    	updateStatus(item1, MyBillingConst.BILLING_ITEM1);
    	updateStatus(item2, MyBillingConst.BILLING_ITEM2);
    	updateStatus(item3, MyBillingConst.BILLING_ITEM3);
    	updateStatus(itemTest, BillingConsts.BILLING_ITEM_AndroidTestPurchased);
    }
    
    private void updateStatus(TextView item, String productId) {
    	boolean isPurchased = BillingHelper.isPurchased(this, productId);
    	String msg = getString((isPurchased ? R.string.item_purchased : R.string.item_not_purchased));
    	item.setText(String.format(msg, productId));
    	if (isPurchased) item.setTextColor(Color.GREEN);
    	else item.setTextColor(Color.RED);
    }
}
