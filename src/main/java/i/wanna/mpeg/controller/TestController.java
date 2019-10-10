package i.wanna.mpeg.controller;

import i.wanna.mpeg.FfmpegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestController {

    @Autowired
    FfmpegService ffmpegService;

    @GetMapping("/api/test")
    public void test(){
        try{
            ffmpegService.wrapper();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("/api/checkFile")
    public void checkFile(){
        try{
            ffmpegService.checkFile();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
