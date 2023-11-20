package umcHomework.umc1.temp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umcHomework.umc1.apiPayLoad.code.status.ErrorStatus;
import umcHomework.umc1.apiPayLoad.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{

    @Override
    public void CheckFlag(Integer flag) {
        if(flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
