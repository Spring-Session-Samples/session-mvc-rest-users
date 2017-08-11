

package com.rudra.aks.user;

public class Account {
	private String username;

	private String logoutUrl;

	private String switchAccountUrl;

	public Account(String username, String logoutUrl, String switchAccountUrl) {
		super();
		this.username = username;
		this.logoutUrl = logoutUrl;
		this.switchAccountUrl = switchAccountUrl;
	}

	public String getUsername() {
		return this.username;
	}

	public String getLogoutUrl() {
		return this.logoutUrl;
	}

	public String getSwitchAccountUrl() {
		return this.switchAccountUrl;
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", logoutUrl=" + logoutUrl + ", switchAccountUrl=" + switchAccountUrl
				+ "]";
	}
	
}
