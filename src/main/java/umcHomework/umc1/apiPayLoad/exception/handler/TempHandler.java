package umcHomework.umc1.apiPayLoad.exception.handler;

import umcHomework.umc1.apiPayLoad.code.BaseErrorCode;
import umcHomework.umc1.apiPayLoad.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
