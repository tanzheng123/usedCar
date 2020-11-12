package com.yajun.redis;

public class UserKey extends BasePrefix{

	public static final int TOKEN_EXPIRE = 3600*24 * 2;
	private UserKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}
	public static UserKey token = new UserKey(TOKEN_EXPIRE, "tk");

	public static UserKey openid = new UserKey(TOKEN_EXPIRE, "openid");

	public static UserKey getById = new UserKey(0, "id");
}
