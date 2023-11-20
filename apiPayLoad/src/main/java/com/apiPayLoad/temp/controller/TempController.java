package umcHomework.umc1.temp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umcHomework.umc1.apiPayLoad.ApiResponse;
import umcHomework.umc1.temp.converter.TempConverter;
import umcHomework.umc1.temp.dto.TempResponse;
import umcHomework.umc1.temp.service.TempQueryService;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempController {

    public final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDto> testAPI(){
        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}