package labcodeinspection;

import java.util.Locale;

/**
 * @author Lessette Zambrano
 *
 */
public class Email {

	private final transient String mFirstName; 
	private final transient String mLastName;
	private transient String password;
	private transient String department;
	private  final transient int defPassLen = 8;
	private transient String email;

	/**
	 * @param firstName
	 * @param lastName
	 */
	public Email(final String firstName, final String lastName) {
		this.mFirstName = firstName;
		this.mLastName = lastName;
	}

	/**
	 * 
	 */
	public void showInfo() {
		System.out.println("\nFIRST NAME= " + mFirstName + "\nLAST NAME= " + mLastName);
		System.out.println("DEPARMENT= " + department + "\nEMAIL= " + email + "\nPASSWORD= " + password);
	}

	/**
	 * @param depChoice
	 */
	public void setDeparment(final int depChoice) {
		switch (depChoice) {
		case 1:
			this.department = "sales";
			break;
		case 2:
			this.department = "dev";
			break;
		case 3:
			this.department = "acct";
			break;
		default:
			break;
		}
	}

	/**
	 * @param length
	 * @return
	 */
	private String randomPassword(final int length) {
		final String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			final int rand = (int) (Math.random() * set.length());
			password[i] = set.charAt(rand);
		}
		return new String(password);
	}

	/**
	 * 
	 */
	public void generateEmail() {
		this.password = this.randomPassword(this.defPassLen);
		this.email = this.mFirstName.toLowerCase(Locale.getDefault()) + this.mLastName.toLowerCase(Locale.getDefault()) + "@" + this.department
				+ ".espol.edu.ec";
	}
}
