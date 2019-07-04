//package link.liwei.app.blog.basic.realm;
//
//import link.liwei.app.blog.basic.dao.RoleDao;
//import link.liwei.app.blog.basic.dao.UserDao;
//import link.liwei.app.blog.basic.dao.UserRoleDao;
//import link.liwei.app.blog.basic.entity.JwtToken;
//import link.liwei.app.blog.basic.entity.po.Role;
//import link.liwei.app.blog.basic.entity.po.User;
//import link.liwei.app.blog.basic.exce.AuthException;
//import link.liwei.app.blog.basic.utils.JwtUtil;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.List;
//
//@Service
//public class ShiroRealm extends AuthorizingRealm {
//
//    @Autowired
//    private RoleDao roleDao;
//    @Autowired
//    private UserDao userDao;
//    @Autowired
//    private UserRoleDao userRoleDao;
//
//    /**
//     * 必须重写此方法，不然shiro会报错
//     *
//     * @param token
//     * @return
//     */
//    @Override
//    public boolean supports(AuthenticationToken token) {
//        return token instanceof JwtToken;
//    }
//
//    /**
//     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//
//        String phone = JwtUtil.getUsername(principalCollection.toString());
//        //此username存的是用户登录的手机号码
//        HashMap hashMap = new HashMap();
//        hashMap.put("phone", phone);
//        List<User> users = userDao.selectByMap(hashMap);
////        //根据用户名查询权限
//        for (User user : users) {
////            Role role = roleDao.selectById(userRoleDao.selectOne())
//        }
////        MeetingRole role = roleService.findMeetingRoleByRoleId(user.getRoleId());
//        /**
//         * user
//         * admin
//         */
////        String roleNo = role.getRoleNo();
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.addRole("roleNo");
//        return simpleAuthorizationInfo;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//
//        String token = (String) authenticationToken.getCredentials();
////        if (StringUtils.isEmpty(token)) {
////            throw  new AuthenticationException("Token is invalid");
////        }
//        //解密获得username，用于和数据库对比
//        String phone = JwtUtil.getUsername(token);
//        if (StringUtils.isEmpty(phone)) {
//            throw new AuthException("Token is invalid");
//        }
//        User user = userDao.selectById(phone);
//        if (null == user) {
//            throw new AuthException("user does not exist");
//        }
//        if (!JwtUtil.verify(token, phone, user.getPassword())) {
//            throw new AuthException("Incorrect username or password");
//        }
//        return new SimpleAuthenticationInfo(token, token, "my_realm");
//    }
//}
