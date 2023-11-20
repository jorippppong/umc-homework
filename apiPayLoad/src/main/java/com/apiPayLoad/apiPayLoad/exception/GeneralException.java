package umcHomework.umc1.apiPayLoad.exception;

import lombok.AllArgsConstructor;
import umcHomework.umc1.apiPayLoad.code.BaseErrorCode;
import umcHomework.umc1.apiPayLoad.code.ErrorReasonDTO;

//해당 클래스를 호출하는게 에러를 발생하는 행위와 동일하다. 왜냐하면 ExceptionAdvice에서 여기가 호출되면 에러가 발생됐다고 생각해서 처리하기 때문
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason(){
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
