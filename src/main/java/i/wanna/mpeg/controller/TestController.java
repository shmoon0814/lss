package i.wanna.mpeg.controller;

import i.wanna.mpeg.FfmpegService;
import i.wanna.mpeg.MPD.XMlFactory;
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
            String a = ffmpegService.wrapper();
            xMlFactory.MPDbuild(a);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
