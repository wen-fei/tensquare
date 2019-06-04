package entity;

/**
 * @author : TenYun
 * @date : 2019-06-04 14:45
 * @description : status code
 **/
public class StatusCode {
    // success
    public static final int OK = 20000;

    // fail
    public static final int ERROR = 20001;

    // username or password error
    public static final int LOGINERROR = 20002;

    // no access
    public static final int ACCESSERROR = 20003;

    // remote fail
    public static final int REMOTEERROR = 20004;

    // duplicate action
    public static final int REPERROR = 20005;

}
