package com.facebook.automation.common.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;

public class StateHelper {
	private static HashMap<String, Object> StepState = new HashMap<String, Object>();

	/**
	 * Save key with Object Value
	 * 
	 * @param key
	 * 			String key
	 * 
	 * @param value
	 * 			String value
	 */
	public static void setStepState(String key, Object value) {
		StepState.put(key, value);
		try {
			FileWriter writer = new FileWriter("Facebook.txt", true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write("" + key + " : Value='" + value + "'" + "  @Input Time(" + new Date().toString() + ") ");
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get key value
	 * 
	 * @param key
	 * 			String key
	 * 
	 * @return key value
	 */
	public static Object getStepState(String key) {
		return StepState.get(key);
	}

	public static void clearStepState() throws IOException {
		StepState.clear();
		PrintWriter writer = new PrintWriter("Facebook.txt");
		writer.print("");
		writer.close();
	}

	public static boolean checkStepStateContainsKey(String keyState) {
		return StepState.containsKey(keyState);
	}

}
