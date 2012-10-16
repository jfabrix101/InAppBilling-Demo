
package com.example.inappbilling_demo;

import jfabrix101.billing.BillingHelper;
import jfabrix101.billing.BillingSecurity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Application extends android.app.Application {

	@Override
	public void onCreate() {
		
		// Test if the first time launch in order to restore billing transactions
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
		boolean isBillingIntialized = preferences.getBoolean("billingInitialized", false);
		if (!isBillingIntialized) {
			// The first time restore transactions
	        BillingHelper.restoreTransactions(this);
	        
//			BillingSecurity.registerPublicKey(this, "<put your public key here>");
			BillingSecurity.registerPublicKey(this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoJKf/ofi7i2G1yavy1HzFjus2RE+b2nhzn29VnWukQJFWTdJG94tlCShBZ0Io5DUAFCDE6IqJgFpFIJ03XflnhTDvo51pcNosSuMrPtm+fPf992BMLrN6wJkvaAeoEASnFxo1VK0RaeHCKoDc95X+59R1yJe5mIqRiFIh7O3UP75ztMhsKWQ4fSLqEVbso4YV/uTf4clYTZVeGjfRwtjwQMjmHGelsp9gO0IdgYLSY4y69S8Mus5qMrRfoQD+a5/UkG+3taN50E1Gqaxk5Nkv6hXb+MWhTQ1eBlNCapBOpYgvjBShhgL231FO5nlbthhgB4SVGNZadhpYjWC7eWpZQIDAQAB");
	        
			preferences.edit().putBoolean("billingInitialized", true).commit();
		}
		
		super.onCreate();
	}
}
