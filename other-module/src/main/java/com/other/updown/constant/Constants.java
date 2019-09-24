package com.other.updown.constant;

/**
 * @author zhangbingquan
 * @desc 静态字符串类
 * @time 2019-09-24 23:25
 */
public class Constants {
    public static final String PLAT_VIDEO = "200";
    public static final String PLAT_UNCAR = "300";
    public static final String PLAT_WIFI = "299";
    public static final String PLAT_DOOR = "298";
    public static final String PLAT_EFENCE = "297";
    public static final String PLAT_IDCARD = "296";
    public static final String PLAT_VIDEO_STRUCTURE = "295";
    public static final String PLAT_FACE = "294";
    public static final String PLAT_CAR = "293";
    public static final String PLAT_FACE_ALARM = "292";
    public static final String PLAT_CAR_ALARM = "291";
    public static final String PLAT_FACE_NXN = "290";
    public static final String PLAT_BD_FTP_COLLECT = "221";
    public static final String PLAT_GPS = "301";
    public static final String DEVICE_CAMERA = "131";
    public static final String DEVICE_IPC = "132";
    public static final String DEVICE_DVR = "111";
    public static final String DEVICE_VIDEO_SERVER = "112";
    public static final String DEVICE_ENCODER = "113";
    public static final String DEVICE_NVR = "118";
    public static final String DEVICE_WIFI = "199";
    public static final String DEVICE_DOOR = "198";
    public static final String DEVICE_EFENCE = "197";
    public static final String DEVICE_IDCARD = "196";
    public static final int SPECIAL_PURPOSE_FACE = 1;
    public static final int SPECIAL_PURPOSE_CAR = 2;
    public static final String DEVICE_FACE_CAPTURE = "194";
    public static final int DEVICE_TYPE_FACE = 194;
    public static final String DEVICE_VEHICLE_CAPTURE = "193";
    public static final String VIDEO_VENDOR_TYPE = "1";
    public static final String CONSOLE_APP_NAME = "console";
    public static final String OSS_APP_NAME = "oss";
    public static final String DICT_KIND_PERSON_ADDRESS = "PERSON_ADDRESS";
    public static final String FACE_INDEX = "face_indice";
    public static final String FACE_TABLE = "FACE_INFO";
    public static String SYS_USERRESOURCE = "SYS_USERRESOURCE";
    public static final String SYS_USERALARM = "SYS_USERALARM";
    public static final int PCIDFS_PERMANENT_FLAG = 200705;
    public static final int PCIDFS_TEMPORARY_FLAG = 266241;
    public static final String PERSON_ARCHIVE_PIC_INDICE = "person_archive_pic_indice";
    public static final String PERSON_ARCHIVE_PIC_INFO = "PERSON_ARCHIVE_PIC_INFO";
    public static final String PERSON_SPECIAL_LIB_PIC_INDICE = "person_special_lib_pic_indice";
    public static final String PERSON_SPECIAL_LIB_PIC_INFO = "PERSON_SPECIAL_LIB_PIC_INFO";
    public static final String SUSPECT_PERSON_ARCHIVE_FACE_INDICE = "suspect_person_archive_face_indice";
    public static final String SUSPECT_PERSON_ARCHIVE_FACE_INFO = "SUSPECT_PERSON_ARCHIVE_FACE_INFO";
    public static final String PERSON_ARCHIVE_FACE_INDICE = "person_archive_face_indice";
    public static final String PERSON_ARCHIVE_FACE_INFO = "PERSON_ARCHIVE_FACE_INFO";
    public static final String PERSON_ARCHIVE_INDICE = "person_archive_indice";
    public static final String PERSON_ARCHIVE_INFO = "PERSON_ARCHIVE_INFO";
    public static String NOT_VEHICLE_DETECT_INDICE = "non_motor_vehicle_indice";
    public static String NOT_VEHICLE_DETECT_INFO = "NON_MOTOR_VEHICLE_INFO";
    public static final String PERSON_TOPIC_INDICE = "person_topic_indice";
    public static final String PERSON_TOPIC_INFO = "PERSON_TOPIC_INFO";
    public static final String PASSENGER_PUBLIC_INFORMATION = "passenger_public_information";
    public static final String PASSENGER_PUBLIC_INFORMATION_INFO = "PASSENGER_PUBLIC_INFORMATION_INFO";
    public static final String INTERNET_CAFE_PERSON = "internet_cafe_person";
    public static final String INTERNET_CAFE_PERSON_INFO = "INTERNET_CAFE_PERSON_INFO";
    public static String AUTOMATIC_CAR_INDICE = "car_detect_indice";
    public static String AUTOMATIC_CAR_TABLE = "CAR_DETECT_INFO";
    public static String DRIVER_FACE_INDICE = "driver_face_indice";
    public static String DRIVER_FACE_INFO = "DRIVER_FACE_INFO";
    public static final int RETURN_CODE_SUCCESS = 0;
    public static final int RETURN_CODE_ERROR = 1;
    public static final int COLLISISON_RESULT_SUCCESS = 0;
    public static final String DICT_KIND_ALGORITHM_TYPE = "FACE_ALGORITHM_TYPE";
    public static final String ARCHIVE_STATUS_ON = "1";
    public static final String ARCHIVE_STATUS_OFF = "2";
    public static final String ARCHIVE_STATUS_DELETE = "3";
    public static final String OPENGW = "opengw";
    public static final int CAMERA_FACE = 1;
    public static final int TASK_FACE_ALARM = 1;
    public static final int DEAL_STATUS_CONFIRM = 0;
    public static final int DEAL_STATUS_DELETE = 1;
    public static final int ALARM_STATUS_UNSEND = 0;
    public static final int ALARM_STATUS_SENT = 1;
    public static final int ALARM_STATUS_HANDLED = 3;
    public static final int ALARM_STATUS_ACCEPT = 2;
    public static final String BIGDATA_SEARCH_MPPDB = "1";
    public static final String BIGDATA_SEARCH_ES = "0";
    public static final String EXPORT_MAX_COUNT = "1000";
    public static final String TAG_TYPE_SYSTEM = "1";
    public static final String TAG_TYPE_CUSTOM = "2";
    public static final String HTTP_HEADER_AUTHORIZATION = "Authorization";
    public static final String HTTP_HEADER_WWW_AUTHENTICATE = "WWW-Authenticate";
    public static final String VIID_CONTENT_TYPE = "application/VIID+JSON";
    public static final String ENCODING_UTF_8 = "UTF-8";
    public static final String SYMBOL_DASH = "-";
    public static final String SYMBOL_ASTERISK = "*";
    public static final String SYMBOL_BACKSLASH = "\\";
    public static final String SYMBOL_COMMA = ",";
    public static final String SYMBOL_EQUALS = "=";
    public static final String SYMBOL_QUOTATION = "\"";
    public static final String SYMBOL_COLON = ":";
    public static final int KEEPALIVE_INTERVAL = 90;
    public static final String DIGEST_REDIS_KEY_PREFIX = "pciviid-client-register-";
    public static final int DIGEST_EXPIRE_TIME = 1800;
    public static final int REST_REQ_TIMEOUT = 3000;
    public static final String URL_PREFIX_HTTP = "http://";
    public static final String JSON_KEY_STATUSCODE = "StatusCode";
    public static final String SUCCESS_RESPONSE_CODE_PREFIX = "2";
    public static final String DEFALUT_ALGO_TYPE = "10003";
    public static final String DEFAULT_VIID_RESPONSE_OBJECT_LIST_KEY = "ListObject";
    public static final String DEFAULT_VIID_RESPONSE_OBJECT_KEY = "Object";

    public Constants() {
    }
}
