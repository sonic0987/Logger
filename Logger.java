public class Logger {
    private static final String FORMAT = "[%s]: %s";

    public static boolean isDebug = true;
    public static boolean isSaveErrorFile = true;
    public static boolean isShowPeriodLog = true;
    public static boolean isTest = true;        //Module ID 없이 링크설정 화면 진입 가능하도록 적용.(시험용)

    public static void d(String tag, String msg) {
        if (!isDebug) return;
        Log.d(tag, String.format(FORMAT, getCallerInfo(), msg));
    }

    public static void i(String tag, String msg) {
        if (!isDebug) return;
        Log.i(tag, String.format(FORMAT, getCallerInfo(), msg));
    }

    public static void e2(String tag, String msg) {
        if (!isDebug) return;
        Log.e(tag, String.format(FORMAT, getCallerInfo(), msg));
    }

    public static void p(String tag, String msg) {
        if (!isShowPeriodLog) return;
        Log.d(tag, String.format(FORMAT, getCallerInfo(), msg));
    }

/*    private static String getCallerInfo() {
        StackTraceElement[] elements = new Exception().getStackTrace();
        String className = elements[2].getClassName();
        return className.substring(className.lastIndexOf(".") + 1, className.length()) + "_" + elements[2].getLineNumber();
    }*/

    public static void e(String tag, String msg) {
        if (!isDebug) return;
        Log.e(tag, String.format(FORMAT, getCallerInfo(), msg));
    }

    private static String getCallerInfo2() {
        StackTraceElement[] elements = new Exception().getStackTrace();
        String className = elements[2].getClassName();
        return className.substring(className.lastIndexOf(".") + 1, className.length()) + "_" + elements[2].getLineNumber();
    }

    public static String getCallerInfo() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if(stackTraceElements.length > 5) {
            StackTraceElement element = stackTraceElements[4];
            if (element.getClassName().contains("Logger")) {
                element = stackTraceElements[5];
            }
            return "("+element.getFileName()+":"+element.getLineNumber()+")" + element.getMethodName();
        }else {
            return "";
        }
    }
}
