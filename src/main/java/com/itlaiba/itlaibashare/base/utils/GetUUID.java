package com.itlaiba.itlaibashare.base.utils;

import java.util.UUID;

public class GetUUID {
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
