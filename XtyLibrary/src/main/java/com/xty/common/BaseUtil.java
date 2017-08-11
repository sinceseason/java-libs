package com.xty.common;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by eugene on 16/3/21.
 */
public class BaseUtil {
    protected static JsonOpera jo = new JsonOpera();
    public static boolean IsBase64Code(String str){
        try{
            return Base64.isBase64(str);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * base64编码
     *
     * @param str 明文 String
     * @return String
     */
    public static String Base64Encode(String str) {
        try {
            return Base64.encodeBase64String(str.getBytes("UTF-8"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * base64解码
     *
     * @param encode base64编码 String
     * @return String
     */
    public static String Base64Decode(String encode) {
        try {
            encode = ReplaceBase64Code(encode);
            return new String(Base64.decodeBase64(encode), "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 判断对象是否为空
     *
     * @param value Object
     * @return boolean
     */
    public static boolean IsNullOrEmpty(Object value) {
        if (value == null || String.valueOf(value).trim().length() < 1) {
            return true;
        }
        return false;
    }

    /**
     * 日期格式化
     *
     * @param time Date
     * @return Sting
     */
    public static String DateFormatYMDHMS(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(time).toString();
    }

    /**
     * 日期格式化
     *
     * @param time Date
     * @return Sting
     */
    public static String DateFormatYMDHMS1(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(time).toString();
    }

    /**
     * 字符串转换日期
     *
     * @param time String
     * @return Date
     */
    public static Date StringToTime(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            return sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    public static Date StringToDate(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }


    /**
     * 字符串转换日期
     *
     * @param date                   String
     * @param simpleDateFormatString String
     * @return Date
     */
    public static Date StringToDate(String date, String simpleDateFormatString) {
        SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormatString);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    /**
     * 日期格式化
     *
     * @param time Date
     * @return String
     */
    public static String DateFormatYMD(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(time).toString();
    }

    /**
     * 格式化GMT时间
     *
     * @param time Date
     * @return Date
     */
    public static Date ConvertTimeToDate(long time) {
        Date date = new Date(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
        return calendar2.getTime();
    }

    public static Date ConvertStringToDate(String format, String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        ParsePosition pos = new ParsePosition(0);
        Date d = sdf.parse(date, pos);
        return d;
    }

    public static Calendar GetGMTCalendar() {
        Calendar cal = Calendar.getInstance(new SimpleTimeZone(0, "GMT"));
        return cal;
    }

    public static Date GetGMTDate(Date date) {
        Calendar cal = Calendar.getInstance(new SimpleTimeZone(0, "GMT"));
        cal.setTime(date);
        return cal.getTime();
    }

    /**
     * 获取配置文件信息
     *
     * @param filePath String
     * @return Properties
     */
    public static Properties LoadPropertiesFile(String filePath) {
        try {
            Properties pps = new Properties();
            pps.load(new FileInputStream(filePath));
            return pps;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 格式化base64编码
     * post会将字符串中的"+"替换成" ",导致乱码
     *
     * @param code String
     * @return String
     */
    public static String ReplaceBase64Code(String code) {
        if (code.indexOf(" ") >= 0) {
            code = code.replaceAll(" ", "+");
        }
        return code;
    }

    /**
     * Parse Object to Integer
     *
     * @param obj Object
     * @return Integer
     */
    public static Integer ObjectToInteger(Object obj) {
        Integer i = null;
        if (obj instanceof Double) {
            i = ((Double) obj).intValue();
        } else if (obj instanceof Long) {
            i = ((Long) obj).intValue();
        } else if (obj instanceof String) {
            i = Integer.parseInt(obj.toString());
        } else if (obj instanceof Integer) {
            i = (Integer) obj;
        }else if (obj instanceof BigInteger) {
            i = ((BigInteger)obj).intValue();
        }else if (obj instanceof BigDecimal) {
            i = ((BigDecimal)obj).intValue();
        }
        return i;
    }

    /**
     * Parse Object to Long
     *
     * @param obj Object
     * @return Long
     */
    public static Long ObjectToLong(Object obj) {
        Long l = null;
        if (obj instanceof Double) {
            l = ((Double) obj).longValue();
        } else if (obj instanceof Long) {
            l = (Long) obj;
        } else if (obj instanceof Integer) {
            l = ((Integer) obj).longValue();
        } else {
            l = Long.parseLong(obj.toString());
        }
        return l;
    }

    public static String ReadFile(String filePath) {
        try {
            File file = new File(filePath);
            BufferedReader reader = null;
            String laststr = "";
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            //一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                laststr = laststr + tempString;
            }
            reader.close();
            return laststr;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static boolean CheckImageFileType(String suffix){
        try {
            suffix = suffix.toUpperCase();
            if (suffix.equals(".JPG") || suffix.equals(".JPEG") || suffix.equals(".PNG") || suffix.equals(".BMP"))
                return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public static String get16sid() {
        String sid = UUID.randomUUID().toString().replace("-", "");
        return sid;
    }

    public static String get32sid() {
        String sid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return sid;
    }

    public static String calMd5(File f){
        try {
            return DigestUtils.md5Hex(new FileInputStream(f));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static String calMd5(InputStream fileInputStream){
        try {
            return DigestUtils.md5Hex(fileInputStream);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static int generate_random_int(int min, int max) {
        Random random = new Random();
        int output = random.nextInt(max) % (max - min + 1) + min;
        return output;
    }
}
