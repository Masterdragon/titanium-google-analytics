/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package analytics.google;

import com.google.analytics.tracking.android.Transaction;
import com.google.analytics.tracking.android.Transaction.Item;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiC;
import org.appcelerator.titanium.util.Log;
import org.appcelerator.titanium.util.TiConfig;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.view.TiCompositeLayout;
import org.appcelerator.titanium.view.TiCompositeLayout.LayoutArrangement;

import java.util.HashMap;

// This proxy can be created by calling GoogleAnalytics.createExample({message: "hello world"})
@Kroll.proxy(creatableInModule=GoogleAnalyticsModule.class)
public class TransactionProxy extends KrollProxy
{
	// Standard Debugging variables
	private static final String LCAT = "TransactionProxy";
	private static final boolean DBG = TiConfig.LOGD;

	public Transaction transaction;

	// Constructor
	public TransactionProxy(String id, float orderTotal, float tax, float shippingCost, String affiliation)
	{
		super();

		transaction = new Transaction.Builder(id, toMicros(orderTotal))
			.setTotalTaxInMicros(toMicros(tax))
			.setShippingCostInMicros(toMicros(shippingCost))
			.setAffiliation(affiliation)
			.build();
	}

	@Kroll.method
	public void addItem(HashMap props)
	{
		KrollDict propsDict = new KrollDict(props);
		String sku = TiConvert.toString(propsDict, "sku");
		String category = TiConvert.toString(propsDict, "category");
		String name = TiConvert.toString(propsDict, "name");
		float price = TiConvert.toFloat(propsDict, "price");
		int quantity = TiConvert.toInt(propsDict, "quantity");

		transaction.addItem(new Item.Builder(sku, name, toMicros(price), (long) quantity)
			.setProductCategory(category)
			.build());
	}

	private long toMicros(float value)
	{
		return (long) (value * 1000000);
	}
}