package checkauto.photo.com;
import java.util.Hashtable;

import android.text.TextUtils;
import android.util.Log;

/**
 * The class for print log
 * @author kesenhoo
 *
 */
public class LoggerUtils
{
	public static String customTagPrefix = "";
    //定义了一个开关
    public final static boolean                logFlag         = true;
    //开发人员的名字
    private static final String                 JMK           = "@jKazf@ ";
    private static final String                 KESEN           = "@kesen@ ";

    // 日志的等级
    private final static int                    logLevel        = Log.VERBOSE;
    
    // 开发人员的名字
    private static String                              mDeveloperName = JMK;

    /**
     * The Log Level:i
     * @param str
     */
    public static void i(Object str)
    {
        if(logFlag)
        {
            if(logLevel <= Log.INFO)
            {
                String[] name = generateTag(getCallerStackTraceElement());
                if(name != null)
                {
                    Log.i(name[0], name[1] + " - " + str);
                }
                else
                {
                    Log.i("TAG", str.toString());
                }
            }
        }

    }

    /**
     * The Log Level:d
     * @param str
     */
    public static void d(Object str)
    {
        if(logFlag)
        {
            if(logLevel <= Log.DEBUG)
            {
            	String[] name = generateTag(getCallerStackTraceElement());
                if(name != null)
                {
                    Log.d(name[0], name[1] + " - " + str);
                }
                else
                {
                    Log.d(name[0], str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:V
     * @param str
     */
    public static void v(Object str)
    {
        if(logFlag)
        {
            if(logLevel <= Log.VERBOSE)
            {
            	String[] name = generateTag(getCallerStackTraceElement());
                if(name != null)
                {
                    Log.v(name[0], name[1] + " - " + str);
                }
                else
                {
                    Log.v(name[0], str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:w
     * @param str
     */
    public static void w(Object str)
    {
        if(logFlag)
        {
            if(logLevel <= Log.WARN)
            {
            	String[] name = generateTag(getCallerStackTraceElement());
                if(name != null)
                {
                    Log.w(name[0], name[1] + " - " + str);
                }
                else
                {
                    Log.w(name[0], str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:e
     * @param str
     */
    public static  void e(Object str)
    {
        if(logFlag)
        {
            if(logLevel <= Log.ERROR)
            {
            	String[] name = generateTag(getCallerStackTraceElement());
                if(name != null)
                {
                    Log.e(name[0], name[1] + " - " + str);
                }
                else
                {
                    Log.e(name[0], str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:e
     * @param ex
     */
    public static void e(Exception ex)
    {
        if(logFlag)
        {
            if(logLevel <= Log.ERROR)
            {
                Log.e("exception", "error", ex);
            }
        }
    }

    /**
     * The Log Level:e
     * @param log
     * @param tr
     */
    public static  void e(String log, Throwable tr)
    {
        if(logFlag)
        {
        	String[] name = generateTag(getCallerStackTraceElement());
            Log.e(name[0], name[1] + log + "\n", tr);
        }
    }
    
    public static StackTraceElement getCallerStackTraceElement() {
        return Thread.currentThread().getStackTrace()[4];
    }
    
    private static String[] generateTag(StackTraceElement caller) {
    	
        String Content =  mDeveloperName + "[ " + Thread.currentThread().getName() + ": "
                + caller.getFileName() + ":" + caller.getLineNumber() + " "
                + caller.getMethodName() + " ]";
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        Content = TextUtils.isEmpty(customTagPrefix) ? Content : customTagPrefix + ":" + Content;
        String[] tags = new String[]{callerClazzName, Content};
        return tags;
    }
}
