package i.wanna.mpeg.MPD;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class Period {
    private long sec;
    private String baseURL;

    //이렇게 3개로 구성이 되어있으면.. 각 대역폭 마다 audio, video, captions 를 찾는 게 다 따로 있겠내요
    //TODO Representaion 은 인터페이스로 자료형 구분해야 할듯하다. 각각이 담고있는 정보들이 다를태니말이다..
    private ArrayList<Representaion> addatationSet_audio = new ArrayList(); //음성 파일
    private ArrayList<Representaion> addatationSet_video = new ArrayList(); //비디오 파일
    private ArrayList<Representaion> addatationSet_captions = new ArrayList(); //자막 파일
}
