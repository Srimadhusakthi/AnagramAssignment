package com.example.anagramassignment;

import java.util.Arrays;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	public EditText mStringFirst, mStringSecond;
	public String stringfirst, stringSecond;
	public static TextView mViewResult;
	public static Context context;
	public Button mGetResult;
	boolean stats = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initialize();
		clickEvent();
	}

	public void initialize() {
		mStringFirst = (EditText) findViewById(R.id.stringvalue_one);
		mStringSecond = (EditText) findViewById(R.id.stringvalue_two);
		mViewResult = (TextView) findViewById(R.id.result_view);
		mGetResult = (Button) findViewById(R.id.get_result);
		mViewResult.setTextColor(Color.GREEN);
	}

	public void clickEvent() {

		mGetResult.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (mStringFirst.getText().toString().trim().length() == 0) {
					mStringFirst.setError("Please enter First String");
				} else if (mStringSecond.getText().toString().trim().length() == 0) {
					mStringSecond.setError("Please enter Second String");
				}
				String firstString = mStringFirst.getText().toString();
				String secondString = mStringSecond.getText().toString();
				checkForAnagram(firstString, secondString);

			}
		});
	}

	private static boolean checkForAnagram(String firstString,
			String secondString) {

		Log.d("STR", "" + firstString + secondString);
		boolean result;

		if (firstString == null || secondString == null) {
			result = false;
		} else {
			String sortedFirstString = sortIgnoreCase(firstString).trim();
			String sortedSecondString = sortIgnoreCase(secondString).trim();

			System.out.println("Sorted First String: " + sortedFirstString);
			System.out.println("Sorted Second String: " + sortedSecondString);

			result = sortedFirstString.equalsIgnoreCase(sortedSecondString);
		}

		mViewResult.setText("ANAGRAM RESULT :" + result);
		return result;

	}

	private static String sortIgnoreCase(String string) {
		if (string == null) {
			return null;
		}

		char[] characters = string.toUpperCase().toCharArray();
		Arrays.sort(characters);
		return new String(characters);

	}

}