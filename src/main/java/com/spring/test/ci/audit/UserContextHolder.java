package com.spring.test.ci.audit;


import com.spring.test.ci.vo.UserInfo;

/**
 * @author Kelvin Mai
 * @date 4/16/2019
 */
public class UserContextHolder {
    private static ThreadLocal<UserInfo> tl = new ThreadLocal<>();

    public static void setUserContext(UserInfo userContext) {
        tl.set(userContext);
    }

    static {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("Kelvin" + (int)(Math.random() * 100));
        setUserContext(userInfo);
    }

    public static UserInfo getUserInfo() {
        return tl.get();
    }
}
