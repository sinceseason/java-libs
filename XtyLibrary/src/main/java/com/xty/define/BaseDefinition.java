package com.xty.define;

/**
 * Created by eugene on 16/3/21.
 */
public class BaseDefinition {
    /**
     * OS
     */
    public static final String LINUX = "LINUX";
    public static final String WINDWOS = "WINDOWS";

    /**
     * result
     */
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";

    /**
     * Status
     */
    public static Integer TODO = 0;
    public static Integer DOING = 1;
    public static Integer DONE = 2;

    public static String WAITING = "WAITING";
    public static String PASSING = "PASSING";

    /**
     * ErrorCode
     */
    /*unknow*/
    public static final int UNKNOW = 0xff;
    /*非法sql注入*/
    public static final int SQL_INJECT = 0x00;
    /*未找到记录集*/
    public static final int HAVE_NOT_LOGINED_USER = 0x01;
    /*参数不够*/
    public static final int HAVE_NOT_ENOUGH_PARAMETERS = 0x02;
    /*未找到记录集*/
    public static final int RECORD_WAS_NOT_FOUND = 0x03;
    /*未找到文件*/
    public static final int NOT_FILE = 0x04;
    /*存在相同记录集*/
    public static final int SAME_RECORD = 0x05;
    /*参数异常*/
    public static final int WRONG_PARAMETERS = 0x06;
    /*关闭状态*/
    public static final int STATUS_CLOSED = 0x07;
    /*超出文件大小限制*/
    public static final int OUT_OF_SIZE = 0x08;
    /*权限不足*/
    public static final int NO_AUTH = 0x09;
    /*不是图片文件*/
    public static final int IS_NOT_IMAGE_FILE = 0x0A;

    /**
     * log
     */
    public static final String LOG_SYSTEM_MODULE = "module.system";
    public static final String LOG_USER_MODULE = "module.user";
    public static final String LOG_ROLE_MODULE = "module.role";
    public static final String LOG_PERSON_MODULE = "module.person";
    public static final String LOG_WARNING_MODULE = "module.warning";
    public static final String LOG_SYSTEM_SETTING_MODULE = "module.system_setting";
    public static final String LOG_LOGIN_TYPE = "log.login";
    public static final String LOG_LOGOUT_TYPE = "log.logout";
    public static final String LOG_CREATE_TYPE = "log.create";
    public static final String LOG_MODIFY_TYPE = "log.modify";
    public static final String LOG_REMOVE_TYPE = "log.remove";
    public static final String LOG_CHANGE_PASSWORD_TYPE = "log.change_password";
    public static final String LOG_DELETE_FILE_TYPE = "log.delete_file";

    /**
     * topic message type
     */
    public static final String TOPIC_MSG_TYPE_REFRESH_INTERVAL_PARA = "REFRESH_INTERVAL_PARA";

    /**
     * topic name
     */
    public static final String TOPIC_REFRESH = "TOPIC_REFRESH";

    /**
     * logo file upload path
     */
    public static final String LOGO_FILE_UPLOAD_PATH = "upload/logo";

    /**
     * logo file upload path
     */
    public static final String RESOURCE_FILE_UPLOAD_PATH = "upload/resource";
}