package com.github.phoenix.utils;

/**
 * 常量的统一管理
 *
 * @author Phoenix
 * @date 2016-10-13 14:15
 */
public class Constant {
/********************************************************************************************
 * 								SharedPreferences start
 ********************************************************************************************/
	public static final String SP_NAME = "shift";
	public static final String SP_IS_FIRST_LOGIN = "isFirstLogin";
	/**apk 文件存储路径*/
	public static final String SP_DOWNLOAD_PATH = "download.path";


/********************************************************************************************
 * 								SharedPreferences end
 ********************************************************************************************/






/********************************************************************************************
 * 								Format of time   start
 ********************************************************************************************/
	/** 格式：yyyy:MM:dd:HH:mm:ss */
	public static final String TIME_FORMAT_01 = "yyyy:MM:dd:HH:mm:ss";
	/** 格式：yyyy-MM-dd HH:mm:ss */
	public static final String TIME_FORMAT_02 = "yyyy-MM-dd HH:mm:ss";
	/** 格式：yyyy年MM月dd日HH时mm分ss秒 */
	public static final String TIME_FORMAT_03 = "yyyy年MM月dd日HH时mm分ss秒";


/********************************************************************************************
 * 								Format of time end
 ********************************************************************************************/






/********************************************************************************************
 * 								db start
 ********************************************************************************************/
	/**
	 * 单种消息 数据库名
	 */
	public static final String DB_NAME_MSG = "shift.db";

	/**
	 * 单种消息 数据库表名（四种消息，四个表）
	 */
	public static final String DB_TABLE_NAME_MSG_SYSTEM = "system_msg";

	/**
	 * （四种消息，四个表）创建表的语句
	 */
	public static final String CREATE_TBL_MSG_SYSTEM = "create table if not exists "
			+ DB_TABLE_NAME_MSG_SYSTEM
			+"(_id integer primary key autoincrement, title text, time text, invalid text, uri text, content text, msgtype text, unread text) ";


/********************************************************************************************
 * 								db end
 ********************************************************************************************/





/********************************************************************************************
 * 								other start
 ********************************************************************************************/




/********************************************************************************************
 * 								other end
 ********************************************************************************************/
	


}
