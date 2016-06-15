package name.valery1707.java.kazakh;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.*;

public class CheckKazakhLocale {

	public static final Locale KAZAKH = new Locale("kk");
	public static final Locale KAZAKH_KZ = new Locale("kk", "KZ");
	public static final List<Locale> LOCALES = Arrays.asList(KAZAKH, KAZAKH_KZ);

	public static final String OK = "[OK]";
	public static final String FAIL = "[FAIL]";

	public static void main(String[] args) {
		if (!checkJavaVersion()) {
			print("BAD JAVA VERSION: KAZAKH LOCALE NEEDS JAVA 6 OR HIGHER");
			System.exit(1);
		}

		Locale[] availableLocales = Locale.getAvailableLocales();
		print("Available locales are: " + Arrays.asList(availableLocales));

		Map<Locale, Boolean> status = new HashMap<Locale, Boolean>(LOCALES.size());
		boolean totalStatus = true;
		for (Locale locale : LOCALES) {
			boolean check = checkLocale(availableLocales, locale);
			status.put(locale, check);
			totalStatus &= check;
		}

		print("");
		print("Checking complete!");
		for (Locale locale : LOCALES) {
			print("Status locale " + locale, status.get(locale));
		}
		print("TOTAL STATUS", totalStatus);
	}

	private static String showStatus(boolean status) {
		return status ? OK : FAIL;
	}

	private static void print(String msg) {
		System.out.println(msg);
	}

	private static void print(String msg, boolean status) {
		int space = 75 - msg.length();
		print(String.format("%s %" + space + "s", msg, showStatus(status)));
	}

	private static boolean checkJavaVersion() {
		String javaVersion = System.getProperty("java.version");

		boolean vmVersionOK = true;
		try {
			Class.forName("java.util.spi.LocaleServiceProvider");
		} catch (Exception e) {
			vmVersionOK = false;
		}
		print("Checking Java version: [" + javaVersion + "]", vmVersionOK);
		return vmVersionOK;
	}

	private static boolean checkLocale(Locale[] availableLocales, Locale checkLocale) {
		print("");
		print("Checking locale: " + checkLocale);
		boolean isOk;

		boolean available = checkLocaleAvailable(availableLocales, checkLocale);
		print("Is locale available in JVM: " + available, available);
		isOk = available;

		isOk &= checkDateFormat(checkLocale);
		isOk &= checkNumberFormat(checkLocale);
		//todo Checking collation
		//todo Checking locale naming
		//todo Checking Time Zone naming

		return isOk;
	}

	private static boolean checkLocaleAvailable(Locale[] availableLocales, Locale checkLocale) {
		boolean available = false;
		for (int i = 0; !available && i < availableLocales.length; i++) {
			Locale locale = availableLocales[i];
			if (checkLocale.getCountry() == null || checkLocale.getCountry().equals("")) {
				if ((locale.getCountry() == null || locale.getCountry().equals("")) && checkLocale.getLanguage().equals(locale.getLanguage())) {
					available = true;
				}
			} else {
				if (checkLocale.getCountry().equals(locale.getCountry()) && checkLocale.getLanguage().equals(locale.getLanguage())) {
					available = true;
				}
			}
		}
		return available;
	}

	private static boolean checkEquals(String message, String expected, String actual) {
		boolean equals = expected.equals(actual);
		print("  " + message + ": [" + actual + "]", equals);
		return equals;
	}

	private static boolean checkDateFormat(Locale checkLocale) {
		print("Checking date formatting...");
		DateFormat dateFormatFull = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, checkLocale);
		DateFormat dateFormatLong = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, checkLocale);
		DateFormat dateFormatMed = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, checkLocale);
		DateFormat dateFormatShort = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, checkLocale);
		Calendar date = makeTestDateCalendar();
		String TZ = TimeZone.getDefault().getDisplayName(false, TimeZone.SHORT, checkLocale);
		return checkEquals("Checking full date format", "Жұма 31 Желтоқсан 2009 жыл 23:59:59 " + TZ, dateFormatFull.format(date.getTime())) &
			   checkEquals("Checking long date format", "31 Желтоқсан 2009 жыл 23:59:59 " + TZ, dateFormatLong.format(date.getTime())) &
			   checkEquals("Checking medium date format", "31 Желтоқсан 2009 ж. 23:59:59", dateFormatMed.format(date.getTime())) &
			   checkEquals("Checking short date format", "31.12.09 23:59", dateFormatShort.format(date.getTime()));
	}

	private static Calendar makeTestDateCalendar() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 31);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.YEAR, 2009);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal;
	}

	private static boolean checkNumberFormat(Locale checkLocale) {
		print("Checking number formatting...");
		NumberFormat numberFormat = NumberFormat.getInstance(checkLocale);
		numberFormat.setMaximumFractionDigits(3);
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(checkLocale);
		double value = 23124213.4563;
		return checkEquals("Checking decimal number format", "23 124 213,456", numberFormat.format(value)) &
			   checkEquals("Checking currency format", "23 124 213,46 ₸", currencyFormat.format(value));
	}
}
