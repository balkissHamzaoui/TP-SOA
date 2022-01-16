package calculations;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class CalculService {

    @WebMethod
    public int addition(@WebParam(name="first") int first,@WebParam(name="second") int second){
        return first + second ;
    }

    @WebMethod
    public int substracting(@WebParam(name="first") int first, @WebParam(name="second") int second){
        return first - second ;
    }

    @WebMethod
    public int multiplying(@WebParam(name="first") int first, @WebParam(name="second") int second){
        return first * second;
    }

    @WebMethod
    public int divising(@WebParam(name="first") int first, @WebParam(name="second") int second){
        return first / second;
    }
}
