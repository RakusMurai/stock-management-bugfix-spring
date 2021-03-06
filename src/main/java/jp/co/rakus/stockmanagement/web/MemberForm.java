package jp.co.rakus.stockmanagement.web;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * メンバー関連のリクエストパラメータが入るフォーム.
 * 
 * @author igamasayuki
 *
 */
public class MemberForm {
	/** 名前 */
	@NotBlank(message = "値を入力してください")
	private String name;
	/** メールアドレス */
	@NotBlank(message = "値を入力してください")
	@Email(message = "Eメールの形で入力してください")
	private String mailAddress;
	/** パスワード */
	@NotBlank(message = "値を入力してください")
	private String password;
	/** 確認用パスワード */
	@NotBlank(message = "値を入力してください")
	private String passwordCheck;

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
