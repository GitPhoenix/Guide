package com.github.phoenix.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Activity跳转工具类
 *
 * @author Phoenix
 * @date 2016-10-13 13:48
 */
public class StartActivityUtil {

	private StartActivityUtil(){}
	
	/**
	 * 从一个activity 跳转到另一个activity，此时目标activity将会存在于启动他的activity所在的栈中
	 * @param activity activity的上下文信息
	 * @param cls 目标activity.class
	 */
	public static void startActivity(Activity activity, Class<?> cls){
		Intent intent = new Intent(activity, cls);
		activity.startActivity(intent);
	}
	
	/**
	 * 当上下文信息是应用全局Context时启动activity， 此时目标activity将会在一个新的任务栈中, 内部设置了Flag:Intent.FLAG_ACTIVITY_NEW_TASK
	 * @param context 全局上下文
	 * @param cls
	 */
	public static void startNewActivity(Context context, Class<?> cls){
		Intent intent = new Intent(context, cls);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}

	/**
	 * 挈带参数启动Activity
	 * @param context 上下文
	 * @param cls 目标class文件
	 * @param bundle 内容bundle
	 */
	public static void startActivity(Context context, Class<?> cls, Bundle bundle){
		Intent intent = new Intent();
		intent.setClass(context, cls);
		intent.putExtras(bundle);
		context.startActivity(intent);
	}
	
}
