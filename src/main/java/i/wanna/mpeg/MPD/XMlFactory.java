package i.wanna.mpeg.MPD;

import i.wanna.mpeg.model.FfmpegData;
import org.springframework.stereotype.Service;

@Service
public class XMlFactory{

    public void MPDbuild(FfmpegData ffmpegData){
        MPDXmlBuiler.builder(ffmpegData).directivesBuilder();
    }

    public void TSbuild(){

    }

}
