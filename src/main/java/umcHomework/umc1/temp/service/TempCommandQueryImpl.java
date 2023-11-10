package umcHomework.umc1.temp.service;

import umcHomework.umc1.apiPayLoad.code.status.ErrorStatus;
import umcHomework.umc1.apiPayLoad.exception.handler.TempHandler;

public class TempCommandQueryImpl implements TempQueryService{

    @Override
    public void CheckFlag(Integer flag) {
        if(flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
