package i.wanna.mpeg.MPD;

import org.springframework.stereotype.Service;

@Service
public class XMlFactory{

    public void MPDbuild(String ori_file_path){
        MPDXmlBuiler.builder(ori_file_path).directivesBuilder();
    }

    public void TSbuild(){

    }

}
