package i.wanna.mpeg.controller;

import i.wanna.mpeg.FfmpegService;
import i.wanna.mpeg.MPD.XMlFactory;
import i.wanna.mpeg.model.FfmpegData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    FfmpegService ffmpegService;

    @Autowired
    XMlFactory xMlFactory;

    @GetMapping("/api/test")
    public void test(){
        try {
            xMlFactory.MPDbuild(ffmpegService.wrapper());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
