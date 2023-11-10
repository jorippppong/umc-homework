package umcHomework.umc1.apiPayLoad.exception;

import lombok.AllArgsConstructor;
import umcHomework.umc1.apiPayLoad.code.BaseErrorCode;
import umcHomework.umc1.apiPayLoad.code.ErrorReasonDTO;

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
