package designpattern.struct.adaptorpattern;

/**
 * @author teohubo
 */
public class AdaptorClass {

    public static void main(String[] args) {
        BizService bizService = new OtherSDKAdaptor(new OtherSDK());
        System.out.println(bizService.getData());
    }

}

interface BizService{
    String getData();
}

class OtherSDK{
    public Integer getResult(){
        return 100;
    }
}

/**
 * 对象适配器
 */
class OtherSDKAdaptor implements BizService{

    private OtherSDK sdk;

    public OtherSDKAdaptor(OtherSDK sdk) {
        this.sdk = sdk;
    }

    @Override
    public String getData() {
        return sdk.getResult().toString();
    }
}
