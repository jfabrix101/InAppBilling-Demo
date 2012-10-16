package com.example.inappbilling_demo;

import java.util.ArrayList;
import java.util.List;

import jfabrix101.billing.AbstractBillingActivity;
import jfabrix101.billing.BillingCatalogEntry;
import jfabrix101.billing.BillingConsts.PurchaseState;
import android.widget.Toast;

public class MyBillingActivity extends AbstractBillingActivity {

	@Override
	public List<BillingCatalogEntry> getBillingCatalogEntry() {
		List<BillingCatalogEntry> billingList =  new ArrayList<BillingCatalogEntry>();
		
		// Create a billing item with an empty productId
		billingList.add(new BillingCatalogEntry(null, 
				"Introduction", "use a null (or empty) productId to show a description (to use as introduction)"));
		
		// Create a billing item with a simple description
		billingList.add(new BillingCatalogEntry(MyBillingConst.BILLING_ITEM1, 
				"Title for productID 1", "This is a simple descripion"));
		
		// Crate a billing item with a description taken from web
		billingList.add(new BillingCatalogEntry(MyBillingConst.BILLING_ITEM2, 
				"Title for productID 2", "http://www.google.com"));
		
		// create a billing item with a description taken form local resource
		// raw/file_raw.html  (the resourse must be end with .html)
		billingList.add(new BillingCatalogEntry(MyBillingConst.BILLING_ITEM3, 
				"Title for productID 3", "file_raw.html"));

		// Add test items (no in production of course)
		billingList.add(BillingCatalogEntry.ANDROID_TEST_PURCHASED);
		
		return billingList;
	}
	
	/**
	 * Callback method when the user press buy button.
	 */
	@Override
	public boolean onBuyButtonPressed(BillingCatalogEntry item) {
		Toast.makeText(this, "Thanks to have select " + item.getProductId(), 
				Toast.LENGTH_SHORT).show();
		return true;
	}
	
	/**
	 * Callback method when the purchase state of item is changed
	 */
	@Override
	public void onPurchaseStateChange(String productId,
			PurchaseState purchaseState) {
		Toast.makeText(this, "ProductId" + productId + " in state " + purchaseState, 
				Toast.LENGTH_SHORT).show();
	}
	       
}
