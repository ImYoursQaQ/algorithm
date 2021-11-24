package designpattern.struct.facadepattern;

/**
 * @author teohubo
 *
 *  门面模式，把细粒度的接口包装成复杂的语义级别的接口
 */
public class FacadeClass {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.userReg();
    }
}

interface UserDomain{

    void saveUser();

    void initAccount();

}

class UserService{
    private UserDomain userDomain;

    public void userReg(){
      userDomain.saveUser();
      userDomain.initAccount();
    }
}
