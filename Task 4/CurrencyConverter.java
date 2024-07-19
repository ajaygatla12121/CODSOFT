package task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Currency Converter");
		System.out.print("Enter base currency (e.g., USD): ");
		String baseCurrency = scanner.nextLine().toUpperCase();

		System.out.print("Enter target currency (e.g., EUR): ");
		String targetCurrency = scanner.nextLine().toUpperCase();

		double exchangeRate = fetchExchangeRate(baseCurrency, targetCurrency);
		if (exchangeRate == -1) {
			System.out.println("Failed to fetch exchange rates. Please try again later.");
		}

		System.out.print("Enter amount to convert: ");
		double amount = scanner.nextDouble();

		double convertedAmount = amount * exchangeRate;

		System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);

		scanner.close();
	}

	private static double fetchExchangeRate(String baseCurrency, String targetCurrency) {

		String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;

		try {
			URL url = new URL(apiUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			StringBuilder response = new StringBuilder();

			while ((line = reader.readLine()) != null) {
				response.append(line);
			}

			reader.close();

			return 1.2;
			
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
	}
}

